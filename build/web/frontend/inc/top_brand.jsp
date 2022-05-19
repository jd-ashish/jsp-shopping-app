<%@page import="Helper.Constent"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ProductsDetailsDao"%>
<%@page import="modal.ProductsStock"%>
<%@page import="modal.Products"%>
<%@page import="Dao.ProductsDao"%>
<%@page import="Helper.Utils"%>



<!-- top-brands -->
<div class="top-brands">
    <div class="container">
        <h3>Hot Offers</h3>
        <!-- Button trigger modal -->

        <div class="agile_top_brands_grids">
            <%
                ProductsDao productsDao = new ProductsDao();
                for (Products products : productsDao.getProducts()) {
                    ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();

                    List<ProductsStock> productsStock = productsDetailsDao.getProductsStocksByProductId(products.getId());
                    
                    int mainPrice = productsStock.get(0).getTotal_price();
                    int offerPrice = productsStock.get(0).getOffer_price();
                    int sum = ((offerPrice - mainPrice) < 0) ? 0 : offerPrice - mainPrice;
                    
//                    int mainPrice = 0;
//                    int offerPrice = 0;
//                    int sum = 0;

            %>
            <div class="col-md-3 top_brand_left">
                <div class="hover14 column">
                    <div class="agile_top_brand_left_grid">
                        <div class="tag"><img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/tag.png" alt=" " class="img-responsive" /></div>
                        <div class="agile_top_brand_left_grid1">
                            <figure>
                                <div class="snipcart-item block" >
                                    <div class="snipcart-thumb">
                                        <a href="single.html"><img title=" " alt=" " src="img/products/<%= products.getThumbnail()%>" width="100px"  height="170"/></a>		
                                        <p><%= products.getName()%></p>
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