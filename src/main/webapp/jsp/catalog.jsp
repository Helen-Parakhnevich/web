<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.locale == null}">
    <c:set var="locale" value="en_EN" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<html>

<head>
    <link rel="stylesheet" href="./static/styles/style.css">
    <link rel="stylesheet" href="./static/styles/style_catalog.css">
    <script type="text/javascript" src="./static/scripts/timer.js"></script>
</head>

<body>
    <header class="top-header">
        <jsp:include page="./fragments/header.jsp" />
    </header>

    <nav class="top-nav">
        <jsp:include page="./fragments/menu.jsp" />
    </nav>
    <c:if test="${type=='direct'}">
      <div class="page-header"><fmt:message key="page-header.direct-auctions"/></div>
      <jsp:include page="./fragments/filter_category.jsp" />
    </c:if>
    <c:if test="${type=='reverse'}">
        <div class="page-header"><fmt:message key="page-header.reverse-auctions"/></div>
    </c:if>
    <div class="grid">
       <c:forEach items="${lots}" var="item" varStatus="loop">
            <div class="item">
                <div class="img-container">
                    <div>
                       <c:choose>
                          <c:when test="${empty item.imgBase64}" >
                            <img src="static/img/no-image.png" width=100% height=100%>
                          </c:when>
                          <c:otherwise>
                            <img src="data:image/jpeg;base64,${item.imgBase64}" width=100% height=100%>
                          </c:otherwise>
                       </c:choose>
                      <c:if test="${item.type=='REVERSE'}">
                        <button class="ico-revers"></button>
                      </c:if>
                    </div>
                </div>
                <div class="text-container">
                  <form method="post" action="${pageContext.request.contextPath}/controller?command=show_lot">
                     <input type="hidden" name="lotId" value="${item.id}">
                     <button class="item-header" type="submit">${item.title}</button>
                  </form>
                    <c:choose>
                      <c:when test="${empty item.bidSum}" >
                        <p>START PRICE: <span style="font-weight:bold;">$<fmt:formatNumber maxFractionDigits = "0" value="${item.startPrice}"/></span></p>
                      </c:when>
                      <c:otherwise>
                        <p>CURRENT BID: <span style="font-weight:bold;">$<fmt:formatNumber maxFractionDigits = "0" value="${item.bidSum}"/> from ${item.bidUserFirstName} ${item.bidUserLastName}</span></p>
                      </c:otherwise>
                    </c:choose>
                    <p class="end" hidden>ENDS: <span id="date_end${loop.index}" style="font-weight:bold;">${item.dateEnd}</span></p>
                    <p>ENDS IN: <span id="timer${loop.index}" style="font-weight:bold;"></span></p>
                </div>
            </div>
        </c:forEach>

    </div>

<script>

    document.addEventListener('DOMContentLoaded', () => {

    for (let i=0; i<"${lots.size()}"; i++) {

        const currentDeadLine = new Date(String(document.getElementById("date_end"+ i).textContent));

        new CountdownTimer(currentDeadLine, (timer)=> {

            document.getElementById("timer"+ i).innerHTML = timer.days + ":" + timer.hours + ":" + timer.minutes + ":" + timer.seconds ;

          }, () => {
            document.getElementById("timer"+ i).innerHTML= 'ENDED';
          });
    }
    });

    </script>


    <style>
    .page-header {
            display: flex;
            justify-content: center;
            font-size: 18px;
            font-weight: bold;
            margin-top: 1%;
        }

             .item-header {
                 border: none;
                 text-decoration: underline;
                 background-color: white;
                 cursor: pointer;
             }


             .ico-revers {
               width: 35px;
               height: 38px;
               display: inline-block;
               vertical-align: top;
               position: relative;
               margin-left: 10px;
               background-image: url('./static/img/arrow-blue.png');
               background-size: 100%;
               background-color: inherit;
               border: none;
               cursor: pointer;
               float: right;
               margin-top: 5px;
               margin-right: 10px;
             }

             .revers {
              display: inline-block;
               vertical-align: top;
               position: relative;
             -webkit-background-clip: text;
             -moz-background-clip: text;
             background-clip: text;
             color: transparent;
             text-shadow: rgba(255,255,255,0.5) 0px 3px 3px;
             font-size: 10px;
             color: yellowgreen;
             }

    </style>

</body>

</html>