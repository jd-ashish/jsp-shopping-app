<%@page import="Helper.Utils"%>
<%@page import="modal.ProductsStock"%>
<%@page import="java.util.List"%>
<%@page import="modal.Products"%>
<%@page import="Dao.ProductsDetailsDao"%>
<%@page import="Dao.ProductsDao"%>
<%
    String ids = GenBase64.deCode(request.getParameter("data"));
    String col;
    if (ids.equals("-99")) {
        col = request.getParameter("search");
    } else {
        col = GenBase64.deCode(request.getParameter("type"));
    }

    String col_name = GenBase64.deCode(request.getParameter("type_name"));

%>
<!-- products-breadcrumb -->
<div class="products-breadcrumb">
    <div class="container">
        <ul>
            <li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
            <li><%=col_name%></li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<!-- banner -->
<div class="banner">
    <%@include file="../inc/nav_left_side_category.jsp" %>
    <div class="w3l_banner_nav_right">
        <div class="w3l_banner_nav_right_banner5">
            <h3>Best Deals For New Products<span class="blink_me"></span></h3>
        </div>

        <div class="w3ls_w3l_banner_nav_right_grid w3ls_w3l_banner_nav_right_grid_veg">
            <h3 class="w3l_fruit"><%= col_name%></h3>
            <div class="w3ls_w3l_banner_nav_right_grid1 w3ls_w3l_banner_nav_right_grid1_veg">
                <%
                    ProductsDao productsDao = new ProductsDao();

                    for (Products products : productsDao.getProducts(col, Integer.valueOf(ids))) {
                        ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();

                        List<ProductsStock> productsStock = productsDetailsDao.getProductsStocksByProductId(products.getId());

                        int mainPrice = productsStock.get(0).getTotal_price();
                        int offerPrice = productsStock.get(0).getOffer_price();
                        int sum = ((offerPrice - mainPrice) < 0) ? 0 : offerPrice - mainPrice;

//                    int mainPrice = 0;
//                    int offerPrice = 0;
//                    int sum = 0;

                %>
                <div class="col-md-3 w3ls_w3l_banner_left w3ls_w3l_banner_left_asdfdfd">
                    <div class="hover14 column">
                        <div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
                            <div class="tag"><img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/tag.png" alt=" " class="img-responsive"></div>
                            <div class="agile_top_brand_left_grid1">
                                <figure>
                                    <div class="snipcart-item block">
                                        <div class="snipcart-thumb">
                                            <a href="single.html"><img style="width: auto; height: 170px;" src="<%= Utils.getBaseUrl(request)%>/img/products/<%= products.getThumbnail()%>" alt=" " class="img-responsive" /></a>
                                            <p class="products-name"><%= products.getName()%></p>
                                            <h4><% if (productsStock.size() > 0) {%><%= Utils.CurrencyFormaString(String.valueOf(productsStock.get(0).getOffer_price()))%><% } %> <span><% if (productsStock.size() > 0) {%><%= Utils.CurrencyFormaString(String.valueOf(productsStock.get(0).getTotal_price()))%><% }%></span></h4>

                                        </div>
                                        <div class="snipcart-details top_brand_home_details">
                                            <input type="submit" name="submit" value="Add to cart" class="button add_to_cart" stock_id="<% if (productsStock.size() > 0) {%><%= productsStock.get(0).getId()%><% } %>"/>

                                        </div>
                                    </div>
                                </figure>
                            </div>
                        </div>
                    </div>
                </div>
                <% }%>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>