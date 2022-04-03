 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <fmt:setLocale value="${sessionScope.locale}"/>
 <fmt:setBundle basename="content"/>

 <html>

        <div class="top-nav">
            <div class="dropdown"><a><fmt:message key="menu.users"/></a>
            </div>
            <div class="dropdown"><a href="${pageContext.request.contextPath}/controller?command=auctions"><fmt:message key="menu.auctions"/></a>
            </div>
            <div class="dropdown"><a><fmt:message key="menu.categories"/></a>
            </div>
            <div class="dropdown"><a><fmt:message key="menu.bids"/></a>
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



