/* WIFI4EU-GATE
 *
 *
 *
 */

package main

import (
	"database/sql"
	"encoding/json"
	"errors"
	"flag"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"net/url"
	"os"
	"runtime"
	"strconv"
	"strings"
	"time"

	"github.com/FZambia/sentinel"
	"github.com/gomodule/redigo/redis"
	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	log "github.com/sirupsen/logrus"
	_ "github.com/tomasen/realip"

	_ "github.com/denisenkom/go-mssqldb"
)

const MAX_POOL_RETRIES = 1000

const APPLY_QUEUE = "wifi4eu-apply"
const COOKIE_NAME = "hasRequested"

// GateConfig - environment specific configuration read from external json file
type GateConfig struct {
	DbUserName   string
	DbPassword   string
	DbHost       string
	DbPort       int
	DbName       string
	HaproxyURI   string
	SentinelUris []string
}

// RegInfo - registration info struct for cache
type RegInfo struct {
	MID  int64
	Flag bool
	Docs bool
}

// UserInfo - user info struct for cache
type UserInfo struct {
	UID           int64
	Csrf          string
	Registrations map[int64]RegInfo
}

// GLOBALS
var gateConfig GateConfig
var userInfoMap map[int64]UserInfo

// readConfig() read config from external JSON file
func readConfig() GateConfig {

	cfgFile := flag.String("conf", "./gate-config.json", "Path to config file")

	log.Debugf("Reading config from %s", *cfgFile)

	data, err := ioutil.ReadFile(*cfgFile)

	if err != nil {
		panic(err)
	}

	json.Unmarshal(data, &gateConfig)

	log.Debugf("CONFIG: %s", gateConfig)

	return gateConfig
}

// Open connection to SQL database
func openDB() *sql.DB {

	u := &url.URL{
		Scheme: "sqlserver",
		User:   url.UserPassword(gateConfig.DbUserName, gateConfig.DbPassword),
		Host:   fmt.Sprintf("%s:%d", gateConfig.DbHost, gateConfig.DbPort),
	}

	db, err := sql.Open("sqlserver", u.String()+"?database="+gateConfig.DbName)

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	return db
}

//
// Set up the USER->XSRF token map
//
func initUsersMap() map[int64]UserInfo {

	start := time.Now()

	userInfoMap = make(map[int64]UserInfo)

	db := openDB()

	defer db.Close()

	rows, err := db.Query(`SELECT  
								u.id AS userId,
								u.csrf_token AS csrfToken,
								CASE WHEN ca.status IS NULL THEN 0 ELSE ca.status END AS acceptStatus,
								reg.id AS regId,
								mun.id AS munId,
								reg.allFiles_flag as docStatus 
							FROM users u 
							INNER JOIN registration_users ru ON u.id = ru._user
							INNER JOIN registrations reg ON reg.id = ru.registration
							
							OUTER APPLY 
								(SELECT TOP 1 * FROM conditions_agreement WHERE user_id=u.id AND registration_id = reg.id ORDER BY change_status_date DESC) ca
							INNER JOIN  municipalities mun ON mun.id = reg.municipality
							WHERE 
								u.csrf_token IS NOT NULL`)

	defer rows.Close()

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	for rows.Next() {
		var uInfo UserInfo
		var mInfo RegInfo
		var rID int64
		var uInfoNode UserInfo

		if err := rows.Scan(&uInfo.UID, &uInfo.Csrf, &mInfo.Flag, &rID, &mInfo.MID, &mInfo.Docs); err != nil {
			log.Fatal(err)
			continue
		}

		uInfoNode, found := userInfoMap[uInfo.UID]

		if !found {
			uInfo.Registrations = make(map[int64]RegInfo)
			userInfoMap[uInfo.UID] = uInfo
			uInfoNode = uInfo
		}

		uInfoNode.Registrations[rID] = mInfo
	}

	log.Infof("-- Loaded %d items into usermap. Took: %s", len(userInfoMap), time.Now().Sub(start).String())

	return userInfoMap
}

func getCallOpen() (int64, time.Time, time.Time) {
	log.Infof("[I] Fetching open call")
	start := time.Now()

	db := openDB()
	defer db.Close()

	const queryCall = "SELECT id, start_date, end_date FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date"
	const nextCall = "SELECT TOP 1 id, start_date, end_date FROM calls WHERE start_date > cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 ORDER BY start_date ASC "
	var (
		cID       int64
		callOpen  int64
		callClose int64
	)

	rows, err := db.Query(queryCall)

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	defer rows.Close()

	for rows.Next() {

		if err := rows.Scan(&cID, &callOpen, &callClose); err != nil {
			log.Fatal(err)
			continue
		}

		log.Infof("Call: %d => [From: %s; To: %s]\n", cID, time.Unix(callOpen/1000, 0).String(), time.Unix(callClose/1000, 0).String())
	}

	if callOpen == 0 || callClose == 0 {
		log.Warn("-- No call open found. Took: ", time.Now().Sub(start).String())
		log.Warn("Get NEXT call")

		rows, err := db.Query(nextCall)

		if err != nil {
			log.Fatal(err)
			panic(err)
		}

		defer rows.Close()

		for rows.Next() {

			if err := rows.Scan(&cID, &callOpen, &callClose); err != nil {
				log.Fatal(err)
				continue
			}

			log.Warn("-- Call: %d => [From: %s; To: %s]\n", cID, time.Unix(callOpen/1000, 0).String(), time.Unix(callClose/1000, 0).String())
		}

	} else {
		log.Info("-- Loaded call. Took: ", time.Now().Sub(start).String())
	}

	return cID, time.Unix(callOpen/1000, 0), time.Unix(callClose/1000, 0)
}

// newPool() - initialise main redis connection pool
// Main pool writes to master via haproxy
func newPool() *redis.Pool {
	return &redis.Pool{
		MaxIdle:     500,
		MaxActive:   12000,
		Wait:        true,
		IdleTimeout: 2 * time.Second,
		Dial:        func() (redis.Conn, error) { return redis.Dial("tcp", gateConfig.HaproxyURI) },
		TestOnBorrow: func(c redis.Conn, t time.Time) error {
			if time.Since(t) < time.Minute {
				return nil
			}
			_, err := c.Do("PING")
			return err
		},
	}
}

// newPool2() - initialise secondary pool
// Secondary pool reads from cluster via sentinel (for pub/sub notifications)
func newPool2() *redis.Pool {

	sntnl := &sentinel.Sentinel{
		Addrs:      gateConfig.SentinelUris, //[]string{"10.0.2.31:5000", "10.0.2.32:5000", "10.0.2.33:5000"},
		MasterName: "master1",
		Dial: func(addr string) (redis.Conn, error) {

			//fmt.Println("***** DIAL1: ADDR=%s", addr)

			timeout := 500 * time.Millisecond
			c, err := redis.DialTimeout("tcp", addr, timeout, timeout, timeout)
			if err != nil {

				log.Warnf("Error connecting to sentinel: %s", err)
				return nil, err
			}
			return c, nil
		},
	}
	return &redis.Pool{
		MaxIdle:     100,
		MaxActive:   1000,
		Wait:        true,
		IdleTimeout: 2 * time.Second,
		Dial: func() (redis.Conn, error) {
			masterAddr, err := sntnl.MasterAddr()

			//fmt.Println("***** DIAL2: ADDR=%s", masterAddr)

			if err != nil {
				//log.Error("ERROR CONNECTING SENTINEL: %s", err)
				return nil, err
			}
			c, err := redis.Dial("tcp", masterAddr)
			if err != nil {
				//log.Warnf("Error connecting to sentinel: %s", err)
				return nil, err
			}
			return c, nil
		},
		TestOnBorrow: func(c redis.Conn, t time.Time) error {
			if !sentinel.TestRole(c, "master") {
				return errors.New("Role check failed")
			}
			if time.Since(t) < time.Minute {
				return nil
			}
			_, err := c.Do("PING")
			return err
		},
	}
}

// subscribeChanges()
// Listen on the redis pubsub channel for changes in user status to update the cache
//
func subscribeChanges(pool *redis.Pool) {
	for {
		c := pool.Get()

		defer c.Close()

		psc := redis.PubSubConn{c}

		// Set up subscriptions
		psc.Subscribe("refresh")

		// While not a permanent error on the connection.
		for c.Err() == nil {
			switch v := psc.Receive().(type) {
			case redis.Message:

				var uInfo UserInfo

				log.Infof("%s: message: %s\n", v.Channel, v.Data)

				err := json.Unmarshal(v.Data, &uInfo)

				if err != nil {
					log.Warn(err)
					continue
				}

				log.Debugf("%s: csrf: %s", v.Channel, v.Data)

				log.Debug(uInfo)

				updateCache(uInfo)

			case redis.Subscription:
				log.Debugf("%s: %s %d\n", v.Channel, v.Kind, v.Count)
			case error:
				continue
			}
		}
		c.Close()

		log.Warnf("Error: %s", c.Err())
	}
}

//
// Refresh the in-memory RUM / XSRF token cache
//
func updateCache(msg UserInfo) {

	log.Info(userInfoMap[msg.UID])

	log.Info("Updating usermap entry for uid=%d", msg.UID)

	userInfoMap[msg.UID] = msg

	log.Info(userInfoMap[msg.UID])
}

func main() {
	start := time.Now()

	//-- GLobal vars
	var totalRetries int = 0

	log.SetLevel(log.DebugLevel)

	// Config
	readConfig()

	//-- Initialization
	initUsersMap()

	callID, callOpen, callClose := getCallOpen()

	if userInfoMap == nil || len(userInfoMap) == 0 {
		log.Warn("No users were pre-fetched on server startup")
	}

	if callOpen.IsZero() || callClose.IsZero() { //-- FIXME not working
		log.Warn("No call is open")
	}

	//-- CONFIGURE GOLANG
	runtime.GOMAXPROCS(runtime.NumCPU())

	//-- Set up redis

	redisPool := newPool2()
	redisPool1 := newPool()

	defer redisPool.Close()
	defer redisPool1.Close()

	go subscribeChanges(redisPool)

	//-- Set up HTTP listener
	e := echo.New()

	//-- Logging
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORS())

	e.GET("/", func(c echo.Context) error {

		name, _ := os.Hostname()

		return c.String(http.StatusOK, fmt.Sprintf("Gate Controller is UP [%s]", name))
	})

	e.GET("/time", func(c echo.Context) error {

		return c.String(http.StatusOK, strconv.FormatInt(time.Now().Local().Unix()*1000, 10))

	})

	//-- FIXME: Will secure. Internal use only.
	e.GET("/next-call", func(c echo.Context) error {
		var strs []string

		strs = append(strs, strconv.FormatInt(callID, 10))
		strs = append(strs, callOpen.String())
		strs = append(strs, callClose.String())

		return c.String(http.StatusOK, strings.Join(strs, " - "))
	})

	//-- FIXME: Will secure. Internal use only.
	e.GET("/is-call-open", func(c echo.Context) error {
		return c.String(http.StatusOK, strconv.FormatBool(time.Now().After(callOpen) && time.Now().Before(callClose)))
	})

	e.GET("/sys/map/:u", func(c echo.Context) error {

		uid, err := strconv.ParseInt(c.Param("u"), 10, 64)
		if err != nil {
			return c.String(http.StatusBadRequest, "")
		}

		data, found := userInfoMap[uid]

		if !found {
			return c.String(http.StatusNotFound, "User not found")
		}

		ujson, err := json.Marshal(data)

		return c.String(http.StatusOK, string(ujson))
	})

	e.GET("/calls/:callId/apply/:r/:u/:m", func(c echo.Context) error {

		//-- 0. Read input parameters parameters
		cToken, err := strconv.ParseInt(c.Param("callId"), 10, 64)
		if err != nil || cToken != callID {
			return c.String(http.StatusBadRequest, "[1] Invalid arguments") //-- No need to give more information
		}

		rToken, err := strconv.ParseInt(c.Param("r"), 10, 64)
		if err != nil {
			return c.String(http.StatusBadRequest, "[2] Invalid arguments")
		}

		uToken, err := strconv.ParseInt(c.Param("u"), 10, 64)
		if err != nil {
			return c.String(http.StatusBadRequest, "[3] Invalid arguments")
		}

		mToken, err := strconv.ParseInt(c.Param("m"), 10, 64)
		if err != nil {
			return c.String(http.StatusBadRequest, "[4] Invalid arguments")
		}

		// 1. CHECK CALL IS OPEN
		now := time.Now()
		if !(now.After(callOpen) && now.Before(callClose)) {
			return c.String(http.StatusUnauthorized, "Call is not active")
		}

		uInfo, userFound := userInfoMap[uToken]

		if !userFound {
			return c.String(http.StatusUnauthorized, "Unauthorized")
		}

		// 2. Validate CSRF token
		xsrfToken := c.Request().Header.Get("X-XSRF-TOKEN")
		//-- fmt.Println("-- XSRF: ", xsrfToken)
		//-- fmt.Println("-- MAP XSRF: ", usersMap[uToken])
		if uInfo.Csrf != xsrfToken {
			//return c.String(http.StatusUnauthorized, "Unauthorized")
		}

		// 4. CHECK R,U,M TOKEN
		//-- fmt.Printf("-- Municipality Received: %d. Found: %d \n", mToken, tupl.mId)
		//-- fmt.Printf("-- User Received: %d. Found: %d \n", uToken, tupl.uId)
		rInfo, rFound := uInfo.Registrations[rToken]

		if !rFound || // Registration ID not found...
			rInfo.MID != mToken || // Registration + Municipality do not match
			!rInfo.Flag || // T&C for this registration not accepted
			!rInfo.Docs { // Supporting documents not uploaded for this R/M combo

			return c.String(http.StatusBadRequest, "Application does not meet the requirements")
		}

		//eturn c.String(http.StatusOK, "DEVELOPMENT MODE") // DEV MODE!!!!! DELETE

		//-- 4. SAVE TO REDIS
		retries := 0

	retry:
		conn := redisPool1.Get()
		defer conn.Close()

		if conn == nil {
			goto retry
		}

		resp, err := conn.Do("XADD", APPLY_QUEUE, "*",
			"r", rToken,
			"u", uToken,
			"m", mToken,
			"ip", c.Request().Header.Get("X-FORWARDED-FOR"), //realip.FromRequest(c.Request()),
			"time", now.String())

		if err != nil {
			if err == io.EOF {
				retries++
				totalRetries++
				log.Debug("Bad redis connection, retrying")
				//if retries < MAX_POOL_RETRIES {
				goto retry
				//}
			}

			log.Error(err.Error())

			return c.String(http.StatusInternalServerError, "Error processing request")
		}

		//-- 4. All good. Set cookie and return OK
		var cookieName []string
		cookieName = append(cookieName, COOKIE_NAME)
		cookieName = append(cookieName, strconv.FormatInt(rToken, 10))

		cookie := new(http.Cookie)
		cookie.Name = strings.Join(cookieName, "_")
		cookie.Value = "true"
		//cookie.Domain = "wifi4eu-dev.everincloud.com" //-- TODO FIXME
		cookie.Expires = time.Now().Add(31 * 24 * time.Hour)
		c.SetCookie(cookie)

		return c.String(http.StatusOK, resp.(string))
	})

	log.Infof("Server startup time: %s", time.Now().Sub(start).String())

	e.Logger.Fatal(e.Start(":7777"))
}
