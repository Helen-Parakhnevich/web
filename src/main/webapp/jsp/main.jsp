<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<c:if test="${sessionScope.language == null}">
    <c:set var="language" value="en" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html language="${sessionScope.locale}">
<head>
    <link rel="stylesheet" href="../static/styles/style.css">
</head>
<body>
    <header class="top-header">
        <jsp:include page="/jsp/fragments/header.jsp" />
    </header>
        <nav class="top-nav">
            <jsp:include page="/jsp/fragments/menu.jsp" />
        </nav>
</body>
</html>