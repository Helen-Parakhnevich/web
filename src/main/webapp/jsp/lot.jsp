<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <link rel="stylesheet" href="../static/styles/style.css">
<%--<link rel="stylesheet" href="../static/styles/style_catalog.css"> --%>
    <script src="../scripts/timer.js"></script>
</head>

<body>

    <header class="top-header">
        <jsp:include page="./fragments/header.jsp" />
    </header>

    <nav class="top-nav">
        <jsp:include page="./fragments/menu.jsp" />
    </nav>

    <div class="lot">
        <div >
            <p><img src="data:image/jpeg;base64,${lot.imgBase64}" width=100% height=100%></p>
        </div>
        <div >
            <form method="post" action="${pageContext.request.contextPath}/controller?command=show_lot">
                <input type="hidden" name="lotId" value="${lot.id}">
                <button class="lot-header" type="submit">${lot.title}</button>
            </form>
            <c:choose>
                <c:when test="${empty lot.bidSum}">
                    <p>START PRICE: <span style="font-weight:bold;">$
                            <fmt:formatNumber maxFractionDigits="0" value="${lot.startPrice}" />
                        </span></p>
                </c:when>
                <c:otherwise>
                    <p>CURRENT BID: <span style="font-weight:bold;">$
                            <fmt:formatNumber maxFractionDigits="0" value="${lot.bidSum}" /> from
                            ${lot.bidUserFirstName} ${lot.bidUserLastName}
                        </span></p>
                </c:otherwise>
            </c:choose>
            <p class="end" hidden>ENDS: <span id="date_end${loop.index}"
                    style="font-weight:bold;">${lot.stringDateEnd}</span></p>
            <p>ENDS IN: <span id="timer${loop.index}" style="font-weight:bold;"></span></p>
        </div>
        <div></div>
        <div></div>
    </div>

</body>

<style>
.lot {
   min-height: 100%;
   display: flex;
   flex-wrap: wrap;
   flex-direction: row;
   margin-top: 5%;
        }
.lot > div {
  display: flex;
  flex-basis: calc(50% - 40px);
  justify-content: center;
  flex-direction: column;
}

.lot > div > div {
  display: flex;
  justify-content: center;
  flex-direction: row;
}

</style>

<script>
    console.log("${lot}");
</script>

</html>