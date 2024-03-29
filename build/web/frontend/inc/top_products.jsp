<%@page import="Helper.Utils"%>
<!-- fresh-vegetables -->
        <div class="fresh-vegetables">
            <div class="container">
                <h3>Top Products</h3>
                <div class="w3l_fresh_vegetables_grids">
                    <div class="col-md-3 w3l_fresh_vegetables_grid w3l_fresh_vegetables_grid_left">
                        <div class="w3l_fresh_vegetables_grid2">
                            <ul>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">All Brands</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="vegetables.html">Vegetables</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="vegetables.html">Fruits</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="drinks.html">Juices</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="pet.html">Pet Food</a></li>
                                <li><i class="fa fa-check" arariaia-hidden="true"></i><a href="bread.html">Bread & Bakery</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="household.html">Cleaning</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Spices</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Dry Fruits</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Dairy Products</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-9 w3l_fresh_vegetables_grid_right">
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/8.jpg" alt=" " class="img-responsive" />
                            </div>
                        </div>
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <div class="w3l_fresh_vegetables_grid1_rel">
                                    <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/7.jpg" alt=" " class="img-responsive" />
                                    <div class="w3l_fresh_vegetables_grid1_rel_pos">
                                        <div class="more m1">
                                            <a href="products.html" class="button--saqui button--round-l button--text-thick" data-text="Shop now">Shop now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="w3l_fresh_vegetables_grid1_bottom">
                                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/10.jpg" alt=" " class="img-responsive" />
                                <div class="w3l_fresh_vegetables_grid1_bottom_pos">
                                    <h5>Special Offers</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/9.jpg" alt=" " class="img-responsive" />
                            </div>
                            <div class="w3l_fresh_vegetables_grid1_bottom">
                                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/11.jpg" alt=" " class="img-responsive" />
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="agileinfo_move_text">
                            <div class="agileinfo_marquee">
                                <h4>get <span class="blink_me">25% off</span> on first order and also get gift voucher</h4>
                            </div>
                            <div class="agileinfo_breaking_news">
                                <span> </span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //fresh-vegetables -->