<%@page import="Helper.Utils"%>
<%@page import="Helper.GenBase64"%>
<%@page import="modal.Category"%>
<%@page import="Dao.SubCategoryDao"%>
<%@page import="Dao.CategoryDao"%>
<%@page import="modal.SubCategory"%>
<div class="w3l_banner_nav_left">
        <nav class="navbar nav_bottom">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header nav_2">
                <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div> 
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                <ul class="nav navbar-nav nav_1">
                    <%
                    CategoryDao categoryDao = new CategoryDao();
                    SubCategoryDao subCategoryDao = new SubCategoryDao();
                    for(Category category:categoryDao.getCategoryList()){
                    if(subCategoryDao.getSubCategoryListByCategoryId(category.getId()).size()<1){
                    
                    %>
                    <li><a href="<%= Utils.getBaseUrl(request) %>/products?type_name=<%= GenBase64.enCode(category.getName()) %>&type=<%= GenBase64.enCode("cateory") %>&data=<%= GenBase64.enCode(String.valueOf(category.getId())) %>"><%= category.getName() %></a></li>
                    <% }else{ %>
                    <li class="dropdown mega-dropdown active">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%= category.getName() %><span class="caret"></span></a>				
                        <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                            <div class="w3ls_vegetables">
                                <ul>	
                                    <%
                                    for(SubCategory subCategory:subCategoryDao.getSubCategoryListByCategoryId(category.getId())){
                                    %>
                                    <li><a href="<%= Utils.getBaseUrl(request) %>/products?type_name=<%= GenBase64.enCode(subCategory.getName()) %>&type=<%= GenBase64.enCode("sub_category") %>&data=<%= GenBase64.enCode(String.valueOf(subCategory.getId())) %>"><%= subCategory.getName() %></a></li>
                                    <% } %>
                                </ul>
                            </div>                  
                        </div>				
                    </li>
                    <% }} %>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </div>