module.exports = function () {
    return {
        port: 3000,
        browserSyncEnabled: true,
        restRootFolder: "./src/mock",
        restPrefix: "/api",
        restServiceCallDelay: 0,
        routerUrlPrefix: "/screen",
        mimeTypes: {
            "html": "text/html",
            "jpeg": "image/jpeg",
            "jpg": "image/jpeg",
            "png": "image/png",
            "js": "text/javascript",
            "css": "text/css",
            "json": "application/json",
            "svg": "image/svg+xml",
            "manifest": "text/cache-manifest"
        }
    }
};