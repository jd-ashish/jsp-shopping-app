<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

<%@page import="Dao.FooterDao"%>
<%@page import="modal.Footer"%>
<%@page import="Helper.GenBase64"%>
<%@page import="Helper.FooterPositions"%>
<%@page import="Dao.BannerPositionDao"%>
<%@page import="modal.BannerPosition"%>
<%@page import="modal.Category"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="modal.Brand"%>
<%@page import="Dao.BrandDao"%>
<%@page import="modal.KeyValues"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Helper.Constent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title><%= Constent.APP_NAME%> - Banner list</title>
        <%@include file="../common/header.jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
        <style>
            .select2-selection__rendered {
                line-height: 40px !important;
            }
            .select2-container .select2-selection--single {
                height: 40px !important;
            }
            .select2-selection__arrow {
                height: 40px !important;
            }
            .select2-selection__clear{
                margin-top: 6px !important;
            }
        </style>
    </head>

    <body>

        <%@include file="../inc/nav.jsp" %>
        <%@include file="../inc/side_nav.jsp" %>



        <main id="main" class="main">

            <%                ArrayList<KeyValues> list = new ArrayList<>();
                list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
                list.add(new KeyValues("Footer link docx", ""));
                list.add(new KeyValues("create", "active"));

                BrandDao brandDao = new BrandDao();
                CategoryDao categoryDao = new CategoryDao();
                BannerPositionDao bannerPositionDao = new BannerPositionDao();
                String titles = request.getParameter("update-title");
                String id = request.getParameter("update-details");
                String details = null;
                if (id != null) {
                    Footer footers = FooterDao.getFooterListById(GenBase64.deCode(Utils.reverse(id))).get(0);
                    details = footers.getDetails();
                }

            %>
            <%= Utils.getBread("Create banner", list)%>

            <form method="post">
                <input type="hidden" name="type" value="create_banner" />
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select Banner Positions </label>
                            <select class="form-control select2" na style="width: 100%" name="posotions">
                                <%
                                    for (FooterPositions footerPositions : FooterPositions.values()) {
                                %>
                                <option value="<%= footerPositions.name()%>" ><%= Utils.ucfirt(footerPositions.name())%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="cat_name">Title: </label>
                            <input type="text" class="form-control" value="<%=(titles != null) ? GenBase64.deCode(Utils.reverse(titles)) : ""%>" id="cat_name" placeholder="Title" name="title" required>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="cat_name">Write details </label>
                            <textarea class="tinymce-editor" required name="description"><%=(details != null) ? details : "<p>asihs kaumr</p>"%></textarea>
                        </div>
                    </div>
                </div>
                <div class="row mt-2 text-end">
                    <div class="col-sm-12">
                        <button type="submit"  class="btn btn-primary ">Create Brand</button>
                    </div>
                </div>

            </form>


        </main><!-- End #main -->
        <script>
            $(".select2").select2({
                width: 'resolve',
                placeholder: "Select a brand",
                allowClear: true
            });
        </script>

        <%@include file="../common/footer.jsp" %>