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
        <label><fmt:message key="request.caption"/></label>
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
         <th><fmt:message key="lot.seller"/></th>
         <th style='width:100px'></th>
         <th style='width:100px'></th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${lots}" var="lot" varStatus="counter">
           <tr class="row-auction">
             <td><c:out value="${counter.count}"/></td>
             <td class="lot-title"><a>${lot.title}"</a></td>
             <td><c:out value="${lot.type}"/></td>
             <td><c:out value="${lot.categoryId}"/></td>
             <td><c:out value="${lot.dateStart}"/></td>
             <td><c:out value="${lot.dateEnd}"/></td>
             <td>$<fmt:formatNumber maxFractionDigits = "0" value="${lot.startPrice}"/></td>
             <td><c:out value="${lot.seller}"/></td>
             <td style='width: 50px; text-align:center'>
                <button class="btn-approve" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=approve_lot&lotId=${lot.id}'">
                   <fmt:message key="btn-approve"/>
                </button>
             </td>
             <td style='width: 50px; text-align:center'>
                <button class="btn-delete" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=delete_lot&lotId=${lot.id}'">
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