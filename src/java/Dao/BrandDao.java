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
import modal.Brand;
import modal.User;

/**
 *
 * @author Dell1
 */
public class BrandDao {

    public void create(HttpServletRequest request, Brand brand) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `brand`(`user_id`, `name`, `img`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?)";
        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, brand.getName());
            ps.setString(3, brand.getImg());
            ps.setInt(4, 1);
            ps.setString(5, date);
            ps.setString(6, date);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {

        }
    }
    public static List<Brand> getBrandList(){
        Connection con = DBConnect.getConnection();
        String sql = "select * from brand";
        PreparedStatement ps;
        ArrayList<Brand> brand = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                brand.add(new Brand(id,uid,status, name, img, created_at, updated_at));
                
            }
            con.close();
        }catch(SQLException e){
            
        }
        return brand;
    }
    public static Brand getBrandById(int bid){
        Connection con = DBConnect.getConnection();
        String sql = "select * from brand where id='"+bid+"'";
        PreparedStatement ps;
        Brand brand = null;
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                brand = new Brand(id,uid,status, name, img, created_at, updated_at);
                
            }
            con.close();
        }catch(SQLException e){
            
        }
        return brand;
    }
}
