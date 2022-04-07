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
    <div class="page-header"><fmt:message key="page-header.lot-create"/></div>
      <div class="lot">
        <form class="form-lot" method="post" action="controller?command=createLot">
            <div>
              <label><fmt:message key="lot.category" /></label>
              <select name="categoryId">
                <c:forEach items="${sessionScope.categories}" var="category">
                <option value="${category.id}" selected>${category.name}</option>
                </c:forEach>
               </select>
            </div>
            <div>
            <input type="radio" id="direct" name="type" value="direct" checked>
            <label for="direct"><fmt:message key="type.direct"/></label><br>
            <input type="radio" id="reverse" name="type" value="reverse">
            <label for="reverse"><fmt:message key="type.reverse"/></label><br>
              <label><fmt:message key="lot.type" /></label>
                 <select name="type">
                   <option value="DIRECT" selected><fmt:message key="type.direct"/></option>
                   <option value="REVERS" selected><fmt:message key="type.reverse"/></option>
                 </select>
            </div>
           <div>
             <label><fmt:message key="lot.title" /></label>
             <input  type="text"/>
           </div>
           <div>
              <input class=" login-row" type="submit" />
           </div>
        </form>
      </div>
    </div>
  </body>

  <style>
    .lot {
       display: flex;
       flex-wrap: wrap;
       flex-direction: column;
       margin-top: 1%;
       border-top: 1px solid gainsboro;
   }
   .form-lot {
     display: flex;
     justify-content:space-around;
     flex-direction: column;
     text-align: center;
     height: 300px;
     margin: 2%;
   }

   .page-header {
      display: flex;
      justify-content:center;
      font-size: 18px;
      font-weight: bold;
      margin-top: 1%;
   }
   </style>

<html>