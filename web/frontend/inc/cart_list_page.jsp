<!-- products-breadcrumb -->
<div class="products-breadcrumb">
    <div class="container">
        <ul>
            <li><i class="fa fa-home text-light" style="color: white" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
            <li>Checkout</li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<!-- banner -->
<input type="hidden" name="index" value="payment"/>
<input type="hidden" name="cartIds" class="cartIds"/>
<div class="banner">
    <%@include file="nav_left_side_category.jsp" %>
    <div class="w3l_banner_nav_right">
        <!-- about -->
        <div class="privacy about">
            <h3>Chec<span>kout</span></h3>

            <div class="checkout-right">
                <h4>Your shopping cart contains: <span><span class="my-cart"></span> Products</span></h4>
                <div class="cart-details"></div>
            </div>
            <div class="checkout-left">	
                <div class="col-md-4 checkout-left-basket">
                    <h4>Continue to basket</h4>
                    <div class="cart_total"></div>
                </div>
                <div class="col-md-8 address_form_agile">
                    <h4>Add a new Details</h4>
                    <div action="payment.html" method="post" class="creditly-card-form agileinfo_form">
                        <section class="creditly-wrapper wthree, w3_agileits_wrapper">
                            <div class="information-wrapper">
                                <div class="first-row form-group">
                                    <div class="controls">
                                        <label class="control-label">Full name: </label>
                                        <input class="billing-address-name form-control" type="text" name="name" placeholder="Full name">
                                    </div>
                                    <div class="w3_agileits_card_number_grids">
                                        <div class="w3_agileits_card_number_grid_left">
                                            <div class="controls">
                                                <label class="control-label">Mobile number:</label>
                                                <input class="form-control" type="text" name="phone" placeholder="Mobile number">
                                            </div>
                                        </div>
                                        <div class="w3_agileits_card_number_grid_right">
                                            <div class="controls">
                                                <label class="control-label">Landmark: </label>
                                                <input class="form-control" type="text" name="landmark" placeholder="Landmark">
                                            </div>
                                        </div>
                                        <div class="clear"> </div>
                                    </div>
                                    <div class="controls">
                                        <label class="control-label">Town/City: </label>
                                        <input class="form-control" type="text" name="city" placeholder="Town/City">
                                    </div>
                                    <div class="controls">
                                        <label class="control-label">Address type: </label>
                                        <select class="form-control select2 option-w3ls" style="padding: 0px !important;" name="address">
                                            <option>Office</option>
                                            <option>Home</option>
                                            <option>Commercial</option>

                                        </select>
                                    </div>
                                </div>
                                <button class="submit check_out" type="submit">Delivery to this Address</button>
                            </div>
                        </section>
                    </div>
                    <div class="checkout-right-basket">
                        <a href="payment.html">Make a Payment <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
                    </div>
                </div>

                <div class="clearfix"> </div>

            </div>

        </div>
        <!-- //about -->
    </div>
    <div class="clearfix"></div>
</div>
<!-- //banner -->