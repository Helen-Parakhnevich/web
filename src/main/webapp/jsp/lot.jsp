<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hp" uri ="/WEB-INF/custom.tld"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="content"/>

<c:choose>
<c:when test="${not empty lot.bidSum}">
<c:set var="starSumtBid" value="${lot.bidSum}" />
</c:when>
<c:otherwise>
<c:set var="starSumtBid" value="${lot.startPrice}" />
</c:otherwise>
</c:choose>

<html>
  <head>
    <link rel="stylesheet" href="./static/styles/style.css">
    <link rel="stylesheet" href="./static/styles/style_lot.css">
    <script type="text/javascript" src="./static/scripts/timer.js"></script>
    <title>${lot.title}</title>
  </head>
  <body>
    <header class="top-header">
        <jsp:include page="./fragments/header.jsp" />
    </header>
    <nav class="top-nav">
        <jsp:include page="./fragments/menu.jsp" />
    </nav>
    <div class="big-title">${lot.title}</div>
    <div class="lot">
        <div class="img" style="justify-content:start;">
            <img src="data:image/jpeg;base64,${lot.imgBase64}" width=100% height=100%>
            <form method="post" action="${pageContext.request.contextPath}/controller?command=watch">
              <button class="watch" type="submit">
                 <div class="star"></div>
                 <fmt:message key="btn.watch"/>
              </button>
            </form>
        </div>
        <div class="details" style="justify-content:start;">
            <form method="post" action="${pageContext.request.contextPath}/controller?command=make_bid">
                <input type="hidden" name="lotId" value="${lot.id}">
                <button class="make-bid" type="submit"><fmt:message key="btn.make-a-bid"/></button>
                <label> $</label>
                <c:choose>
                  <c:when test="${lot.type=='DIRECT'}">
                    <input class="bid-sum" name="bidSum" type="number" min="${starSumtBid}" value="${starSumtBid}" step="200" />
                  </c:when>
                  <c:otherwise>
                     <input class="bid-sum" name="bidSum" type="number" max="${starSumtBid}" min=1 value="${starSumtBid}" step="10" />
                  </c:otherwise>
                </c:choose>
            </form>
            <c:choose>
                <c:when test="${empty lot.bidSum}">
                    <p class="label"><fmt:message key="lot.start-price"/>: <span style="font-weight:bold;">$
                            <fmt:formatNumber maxFractionDigits="0" value="${lot.startPrice}" />
                        </span></p>
                </c:when>
                <c:otherwise>
                    <p class="label"><fmt:message key="current-bid"/>: <span style="font-weight:bold; text-transform:none;">
                    $<fmt:formatNumber maxFractionDigits="0" value="${lot.bidSum}" /> <fmt:message key="from"/> ${lot.bidUserFirstName} ${lot.bidUserLastName}
                        </span></p>
                </c:otherwise>
            </c:choose>
            <p class="label"><fmt:message key="ends-in"/>:
              <span style="font-weight:bold;">
                <hp:formatDataTime locale="${sessionScope.locale}" value="${lot.dateEnd}" />
              </span>
            </p>
            <p hidden>ENDS ON: <span id="date_end" style="font-weight:bold;">${lot.dateEnd}</span></p>
            <p class="label"><fmt:message key="time-left"/>: <span id="timer" style="font-weight:bold;"></span></p>
        </div>
        <div></div>
        <div></div>
    </div>

</body>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const currentDeadLine = new Date(String(document.getElementById("date_end").textContent));
        new CountdownTimer(currentDeadLine, (timer)=> {
            document.getElementById("timer").innerHTML = timer.days + ":" + timer.hours + ":" + timer.minutes + ":" + timer.seconds ;
          }, () => {
            document.getElementById("timer").innerHTML= 'ENDED';
          });
    });
</script>

</html>