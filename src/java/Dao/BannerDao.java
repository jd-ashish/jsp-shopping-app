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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modal.Banner;
import modal.Products;
import modal.SubSubCategory;
import modal.User;

/**
 *
 * @author Dell1
 */
public class BannerDao {
    public static final String table = "banner";
    
    public static void create(HttpServletRequest request, Banner banner) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `banner`(`file`, `positions`, `title`, `description`, `offer`, `link`, `status`, `created_at`, "
                + "`updated_at`) VALUES (?,?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, banner.getFile());
            ps.setString(2, banner.getPositions());
            ps.setString(3, banner.getTitle());
            ps.setString(4, banner.getDescription());
            ps.setString(5, banner.getOffer());
            ps.setString(6, banner.getLink());
            ps.setInt(7, 1);
            ps.setString(8, date);
            ps.setString(9, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " BannerDaoErrorLog");
        }
    }
    
    public static List<Banner> getBannerList(int positions){
        Connection con = DBConnect.getConnection();
        String sql = "select * from "+table;
        if (positions == -1) {
            sql = "select * from "+table;
        } else if(positions>0){
            sql = "select * from "+table+" where positions='"+positions+"'";
        }
        PreparedStatement ps;
        ArrayList<Banner> banners = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                
                int id = rs.getInt("id");
                String file = rs.getString("file");
                String positions_col = rs.getString("positions");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String offer = rs.getString("offer");
                int status = rs.getInt("status");
                String link = rs.getString("link");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                banners.add(new Banner(id, status, file, positions_col, title, description, offer, link, created_at, updated_at));
            }
            con.close();
        } catch (SQLException e) {

        }
        return banners;
    }
}
