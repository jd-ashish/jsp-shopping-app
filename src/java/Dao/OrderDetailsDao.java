/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.Auth;
import Helper.Constent;
import Helper.DBConnect;
import Helper.GenBase64;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import modal.OrderDetails;
import modal.User;

/**
 *
 * @author Dell1
 */
public class OrderDetailsDao {
    public static int create(HttpServletRequest request, OrderDetails order) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `order_details`(`user_id`, `order_id`, `stock_id`, `status`, `created_at`, `updated_at`) "
                + "VALUES (?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, order.getOrder_id());
            ps.setInt(3, order.getStock_id());
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
            System.out.println(e.getMessage() + " errorLog");
        }
        return insertid;
    }
}
