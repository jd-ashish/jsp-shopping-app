/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.Auth;
import Helper.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import modal.Banner;
import modal.Newsletter;
import modal.User;

/**
 *
 * @author Dell1
 */
public class NewsletterDao {
    public static void create(HttpServletRequest request, Newsletter newsletter) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `newsletter`( `email`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, newsletter.getEmail());
            ps.setInt(2, 1);
            ps.setString(3, date);
            ps.setString(4, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " NewsletterDaoErrorLog");
        }
    }
}
