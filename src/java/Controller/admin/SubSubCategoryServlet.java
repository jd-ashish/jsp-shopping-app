/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.admin;

import Dao.SubSubCategoryDao;
import Helper.Auth;
import Helper.CommonFileUpload;
import Helper.Constent;
import Helper.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modal.SubCategory;
import modal.SubSubCategory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dell1
 */

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class SubSubCategoryServlet extends HttpServlet {
    private static final String UPLOAD_PATH_FILES = "C:/Users/Dell1/Documents/NetBeansProjects/Shopping/web/img/sub_sub_category";

    SubSubCategoryDao subSubCategoryDao = new SubSubCategoryDao();
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
        request.getRequestDispatcher("../admin/SubSubCategory/sub_sub_cat_index.jsp").forward(request, response);
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
            request.getRequestDispatcher("../admin/SubSubCategory/sub_sub_cat_create.jsp").forward(request, response);
        }else if(index.split("-")[0].equals("update")){
            request.getRequestDispatcher("../admin/SubSubCategory/sub_sub_cat_update.jsp").forward(request, response);
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
        
        
        if (request.getParameter("type").equals("create_category")) {
            Auth auth = new Auth(request);
            if (auth.user() == null) {
                response.sendRedirect(Utils.getBaseUrl(request));
            } else {
                ArrayList<String> img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
                String bid = (request.getParameter("brand_id").equals("Select brand"))? "0":request.getParameter("brand_id");
                
                SubSubCategory subSubCategory = new SubSubCategory(Integer.valueOf(bid), Integer.valueOf(request.getParameter("category_id"))
                        , Integer.valueOf(request.getParameter("sub_category_id")), request.getParameter("cat_name"), img.get(0));
                
                subSubCategoryDao.create(request, subSubCategory);
                request.getSession().setAttribute("type", "success");
                request.getSession().setAttribute("message", "Sub Sub category added successfully");
                response.sendRedirect(Constent.getSubSubCategoryUrl(request));
            }

        }else if(request.getParameter("type").equals("update_category")){
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if(isMultipart){
                Part filePart = request.getPart("file1");
                String imgData = "";
                if(filePart.getSize()>0){
                    ArrayList<String> img = new CommonFileUpload(UPLOAD_PATH_FILES, request).use();
                    imgData = img.get(0);
                }
                String bid = (request.getParameter("brand_id").equals("Select brand"))? "0":request.getParameter("brand_id");
                
                SubSubCategory subSubCategory = new SubSubCategory(Integer.valueOf(bid), Integer.valueOf(request.getParameter("category_id"))
                        , Integer.valueOf(request.getParameter("sub_category_id")), request.getParameter("cat_name"), imgData);
                
                subSubCategoryDao.updateSubSubCategory(subSubCategory, request.getParameter("index").split("-")[1]);
                request.getSession().setAttribute("type", "success");
                request.getSession().setAttribute("message", "Sub Sub category update successfully");
                response.sendRedirect(Constent.getSubSubCategoryUrl(request));
            }else{
                out.print("no file dound");
            }
            
        }
    }
private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
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
