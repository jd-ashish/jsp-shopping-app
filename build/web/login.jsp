<%-- 
    Document   : login
    Created on : 11 May, 2022, 1:17:10 PM
    Author     : Dell1
--%>

<%@page import="Helper.Utils"%>
<%@page import="Helper.Constent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <%@include file="common_header.jsp" %>
        <link rel="stylesheet" href="css/login.css"/>
    </head>
    <body>
        <form method="post" onsubmit="return loginValidate()">
            <div class="wrapper">
                <div class="logo">
                    <img src="img/app/logo.png" alt="" class="logo-img">
                </div>
                <div class="text-center mt-4 name">
                    <%= Constent.APP_NAME%>
                </div>
                <form class="p-3 mt-3">
                    <small class="text-danger loginEmailError hide">ENter correct email</small>
                    <div class="form-field d-flex align-items-center">
                        <i class="fas fa-at"></i>
                        <input type="email" name="email" id="loginEmail" placeholder="Email">
                        <i class="fas fa-exclamation text-danger mr-3 emailIcon hide"></i>
                    </div>

                    <small class="text-danger loginPassError hide">ENter correct password: </small>
                    <div class="form-field d-flex align-items-center">
                        <span class="fas fa-key"></span>
                        <input type="password" name="password" id="loginPass" placeholder="Password">
                        <i class="fas fa-exclamation text-danger mr-3 passIcon hide"></i>
                    </div>
                    <button class="btn mt-3" type="submit">Login</button>
                </form>
                <div class="text-center fs-6">
                    <a href="#">Forget password?</a> or <a href="<%= Utils.getBaseUrl(request) %>/signup">Sign up</a>
                </div>
            </div>
        </form>

<%@include file="common_footer.jsp" %>
        <script src="js/common.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>