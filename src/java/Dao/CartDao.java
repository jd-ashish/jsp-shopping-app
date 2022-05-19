/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.Auth;
import Helper.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modal.Cart;
import modal.Category;
import modal.Products;
import modal.User;

/**
 *
 * @author Dell1
 */
public class CartDao {

    public static final String table = "cart";

    public static boolean checkCartExist(int uid, int sid) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from " + table + " where user_id=? && stock_id=?";
        System.out.println("sqlsqlsql " + sql);
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2, sid);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                return true;
            }
            con.close();
        } catch (SQLException e) {

        }
        return false;
    }

    public static int create(HttpServletRequest request, Cart cart) {

        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `cart`(`user_id`, `stock_id`, `qty`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        if (!checkCartExist(user.getId(), cart.getStock_id())) {
            ResultSet rs;
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, user.getId());
                ps.setInt(2, cart.getStock_id());
                ps.setInt(3, cart.getQty());
                ps.setInt(4, 1);
                ps.setString(5, date);
                ps.setString(6, date);
                ps.executeUpdate();

                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    insertid = rs.getInt(1);
                }

                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " CartAddErrorLog");
            }
            return insertid;
        } else {
            updateQty(user.getId(), cart.getStock_id(), 1);
            return -1;
        }

    }

    public static void updateQty(int user_id, int stock_id, int qty) {
        Connection con = DBConnect.getConnection();
        String sql = "update cart set qty=qty+? , updated_at=? where user_id='" + user_id + "' && stock_id='" + stock_id + "'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setString(2, date);

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("geterfghsjh " + e.getMessage());
        }
    }

    public static List<Cart> getCart(HttpServletRequest request) {
        User user = new Auth(request).user();
        return getCommonCarts(user.getId(), -1);

    }

    public static List<Cart> getCommonCarts(int data_id, int type_id) {
        String sql = "";
        if (type_id == -1) {
            sql = "select * from " + table + " where user_id='" + data_id + "'";
        } else if (type_id == -2) {
            sql = "select * from " + table + " where id='" + data_id + "'";
        }
        commonDeleteCart("-1");
        System.err.println("aasdfgjk " + sql);
        Connection con = DBConnect.getConnection();
        List<Cart> carts = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int stock_id = rs.getInt("stock_id");
                int qty = rs.getInt("qty");
                int status = rs.getInt("status");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");

                carts.add(new Cart(id, user_id, stock_id, qty, status, created_at, updated_at));
            }
            con.close();
        } catch (SQLException e) {

        }
        return carts;
    }

    public static void updateCartQty(String id, String type , int qty) {
        Connection con = DBConnect.getConnection();
        String sql = "update cart set qty=qty"+type+"? , updated_at=? where id='" + id + "'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setString(2, date);

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("geterfghsjh " + e.getMessage());
        }
    }
    
    public static void updateCart(String id,String type) {
        ProductsDetailsDao productsDetailsDao = new ProductsDetailsDao();
        List<Cart> carts = getCommonCarts(Integer.parseInt(id), -2);
        if(carts.size()>0){
            //data is present
            int qty = carts.get(0).getQty();
            int qty_details_dao = productsDetailsDao.getProductsStocks(carts.get(0).getStock_id()).get(0).getTotal_stock();
            if(qty<=qty_details_dao){
                updateCartQty(id, type, 1);
            }else if(type.equals("-")){
                updateCartQty(id, type, 1);
            }
            
        }
    }
    
    public static void removeCart(String id) {
        commonDeleteCart(id);
    }
    public static void commonDeleteCart(String id){
        Connection con = DBConnect.getConnection();
        String sql = "";
        int zero = 0;
        if(id.equals("-1")){
            sql = "delete from " + table + " where qty='" + zero + "'";
        }else{
            sql = "delete from " + table + " where id='" + id + "'";
        }
       
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void clearCart(int uid){
        Connection con = DBConnect.getConnection();
        String sql = "delete from "+table+" where user_id='" + uid + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
