 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <div class="top-nav">
            <div class="dropdown"><a>AUCTIONS</a>
                <div class="dropdown-menu">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/controller?command=catalog">Direct auctions</a>
                         </li>
                        <li><a href="#">Revers auctions</a></li>
                        <li><a href="#">Planned lots</a></li>
                        <li><a href="#">Recently sold</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>BUY</a>
                <div class="dropdown-menu">
                    <ul>
                    <c:forEach items="${sessionScope.categories}" var="category">
                    <li><a href="#">${category.name}</a></li>
                    </c:forEach>
                     <%--   <li><a href="#">Motor vehicles</a></li>
                        <li><a href="#">Work of art</a></li>
                        <li><a href="#">Antiques</a></li>
                        <li><a href="#">Model cars</a></li> --%>
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
                <a href="${pageContext.request.contextPath}/controller?command=logout" class="login">Log Out</a>
                <div class="dropdown"><a ${language}></a>
                    <div class="dropdown-menu">
                        <ul class="language">
                            <li><a href="${pageContext.request.contextPath}/controller?command=en">en</a></li>
                            <li><a href="${pageContext.request.contextPath}/controller?command=by">by</a></li>
                            <li><a href="${pageContext.request.contextPath}/controller?command=ru">ru</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>



