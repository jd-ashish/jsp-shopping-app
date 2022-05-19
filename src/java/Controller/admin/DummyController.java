/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.admin;

import Dao.BrandDao;
import Helper.Auth;
import Helper.CommonFileUpload;
import Helper.Constent;
import Helper.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Brand;

/**
 *
 * @author Dell1
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class DummyController extends HttpServlet {
private static final String UPLOAD_PATH_FILES = "C:/Users/Dell1/Documents/NetBeansProjects/Shopping/web/img/dummy";
    BrandDao brandDao = new BrandDao();

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
        request.getRequestDispatcher("admin/Brands/brand_index.jsp").forward(request, response);
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
//        request.getRequestDispatcher("admin/Brands/brand_create.jsp").forward(request, response);
        String index = request.getParameter("index");
        if (index == null) {
            processRequest(request, response);
        } else if (index.equals("create")) {
            request.getRequestDispatcher("admin/Brands/brand_create.jsp").forward(request, response);
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

        if (request.getParameter("type").equals("create_brand")) {
            Auth auth = new Auth(request);
            if (auth.user() == null) {
                response.sendRedirect(Utils.getBaseUrl(request));
            } else {
                out.print(request.getParameter("brand"));
                ArrayList<String> img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
//                Brand brand = new Brand(request.getParameter("brand"), img.get(0));
//                brandDao.create(request, brand);
//                request.getSession().setAttribute("type", "success");
//                request.getSession().setAttribute("message", "Brand added successfully");
//                response.sendRedirect(Constent.getBrandUrl(request));
            }

        }

//        processRequest(request, response);
//        PrintWriter out = response.getWriter();
//
//      
//
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

}
