<%@page import="Dao.FooterDao"%>
<%@page import="modal.Footer"%>
<%
String title = GenBase64.deCode(Utils.reverse(request.getParameter("index").split("-")[1]));
Footer footerDesc = FooterDao.commonListData("select * from "+FooterDao.table+" WHERE `title` LIKE '"+title+"'").get(0);
%>
<!-- products-breadcrumb -->
<div class="products-breadcrumb">
    <div class="container">
        <ul>
            <li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
            <li><%=title%></li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<!-- banner -->
<div class="banner">
    <%@include file="../inc/nav_left_side_category.jsp" %>
    <div class="w3l_banner_nav_right">
        <!-- about -->
        <div class="privacy about">
            <h3><%=title%></h3>
            <div class="agile_about_grids" style="width: 100%; overflow: hidden">
                <%= footerDesc.getDetails() %>
            </div>
            
        </div>
        <!-- //about -->
    </div>
    <div class="clearfix"></div>
</div>