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
                            <a href="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">Direct auctions</a>
                         </li>
                        <li><a href="${pageContext.request.contextPath}/controller?command=reverse_lot">Revers auctions</a></li>
                        <%--<li><a href="#">Planned lots</a></li>--%>
                        <li><a href="#">Recently sold</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a href="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">BUY</a>
                <div class="dropdown-menu">
                    <ul>
                    <c:forEach items="${sessionScope.categories}" var="category">
                    <form class="category" method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
                          <input  name="categoryId" value="${category.id}" type="hidden">
                           <button class="button" id="button${loop.index}" type="submit">${category.name}</button>
                     </form>
                    </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>SELL</a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="#">Request for sale</a></li>
                        <li><a href="#">Sell at reverse auction</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>MY DASHBOARD</a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="#">Waiting for payment</a></li>
                        <li><a href="#">My lots</a></li>
                        <li><a href="#">My bids</a></li>
                        <li><a href="#">My watchlist</a></li>
                        <li><a href="#">My purchases</a></li>
                        <li><a href="#">My sales</a></li>
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



