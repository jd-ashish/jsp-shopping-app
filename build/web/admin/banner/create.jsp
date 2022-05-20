<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

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

            <%
                ArrayList<KeyValues> list = new ArrayList<>();
                list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
                list.add(new KeyValues("Banner", ""));
                list.add(new KeyValues("create", "active"));

                BrandDao brandDao = new BrandDao();
                CategoryDao categoryDao = new CategoryDao();
                BannerPositionDao bannerPositionDao = new BannerPositionDao();
            %>
            <%= Utils.getBread("Create banner", list)%>

            <form method="post" enctype="multipart/form-data">
                <input type="hidden" name="type" value="create_banner" />
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select Banner Positions </label>
                            <select class="form-control select2" na style="width: 100%" name="banner_id">
                                <%
                                    for (BannerPosition bannerPosition : bannerPositionDao.getBannerPosition()) {
                                %>
                                <option value="<%= bannerPosition.getBanner_id()%>" ><%= bannerPosition.getPositions()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="cat_name">Small title: </label>
                            <input type="text" class="form-control" id="cat_name" placeholder="Title" name="title" required>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="cat_name">Offer title </label>
                            <input type="text" class="form-control" maxlength="40" id="cat_name" placeholder="Offer Title" name="offer_title">
                            <small class="text-right w-100 text-danger">Maximum 40 character</small>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Image: </label>
                            <input type="file" class="form-control" id="file" name="file1"  />
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Link </label>
                            <input type="text" class="form-control" id="" placeholder="Link" name="link">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Descriptions </label>
                            <textarea type="text" class="form-control" id="" name="descriptions"></textarea>
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