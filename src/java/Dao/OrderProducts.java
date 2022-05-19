/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.Auth;
import Helper.Constent;
import Helper.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import modal.Order;
import modal.Products;
import modal.User;

/**
 *
 * @author Dell1
 */
public class OrderProducts {
    public static int create(HttpServletRequest request, Order order) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `order_products`(`user_id`, `address`, `sub_total`, `order_type`, "
                + "`order_status`, `delivery_status`, `payment_method`, `payment_staus`, `created_at`, `updated_at`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, order.getAddress());
            ps.setDouble(3, order.getSub_total());
            ps.setString(4, order.getOrder_type());
            ps.setString(5, order.getOrder_status());
            ps.setString(6, order.getDelivery_status());
            ps.setString(7, order.getPayment_method());
            ps.setString(8, order.getPayment_staus());
            ps.setString(9, date);
            ps.setString(10, date);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insertid = rs.getInt(1);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " errorLog");
        }
        return insertid;
    }
    
    public static void updateCod(HttpServletRequest request,String order_id) {
        Connection con = DBConnect.getConnection();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        String sql = "UPDATE `order_products` SET `order_type`='"+Constent.PENDING+"',`order_status`='"+Constent.PENDING+"',"
                + "`delivery_status`='"+Constent.PENDING+"',`payment_method`='"+Constent.COD+"',"
                + "`payment_staus`='"+Constent.PENDING+"',`updated_at`='"+date+"' WHERE id="+order_id+"";
        User user = new Auth(request).user();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            
            CartDao.clearCart(user.getId());

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("geterfghsjh "+e.getMessage());
        }
    }
}
