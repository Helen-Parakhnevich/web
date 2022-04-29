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
        <div class="page-header"><fmt:message key="page-header.lot-create.admin"/></div>
      </c:when>
      <c:otherwise>
        <div class="page-header"><fmt:message key="page-header.lot-create"/></div>
      </c:otherwise>
    </c:choose>
      <div class="lot">
        <form class="form-lot" method="post" action="controller?command=create_lot">
           <div>
             <label><fmt:message key="lot.title" /></label>
             <input class="text-input" type="text" name="title" required/>
           </div>
            <div>
              <label><fmt:message key="lot.category" /></label>
              <select name="category_id" placeholder="Choose">
                <c:forEach items="${sessionScope.categories}" var="category">
                  <c:choose>
                     <c:when test="${category.id==1}">
                       <option value="${category.id}" selected>${category.name}</option>
                     </c:when>
                     <c:otherwise>
                        <option value="${category.id}">${category.name}</option>
                      </c:otherwise>
                  </c:choose>
                </c:forEach>
               </select>
            </div>
            <div class="type">
              <input type="radio" id="direct" name="type" value="direct" checked>
              <label for="direct"><fmt:message key="type.direct"/></label><br>
              <input type="radio" id="reverse" name="type" value="reverse">
              <label for="reverse"><fmt:message key="type.reverse"/></label><br>
            </div>
           <div>
              <label><fmt:message key="lot.start-price" /></label>
                 <label> $</label>
                 <input  type="number" name="start_price" min=10 pattern="\d\.\d{3}" required />
           </div>
           <div>
              <label><fmt:message key="lot.date-start" /></label>
              <input  type="datetime-local" name="date_start" required />
           </div>
           <div>
             <label><fmt:message key="lot.date-end" /></label>
             <input  type="datetime-local" name="date_end" required />
           </div>
           <div>
             <label><fmt:message key="lot.description" /></label>
             <input class="text-input" id="description" type="text" name="description" />
           </div>
           <div>
              <button class="btn-create" type="submit"><fmt:message key="save" /></button>
           </div>
        </form>
      </div>
    </div>
  </body>

  <style>
    .lot {
       display: flex;
       justify-content: center;
       flex-direction: row;
       margin-top: 1%;
       border-top: 1px solid gainsboro;
   }
   .form-lot {
     display: flex;
     justify-content: space-between;;
     flex-direction: column;
     height: 400px;
     width: 45%;
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

  #description {
    eight: 50px;
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