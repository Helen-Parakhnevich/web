 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
  <head>
      <link rel="stylesheet" href="./static/styles/style.css">
      <link rel="stylesheet" href="./static/styles/style_table.css">
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
        <button class="btn-add" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=page_new_lot'">+</button>
       </caption>
       <thead class="table-header">
       <tr class="header-auction">
         <th>#</th>
         <th style='width:350px'><fmt:message key="lot.title"/></th>
         <th><fmt:message key="lot.type"/></th>
         <th><fmt:message key="lot.category"/></th>
         <th><fmt:message key="lot.date-start"/></th>
         <th><fmt:message key="lot.date-end"/></th>
         <th><fmt:message key="lot.start-price"/></h>
         <th><fmt:message key="lot.status"/></th>
         <th><fmt:message key="lot.is-paid"/></th>
         <th style='width:100px'></th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${lots}" var="lot" varStatus="counter">
           <tr class="row-auction">
             <td><c:out value="${counter.count}"/></td>
             <td class="lot-title"><a href="${pageContext.request.contextPath}/controller?command=edit_lot&lotId=${lot.id}">${lot.title}</a></td>
             <td><c:out value="${lot.type}"/></td>
             <td><c:out value="${lot.categoryId}"/></td>
             <td><c:out value="${lot.dateStart}"/></td>
             <td><c:out value="${lot.dateEnd}"/></td>
             <td>$<fmt:formatNumber maxFractionDigits = "0" value="${lot.startPrice}"/></td>
             <td><c:out value="${lot.status}"/></td>
             <td style='font-size:20px; text-align:center'>
               <c:if test="${lot.isPaid}"><b>&#10003</b</c:if>
             </td>
             <td style='width: 50px; text-align:center'>
                <button class="btn-delete" type="submit" onclick="location.href='${pageContext.request.contextPath}/controller?command=delete_lot&lotId=${lot.id}'">
                   <fmt:message key="btn-delete"/>
                </button>
             </td>
           </tr>
       </c:forEach>
       <tbody>
    </table>
    </div>
  </body>

</html>