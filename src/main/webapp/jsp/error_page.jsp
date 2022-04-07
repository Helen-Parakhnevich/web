<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
  <head>
    <link rel="stylesheet" href="./static/styles/style.css">
  </head>

  <body>

	<h1 id="heading">
		<fmt:message key="error-page.title" />
	</h1>
	<p>${errorMessage}</p>
	<div class="container">
	  <div class="back" onclick="location.href='index.jsp'">
	    <img src="static/img/arrow.png">
	    <label><fmt:message key="error-page.back" /></label>
	  </div>
       <div class="img">
        <img src="static/img/car-line.png">
       </div>
     </div>

  <body>

  <style>

    .back {
    flex-direction: row;
    display: flex;
    justify-content: center;
    width: 250px;
    height: 30px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 25px;
    }

    .container {
       display: flex;
       justify-content: center;
       align-items: center;
       flex-direction: row;
       height: 500px;
    }

    .img {
    display: flex;
    }


 </style>

<html>
