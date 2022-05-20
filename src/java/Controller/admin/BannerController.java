/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.admin;

import Dao.BannerDao;
import Helper.CommonFileUpload;
import Helper.Constent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Banner;

/**
 *
 * @author Dell1
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class BannerController extends HttpServlet {

    private static final String UPLOAD_PATH_FILES = "C:/Users/Dell1/Documents/NetBeansProjects/Shopping/web/img/banner";

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
        request.getRequestDispatcher("../admin/banner/index.jsp").forward(request, response);
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
            request.getRequestDispatcher("../admin/banner/create.jsp").forward(request, response);
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
        ArrayList<String> img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
                
//        int banner_id = Integer.valueOf((.equalsIgnoreCase("Select brand"))?"0":request.getParameter("banner_id"));
        String title = request.getParameter("title");
        String offer_title = request.getParameter("offer_title");
        String file = img.get(0);
        String link = request.getParameter("link");
        String descriptions = request.getParameter("descriptions");
        Banner banner = new Banner(1,file , request.getParameter("banner_id"), title, descriptions, offer_title, link);
        
        BannerDao.create(request, banner);
        response.sendRedirect(Constent.getBannerUrl(request));
        
        
//        create_banner
//        processRequest(request, response);
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
