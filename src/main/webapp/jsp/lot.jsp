<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <link rel="stylesheet" href="../static/styles/style.css">
<%--<link rel="stylesheet" href="../static/styles/style_catalog.css"> --%>
    <script type="text/javascript" src="../static/scripts/timer.js"></script>
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
              <button class="watch" type="submit">WATCH</button>
            </form>
        </div>
        <div class="details" style="justify-content:start;">
            <form method="post" action="${pageContext.request.contextPath}/controller?command=make_bid">
                <input type="hidden" name="lotId" value="${lot.id}">
                <button class="make-bid" type="submit">MAKE A BID</button>
                <label> $</label>
                <c:choose>
                    <c:when test="${not empty lot.bidSum}">
                        <input class="bid-sum" name="bidSum" type="number" min="${lot.bidSum}" value="${lot.bidSum}"
                            step="200" />
                    </c:when>
                    <c:otherwise>
                        <input class="bid-sum" name="bidSum" type="number" min="${lot.startPrice}"
                            value="${lot.startPrice}" step="200" />
                    </c:otherwise>
                </c:choose>
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
            <p>ENDS ON: <span id="date_end" style="font-weight:bold;">${lot.stringDateEnd}</span></p>
            <p>TIME LEFT: <span id="timer" style="font-weight:bold;"></span></p>
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

<style>

@media (max-width: 800px) {
    .lot {
    flex-direction: column;
    }
}

.big-title {
        display: flex;
        justify-content: center;
        font-size: 18px;
        font-weight: bold;
        margin-top: 1%;
    }


    .lot {

   display: flex;
   flex-wrap: wrap;
   flex-direction: row;
   margin-top: 1%;
   border-top: 1px solid gainsboro;
        }

.lot > div {
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin: 2%;
}

.img {
    flex-basis: calc(50% - 40px);
}

    .make-bid,
    .bid-sum {

        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 18px;
        padding: 4px 15px;
    }

    .make-bid {
        border: none;
        background-color: #555555;
        color: whitesmoke;
        padding: 4px 15px;
    }

    .watch {
        border: 0.2px solid;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 16px;
        background-color: white;
        padding: 4px 15px;
    }

</style>

<script>
    console.log("${lot}");
    }
</script>

</html>