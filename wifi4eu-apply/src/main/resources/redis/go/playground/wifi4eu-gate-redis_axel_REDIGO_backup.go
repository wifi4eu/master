 /* WIFI4EU-GATE
 *
 *
 *
 */

 package main

 import (
	 "database/sql"
	 "fmt"
	 _ "log"
	 "net/http"
	 "net/url"
	 "runtime"
	 "strconv"
	 "time"
	"io"
 
	 _ "github.com/denisenkom/go-mssqldb"
	 "github.com/garyburd/redigo/redis"
	 "github.com/labstack/echo"
	 "github.com/labstack/echo/middleware"
	 "github.com/labstack/gommon/log"
	 "github.com/tomasen/realip"
 )
 
 func initDB() map[int64]string {
 
	 // DEV ENVIRONMENT
	 dbUserName := "taqof2g1aamcdvf"
	 dbPassword := "TFpKzD@8RkK1Be-/yV2D.QbC3lRzTL*H$EN"
	 dbHost := "wifi4eu-dbserver.database.windows.net"
	 dbPort := 1433
	 dbName := "wifi4eudb-dev"
 
	 var (
		 uID   int64
		 uECAS string
	 )
 
	 userMap := make(map[int64]string)
 
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
 
	 rows, err := db.Query("SELECT id, ecas_username FROM dbo.Users")
 
	 if err != nil {
		 log.Fatal(err)
		 panic(err)
	 }
 
	 defer rows.Close()
 
	 for rows.Next() {
		 err := rows.Scan(&uID, &uECAS)
		 if err != nil {
			 // TODO
			 fmt.Println("error processing rows")
			 continue
		 }
		 userMap[uID] = uECAS
	 }
 
	 fmt.Println("Loaded ", len(userMap), " items into usermap")
 
	 return userMap
 }
 
 func newPool(addr string) *redis.Pool {
	 return &redis.Pool{
		 MaxIdle:     500,
		MaxActive: 12000,
		Wait: true,
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
 
 func main() {
 
	 // ENVIRONMENT
	 //sentinelURI := "127.0.0.1:8000"
	totalRetries := 0 
	redisURI := "127.0.0.1:8000"
	 //redisURI := "/var/run/redis/redis.sock"
	 redisQueue := "wifi4eu-apply-stream2"
 
	 // CALL INFO
	 callOpenTimestamp, _ := time.Parse(time.RFC3339, "2018-07-14T08:20:00Z")
 
	 // CONFIGURE GOLANG
	 runtime.GOMAXPROCS(runtime.NumCPU())
 
	 // Read database, load usermap
	 //userData := initDB()
	 //userData := make(map[int64]string)
	 //initDB()
 
	 // Set up redis
	 /*client := redis.NewClient(&redis.Options{
		 Addr:     "localhost:8000",
		 Password: "", // no password set
		 DB:       0,  // use default DB
	 })*/
 
	 redisPool := newPool(redisURI)
 
	 /*redisPool := redis.NewPool(func() (redis.Conn, error) {
		 c, err := redis.Dial("tcp", redisURI)
 
		 if err != nil {
			 return nil, err
		 }
 
		 return c, err
	 }, 500)
	 */
	 defer redisPool.Close()
 
	 // Set up HTTP listener
	 e := echo.New()
 
	 //e.Use(middleware.Logger())
	 e.Use(middleware.Recover())
	 e.Use(middleware.CORS())
 
	 /*e.GET("/", func(c echo.Context) error {
 
		 tstamp := time.Now()
 
		 fmt.Println(tstamp)
		 fmt.Println(callOpenTimestamp)
 
		 if tstamp.After(callOpenTimestamp) {
			 fmt.Print("OK")
		 } else {
			 fmt.Print("NOT YET")
		 }
 
		 return c.String(http.StatusOK, "Ok")
 
	 })
	 */
 
	 e.GET("/time", func(c echo.Context) error {
 
		 return c.String(http.StatusOK, strconv.FormatInt(time.Now().Unix(), 10))
 
	 })
 
	e.GET("/retries", func(c echo.Context) error {

                 return c.String(http.StatusOK, strconv.Itoa(totalRetries))

         })

	 e.GET("/calls/:callId/apply/:r/:u/:m", func(c echo.Context) error {
 
		 // 1. CHECK TIMESTAMP
		 tstamp := time.Now()
 
		 if tstamp.Before(callOpenTimestamp) {
			 return c.String(http.StatusUnauthorized, "Call is not active")
		 }
 
		 // 2. CHECK R,U,M TOKEN
		 rToken, err := strconv.ParseInt(c.Param("r"), 10, 64)
		 if err != nil {
			 return c.String(http.StatusBadRequest, "Invalid arguments")
		 }
		 uToken, err := strconv.ParseInt(c.Param("u"), 10, 64)
		 if err != nil {
			 return c.String(http.StatusBadRequest, "Invalid arguments")
		 }
		 mToken, err := strconv.ParseInt(c.Param("m"), 10, 64)
		 if err != nil {
			 return c.String(http.StatusBadRequest, "Invalid arguments")
		 }
 
		 key := make(map[string]interface{})
		 key["uid"] = uToken
 
		 // 3. SAVE TO REDIS
 
		 //conn, err := redisPool.Get()
 
		 //defer redisPool.Put(conn)
 
		 //conn, err := client.GetMaster("master1")
		 if err != nil {
			 panic(err)
		 }
 
		 //defer client.PutMaster("master1", conn)
 
		 //if err != nil {
		 //	return c.String(501, "Error processing internal request")
		 //}
 
		
		count := 0
		
		retry: 
		conn := redisPool.Get()
		 defer conn.Close()
 
		resp, err := conn.Do("XADD", redisQueue, "*",
			"r", rToken,
			"u", uToken,
			"m", mToken,
			"ip", realip.FromRequest(c.Request()),
			"ecas", "foo")

		if err != nil {
			if err == io.EOF {
				count = count + 1
				totalRetries++
				log.Info("Retrying!!")
				if (count < 100) {
					goto retry
				}

			}

			log.Error(err.Error())

			return c.String(http.StatusInternalServerError, "Error processing request")
		}
		 //userLink := userData[uToken]
 
		 return c.String(http.StatusOK, resp.(string))
	 })
 
	 e.Logger.Fatal(e.Start(":80"))
 
	 //defer conn.Close()
	 //defer ch.Close()
 }
