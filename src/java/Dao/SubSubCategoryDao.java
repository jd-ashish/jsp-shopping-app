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
import modal.SubCategory;
import modal.SubSubCategory;
import modal.User;

/**
 *
 * @author Dell1
 */
public class SubSubCategoryDao {

    public static void create(HttpServletRequest request, SubSubCategory subSubCategory) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `sub_sub_category`(`user_id`, `brand_id`, `category_id`, `sub_category_id`, `name`, `img`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, subSubCategory.getBrand_id());
            ps.setInt(3, subSubCategory.getCategory_id());
            ps.setInt(4, subSubCategory.getSub_category_id());
            ps.setString(5, subSubCategory.getName());
            ps.setString(6, subSubCategory.getImg());
            ps.setInt(7, 1);
            ps.setString(8, date);
            ps.setString(9, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " SubSubCategoryDaoErrorLog");
        }
    }

    public static List<SubSubCategory> getSubSubCategoryList() {
        Connection con = DBConnect.getConnection();
        String sql = "select * from sub_sub_category";
        PreparedStatement ps;
        ArrayList<SubSubCategory> subCategorys = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int brand_id = rs.getInt("brand_id");
                int category_id = rs.getInt("category_id");
                int sub_category_id = rs.getInt("sub_category_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                subCategorys.add(new SubSubCategory(id, uid, status, brand_id, category_id, sub_category_id, name, img, created_at, updated_at));

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error in getSubCategoryList " + e.getMessage());
        }
        return subCategorys;
    }

    public static SubSubCategory getSubSubCategoryById(int bid) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from sub_sub_category where id='" + bid + "'";
        PreparedStatement ps;
        SubSubCategory subCategory = null;
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int brand_id = rs.getInt("brand_id");
                int category_id = rs.getInt("category_id");
                int sub_category_id = rs.getInt("sub_category_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                subCategory = new SubSubCategory(id, uid, status, brand_id, category_id, sub_category_id, name, img, created_at, updated_at);

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("SubCategoryErro " + e.getMessage());
        }
        return subCategory;
    }

    public static void updateSubSubCategory(SubSubCategory subSubCategory , String sscid) {
        Connection con = DBConnect.getConnection();
        String sql;
        if (subSubCategory.getImg().equals("")) {
            sql = "update sub_sub_category set brand_id=? , category_id=? , sub_category_id=?  , name=? where id='" + sscid + "'";
        
        }else{
            sql = "update sub_sub_category set brand_id=? , category_id=? , sub_category_id=? , name=? , img=? where id='" + sscid + "'";
        
        }
        
        com.mysql.jdbc.PreparedStatement ps;
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, subSubCategory.getBrand_id());
            ps.setInt(2, subSubCategory.getCategory_id());
            ps.setInt(3, subSubCategory.getSub_category_id());
            ps.setString(4, subSubCategory.getName());
            if (!subSubCategory.getImg().equals("")) {
                ps.setString(5, subSubCategory.getImg());
            }

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("geterfghsjh "+e.getMessage());
        }
    }
}
