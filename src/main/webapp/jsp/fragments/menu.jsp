 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>

        <div class="top-nav">
            <div class="dropdown"><a>AUCTIONS</a>
                <div class="dropdown-menu">
                    <ul>

                        <li>
                            <a href="controller?command=catalog">Direct auctions</a>

                         </li>
                        <li><a href="#">Revers auctions</a></li>
                        <li><a href="#">Planned lots</a></li>
                        <li><a href="#">Recently sold</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>BUY</a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="#">Motor vehicles</a></li>
                        <li><a href="#">Work of art</a></li>
                        <li><a href="#">Antiques</a></li>
                        <li><a href="#">Model cars</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>SELL</a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="#">Request for sale</a></li>
                        <li><a href="#">Sell at reverse auction</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown"><a>MY DASHBOARD</a>
                <div class="dropdown-menu">
                    <ul>
                        <li><a href="#">Waiting for payment</a></li>
                        <li><a href="#">My lots</a></li>
                        <li><a href="#">My bids</a></li>
                        <li><a href="#">My watchlist</a></li>
                        <li><a href="#">My purchases</a></li>
                        <li><a href="#">My sales</a></li>
                    </ul>
                </div>
            </div>
            <div class="top-nav-left">
                <a href="" class="login" data-toggle="modal" data-target="#loginModal" action="controller?command=logout">Log Out</a>
                <span class="dropdown"><a>EN</a>
                    <div class="dropdown-menu">
                        <ul class="language">
                            <li><a value="en_En">$(en)</a></li>
                            <li><a value="by_BY">$(by)</a></li>
                            <li><a value="ru_RU">$(ru)</a></li>
                        </ul>
                    </div>
                </span>
            </div>
        </div>
    </nav>



