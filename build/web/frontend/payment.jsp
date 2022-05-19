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
        <%@include file="inc/header.jsp" %>
    </head>

    <body>
        <!-- header -->
        <%@include file="inc/top_header.jsp" %>


        <%@include file="inc/sticky_nav.jsp" %>
        <!--Checkout cart list-->

        <%@include file="layout/payment_layout.jsp" %>


        <!-- newsletter -->
        <%@include file="inc/newsletter.jsp" %>
        <!-- //newsletter -->
        <!-- footer -->
        <%@include file="inc/footer_sections.jsp" %>
        <!-- //footer -->
        <%@include file="inc/footer.jsp" %>
    </body>
</html>
