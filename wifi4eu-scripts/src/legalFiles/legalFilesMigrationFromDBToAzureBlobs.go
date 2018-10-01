/* migrate blobs
*
*
*
*/

package main

import (
    "context"
    "crypto/sha1"
    "database/sql"
    "encoding/base64"
    "fmt"
    "math/rand"
    "net/url"
    "runtime"
    "strconv"
    "strings"
    "time"

    "github.com/Azure/azure-storage-blob-go/2016-05-31/azblob"
    log "github.com/sirupsen/logrus"

    _ "github.com/denisenkom/go-mssqldb"
)

var src = rand.NewSource(time.Now().UnixNano())

const letterBytes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
const (
    letterIdxBits = 6                    // 6 bits to represent a letter index
    letterIdxMask = 1<<letterIdxBits - 1 // All 1-bits, as many as letterIdxBits
    letterIdxMax  = 63 / letterIdxBits   // # of letter indices fitting in 63 bits
)

func main() {

    nRead := 0
    nOK := 0

    runtime.GOMAXPROCS(runtime.NumCPU())

    //nKO := 0

    // DEV
    /*dbUserName := "taqof2g1aamcdvf"
    dbPassword := "TFpKzD@8RkK1Be-/yV2D.QbC3lRzTL*H$EN"
    dbHost := "wifi4eu-dbserver.database.windows.net"
    dbPort := 1433
    dbName := "wifi4eudb-dev"
    storageUrl = "https://w4eudevlfstore.blob.core.windows.net/wifi4eu"
    blobCredential := azblob.NewSharedKeyCredential("w4eudevlfstore", "FqH8YTh8O5ZJcPyiFBjjFsQFg9MH1eev8srDcc4MUlFCupEGW66bbPFgyPO7EIgwfu3saPq/ECiuEEAgrF0b6A==")
    */
    // ACC
    /*dbUserName := "user_rw"
    dbPassword := "532V301vO205lHz"
    dbHost := "wifi4eu-dbserver-acc.database.windows.net"
    dbPort := 1433
    dbName := "wifi4eu-dbserver-acc"
    storageURL := "https://w4euaccstore.blob.core.windows.net/wifi4eu"
    blobCredential := azblob.NewSharedKeyCredential("w4euaccstore", "1KBrnoyFBjM/q8s9+Ea8GIMbPZ1ZC1ddYH7GzmSz7r8pwCO+aVJVs1I90otH6pvWzn3j7VP/W2ks+qHIuGg0mQ==")
    */

    // PROD-TEST
    dbUserName := "taqof2g1aamcdvf"
    dbPassword := "TFpKzD@8RkK1Be-/yV2D.QbC3lRzTL*H$EN"
    dbHost := "wifi4eu-dbserver.database.windows.net"
    dbPort := 1433
    dbName := "wifi4eudb-prod_01_TESTUPGRADE"
    storageURL := "https://w4euprolfstore.blob.core.windows.net/wifi4eu"
    blobCredential := azblob.NewSharedKeyCredential("w4euprolfstore", "NhcqikkBJex1UcqOWhe7OELaeA7c5mY0nUXDD/MFGKQli7B3Nt4PK74gV/I4bHIrtlGrAJ/PYDUGhTMO6R/79g==")

    // OPEN DB

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

    rows, err := db.Query(`Select   r.id, 
                                    r._user,
                                    r.municipality,
                                    lf.id, 
                                    CASE WHEN lf.file_mime IS NULL THEN '' ELSE lf.file_mime END
                                from registrations r
                                inner join legal_files lf on lf.registration = r.id
                                WHERE
                                    r.id IS NOT NULL AND
                                    r._user IS NOT NULL;`)

    defer rows.Close()

    if err != nil {
        log.Fatal(err)
        panic(err)
    }

    for rows.Next() {

        var uID int64
        var rID int64
        var mID int64
        var fileID int64
        var fileName string
        var fileMime string
        var b64data string
        var plainData []byte

        if err := rows.Scan(&rID, &uID, &mID, &fileID, &fileMime); err != nil {
            panic(err)

        }

        dataRow, err := db.Query("SELECT data FROM legal_files WHERE registration=" + strconv.FormatInt(rID, 10))

        if err != nil {
            panic(err)
        }

        dataRow.Next()

        if err := dataRow.Scan(&b64data); err != nil {
            panic(err)
        }

        fileName = strconv.FormatInt(rID, 10) + "_" + randString(8) + "_" + strconv.FormatInt(fileID, 10) + getFileExtension(fileMime)

        plainData, err = base64.StdEncoding.DecodeString(b64data)

        if err != nil {
            panic(err)
        }

        blobURL := uploadBlob(storageURL, blobCredential, uID, rID, fileName, plainData)

        _, err = db.Exec(fmt.Sprintf("UPDATE legal_files SET file_name='%s', azure_uri='%s' WHERE id=%d", fileName, blobURL, fileID))

        fmt.Printf("%d,%d,%d,%s,%x,%s\n", rID, uID, mID, fileName, sha1.Sum(plainData), blobURL)

        nOK++

        dataRow.Close()

        nRead++
    }

}

func getFileExtension(mime string) string {

    pos := strings.LastIndex(mime, "/")

    if pos == -1 {
        return ""
    }
    adjustedPos := pos + 1

    if adjustedPos >= len(mime) {
        return ""
    }

    ext := mime[adjustedPos:len(mime)]

    if ext == "pdf" {
        return ".pdf"
    } else if ext == "jpeg" {
        return ".jpg"
    } else if ext == "png" {
        return ".png"
    }

    return ""
}

func uploadBlob(urlStore string, credential *azblob.SharedKeyCredential, uID int64, rID int64, fileName string, data []byte) string {

    ctx := context.Background()

    p := azblob.NewPipeline(credential, azblob.PipelineOptions{
        Retry: azblob.RetryOptions{
            TryTimeout: 3 * time.Minute,
        },
    })

    URL, _ := url.Parse(urlStore)

    containerURL := azblob.NewContainerURL(*URL, p)

    blobURL := containerURL.NewBlockBlobURL(fileName)

    _, err := azblob.UploadBufferToBlockBlob(ctx, data, blobURL, azblob.UploadToBlockBlobOptions{})

    if err != nil {
        panic(err)
    }

    return blobURL.String()

}

func randString(n int) string {
    b := make([]byte, n)
    // A src.Int63() generates 63 random bits, enough for letterIdxMax characters!
    for i, cache, remain := n-1, src.Int63(), letterIdxMax; i >= 0; {
        if remain == 0 {
            cache, remain = src.Int63(), letterIdxMax
        }
        if idx := int(cache & letterIdxMask); idx < len(letterBytes) {
            b[i] = letterBytes[idx]
            i--
        }
        cache >>= letterIdxBits
        remain--
    }

    return string(b)
}
