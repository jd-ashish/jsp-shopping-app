<%@page import="Dao.BannerDao"%>
<%@page import="modal.Banner"%>
<%@page import="Dao.SubCategoryDao"%>
<%@page import="modal.SubCategory"%>
<%@page import="modal.Category"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="Helper.Utils"%>
<!-- banner -->
<div class="banner">
    <%@include file="nav_left_side_category.jsp" %>
    <div class="w3l_banner_nav_right">
        <section class="slider">
            <div class="flexslider">
                <ul class="slides">
                    <%
                    for(Banner banner:BannerDao.getBannerList(99)){
                    %>
                    <li>
                        <div class="w3l_banner_nav_right_banner2" style="background: url(img/banner/<%= banner.getFile() %>) no-repeat 0px 0px;">
                            <h3><%= banner.getTitle() %>.</h3>
                            <div class="more">
                                <a href="<%= banner.getLink()%>" class="button--saqui button--round-l button--text-thick" data-text="Shop now">Shop now</a>
                            </div>
                        </div>
                    </li>
                    <% } %>
                </ul>
            </div>
        </section>
        <!-- flexSlider -->
        <link rel="stylesheet" href="<%= Utils.getBaseUrl(request) %>/frontend/asset/css/flexslider.css" type="text/css" media="screen" property="" />
        <script defer src="<%= Utils.getBaseUrl(request) %>/frontend/asset/js/jquery.flexslider.js"></script>
        <script type="text/javascript">
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide",
                    start: function (slider) {
                        $('body').removeClass('loading');
                    }
                });
            });
        </script>
        <!-- //flexSlider -->
    </div>
    <div class="clearfix"></div>
</div>