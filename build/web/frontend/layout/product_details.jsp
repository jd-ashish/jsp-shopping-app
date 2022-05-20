<%@page import="modal.ProductsStock"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ProductsDetailsDao"%>
<%@page import="Dao.ProductsDao"%>
<%@page import="modal.Products"%>
<%
    String pid = GenBase64.deCode(Utils.reverse(request.getParameter("id")));
    String name = GenBase64.deCode(Utils.reverse(request.getParameter("name")));

    Products products = ProductsDao.getProductsById("", Integer.valueOf(pid)).get(0);
    ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();

    List<ProductsStock> productsStock = productsDetailsDao.getProductsStocksByProductId(products.getId());

    int mainPrice = productsStock.get(0).getTotal_price();
    int offerPrice = productsStock.get(0).getOffer_price();
    int sum = ((offerPrice - mainPrice) < 0) ? 0 : offerPrice - mainPrice;
%>
<!-- products-breadcrumb -->
<div class="products-breadcrumb">
    <div class="container">
        <ul>
            <li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
            <li>Single Page <%=name%></li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<!-- banner -->
<div class="banner">
    <%@include file="../inc/nav_left_side_category.jsp" %>
    <div class="w3l_banner_nav_right">
        <div class="w3l_banner_nav_right_banner3">
            <h3>Best Deals For New Products<span class="blink_me"></span></h3>
        </div>
        <div class="agileinfo_single">
            <h5><%=name%></h5>
            <div class="col-md-4 agileinfo_single_left">
                <img id="example" src="<%= Utils.getBaseUrl(request)%>/img/products/<%= products.getThumbnail()%>" alt=" " class="img-responsive" />
            </div>
            <div class="col-md-8 agileinfo_single_right">
                <div class="rating1">
                    <span class="starRating">
                        <input id="rating5" type="radio" name="rating" value="5">
                        <label for="rating5">5</label>
                        <input id="rating4" type="radio" name="rating" value="4">
                        <label for="rating4">4</label>
                        <input id="rating3" type="radio" name="rating" value="3" checked>
                        <label for="rating3">3</label>
                        <input id="rating2" type="radio" name="rating" value="2">
                        <label for="rating2">2</label>
                        <input id="rating1" type="radio" name="rating" value="1">
                        <label for="rating1">1</label>
                    </span>
                </div>
                <div class="w3agile_description">
                    <h4>Description :</h4>
                    <p><%=products.getDetails()%>.</p>
                </div>
                <div class="snipcart-item block">
                    <div class="snipcart-thumb agileinfo_single_right_snipcart">
                        <h4><% if (productsStock.size() > 0) {%><%= Utils.CurrencyFormaString(String.valueOf(productsStock.get(0).getOffer_price()))%><% } %> <span><% if (productsStock.size() > 0) {%><%= Utils.CurrencyFormaString(String.valueOf(productsStock.get(0).getTotal_price()))%><% }%></span></h4>

                    </div>
                    <div class="snipcart-details agileinfo_single_right_details">
                        <input type="button" name="submit" value="Add to cart" class="button add_to_cart" stock_id="<% if (productsStock.size() > 0) {%><%= productsStock.get(0).getId()%><% } %>"/>

                    </div>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>