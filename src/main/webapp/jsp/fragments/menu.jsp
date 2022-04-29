 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>
        <div class="top-nav">
            <div class="dropdown"><a><fmt:message key="menu.auctions"/></a>
                <div class="dropdown-menu">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/controller?command=direct_lot_by_category"><fmt:message key="menu.direct-auctions"/></a>
                         </li>
                        <li><a href="${pageContext.request.contextPath}/controller?command=reverse_lot"><fmt:message key="menu.revers-auctions"/></a></li>
                        <%--<li><a href="#">Planned lots</a></li>
                        <li><a href="#"><fmt:message key="menu.recently-sold"/></a></li>--%>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a href="${pageContext.request.contextPath}/controller?command=direct_lot_by_category"><fmt:message key="menu.buy"/></a>
                <div class="dropdown-menu">
                    <ul>
                    <c:forEach items="${sessionScope.categories}" var="category">
                    <form class="category" method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
                          <input  name="categoryId" value="${category.id}" type="hidden">
                          <button class="button" id="button${loop.index}" onclick="sessionStorage.setItem('currentCategoryId', ${category.id})" type="submit" >
                            <c:choose>
                              <c:when test="${sessionScope.language=='en'}">${category.en}</c:when>
                              <c:when test="${sessionScope.language=='be'}">${category.be}</c:when>
                              <c:when test="${sessionScope.language=='ru'}">${category.ru}</c:when>
                              <c:otherwise>${category.name}</c:otherwise>
                             </c:choose>
                          </button>
                     </form>
                    </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a><fmt:message key="menu.sell"/></a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/controller?command=page_new_lot"><fmt:message key="menu.request-for-sale"/></a></li>
                        <li><a href="${pageContext.request.contextPath}/controller?command=reverse_lot"><fmt:message key="menu.sell-at-reverse-auction"/></a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a><fmt:message key="menu.my-dashboard"/>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/controller?command=waiting_for_payment"><fmt:message key="menu.waiting-for-payment"/></a></li>
                        <li><a href="#"><fmt:message key="menu.my-lots"/></a></li>
                        <li><a href="#"><fmt:message key="menu.my-bids"/></a></li>
                        <li><a href="#"><fmt:message key="menu.my-watchlist"/></a></li>
                        <li><a href="#"><fmt:message key="menu.my-purchases"/></a></li>
                        <li><a href="#"><fmt:message key="menu.my-sales"/></a></li>
                    </ul>
                </div>
            </div>
            <div class="top-nav-left">
                <a href="${pageContext.request.contextPath}/controller?command=logout" class="login"><fmt:message key="menu.log-out"/></a>
                <div class="dropdown"><a>${language}</a>
                    <div class="dropdown-menu">
                        <ul>
                        <form class="language" method="post" action="${pageContext.request.contextPath}/controller?command=language">
                           <li><button class="button" type="submit" name="language" value="en_US">en</button></li>
                           <li><button class="button" type="submit" name="language" value="be_BY">by</button></li>
                           <li><button class="button" type="submit" name="language" value="ru_RU">ru</button></li>
                        </form>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>

</html>

    <style>
      .dropdown a {
         text-decoration: none;
         color: black;
       }
        .button {
            display: block;
            color: black;
            white-space: nowrap;
            padding: 14px 16px;
            text-decoration: none;
            text-align: left;
            font-size: 12px;
            width: 100%;
            border: none;
            background: none;
            text-transform: uppercase;
            height: auto;
            list-style-type: none;

            background-color:transparent;
            height: auto;
            min-width: 1rem;
         }

         .button:hover {
             background-color: rgb(221, 221, 221);
         }
        .category, .language{
            margin: 0;
            padding: 0;
          }
    </style>



