<%-- 
    Document   : home
    Created on : 12 May, 2022, 11:46:02 AM
    Author     : Dell1
--%>

<%@page import="Helper.GenBase64"%>
<%@page import="Dao.FooterDao"%>
<%@page import="modal.Footer"%>
<%@page import="Dao.BannerDao"%>
<%@page import="modal.Banner"%>
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
            <%                ArrayList<KeyValues> list = new ArrayList<>();
                list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
                list.add(new KeyValues("Footer", ""));
                list.add(new KeyValues("link List", "active"));

                CategoryDao categoryDao = new CategoryDao();
                BrandDao brandDao = new BrandDao();
                SubCategoryDao subCategoryDao = new SubCategoryDao();

            %>
            <%= Utils.getBread("Footer link list", list)%>
            <section class="section">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body  p-3">
                                <div class="text-end">
                                    <a class="btn btn-outline-primary " href="<%= Constent.getFooterUrl(request)%>?index=create">Create Footer page</a>
                                </div>

                                <!-- Table with stripped rows -->
                                <table class="table datatable">
                                    <thead>

                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Positions</th>
                                            <th scope="col">Title</th>
                                            <th scope="col">Created at</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <%
                                            int count = 0;
                                            for (Footer footer : FooterDao.getFooterList("")) {
                                        %>
                                        <tr>
                                            <th scope="row"><%= ++count%></th>
                                            <td><%= footer.getPositions()%></td>
                                            <td><%= footer.getTitle()%></td>
                                            <td><%= footer.getCreated_at()%></td>
                                            <td><a href="<%= Constent.getFooterUrl(request)%>?index=create&update-title=<%= Utils.reverse(GenBase64.enCode(footer.getTitle())) %>&update-details=<%= Utils.reverse(GenBase64.enCode(footer.getDetails())) %>"><i class="fas fa-pen"></i></a></td>
                                        
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