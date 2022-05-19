
<%@page import="modal.ProductsStock"%>
<%@page import="Dao.ProductsDetailsDao"%>
<%@page import="modal.Products"%>
<%@page import="Dao.ProductsDao"%>
<%@page import="modal.SubSubCategory"%>
<%@page import="Dao.SubSubCategoryDao"%>
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

        <title><%= Constent.APP_NAME%> - Update product</title>
        <%@include file="../common/header.jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
        <link href="https://unpkg.com/filepond@^4/dist/filepond.css" rel="stylesheet" />
        <link
            href="https://unpkg.com/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.css"
            rel="stylesheet"
            />
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
                list.add(new KeyValues("Products", Constent.getAdminProductUrl(request)));
                list.add(new KeyValues("update", "active"));

                BrandDao brandDao = new BrandDao();
                CategoryDao categoryDao = new CategoryDao();
                SubCategoryDao subCategoryDao = new SubCategoryDao();
                SubSubCategoryDao subSubCategoryDao = new SubSubCategoryDao();

                ProductsDao productsDao = new ProductsDao();
                Products product = productsDao.getProductsById("",Integer.valueOf(request.getParameter("index").split("-")[1])).get(0);

                ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();
                ProductsStock productsStock = productsDetailsDao.getProductsStocksByProductId(product.getId()).get(0);
            %>
            <%= Utils.getBread("Update products", list)%>

            <section class="section">

                <form class="row" method="post" enctype="multipart/form-data" action="">
                    <div class="col-lg-6">
                        <input type="hidden" name="pid" value="<%=  product.getId() %>"/>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">General informations</h5>

                                <!-- Horizontal Form -->
                                <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputText" value="<%= product.getName()%>" name="productName" placeholder="Enter products name" required>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-2 col-form-label">Unit</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputText" value="<%= product.getUnit()%>" name="unit" placeholder="PC or Packet etc" required>
                                    </div>
                                </div>
                                <!-- End Horizontal Form -->

                            </div>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Images</h5>

                                <div class="col-md-12">
                                    <label for="inputName5" class="form-label">Thumbnail</label>
                                    <img src="<%= Utils.getBaseUrl(request)%>/img/products/<%= product.getThumbnail() %>" class="float-end thumbnailimage" style="margin-bottom: -100px;" alt="alt" width="30"/>
                                    <input type="file" class="form-control thumbnails" id="" name="thumbnails"  accept="image/*"  >
                                </div>

                                <div class="col-md-12">
                                    <label for="inputName5" class="form-label">Main Image</label>
                                    <input type="file" class="form-control" id="" name="main_image" multiple="" accept="image/*">
                                </div>
                                <section class="section mt-2">
                                    <div class="row align-items-top">
                                        
                                        <%
                                        for(String img:Utils.StrinArrayToArray(product.getMain_image())){
                                        %>
                                        <div class="col-lg-3">
                                            <div class="card">
                                                <img src="<%= Utils.getBaseUrl(request)%>/img/products/<%= img %>" class="card-img-top" alt="...">
                                            </div>
                                        </div>
                                            <% } %>
                                    </div>
                                </section>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Select brand or category</h5>

                                <!-- Vertical Form -->
                                <div class="row g-3">
                                    <div class="col-12">
                                        <label for="inputNanme4" class="form-label">Select brand</label>
                                        <select class="form-control select2" na style="width: 100%" name="brand_id" required>
                                            <option>Select brand</option>
                                            <%
                                                for (Brand brand : brandDao.getBrandList()) {
                                            %>
                                            <option value="<%= brand.getId()%>" <% if (product.getBrand() == brand.getId()) { %> selected <% }%>><%= brand.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                        <label class="form-label">Select Category </label>
                                        <select class="form-control select2" na style="width: 100%" name="category_id" required>
                                            <option>Select Category</option>
                                            <%
                                                for (Category category : categoryDao.getCategoryList()) {
                                            %>
                                            <option value="<%= category.getId()%>" <% if (product.getCateory() == category.getId()) { %> selected <% }%> ><%= category.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                        <label class="form-label">Select Sub Category </label>
                                        <select class="form-control select2" na style="width: 100%" name="sub_category_id" required>
                                            <option>Select Category</option>
                                            <%
                                                for (SubCategory category : subCategoryDao.getSubCategoryList()) {
                                            %>
                                            <option value="<%= category.getId()%>" <% if (product.getSub_category() == category.getId()) { %> selected <% }%> ><%= category.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                        <label class="form-label">Select Sub Sub Category </label>
                                        <select class="form-control select2" na style="width: 100%" name="sub_sub_category_id" required>
                                            <option value="0">Select Category</option>
                                            <%
                                                for (SubSubCategory category : subSubCategoryDao.getSubSubCategoryList()) {
                                            %>
                                            <option value="<%= category.getId()%>" <% if (product.getSub_sub_category() == category.getId()) { %> selected <% }%> ><%= category.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div><!-- Vertical Form -->

                            </div>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Stock management</h5>

                                <!-- No Labels Form -->
                                <div class="row g-3">
                                    <div class="col-md-12">
                                        <input type="hidden" name="sid" value="<%= productsStock.getId()%>" />
                                        <input type="number" class="form-control" value="<%= productsStock.getTotal_stock()%>" name="number_of_stock" placeholder="Enter total stock" required>
                                    </div>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" value="<%= productsStock.getSku()%>" name="sku" placeholder="SKU" required>
                                    </div>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" value="<%= productsStock.getTotal_price()%>" name="total_price" placeholder="Total price" required>
                                    </div>
                                    <div class="col-12">
                                        <input type="text" class="form-control" value="<%= productsStock.getOffer_price()%>" name="offer_price" placeholder="Offer price" required>
                                    </div>
                                </div><!-- End No Labels Form -->

                            </div>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Details</h5>

                                <!-- Floating Labels Form -->
                                <div class="row g-3">
                                    <div class="col-md-12">
                                        <textarea class="tinymce-editor" required name="descriptions">
                                            <%= product.getDetails()%>
                                        </textarea>
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                        <button type="reset" class="btn btn-secondary">Reset</button>
                                    </div>
                                </div><!-- End floating Labels Form -->

                            </div>
                        </div>

                    </div>
                </form>
            </section>


        </main><!-- End #main -->
        <script>
            $(".select2").select2({
                width: 'resolve',
                placeholder: "Select a brand",
                allowClear: true
            });
        </script>
        <script src="https://unpkg.com/filepond@^4/dist/filepond.js"></script>
        <script src="https://unpkg.com/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.js"></script>
        <script>
            function encodeImageFileAsURL(element) {
                var file = element.files[0];
                var reader = new FileReader();
                reader.onloadend = function() {
                  $(".thumbnailimage").attr("src",reader.result);
                }
                reader.readAsDataURL(file);
            }
            $(".thumbnails").change(function () {
                encodeImageFileAsURL(this);
            });
            // Get a reference to the file input element
            const mainImage = document.querySelector('input[id="main_image"]');

            // Create a FilePond instance
            FilePond.registerPlugin(FilePondPluginImagePreview);
            const pond = FilePond.create(mainImage);
        </script>

        <%@include file="../common/footer.jsp" %>