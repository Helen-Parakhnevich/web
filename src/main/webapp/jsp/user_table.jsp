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
        <label><fmt:message key="user.caption"/></label>
        <button class="btn-add" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=page_new_user'">+</button>
       </caption>
       <thead class="table-header">
       <tr class="header-user">
         <th>#</th>
         <th><fmt:message key="user.first-name"/></th>
         <th><fmt:message key="user.last-name"/></th>
         <th><fmt:message key="user.login"/></th>
         <th style='width:70px; text-align:center'><fmt:message key="user.is-admin"/></th>
         <th style='width:70px; text-align:center'><fmt:message key="user.is-blocked"/></th>
         <th style='width:100px'></th>
         <th style='width:100px'></th>
       </tr>
       <thead>
       <tbody class="table-body">
       <c:forEach items="${users}" var="user" varStatus="counter">
           <tr class="row-user">
             <td><c:out value="${counter.count}"/></td>
             <td><c:out value="${user.firstName}"/></td>
             <td><c:out value="${user.lastName}"/></td>
             <td><c:out value="${user.login}"/></td>
             <td style='font-size:20px; text-align:center'>
               <c:if test="${user.isAdmin}"><b>&#10003</b></c:if>
             </td>
             <td style='font-size:20px; text-align:center'>
               <c:if test="${user.isBlocked}"><b>&#10003</b</c:if>
             </td>
             <td style='width: 50px'>
               <c:if test="${user.id != sessionScope.userId}">
                 <button class="btn-block" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=block_unblock_user&userId=${user.id}'">
                   <c:if test="${user.isBlocked}"> <fmt:message key="user.btn-unblock" /></c:if>
                   <c:if test="${!user.isBlocked}"> <fmt:message key="user.btn-block" /></c:if>
                 </button>
               </c:if>
             </td>
             <td style='width: 50px'>
                <c:if test="${user.id != sessionScope.userId}">
                  <button class="btn-delete" type="submit" onclick="location.href= '${pageContext.request.contextPath}/controller?command=delete_user&userId=${user.id}'">
                    <fmt:message key="btn-delete"/>
                  </button>
                </c:if>
             </td>
           </tr>
       </c:forEach>
       <tbody>
    </table>
    </div>
  </body>

</html>