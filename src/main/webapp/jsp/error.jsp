<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
<body>

	<h1 id="heading">
		<fmt:message key="error-page-title" />
	</h1>
	<p>${errorMessage}</p>
	<button onclick="location.href='index.jsp'" type="button" style = "background-image: url('static/img/arrow.png')">
		<fmt:message key="go-back" />
	</button>
     <div class="img" style="size: 100px; float: right; top: 100%">
                <p><img src="static/img/car-line.jpg"></p>
        </div>

<body>
<html>
