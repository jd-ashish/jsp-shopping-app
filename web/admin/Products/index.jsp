<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

<%@page import="modal.Products"%>
<%@page import="Dao.ProductsDao"%>
<%@page import="modal.SubSubCategory"%>
<%@page import="Dao.SubSubCategoryDao"%>
<%@page import="modal.SubCategory"%>
<%@page import="Dao.SubCategoryDao"%>
<%@page import="modal.KeyValues"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.BrandDao"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="modal.Category"%>
<%@page import="Helper.Constent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title><%= Constent.APP_NAME%> - Sub category list</title>
        <%@include file="../common/header.jsp" %>

    </head>

    <body>

        <%@include file="../inc/nav.jsp" %>
        <%@include file="../inc/side_nav.jsp" %>



        <main id="main" class="main">
            <%
                ArrayList<KeyValues> list = new ArrayList<>();
                list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
                list.add(new KeyValues("Products", ""));
                list.add(new KeyValues("List", "active"));

                CategoryDao categoryDao = new CategoryDao();
                BrandDao brandDao = new BrandDao();
                SubCategoryDao subCategoryDao = new SubCategoryDao();
                SubSubCategoryDao subSubCategoryDao = new SubSubCategoryDao();

                ProductsDao productsDao = new ProductsDao();

            %>
            <%= Utils.getBread("Products List", list)%>
            <section class="section">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body  p-3">
                                <div class="text-end">
                                    <a class="btn btn-outline-primary " href="<%= Constent.getAdminProductUrl(request)%>?index=create">Create Products List</a>
                                </div>

                                <!-- Table with stripped rows -->
                                <table class="table datatable">
                                    <thead>

                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Image</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Brand</th>
                                            <th scope="col">Category</th>
                                            <th scope="col">Sub Category</th>
                                            <th scope="col">Created at</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <%
                                            int count = 0;
                                            for (Products products : productsDao.getProducts()) {
                                        %>
                                        <tr>
                                            <th scope="row"><%= ++count%></th>
                                            <td><img src="../img/products/<%= products.getThumbnail()%>" alt="alt" width="40px"/></td>
                                            <td><%= products.getName()%></td>
                                            
                                            <td><%= brandDao.getBrandById(products.getBrand()).getName() %></td>
                                            

                                            <td><%= categoryDao.getCategoryById(products.getCateory()).getName()%></td>
                                            <td><%= subCategoryDao.getCategoryById(products.getSub_category()).getName() %></td>

                                            <td><%= products.getCreated_at()%></td>
                                            <td><a href="<%= Constent.getAdminProductUrl(request)%>?index=update-<%= products.getId()%>"><i class="fas fa-pen"></i></a></td>
                                        
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                                <!-- End Table with stripped rows -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main><!-- End #main -->

        <%@include file="../common/footer.jsp" %>