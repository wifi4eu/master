<%@
	page pageEncoding="UTF-8" import="java.io.File" %><%@ 
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ 
	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><c:set
	var="baseHref" value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}"
/><!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>WiFi4EU - ABAC Interface</title>
        <base href="${baseHref}/">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/x-icon" href="${baseHref}/favicon.ico">
        <!-- Don't remove the following 2 lines -->
        <!-- open-id-inject -->
        <!-- end-open-id-inject -->
    </head>
    <body>
        <app-root>
            <div id="loader-wrapper">
                <div id="loader"></div>
            </div>
        </app-root>
		<script type="text/javascript" src="${baseHref}/inline.bundle.js"></script>
		<script type="text/javascript" src="${baseHref}/polyfills.bundle.js"></script>
		<script type="text/javascript" src="${baseHref}/styles.bundle.js"></script>
		<script type="text/javascript" src="${baseHref}/vendor.bundle.js"></script>
		<script type="text/javascript" src="${baseHref}/main.bundle.js"></script>
	</body>
</html>
