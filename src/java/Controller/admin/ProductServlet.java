/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.admin;

import Dao.ProductsDao;
import Dao.ProductsDetailsDao;
import Helper.CommonFileUpload;
import Helper.Constent;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modal.Products;
import modal.ProductsStock;

/**
 *
 * @author Dell1
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProductServlet extends HttpServlet {

    private static final String UPLOAD_PATH_FILES = "C:/Users/Dell1/Documents/NetBeansProjects/Shopping/web/img/products";
    ProductsDao productsDao = new ProductsDao();
    ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../admin/Products/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String index = request.getParameter("index");
        if (index == null) {
            processRequest(request, response);
        } else if (index.equals("create")) {
            request.getRequestDispatcher("../admin/Products/create.jsp").forward(request, response);
        } else if (index.split("-")[0].equals("update")) {
            request.getRequestDispatcher("../admin/Products/update.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String index = request.getParameter("index");
        if (index.equals("create")) {
            productsUpload(request, response, out);
        } else if (index.split("-")[0].equals("update")) {
            productsCreate(request, response, out);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void productsUpload(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        ArrayList<String> img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
        int brand_id = Integer.valueOf(request.getParameter("brand_id"));
        int category_id = Integer.valueOf(request.getParameter("category_id"));
        int sub_category_id = Integer.valueOf(request.getParameter("sub_category_id"));
        int sub_sub_category_id = Integer.valueOf(request.getParameter("sub_sub_category_id"));
        String name = request.getParameter("productName");
        String unit = request.getParameter("unit");
        String descriptions = request.getParameter("descriptions");
        String thumbnails = "";
        String[] mainImage = null;
        if (img.size() >= 1) {
            thumbnails = img.get(0);
        }
        if (img.size() > 1) {
            mainImage = new String[img.size() - 1];
            for (int i = 1; i < img.size(); i++) {
                mainImage[i - 1] = img.get(i);
            }
        }
        Gson gson = new Gson();
        out.print(gson.toJson(mainImage));

        Products products = new Products(brand_id, category_id, sub_category_id, sub_sub_category_id, name, unit, thumbnails, gson.toJson(mainImage), descriptions);
//       
        int insert_id = productsDao.create(request, products);
        int number_of_stock = Integer.valueOf(request.getParameter("brand_id").replace(",", "").replace(" ", "").replace("-", ""));
        int total_price = Integer.valueOf(request.getParameter("total_price").replace(",", "").replace(" ", "").replace("-", ""));
        int offer_price = Integer.valueOf(request.getParameter("offer_price").replace(",", "").replace(" ", "").replace("-", ""));

        String sku = request.getParameter("sku");

        ProductsStock productsStock = new ProductsStock(insert_id, number_of_stock, total_price, offer_price, sku);
//       
        out.print("wooooooooooo" + insert_id);
        productsDetailsDao.create(request, productsStock);
        response.sendRedirect(Constent.getAdminProductUrl(request));
    }

    private void productsCreate(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException, ServletException {

        Part PartThumbnails = request.getPart("thumbnails");
        Part PartMain_image = request.getPart("main_image");

        ArrayList<String> img;
        int pid = Integer.valueOf(request.getParameter("pid"));
        int sid = Integer.valueOf(request.getParameter("sid"));
        int brand_id = Integer.valueOf(request.getParameter("brand_id"));
        int category_id = Integer.valueOf(request.getParameter("category_id"));
        int sub_category_id = Integer.valueOf(request.getParameter("sub_category_id"));
        int sub_sub_category_id = Integer.valueOf(request.getParameter("sub_sub_category_id"));
        String name = request.getParameter("productName");
        String unit = request.getParameter("unit");
        String descriptions = request.getParameter("descriptions");
        String thumbnails = "";
        String[] mainImage = null;
        if (PartThumbnails.getSize() > 0) {
            img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
            if (img.size() >= 1) {
                thumbnails = img.get(0);
            }
        }

        if (PartMain_image.getSize() > 0) {
            img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
            if (img.size() > 1) {
                mainImage = new String[img.size() - 1];
                for (int i = 1; i < img.size(); i++) {
                    mainImage[i - 1] = img.get(i);
                }
            }
        }

        Gson gson = new Gson();

        Products products = new Products(pid, brand_id, category_id, sub_category_id, sub_sub_category_id, name, unit, thumbnails,
                (mainImage == null) ? "" : gson.toJson(mainImage), descriptions);
//        out.print(gson.toJson(products));
        productsDao.update(request, products);
//       
//        int insert_id = 
        int number_of_stock = Integer.valueOf(request.getParameter("brand_id").replace(",", "").replace(" ", "").replace("-", ""));
        int total_price = Integer.valueOf(request.getParameter("total_price").replace(",", "").replace(" ", "").replace("-", ""));
        int offer_price = Integer.valueOf(request.getParameter("offer_price").replace(",", "").replace(" ", "").replace("-", ""));

        String sku = request.getParameter("sku");

        ProductsStock productsStock = new ProductsStock(sid , pid, number_of_stock, total_price, offer_price, sku);
//       
//        out.print("wooooooooooo" + insert_id);
        productsDetailsDao.update(request, productsStock);
        response.sendRedirect(Constent.getAdminProductUrl(request)+"?index=update-"+pid);
    }

}
