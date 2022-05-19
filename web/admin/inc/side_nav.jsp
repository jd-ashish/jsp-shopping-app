<%@page import="Helper.Constent"%>
<%@page import="Helper.Utils"%>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="<%=  Utils.getBaseUrl(request)%>/admin">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Products</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="<%=  Constent.getBrandUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Brand</span>
                    </a>
                </li>
                <li>
                    <a href="<%=  Constent.getCategoryUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Category</span>
                    </a>
                </li>
                <li>
                    <a href="<%= Constent.getSubCategoryUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Sub Category</span>
                    </a>
                </li>
                <li>
                    <a href="<%= Constent.getSubSubCategoryUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Sub Sub Category</span>
                    </a>
                </li>
                <li>
                    <a href="<%= Constent.getAdminProductUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Products</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#frontend-setting-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Frontend Setting</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="frontend-setting-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="<%=  Constent.getBrandUrl(request)%>">
                        <i class="bi bi-circle"></i><span>Banner</span>
                    </a>
                </li>
                
            </ul>
        </li><!-- End Components Nav -->

    </ul>

</aside><!-- End Sidebar-->