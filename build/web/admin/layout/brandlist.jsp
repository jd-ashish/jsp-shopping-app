
<%@page import="modal.Brand"%>
<%@page import="Dao.BrandDao"%>
<%@page import="Helper.Constent"%>
<%@page import="modal.KeyValues"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Helper.Utils"%>

<%
    ArrayList<KeyValues> list = new ArrayList<>();
    list.add(new KeyValues("Home", Utils.getBaseUrl(request) + "/admin"));
    list.add(new KeyValues("Brand", ""));
    list.add(new KeyValues("List", "active"));

    BrandDao brandDao = new BrandDao();
%>
<%= Utils.getBread("Brand", list)%>

<section class="section">
    <div class="row">
        <div class="col-lg-12">

            <div class="card">
                <div class="card-body  p-3">
                    <div class="text-end">
                        <a class="btn btn-outline-primary " href="<%= Constent.getBrandUrl(request)%>?index=create">Create Brand</a>
                    </div>
                    
                    <!-- Table with stripped rows -->
                    <table class="table datatable">
                        <thead>
                            
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Image</th>
                                <th scope="col">Name</th>
                                <th scope="col">Start Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            int count = 0;
                            for(Brand brand:brandDao.getBrandList()){
                            %>
                            <tr>
                                <th scope="row"><%= ++count %></th>
                                <td><img src="img/brand/<%= brand.getImg() %>" alt="alt" width="40px"/></td>
                                <td><%= brand.getName() %></td>
                                <td><%= brand.getCreated_at()%></td>
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