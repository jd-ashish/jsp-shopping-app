<%-- 
    Document   : index.jsp
    Created on : 11 May, 2022, 6:02:07 PM
    Author     : Dell1
--%>

<%@page import="Helper.Utils"%>
<%@page import="Helper.Constent"%>

<%
    if (Utils.getCookies(request, Constent.LOGIN_COOKIE_NAME) == null) {
        response.sendRedirect(Utils.getBaseUrl(request) + "/login");
    }

//            Cookie cookie = new Cookie(Constent.LOGIN_COOKIE_NAME, "");
    Cookie cookie1 = Utils.getCookies(request, Constent.LOGIN_COOKIE_NAME);
    if (cookie1 != null) {
%>
<%
    //cookie1.getValue()
%>
<%            }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Grocery Store a Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
        <%@include file="frontend/inc/header.jsp" %>
    </head>

    <body>
        <!-- header -->
        <%@include file="frontend/inc/top_header.jsp" %>


        <%@include file="frontend/inc/sticky_nav.jsp" %>

        <%@include file="frontend/inc/banner.jsp" %>
        
        <!-- banner_bottom -->
        <%@include file="frontend/inc/banner_bottom.jsp" %>
        
        <!-- top-brands -->
        <%@include file="frontend/inc/top_brand.jsp" %>
        
        <!--Top products-->
        <%@include file="frontend/inc/top_products.jsp" %>
        <!-- newsletter -->
        <%@include file="frontend/inc/newsletter.jsp" %>
        <!-- //newsletter -->
        <!-- footer -->
        <%@include file="frontend/inc/footer_sections.jsp" %>
        <!-- //footer -->
        <%@include file="frontend/inc/footer.jsp" %>
    </body>
</html>
