<%@ page pageEncoding="UTF-8" import="java.io.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseHref" value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}" />
<c:set var="srcAttribute">src="${baseHref}/</c:set>
<c:set var="hrefAttribute">href="${baseHref}/</c:set>
<c:import url="index.html" var="html" charEncoding="UTF-8" />
<c:set var="html" value="${fn:replace(html, '<base href=\"/\">', '<base href=\"\">')}" />
<c:set var="html" value="${fn:replace(html, 'src=\"', srcAttribute)}" />
<c:set var="html" value="${fn:replace(html, 'href=\"', hrefAttribute)}" />			
${html}