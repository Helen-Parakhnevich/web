<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="static/styles/style_login.css">
</head>
<header class="login">
</header>

<body>
    <div class="central-block">
        <div class="text-header">
            <div>Auction</div>
            <div class="top-header-add">many priceless things can de bought...</div>
        </div>
        <div class="login-container">
            <div class="login-box">
                <form class="form-login" method="post" action="controller?command=login">
                    <div>
                        <input class="login-row" type="text" name="login" placeholder="Login" />
                    </div>
                    <div>
                        <input class=" login-row" type="password" name="password" placeholder="Password" />
                    </div>
                    <div>
                        <input class=" login-row" type="submit" value="Log In"/>
                    </div>
                    <div>
                        <p style="color:black" ;>${errorMessage}</p>
                    </div>
                </form>

            </div>
        </div>
    </div>

        <div class="img" style="size: 100px;">
            <p><img src="static/img/wave.png" width=100% height="15%"></p>
        </div>

</body>
</html>
