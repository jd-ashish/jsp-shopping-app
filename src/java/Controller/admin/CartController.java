/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.admin;

import Dao.CartDao;
import Dao.OrderDetailsDao;
import Dao.OrderProducts;
import Dao.ProductsDao;
import Dao.ProductsDetailsDao;
import Helper.Constent;
import Helper.GenBase64;
import Helper.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.service.app.CartDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Cart;
import modal.Order;
import modal.OrderDetails;
import modal.Products;
import modal.ProductsStock;

/**
 *
 * @author Dell1
 */
public class CartController extends HttpServlet {

    CartDao cartDao = new CartDao();

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
        request.getRequestDispatcher("frontend/cart.jsp").forward(request, response);
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
        processRequest(request, response);
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
        String type = request.getParameter("index");

        if (type.equals("addCart")) {
            int stock_id = Integer.valueOf(request.getParameter("stock_id"));
            int qty = Integer.valueOf(request.getParameter("qty"));
            addCart(request, stock_id, qty);
        } else if (type.equals("getCart")) {
            int totalCart = cartDao.getCart(request).size();
            
            out.print(new Gson().toJson(CartDetails.getCartDetails(totalCart,request,response,cartDao)));
        } else if (type.equals("removeCart")) {
            cartDao.removeCart(request.getParameter("cart_id"));
        } else if (type.equals("updateCart")) {
            cartDao.updateCart(request.getParameter("cart_id"), request.getParameter("type"));
        } else if (type.equals("payment")) {
            gotoPaymentPage(request, response, out);
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

    private void addCart(HttpServletRequest request, int stock_id, int qty) {
        Cart cart = new Cart(stock_id, qty);
        cartDao.create(request, cart);

    }

    private void gotoPaymentPage(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {

        String cartIds = request.getParameter("cartIds").replaceAll("\"", "").replace("]", "").replace("[", "");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String landmark = request.getParameter("landmark");
        String sub_total = request.getParameter("sub_total");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("landmark", landmark);
        jsonObject.addProperty("city", city);
        jsonObject.addProperty("address", address);

        String full_address_detail = new Gson().toJson(jsonObject);

        String[] cart_ids = cartIds.split(",");

        Order order = new Order(Double.valueOf(sub_total), full_address_detail, Constent.PENDING, Constent.PENDING, Constent.PENDING, Constent.PENDING, Constent.PENDING);
        //submit
        int order_id = OrderProducts.create(request, order);

        Cookie cookie = new Cookie(Constent.ORDER_ID, String.valueOf(order_id));
        cookie.setMaxAge(60 * 60);//60 min
        response.addCookie(cookie);

        for (String cid : cart_ids) {
            Cart cart = cartDao.getCommonCarts(Integer.valueOf(cid), -2).get(0);
            //stock
            ProductsStock productsStock = ProductsDetailsDao.getProductsStocks(cart.getStock_id()).get(0);
            //product
            Products products = ProductsDao.getProductsById(productsStock.getProduct_id()).get(0);
            //Order model
            OrderDetails orderDetails = new OrderDetails(order_id, cart.getStock_id());
            OrderDetailsDao.create(request, orderDetails);

        }
        response.sendRedirect(Utils.getBaseUrl(request) + "/payment");

    }

}
