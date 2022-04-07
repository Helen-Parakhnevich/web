 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
  <head>
      <link rel="stylesheet" href="./static/styles/style.css">
  </head>

  <body>
    <header class="top-header">
        <jsp:include page="/jsp/fragments/header.jsp" />
    </header>
    <nav class="top-nav">
      <jsp:include page="/jsp/fragments/menu_admin.jsp" />
    </nav>

    <div class="container">
    <table>
       <caption class="table-caption" align="left">
        <label><fmt:message key="user.caption"/></label>
        <button class="btn-add" type="submit">+</button>
       </caption>
       <thead class="table-header">
       <tr>
         <th>#<th>
         <th><fmt:message key="user.first-name"/><th>
         <th><fmt:message key="user.last-name"/><th>
         <th><fmt:message key="user.login"/><th>
         <th><fmt:message key="user.is-admin"/><th>
         <th><fmt:message key="user.is-blocked"/><th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${users}" var="user" varStatus="counter">
           <tr class="row">
             <td><c:out value="${counter.count}"/><td>
             <td><c:out value="${user.firstName}"/><td>
             <td><c:out value="${user.lastName}"/><td>
             <td><c:out value="${user.login}"/><td>
             <td><c:out value="${user.isAdmin}"/><td>
             <td><c:out value="${user.isBlocked}"/><td>
             <%-- <c:if test="${user.isAdmin}">
               <td><td>
             </c:if>
             <c:if test="${user.isBlocked}">
                <td><td>
             </c:if> --%>
           </tr>
       </c:forEach>
       <tbody>
    </table>
    </div>
  </body>

  <style>

  table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
  }

  .table-caption, .table-header {
    text-transform: uppercase;
  }

  .table-caption {
    font-weight: bold;
  }

  .table-header {
    background-color: rgb(221, 221, 221);;
    font-weight: normal;
    font-size: 12px;
  }

  .table-body {
    overflow-x: auto;
  }

  /* Style table headers and table data */
  th, td {
    text-align: left;
    padding: 16px;
  }

  th:first-child, td:first-child {
    text-align: left;
  }

  /* Zebra-striped table rows */
  tr:nth-child(even) {
    background-color: #f2f2f2
  }

  .container {
     display: grid;
     position: relative;
     margin: 3%;
  }

  .btn-add {
    background-color: #555555;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 30px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 18px;
    margin: 4px 2px;
    border-radius: 50%;
  }

  .btn-add:hover {
    background-color: #7d7b7b
  }

  .btn-add:active {
    background-color: #7d7b7b;
    transform: translateY(1px);
  }

  </style>

</html>