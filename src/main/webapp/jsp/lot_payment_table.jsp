 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="hp" uri ="/WEB-INF/custom.tld"%>

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
      <jsp:include page="/jsp/fragments/menu.jsp" />
    </nav>
    <div class="container">
    <table>
       <caption class="table-caption" align="left">
        <label><fmt:message key="lot.payment.caption"/></label>
       </caption>
       <thead class="table-header">
       <tr class="header-auction">
         <th>#</th>
         <th style='width:350px'><fmt:message key="lot.title"/></th>
         <th><fmt:message key="lot.category"/></th>
         <th><fmt:message key="lot.date-end"/></th>
         <th><fmt:message key="lot.total-price"/></h>
         <th style='width:100px'></th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${lots}" var="lot" varStatus="counter">
           <tr class="row-auction">
             <td><c:out value="${counter.count}"/></td>
             <td class="lot-title"><a style="color:black" href="${pageContext.request.contextPath}/controller?command=show_lot&lotId=${lot.id}">${lot.title}</a></td>
             <td><c:out value="${lot.categoryId}"/></td>
             <td><hp:formatDataTime locale="${sessionScope.locale}" value="${lot.dateEnd}"/></td>
             <td>$<fmt:formatNumber maxFractionDigits = "0" value="${lot.bidSum}"/></td>
             <td style='width: 50px; text-align:center'>
                <button class="btn-pay" type="submit" onclick="location.href='${pageContext.request.contextPath}/controller?command=pay_lot&lotId=${lot.id}'">
                   <fmt:message key="btn-pay"/>
                </button>
             </td>
           </tr>
       </c:forEach>
       <tbody>
    </table>
    </div>
  </body>

</html>