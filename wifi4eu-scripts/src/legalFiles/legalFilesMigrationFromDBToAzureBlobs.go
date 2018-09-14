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
    "net/url"
    "strconv"

    "github.com/Azure/azure-storage-blob-go/2016-05-31/azblob"
    log "github.com/sirupsen/logrus"

    _ "github.com/denisenkom/go-mssqldb"
)

func main() {

    nRead := 0
    nOK := 0
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
    dbUserName := "user_rw"
    dbPassword := "532V301vO205lHz"
    dbHost := "wifi4eu-dbserver-acc.database.windows.net"
    dbPort := 1433
    dbName := "wifi4eu-dbserver-acc"
    storageURL := "https://w4euaccstore.blob.core.windows.net/wifi4eu"
    blobCredential := azblob.NewSharedKeyCredential("w4euaccstore", "1KBrnoyFBjM/q8s9+Ea8GIMbPZ1ZC1ddYH7GzmSz7r8pwCO+aVJVs1I90otH6pvWzn3j7VP/W2ks+qHIuGg0mQ==")

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

    rows, err := db.Query(`Select r.id, r._user, r.municipality, lf.file_name, lf.id
                                from registrations r
                                inner join legal_files lf on lf.registration = r.id
                                WHERE
                                    r.id IS NOT NULL AND
                                    r._user IS NOT NULL AND 
                                    lf.file_name IS NOT NULL;`)

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
        var b64data string
        var plainData []byte

        if err := rows.Scan(&rID, &uID, &mID, &fileName, &fileID); err != nil {
            panic(err)

        }

        dataRow, err := db.Query("SELECT data FROM legal_files WHERE registration=" + strconv.FormatInt(rID, 10))
        defer dataRow.Close()

        if err != nil {
            panic(err)
        }

        dataRow.Next()

        if err := dataRow.Scan(&b64data); err != nil {
            panic(err)
        }

        fileName = strconv.FormatInt(rID, 10) + "_" + fileName + "_" + strconv.FormatInt(fileID, 10)

        plainData, err = base64.StdEncoding.DecodeString(b64data)

        if err != nil {
            panic(err)
        }

        blobURL := uploadBlob(storageURL, blobCredential, uID, rID, fileName, plainData)

        _, err = db.Exec(fmt.Sprintf("UPDATE legal_files SET azure_uri='%s' WHERE id=%d", blobURL, fileID))

        if err != nil {
            panic(err)
        }

        fmt.Printf("%d,%d,%d,%s,%x,%s\n", rID, uID, mID, fileName, sha1.Sum(plainData), blobURL)

        nOK++

        nRead++

    }

}

func uploadBlob(urlStore string, credential *azblob.SharedKeyCredential, uID int64, rID int64, fileName string, data []byte) string {

    ctx := context.Background() 

    p := azblob.NewPipeline(credential, azblob.PipelineOptions{})

    URL, _ := url.Parse(urlStore)

    containerURL := azblob.NewContainerURL(*URL, p)

    blobURL := containerURL.NewBlockBlobURL(fileName)

    _, err := azblob.UploadBufferToBlockBlob(ctx, data, blobURL, azblob.UploadToBlockBlobOptions{})

    if err != nil {
        panic(err)
    }

    return blobURL.String()

}

