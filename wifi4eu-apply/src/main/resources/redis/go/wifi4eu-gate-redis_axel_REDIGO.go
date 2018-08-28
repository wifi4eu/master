/* WIFI4EU-GATE
 *
 *
 *
 */

package main

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"net/url"
	"runtime"
	"strconv"
	"strings"
	"time"

	"github.com/garyburd/redigo/redis"
	"github.com/labstack/echo"
	"github.com/labstack/echo/middleware"
	"github.com/labstack/gommon/log"
	_ "github.com/tomasen/realip"

	_ "github.com/denisenkom/go-mssqldb"
)

const MAX_POOL_RETRIES = 100
const HAPROXY_URI = "127.0.0.1:6379"
const APPLY_QUEUE = "wifi4eu-apply"
const COOKIE_NAME = "hasRequested"

//-- DEV ENVIRONMENT
const (
	dbUserName = "taqof2g1aamcdvf"
	dbPassword = "TFpKzD@8RkK1Be-/yV2D.QbC3lRzTL*H$EN"
	dbHost     = "wifi4eu-dbserver.database.windows.net"
	dbPort     = 1433
	dbName     = "wifi4eudb-prod_01_2018-05-28T08-30Z"
)

// UID -> MID Mapping
/*type UserMunicipalityTuple struct {
	uID int64
	mID int64
}
*/
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

// RefreshData - live updates from portal
type RefreshData struct {
	UID  int64
	RID  int64
	MID  int64
	Csrf string
	Docs bool
	Flag bool
	Data string
}

//var userMap map[int64]string
var userInfoMap map[int64]UserInfo

// Open connection to SQL database
func openDB() *sql.DB {

	u := &url.URL{
		Scheme: "sqlserver",
		User:   url.UserPassword(dbUserName, dbPassword),
		Host:   fmt.Sprintf("%s:%d", dbHost, dbPort),
	}

	db, err := sql.Open("sqlserver", u.String()+"?database="+dbName)

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

	fmt.Println("[I] Initializing users map")
	start := time.Now()

	userInfoMap = make(map[int64]UserInfo)

	db := openDB()

	defer db.Close()

	rows, err := db.Query(`SELECT  
								u.id AS userId,
								u.csrf_token AS csrfToken,
								CASE WHEN ca.status IS NULL THEN 0 ELSE 1 END AS acceptStatus,
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
	/*WHERE
	u.csrf_token IS NOT NULL AND
	ca.status = 1`)
	*/
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

		//fmt.Printf("MINFO: u=%d r=%d m=%d accept=%t docs=%t\n", uInfo.UID, rID, mInfo.MID, mInfo.Flag, mInfo.Docs)

		uInfoNode.Registrations[rID] = mInfo

		//fmt.Println(uInfoNode)
		//userInfoMap[u.UID] = u

	}

	fmt.Println("-- Loaded ", len(userInfoMap), " items into usermap. Took: ", time.Now().Sub(start).String())
	fmt.Println("[F] Finished users map initialization")
	return userInfoMap
}

/*
func initRegistrationsMap() map[int64]UserMunicipalityTuple {
	fmt.Println("[I] Fetching registrations")
	start := time.Now()

	const queryCall = "SELECT ru._user as user_id, ru.registration as reg_id, m.id as mun_id FROM registration_users ru INNER JOIN registrations r ON r.id = ru.registration INNER JOIN municipalities m ON m.id = r.municipality WHERE r.allFiles_flag = 1"
	var regsMap = make(map[int64]UserMunicipalityTuple)

	u := &url.URL{
		Scheme: "sqlserver",
		User:   url.UserPassword(dbUserName, dbPassword),
		Host:   fmt.Sprintf("%s:%d", dbHost, dbPort),
	}

	db, err := sql.Open("sqlserver", u.String()+"?database="+dbName)

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	defer db.Close()

	rows, err := db.Query(queryCall)

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	defer rows.Close()

	for rows.Next() {
		var (
			uID int64
			rID int64
			mID int64
		)

		if err := rows.Scan(&uID, &rID, &mID); err != nil {
			fmt.Printf("Something went wrong: (%d,%d) of user %d\n", rID, mID, uID) //-- For testing purposes
			//log.Fatal(err)
			continue
		}

		tupl := UserMunicipalityTuple{uID: uID, mID: mID}

		//fmt.Printf("Added registration: (%d,%d) of user %d\n", rId, mId, uId) //-- For testing purposes
		regsMap[rID] = tupl
	}

	fmt.Println("-- Loaded ", len(regsMap), " items into registrationsMap. Took: ", time.Now().Sub(start).String())
	fmt.Println("[F] Fetching registrations")
	return regsMap
}
*/
func getCallOpen() (int64, time.Time, time.Time) {
	fmt.Println("[I] Fetching open call")
	start := time.Now()

	const queryCall = "SELECT id, start_date, end_date FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date"
	const nextCall = "SELECT TOP 1 id, start_date, end_date FROM calls WHERE start_date > cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 ORDER BY start_date ASC "
	var (
		cID       int64
		callOpen  int64
		callClose int64
	)

	u := &url.URL{
		Scheme: "sqlserver",
		User:   url.UserPassword(dbUserName, dbPassword),
		Host:   fmt.Sprintf("%s:%d", dbHost, dbPort),
	}

	db, err := sql.Open("sqlserver", u.String()+"?database="+dbName)

	if err != nil {
		log.Fatal(err)
		panic(err)
	}

	defer db.Close()

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

		fmt.Printf("-- Call: %d => [From: %s; To: %s]\n", cID, time.Unix(callOpen/1000, 0).String(), time.Unix(callClose/1000, 0).String())
	}

	if callOpen == 0 || callClose == 0 {
		fmt.Println("-- No call open found. Took: ", time.Now().Sub(start).String())
		fmt.Println("Get NEXT call")

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

			fmt.Printf("-- Call: %d => [From: %s; To: %s]\n", cID, time.Unix(callOpen/1000, 0).String(), time.Unix(callClose/1000, 0).String())
		}

	} else {
		fmt.Println("-- Loaded call. Took: ", time.Now().Sub(start).String())
	}
	fmt.Println("[F] Fetching open call")
	return cID, time.Unix(callOpen/1000, 0), time.Unix(callClose/1000, 0)
}

func newPool(addr string) *redis.Pool {
	return &redis.Pool{
		MaxIdle:     500,
		MaxActive:   12000,
		Wait:        true,
		IdleTimeout: 2 * time.Second,
		Dial:        func() (redis.Conn, error) { return redis.Dial("tcp", addr) },
		TestOnBorrow: func(c redis.Conn, t time.Time) error {
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
				fmt.Printf("%s: message: %s\n", v.Channel, v.Data)

				/*var msg RefreshData

				err := json.Unmarshal(v.Data, &msg)

				if err != nil {
					log.Warn(err)
					continue
				}
				*/
				fmt.Printf("%s: csrf: %s", v.Channel, v.Data)
				//fmt.Println(msg)

			case redis.Subscription:
				fmt.Printf("%s: %s %d\n", v.Channel, v.Kind, v.Count)
			case error:
				continue
			}
		}
		c.Close()

		fmt.Printf("Error: %s", c.Err())
	}
}

//
// Refresh the in-memory RUM / XSRF token cache
//
/*func updateCache(refData RefreshData) {

	// Update XSRF token for user
	userMap[refData.UID] = refData.Csrf

	// Update rest of data

}
*/
func main() {
	start := time.Now()

	//-- GLobal vars
	var totalRetries int = 0

	//-- Initialization
	initUsersMap()

	tmp, err := json.MarshalIndent(userInfoMap, "", "")
	if err == nil {
		fmt.Print(string(tmp))
	} else {
		fmt.Println("error:", err)
	}
	callID, callOpen, callClose := getCallOpen()
	//var regsMap = initRegistrationsMap()
	//-- TODO Pending registrations

	if userInfoMap == nil || len(userInfoMap) == 0 {
		log.Warn("No users were pre-fetched on server startup")
	}

	if callOpen.IsZero() || callClose.IsZero() { //-- FIXME not working
		log.Warn("No call is open")
	}

	/*if regsMap == nil || len(regsMap) == 0 {
		log.Warn("No registrations were pre-fetched on server startup")
	}
	*/

	//-- CONFIGURE GOLANG
	runtime.GOMAXPROCS(runtime.NumCPU())

	//-- Set up redis
	redisPool := newPool(HAPROXY_URI)
	defer redisPool.Close()

	go subscribeChanges(redisPool)

	//-- Set up HTTP listener
	e := echo.New()

	//-- Logging
	//e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORS())

	e.GET("/", func(c echo.Context) error {

		return c.String(http.StatusOK, "Gate Controller is UP") //TODO return machine name

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
			rInfo.Docs { // Supporting documents not uploaded for this R/M combo

			return c.String(http.StatusBadRequest, "Application does not meet the requirements")
		}

		//eturn c.String(http.StatusOK, "DEVELOPMENT MODE") // DEV MODE!!!!! DELETE

		//-- 4. SAVE TO REDIS
		retries := 0

	retry:
		conn := redisPool.Get()
		defer conn.Close()

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
				log.Info("Retrying!!")
				if retries < MAX_POOL_RETRIES {
					goto retry
				}
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

	fmt.Println("\n\n-- Server startup time: ", time.Now().Sub(start).String())

	e.Logger.Fatal(e.Start(":7777"))
}
