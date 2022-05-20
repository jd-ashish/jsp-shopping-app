/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import static Dao.ProductsDao.getProductsById;
import static Dao.ProductsDao.imageDel;
import Helper.Auth;
import Helper.DBConnect;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modal.Brand;
import modal.Footer;
import modal.Products;
import modal.User;

/**
 *
 * @author Dell1
 */
public class FooterDao {

    public static void create(HttpServletRequest request, Footer footer) {
        if (getFooterList(footer.getTitle()).size() > 0) {
            Footer footer1 = new Footer(getFooterList(footer.getTitle()).get(0).getId(), 0, 
                    "", "", footer.getDetails(), "", "");
            update(request, footer1, "On_create");
        } else {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO `footer`(`positions`, `title`, `details`, `status`, `created_at`, `updated_at`) "
                    + "VALUES (?,?,?,?,?,?)";
            User user = new Auth(request).user();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, footer.getPositions());
                ps.setString(2, footer.getTitle());
                ps.setString(3, footer.getDetails());
                ps.setInt(4, 1);
                ps.setString(5, date);
                ps.setString(6, date);
                ps.executeUpdate();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(HttpServletRequest request, Footer footer, String type) {

        
        Connection con = DBConnect.getConnection();
        String sql = "";

        if (type.equals("On_create")) {
            sql = "UPDATE `footer` SET `details`=? , `updated_at`=? WHERE id=" + footer.getId();
        }
        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
System.err.println("qwertyuioasd "+new Gson().toJson(footer));
            ps = con.prepareStatement(sql);
            ps.setString(1, footer.getDetails());
            ps.setString(2, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " errorLog");
        }
    }
    
    public static List<Footer> getFooterListByPositions(String positions){
        String sql = "select * from footer where positions='"+positions+"'";
        return commonListData(sql);
    } 

    public static List<Footer> commonListData(String sql) {
        System.err.println("qwertyuioppoiuytrew "+sql);
        Connection con = DBConnect.getConnection();
        PreparedStatement ps;
        ArrayList<Footer> footers = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                int id = rs.getInt("id");
                int status = rs.getInt("status");
                String positions = rs.getString("positions");
                String title = rs.getString("title");
                String details = rs.getString("details");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                footers.add(new Footer(id, status, positions, title, details, created_at, updated_at));

            }
            con.close();
        } catch (SQLException e) {

        }
        return footers;
    }
    public static List<Footer> getFooterList(String titile) {

        
        String sql = "select * from products";
        if (titile.equals("")) {
            sql = "select * from footer";
        } else {
            sql = "SELECT * FROM `footer` WHERE `title` LIKE '" + titile + "'";
        }
        return commonListData(sql);
    }
}
