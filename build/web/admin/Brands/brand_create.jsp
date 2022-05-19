<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

<%@page import="Helper.Constent"%>
<%@page import="modal.KeyValues"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Helper.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title><%= Constent.APP_NAME%> - Brands list</title>
        <%@include file="../common/header.jsp" %>

    </head>

    <body>

        <%@include file="../inc/nav.jsp" %>
        <%@include file="../inc/side_nav.jsp" %>



        <main id="main" class="main">



            <%
                ArrayList<KeyValues> list = new ArrayList<>();
                list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
                list.add(new KeyValues("Brand", ""));
                list.add(new KeyValues("create", "active"));
            %>
            <%= Utils.getBread("Create brands", list)%>


            <form method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uname">Category name: </label>
                            <input type="text" class="form-control" id="uname" placeholder="Enter username" name="brand" required>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select category image: </label>
                            <input type="file" class="form-control" id="file" name="file1"  />
                            <div class="valid-feedback">Valid.</div>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>
                    </div>
                </div>
                <div class="row mt-2 text-end">
                    <div class="col-sm-12">
                        <button type="submit"  class="btn btn-primary ">Create Category</button>
                    </div>
                </div>
                <input type="hidden" name="type" value="create_brand" />
            </form>

        </main><!-- End #main -->
        
        <script>
            $(".create_category").click(function () {

var url = "";

                var form = $(".upload-box")[0];
                window.console.log(form);


                var data = new FormData(form);

                /* var data = {};
                 data['key1'] = 'value1';
                 data['key2'] = 'value2'; */
                $.ajax({
                    type: "POST",
                    encType: "multipart/form-data",
                    url: url,
                    processData: false,
                    contentType: false,
                    data: data,
                    success: function (msg) {
                        alert(msg);
                    },
                    error: function (msg) {
                        alert("Couldn't upload file");
                    }
                });
            })
        </script>
        <%@include file="../common/footer.jsp" %>
        
