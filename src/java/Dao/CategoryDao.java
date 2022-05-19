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
import modal.Category;
import modal.User;

/**
 *
 * @author Dell1
 */
public class CategoryDao {

    public static final String table = "category";
    public static void create(HttpServletRequest request, Category category) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO "+category+"(`user_id`, `brand_id`, `name`, `img`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, category.getBrand_id());
            ps.setString(3, category.getName());
            ps.setString(4, category.getImg());
            ps.setInt(5, 1);
            ps.setString(6, date);
            ps.setString(7, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+" errorLog");
        }
    }
    
    public static List<Category> getCategoryList(){
        Connection con = DBConnect.getConnection();
        String sql = "select * from category";
        PreparedStatement ps;
        ArrayList<Category> categorys = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int brand_id = rs.getInt("brand_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                categorys.add(new Category(id, uid, status, brand_id, name, img, created_at, updated_at));
                
            }
            con.close();
        }catch(SQLException e){
            
        }
        return categorys;
    }
    public static Category getCategoryById(int bid){
        Connection con = DBConnect.getConnection();
        String sql = "select * from category where id='"+bid+"'";
        PreparedStatement ps;
        Category brand = null;
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int brand_id = rs.getInt("brand_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                brand = new Category(id, uid, status, brand_id, name, img, created_at, updated_at);
                
            }
            con.close();
        }catch(SQLException e){
            
        }
        return brand;
    }
}
