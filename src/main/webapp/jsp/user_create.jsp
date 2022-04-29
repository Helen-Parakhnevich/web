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
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <link rel="stylesheet" href="./static/styles/style.css">
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
    <c:choose>
      <c:when test="${isAdmin}">
        <div class="page-header"><fmt:message key="page-header.user-create.admin"/></div>
      </c:when>
      <c:otherwise>
        <div class="page-header"><fmt:message key="page-header.user-create"/></div>
      </c:otherwise>
    </c:choose>
      <div class="user">
        <form class="form-user" method="post" action="controller?command=create_user">
           <div>
             <label><fmt:message key="user.first-name" /></label>
             <input class="text-input" type="text" name="first_name" maxlength="20" pattern="\w{3,20}" required/>
           </div>
           <div>
             <label><fmt:message key="user.last-name" /></label>
             <input class="text-input" type="text" name="last_name" maxlength="20" pattern="\w{3,20}" required/>
           </div>
           <div>
             <label><fmt:message key="user.login" /></label>
             <input class="text-input" type="text" name="login" maxlength="10" pattern="[\d|\w]{1,10}" required/>
           </div>
           <div>
             <label><fmt:message key="user.password" /></label>
             <input class="text-input" type="password" name="password" maxlength="10" pattern="[\d|\w]{1,10}" required/>
           </div>
           <div>
             <input type="checkbox" name="isAdmin">
             <label for="isAdmin"><fmt:message key="user.is-admin" /></label><br>
           </div>
           <div>
              <button class="btn-create" type="submit"><fmt:message key="save" /></button>
           </div>
        </form>
      </div>
    </div>
  </body>

  <style>
    .user {
       display: flex;
       justify-content: center;
       flex-direction: row;
       margin-top: 1%;
       border-top: 1px solid gainsboro;
   }
   .form-user {
     display: flex;
     justify-content: space-between;;
     flex-direction: column;
     height: 300px;
     width: 20%;
     margin: 2%;
     padding: 5% 10%;
     border: 1px solid gainsboro;
   }

   .page-header {
      display: flex;
      justify-content:center;
      font-size: 18px;
      font-weight: bold;
      margin-top: 1%;
   }

   .type {
     display: flex;
     justify-content:left;
   }

   .text-input {
     width: 100%;
   }

   input:valid+span:after {
      content: "✓";
      padding-left: 5px;
   }

   input:invalid+span:after {
     content: '✖';
     padding-left: 5px;
   }

   label {
       text-transform: uppercase;
   }

   </style>

<html>