<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <link rel="stylesheet" href="../static/styles/style.css">
    <link rel="stylesheet" href="../static/styles/style_catalog.css">
    <script type="text/javascript" src="../static/scripts/timer.js"></script>
</head>

<body>

    <header class="top-header">
        <jsp:include page="./fragments/header.jsp" />
    </header>

    <nav class="top-nav">
        <jsp:include page="./fragments/menu.jsp" />
    </nav>
    <c:if test="${type=='direct'}">
      <jsp:include page="./fragments/filter_category.jsp" />
    </c:if>
    <div class="grid">
       <c:forEach items="${lots}" var="item" varStatus="loop">
            <div class="item">
                <div class="img-container">
                    <p><img src="data:image/jpeg;base64,${item.imgBase64}" width=100% height=100%></p>
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
                    <p class="end" hidden>ENDS: <span id="date_end${loop.index}" style="font-weight:bold;">${item.stringDateEnd}</span></p>
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
    console.log("${type}");
    </script>


    <style>
             .item-header {
                 border: none;
                 text-decoration: underline;
                 background-color: white;

             }

             .item-header {

                 cursor: pointer;

             }

    </style>

</body>

</html>