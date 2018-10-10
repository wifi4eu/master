/* WIFI4EU-GATE
*
*
*
*/

package main

import (
    "encoding/json"
    "flag"
    "os"
    "io/ioutil"
    "runtime"
    "time"
	"strconv"
	"bytes"
	"fmt"
	"sync/atomic"

	"github.com/gomodule/redigo/redis"
    log "github.com/sirupsen/logrus"
    _ "github.com/tomasen/realip"
	_ "github.com/denisenkom/go-mssqldb"
)


const APPLY_QUEUE = "wifi4eu-apply"
const FINAL_NAME_FILE = " user login "
const LINE_FEED = "\n"
const SLASH = "/"
const SEPARATOR1 = " - "
const SEPARATOR2 = ":"

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

// GLOBALS
var gateConfig GateConfig

type Counter struct {
	count   int64
}
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

func formatLine( numberLoggings int64, time time.Time ) bytes.Buffer{
    var buf bytes.Buffer;
    var loggedNumber string = strconv.FormatInt(numberLoggings,10)
    buf.WriteString( strconv.Itoa(time.Year()))
	buf.WriteString(SLASH)
	buf.WriteString(fmt.Sprintf("%02d", time.Month()))
	buf.WriteString(SLASH)
	buf.WriteString(fmt.Sprintf("%02d", time.Day()))
	buf.WriteString(SEPARATOR1)
	buf.WriteString( fmt.Sprintf("%02d", time.Hour()))
	buf.WriteString(SEPARATOR2)
	buf.WriteString( fmt.Sprintf("%02d ", time.Minute()))
	buf.WriteString(loggedNumber)
    buf.WriteString(FINAL_NAME_FILE)
	buf.WriteString(LINE_FEED)

	return buf;
}

func writeLine(fo *os.File, counter int64, currentTime time.Time) {
	var buf = formatLine( counter ,currentTime);
	if _, err := fo.Write(buf.Bytes()); err != nil {
		panic(err)
	}
}

// subscribeChanges()
// Listen on the redis pubsub channel for changes in user status to update the cache
//
func subscribeChanges(pool *redis.Pool,counter *Counter) {
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
				counter.incCounter();
				log.Infof(" REFRESH: received logging: %d\n", counter.getCounter())

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

func  (c *Counter) incCounter(){
	newcount := atomic.AddInt64(&c.count, 1)
	log.Infof("incCounter: %d", newcount)
}

func (c *Counter) getCounter() int64{
	log.Infof("getCounter: %d", c.count)
	return c.count
}

func (c *Counter) resetCounter() {
	atomic.AddInt64(&c.count, -c.count)
	log.Infof("resetCounter: %d", c.count)
}

func main() {

    start := time.Now()
    log.SetLevel(log.DebugLevel)
    //var minuteKey string;
    // Config
    readConfig()
    //-- CONFIGURE GOLANG
    runtime.GOMAXPROCS(runtime.NumCPU())
    //-- Set up redis
    redisPool := newPool()
    defer redisPool.Close()
    // open output file
    fo, err := os.Create("logging/metrics.txt")
    if err != nil {
        panic(err)
    }
	// close fo on exit and check for its returned error
	defer func() {
		if err := fo.Close(); err != nil {
			panic(err)
		}
	}()

	counter := new(Counter)
	go subscribeChanges(redisPool,counter)

	// while true loop
    for {

        currentTime := time.Now()
        retry:
			conn := redisPool.Get()
            defer conn.Close()

            if conn == nil {
                goto retry
            }
			log.Infof("Counter in main to process %d ",counter.getCounter())

			writeLine(fo,counter.getCounter(),currentTime)
			counter.resetCounter()

			log.Infof("Time to process %s ", time.Now().Sub(currentTime).String())
			time.Sleep(time.Minute)

	}
	log.Infof("Server startup time: %s", time.Now().Sub(start).String())
}


