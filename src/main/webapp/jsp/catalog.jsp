<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<html>

<head>
    <link rel="stylesheet" href="static/styles/style.css">
    <link rel="stylesheet" href="static/styles/style_catalog.css">
</head>

<body>
    <header class="top-header">
        <jsp:include page="/WEB-INF/view/fragments/header.jsp" />
    </header>

        <nav class="top-nav">
            <jsp:include page="/WEB-INF/view/fragments/menu.jsp" />
        </nav>
                <div class="grid">
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1967Camaro.jpg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1967 Chevrolet Camaro coupe</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $55,000 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 7 days</span></p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1958Porsche356.jpeg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1958 Porsche 356A Sunroof Coupe</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $115,000 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 22 hours</span></p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1969FordBronco.jpg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1969 Ford Bronco Sport</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $58,000 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 1 day</span></p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1972VolkswagenBus.jpg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1972 Volkswagen Type 2 Campmobile</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $25,000 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 2 days</span></p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1972Porsche911E.jpeg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1972 Porsche 911E Coupe</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $78,500 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 15 hours</span></p>
                                </div>
                            </div>
                            <div class="item">
                                <div class="img-container">
                                    <p><img src="static/img/1993ChevroletCorvette.jpg" width=100% height=100%></p>
                                </div>
                                <div class="text-container">
                                    <p class="item-header">1993 Chevrolet Corvette ZR-1</p>
                                    <p>CURRENT BID: <span style="font-weight:bold;"> $19,100 </span></p>
                                    <p>END IN: <span style="font-weight:bold;"> 10 hours</span></p>
                                </div>
                            </div>
                        </div>

</body>

</html>