<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <link rel="stylesheet" href="../static/styles/style.css">
    <link rel="stylesheet" href="../static/styles/style_catalog.css">
    <script src="../scripts/timer.js"></script>
</head>

<body>
    <header class="top-header">
        <jsp:include page="./fragments/header.jsp" />
    </header>

    <nav class="top-nav">
        <jsp:include page="./fragments/menu.jsp" />
    </nav>
    <jsp:include page="./fragments/filter_category.jsp" />
    <div class="grid">
       <c:forEach items="${lots}" var="item">
            <div class="item">
                <div class="img-container">
                    <p><img src="data:image/jpeg;base64,${item.img}" width=100% height=100%></p>
                </div>
                <div class="text-container">
                    <p class="item-header">${item.title}</p>
                    <p>CURRENT BID: <span style="font-weight:bold;"> $55,000 </span></p>
                    <p class="end" hidden>ENDS: <span id="date_end" style="font-weight:bold;">${item.stringDateEnd}</span></p>
                    <p>ENDS IN: <span id="timer" style="font-weight:bold;"></span></p>
                </div>
            </div>
        </c:forEach>
        <div class="item">
            <div class="img-container">
                <p><img src="..static/img/1967Camaro.jpg" width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1967 Chevrolet Camaro coupe</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $55,000 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 7 days</span></p>
            </div>
        </div>
        <div class="item">
            <div class="img-container">
                <p><img src="..static/img/1958Porsche356.jpeg" width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1958 Porsche 356A Sunroof Coupe</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $115,000 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 22 hours</span></p>
            </div>
        </div>
        <div class="item">
            <div class="img-container">
                <p><img src="../static/img/1969FordBronco.jpg" width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1969 Ford Bronco Sport</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $58,000 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 1 day</span></p>
            </div>
        </div>
        <div class="item">
            <div class="img-container">
                <p><img src="data:image/png;base64,<?=base64_encode(${img});?>"/> width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1972 Volkswagen Type 2 Campmobile</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $25,000 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 2 days</span></p>
            </div>
        </div>
        <div class="item">
            <div class="img-container">
                <p><img src="../static/img/1972Porsche911E.jpeg" width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1972 Porsche 911E Coupe</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $78,500 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 15 hours</span></p>
            </div>
        </div>
        <div class="item">
            <div class="img-container">
                <p><img src="../static/img/1993ChevroletCorvette.jpg" width=100% height=100%></p>
            </div>
            <div class="text-container">
                <p class="item-header">1993 Chevrolet Corvette ZR-1</p>
                <p>CURRENT BID: <span style="font-weight:bold;"> $19,100 </span></p>
                <p>END IN: <span style="font-weight:bold;"> 10 hours</span></p>
            </div>
        </div>
    </div>

<script>



    for (var i=1, b; b = document.getElementById("date_end"); i++) {
                b.id = b.id + "_" +i;
        }

        for (var i=1, b; b = document.getElementById("timer"); i++) {
                    b.id = b.id + "_" +i;
        }

    var countDownDate = Date.parse(document.getElementById('date_end_1').innerHTML);

    var countDownFunction = setInterval(function () {
    var now = new Date().getTime();
    var distance = countDownDate - now;

    var days = Math.floor(distance/(1000*60*60*24));
    var hours = Math.floor((distance % (1000*60*60*24)) / (1000*60*60));
    var minutes = Math.floor((distance % (1000*60*60)) / (1000*60));
    var seconds = Math.floor((distance % (1000*60)) / (1000));

    document.getElementById("timer_1").innerHTML = days + "d " + hours + "h " +  minutes + "m " + seconds + "s";
     if (distance<0) {
        clearInterval(countDownFunction);
        document.getElementById("timer_1").innerHTML = "completed";
     }
    }, 1000)

    </script>

</body>

</html>