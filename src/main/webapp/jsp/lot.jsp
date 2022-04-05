<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <link rel="stylesheet" href="../static/styles/style.css">
<%--<link rel="stylesheet" href="../static/styles/style_catalog.css"> --%>
    <script type="text/javascript" src="../static/scripts/timer.js"></script>
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
                 WATCH
              </button>
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
   background-image: url("arrow-blue.png");
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

    .star {
      display: inline-block;
      vertical-align: top;
      margin-left: 10px;
      margin-right: 10px;
      width: 38px;
      height: 35px;
      background: linear-gradient(to bottom, rgba(197, 196, 196, 1) 0%, rgba(180, 179, 178, 1) 100%);
      position: relative;
    }

    .star:before {
      content: '';
      position: absolute;
      top: 1px;
      left: 2px;
      bottom: 1px;
      right: 1px;
      background: linear-gradient(to bottom, rgba(221, 220, 219, 1) 0%, rgba(209, 208, 206, 1) 100%);
      z-index: 1;
    }

    .star,
    .star:before {
      -webkit-clip-path: polygon(50% 0%, 66% 27%, 98% 35%, 76% 57%, 79% 91%, 50% 78%, 21% 91%, 24% 57%, 2% 35%, 32% 27%);
      clip-path: polygon(50% 0%, 66% 27%, 98% 35%, 76% 57%, 79% 91%, 50% 78%, 21% 91%, 24% 57%, 2% 35%, 32% 27%);
    }

    .star:hover {
      background: linear-gradient(to bottom, rgba(224, 194, 75, 1) 0%, rgba(207, 125, 0, 1) 100%);
    }

    .star:hover:before {
      background: linear-gradient(to bottom, rgba(243, 212, 85, 1) 0%, rgba(238, 164, 0, 1) 100%);
    }

</style>

<script>
    console.log("${lot}");
    }
</script>

</html>