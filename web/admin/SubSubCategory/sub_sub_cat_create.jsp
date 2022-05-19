<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

<%@page import="modal.SubCategory"%>
<%@page import="Dao.SubCategoryDao"%>
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

        <title><%= Constent.APP_NAME%> - Brands list</title>
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
                list.add(new KeyValues("Products", ""));
                list.add(new KeyValues("Sub Sub Category", ""));
                list.add(new KeyValues("create", "active"));

                BrandDao brandDao = new BrandDao();
                CategoryDao categoryDao = new CategoryDao();
                SubCategoryDao subCategoryDao =  new SubCategoryDao();
            %>
            <%= Utils.getBread("Create Sub Sub Category", list)%>

            <form method="post" enctype="multipart/form-data">
                <input type="hidden" name="type" value="create_category" />
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="cat_name">Sub Sub Category name: </label>
                            <input type="text" class="form-control" id="cat_name" placeholder="Sub Category nam" name="cat_name" required>
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
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select Brand </label>
                            <select class="form-control select2" na style="width: 100%" name="brand_id">
                                <option>Select brand</option>
                                <%
                                    for (Brand brand : brandDao.getBrandList()) {
                                %>
                                <option value="<%= brand.getId()%>" ><%= brand.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select Category </label>
                            <select class="form-control select2" na style="width: 100%" name="category_id">
                                <option>Select Category</option>
                                <%
                                    for (Category category : categoryDao.getCategoryList()) {
                                %>
                                <option value="<%= category.getId()%>" ><%= category.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="uploadFiles">Select Sub Category </label>
                            <select class="form-control select2" na style="width: 100%" name="sub_category_id">
                                <option>Select Category</option>
                                <%
                                    for (SubCategory category : subCategoryDao.getSubCategoryList()) {
                                %>
                                <option value="<%= category.getId()%>" ><%= category.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
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