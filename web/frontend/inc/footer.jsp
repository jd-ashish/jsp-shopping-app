<%@page import="Helper.Constent"%>
<%@page import="Helper.Utils"%>
<!-- Bootstrap Core JavaScript -->
<script src="<%= Utils.getBaseUrl(request)%>/frontend/asset/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(".dropdown").hover(
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                    $(this).toggleClass('open');
                }
        );
    });
</script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear' 
         };
         */

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    $(".add_to_cart").click(function () {
        var stock_id = $(this).attr("stock_id");
        var url = "<%= Constent.getCartUrl(request)%>";
        $.ajax({
            url: url,
            type: "POST",
            data: {stock_id: stock_id, qty: 1, index: "addCart"},
            success: function (data)
            {
                Swal.fire(
                        'Cart added!',
                        'YOu have added on products!',
                        'success'
                        )
                getCart();
            },
            error: function (data) {
                Swal.fire(
                        'Some thing going wrong!',
                        'Try after some time!',
                        'error'
                        )
            }
        });
    })
    function update_cart(el, type) {
        var cart_id = el;
        var url = "<%= Constent.getCartUrl(request)%>";
        $.ajax({
            url: url,
            type: "POST",
            data: {cart_id: cart_id, type: type, index: "updateCart"},
            success: function (data)
            {
//                Swal.fire(
//                        'Cart updated!',
//                        type+' 1 update cart!',
//                        'success'
//                        )
                getCart();
            },
            error: function (data) {
                Swal.fire(
                        'Some thing going wrong!',
                        'Try after some time!',
                        'error'
                        )
            }
        });
    }
    function remove_cart(el) {
        var cart_id = el;
        var url = "<%= Constent.getCartUrl(request)%>";
        $.ajax({
            url: url,
            type: "POST",
            data: {cart_id: cart_id, index: "removeCart"},
            success: function (data)
            {
                Swal.fire(
                        'Cart removed!',
                        'You cart update successfully!',
                        'success'
                        )
                getCart();
            },
            error: function (data) {
                Swal.fire(
                        'Some thing going wrong!',
                        'Try after some time!',
                        'error'
                        )
            }
        });
    }
    function payment(type) {
        var url = "<%= Constent.getPaymentUrl(request)%>";
        $.ajax({
            url: url,
            type: "POST",
            data: {index: type},
            success: function (data)
            {
                Swal.fire(
                        'COD order placed successfully!',
                        'You will get notify soon!',
                        'success'
                        )
                setTimeout(function () {
                    location.reload(true);
                }, 2000);
            },
            error: function (data) {
                Swal.fire(
                        'Some thing going wrong!',
                        'Try after some time!',
                        'error'
                        )
            }
        });
    }
//    $(".remove_cart").click(function () {
//        alert();

//    })
    getCart();
    function getCart() {
        var url = "<%= Constent.getCartUrl(request)%>";
        $.ajax({
            url: url,
            type: "POST",
            data: {index: "getCart"},
            success: function (data)
            {
                var t = JSON.parse(data);
                $(".my-cart").html(t.total);
                $(".cart-details").html(t.details);
                $(".cart_total").html(t.cart_total);
                $(".cartIds").val(t.cartIds);
            }
        });
    }
</script>
<!-- //here ends scrolling icon -->
<script src="<%= Utils.getBaseUrl(request)%>/frontend/asset/js/minicart.js"></script>
<script>
    paypal.minicart.render();



    paypal.minicart.cart.on('checkout', function (evt) {
        var items = this.items(),
                len = items.length,
                total = 0,
                i;

        // Count the number of each item in the cart
        for (i = 0; i < len; i++) {
            total += items[i].get('quantity');
        }

        if (total < 1) {
            alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
            evt.preventDefault();
        }
    });

</script>