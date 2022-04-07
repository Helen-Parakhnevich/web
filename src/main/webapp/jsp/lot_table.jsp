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
        <label><fmt:message key="lot.caption"/></label>
        <button class="btn-add" type="submit">+</button>
       </caption>
       <thead class="table-header">
       <tr>
         <th>#<th>
         <th><fmt:message key="lot.title"/><th>
         <th><fmt:message key="lot.type"/><th>
         <th><fmt:message key="lot.category"/><th>
         <th><fmt:message key="lot.date_start"/><th>
         <th><fmt:message key="lot.date_end"/><th>
         <th><fmt:message key="lot.start_price"/><th>
         <th><fmt:message key="lot.status"/><th>
         <th><fmt:message key="lot.is_paid"/><th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${lots}" var="lot" varStatus="counter">
           <tr class="row">
             <td><c:out value="${counter.count}"/><td>
             <td><c:out value="${lot.title}"/><td>
             <td><c:out value="${lot.type}"/><td>
             <td><c:out value="${lot.categoryId}"/><td>
             <td><c:out value="${lot.dateStart}"/><td>
             <td><c:out value="${lot.dateEnd}"/><td>
             <td><c:out value="${lot.startPrice}"/><td>
             <td><c:out value="${lot.status}"/><td>

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