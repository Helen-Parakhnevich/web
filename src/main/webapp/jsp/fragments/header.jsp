<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
<div>
    <span> <a><fmt:message key="header.first"/></a></span>
    <span class="top-header-right"><a><fmt:message key="header.second"/></a></span>
</div>

</html>