/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import static Controller.SignupServlet.flash;
import Dao.UserDao;
import Helper.Constent;
import Helper.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.User;

/**
 *
 * @author Dell1
 */
public class LoginServlet extends HttpServlet {

    UserDao userDao = new UserDao();

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
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("login.jsp").forward(request, response);

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
        
        if(Utils.getCookies(request, Constent.LOGIN_COOKIE_NAME)==null){
            processRequest(request, response);
        }else{
            response.sendRedirect(Utils.getBaseUrl(request));
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
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        if (userDao.login(email, pass)) {
            Cookie cookie = new Cookie(Constent.LOGIN_COOKIE_NAME, email);
            cookie.setMaxAge(1440 * 60);//24 hr
            response.addCookie(cookie);
            flash(request, response, "", "login successfully", "success");
            
            response.sendRedirect(Utils.getBaseUrl(request));
        } else {
            flash(request, response, "", "This user not found!", "error");
            response.sendRedirect("login");
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

    public static void flash(HttpServletRequest request, HttpServletResponse response,
            String url, String message, String type) {
        try {
            request.getSession().setAttribute("type", type);
            request.getSession().setAttribute("message", message);
            if (!type.equals("success")) {
                if (!url.equals("")) {
                    request.getRequestDispatcher(url).forward(request, response);
                }
            }

        } catch (ServletException | IOException ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
