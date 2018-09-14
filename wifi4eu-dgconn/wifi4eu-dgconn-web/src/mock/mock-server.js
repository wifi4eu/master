var fs = require("fs");
var http = require("http");
var path = require("path");
var url = require("url");

// Variables loading from the config file (that may be modified:
// ------------------------------
var config = require("./config.js")();
var port = config.port;
var restMockRootFolder = config.restRootFolder;
var restPrefix = config.restPrefix;
var restServiceCallDelay = config.restServiceCallDelay;
var routerUrlPrefix = config.routerUrlPrefix;
var mimeTypes = config.mimeTypes;
// ------------------------------

console.log("*****************************************************************");
console.log("Starting Node JS - Super light development mock server");
console.log("*****************************************************************");
console.log("REST mockup root folder is: " + path.resolve(restMockRootFolder));
console.log("*****************************************************************");
console.log("Your modifications in source folder have priority now... listening to port " + port);

http.createServer(function (req, res) {
    if (requestHandlers != null) {
        for (var i=0; i<requestHandlers.length; i++) {
            requestHandlers [i](req, res);
        }
    }
}).listen(port);

//-------------- Request handling: -----------------
var getQueryParameters = function (str) {
    return str.replace(/(^\?)/, '').split("&").map(function (n) {
        return n = n.split("="), this[n[0]] = n[1], this
    }.bind({}))[0];
};
var fileExists = function (filePath) {
    try {
        var stats = fs.lstatSync(filePath);
        return stats != null && stats.isFile();
    } catch (e) {}
};

var requestHandlers = [
    function (req, res, next) {
        var parsedUrl = url.parse(req.url);
        var uri = parsedUrl.pathname;
        if (uri == "/") {
            // Auto-redirect to index.html:
            res.writeHead(302, {"Location": "/index.html"});
            res.end();

            return;
        } else {
            uri = uri.replace(/:/g, "-");
        }

        var filename = null;
        var httpCode = 500;
        var responseDelay = 0;
        var itsARestRequest = false;

        // all uri containing REST prefix are mockups:
        if (uri.indexOf(restPrefix + "/") != -1) {
            responseDelay = restServiceCallDelay;
            itsARestRequest = true;

            if (req.headers != null && req.headers ["x-csrf-token-request"] != null) {
                // Check for CSRF token requests:
                res.writeHead(200, {"Content-Type": "text/plain"});
                res.end("aaa-some-token-bbb-" + new Date().getTime());
                return;
            } else if (req.headers != null && req.headers ["content-type"] != null && req.headers ["content-type"].indexOf("multipart/form-data") > -1) {
                // Check for file uploads. When there is a file upload, the response for iframe fallbacks, should be plain text:
                res.writeHead(200, {"Content-Type": "text/plain"});
                res.end("abcd");
                return;
            } else if (uri.indexOf(restPrefix + "/no-content/") >= 0) {
                res.writeHead(204, {"Content-Type": "text/plain"});
                res.end("");
                return;
            } else {
                // Put parameters in the path:
                var parameters = parsedUrl.query;
                if (parameters != null && parameters.length > 0) {
                    if (!uri.match("/$")) {
                        uri += "/";
                    }
                    var parametersPath = [];
                    var parametersAsObject = getQueryParameters(parameters);
                    delete parametersAsObject ["_"];
                    var isFirst = true;
                    for (var parameter in parametersAsObject) {
                        if (!isFirst) {
                            parametersPath.push("_");
                        } else {
                            isFirst = false;
                        }
                        parametersPath.push(parameter + "-" + parametersAsObject [parameter]);
                    }
                    if (parametersPath.length > 0) {
                        uri = uri + parametersPath.join("") + "/";
                    }
                }

                if (!/\/$/.test(uri)) {
                    uri += "/";
                }
                if (req.method == "GET") {
                    uri = uri.replace(/\/$/, "");
                } else {
                    uri = uri.replace(/\/$/, "-" + req.method.toLowerCase() + "");
                }

                // Determine the content-type:
                var realPath = restMockRootFolder + uri;
                for (extension in mimeTypes) {
                    if (fileExists(realPath + "." + extension)) {
                        uri = uri + "." + extension;
                        break;
                    }
                }
            }
            filename = restMockRootFolder + uri;
            httpCode = (fileExists(filename)) ? 200 : 404;
        }

        var extension = path.extname(filename).split(".")[1];
        if (httpCode === 200) {
            var mimeType = mimeTypes [extension];
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            var headers = {
                "Content-Type": mimeType,
                "cache-control": "no-cache",
                "Pragma": "no-cache"
            };
            res.writeHead(httpCode, headers);
            if (responseDelay <= 0) {
                fs.createReadStream(filename).pipe(res);
            } else {
                setTimeout(function () {
                    var fileStream = fs.createReadStream(filename);
                    fileStream.pipe(res);
                }, responseDelay);
            }
        } else if (itsARestRequest || !uri.startsWith(routerUrlPrefix + "/")) {
            console.log("HTTP 404: Tried to map " + uri + " to: " + filename);
            res.writeHead(404);
            res.end();
        } else {
            res.writeHead(500, {"Content-Type": "text/plain"});
            res.end("The mock server is supposed to be used in conjunction with the Angular-cli development server.");
        }
    }
];