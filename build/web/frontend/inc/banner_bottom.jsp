<%@page import="Dao.BannerDao"%>
<%@page import="modal.Banner"%>
<%@page import="Helper.Utils"%>
<div class="banner_bottom">
    <div class="wthree_banner_bottom_left_grid_sub">
    </div>
    <div class="wthree_banner_bottom_left_grid_sub1">
        <%
            for (Banner banner : BannerDao.getBannerList(100)) {
        %>
        <div class="col-md-4 wthree_banner_bottom_left">
            <div class="wthree_banner_bottom_left_grid">
                <img src="img/banner/<%= banner.getFile()%>" alt=" " class="img-responsive" />

                <%
                    if (banner.getTitle().contains("Discount")) {
                %>
                <div class="wthree_banner_bottom_left_grid_pos">

                    <h4><%= banner.getTitle()%> <span><%= banner.getOffer()%></span></h4>
                </div>

                <%
                    }
                %>
                <%
                    if (banner.getTitle().contains("Save")) {
                %>
                <div class="wthree_banner_btm_pos1">
                    <h3><span><%= banner.getTitle()%></span> <%= banner.getOffer()%></h3>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <% }%>
<!--        <div class="col-md-4 wthree_banner_bottom_left">
            <div class="wthree_banner_bottom_left_grid">
                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/4.jpg" alt=" " class="img-responsive" />
                <div class="wthree_banner_bottom_left_grid_pos">
                    <h4>Discount Offer <span>25%</span></h4>
                </div>
            </div>
        </div>
        <div class="col-md-4 wthree_banner_bottom_left">
            <div class="wthree_banner_bottom_left_grid">
                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/5.jpg" alt=" " class="img-responsive" />
                <div class="wthree_banner_btm_pos">
                    <h3>introducing <span>best store</span> for <i>groceries</i></h3>
                </div>
            </div>
        </div>
        <div class="col-md-4 wthree_banner_bottom_left">
            <div class="wthree_banner_bottom_left_grid">
                <img src="<%= Utils.getBaseUrl(request)%>/frontend/asset/images/6.jpg" alt=" " class="img-responsive" />
                <div class="wthree_banner_btm_pos1">
                    <h3>Save <span>Upto</span> $10</h3>
                </div>
            </div>
        </div>-->
        <div class="clearfix"> </div>
    </div>
    <div class="clearfix"> </div>
</div>