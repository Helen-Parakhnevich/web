<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.locale == null}">
    <c:set var="locale" value="en_US" scope="session"/>
</c:if>
<c:if test="${sessionScope.language == null}">
    <c:set var="language" value="en" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
<head>
    <link rel="stylesheet" href="../static/styles/style.css">
</head>
<body>
    <header class="top-header">
        <jsp:include page="/jsp/fragments/header.jsp" />
    </header>
        <nav class="top-nav">
          <c:choose>
            <c:when test="${isAdmin}">
              <jsp:include page="/jsp/fragments/menu_admin.jsp" />
            </c:when>
            <c:otherwise>
              <jsp:include page="/jsp/fragments/menu.jsp" />
            </c:otherwise>
          </c:choose>
        </nav>
</body>

<script>
    console.log("${BundleContent}");
    console.log("${locale}");
    console.log("${language}");
    console.log("${sessionScope.locale}");
    console.log("${sessionScope.userId}");
    console.log("${sessionScope.isAdmin}");
</script>

</html>