<%@page import="Helper.Constent"%>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark ">
        <a class="navbar-brand flex-grow-1" href="#"><%= Constent.APP_NAME%></a>
        <div class="flex-grow-1 d-flex">
            <form class="form-inline flex-nowrap mx-0 mx-lg-auto">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            </form>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ml-auto">
                <a class="nav-item nav-link" href="#"> <i class="fas fa-sign-out-alt"></i> Logout</a>
                <a class="nav-item nav-link" href="#"><i class="fas fa-shopping-cart"></i> Cart</a>
                <a class="nav-item nav-link" href="#"><i class="fas fa-tachometer-alt"></i> Account</a>
            </div>
        </div>
    </nav>
</header>  