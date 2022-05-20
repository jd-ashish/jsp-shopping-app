/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.Auth;
import Helper.Constent;
import Helper.DBConnect;
import Helper.Utils;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modal.Category;
import modal.Products;
import modal.User;

/**
 *
 * @author Dell1
 */
public class ProductsDao {

    public static int create(HttpServletRequest request, Products products) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `products`(`user_id`, `name`, `unit`, `brand`, `cateory`, `sub_category`, `sub_sub_category`, "
                + "`thumbnail`, `main_image`, `details`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, products.getName());
            ps.setString(3, products.getUnit());
            ps.setInt(4, products.getBrand());
            ps.setInt(5, products.getCateory());
            ps.setInt(6, products.getSub_category());
            ps.setInt(7, products.getSub_sub_category());
            ps.setString(8, products.getThumbnail());
            ps.setString(9, products.getMain_image());
            ps.setString(10, products.getDetails());
            ps.setInt(11, 1);
            ps.setString(12, date);
            ps.setString(13, date);
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

    public static int update(HttpServletRequest request, Products products) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "UPDATE `products` SET `user_id`=?,`name`=?,`unit`=?,"
                + "`brand`=?,`cateory`=?,`sub_category`=?,`sub_sub_category`=?,"
                + "`thumbnail`=?,`main_image`=?,`details`=?,`status`=?"
                + ",`updated_at`=? WHERE id='" + products.getId() + "'";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {

            if (!products.getThumbnail().equals("")) {
                imageDel(request, products, "thumb");
            }
            if (!products.getMain_image().equals("")) {
                imageDel(request, products, "main");
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, products.getName());
            ps.setString(3, products.getUnit());
            ps.setInt(4, products.getBrand());
            ps.setInt(5, products.getCateory());
            ps.setInt(6, products.getSub_category());
            ps.setInt(7, products.getSub_sub_category());
            ps.setString(8, (products.getThumbnail().equals("")) ? getProductsById("",products.getId()).get(0).getThumbnail() : products.getThumbnail());
            ps.setString(9, (products.getMain_image().equals("")) ? getProductsById("",products.getId()).get(0).getMain_image() : products.getMain_image());

            ps.setString(10, products.getDetails());
            ps.setInt(11, 1);
            ps.setString(12, date);
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

    public static void imageDel(HttpServletRequest request, Products products, String type) {
        String thumbnail = getProductsById("",products.getId()).get(0).getThumbnail();
        String[] main_img = Utils.StrinArrayToArray(getProductsById("",products.getId()).get(0).getMain_image());

        if (type.equals("main")) {
            for (String mainImg : main_img) {
                new File(Constent.PRODUCTS_UPLOAD_PATH_FILES + "/" + mainImg).delete();
            }
        }
        if (type.equals("thumb")) {
            if (!thumbnail.equals("")) {
                new File(Constent.PRODUCTS_UPLOAD_PATH_FILES + "/" + thumbnail).delete();
            }
        }

    }

    public static List<Products> getProducts() {
        return getProductsById("",-1);
    }
    public static List<Products> getProducts(String col, int id){
        return getProductsById(col,id);
    }

    public static List<Products> getProductsById(String col, int pid) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from products";
        if (pid == -1) {
            sql = "select * from products";
        } else if(col.equals("")){
            sql = "select * from products where id='" + pid + "'";
        }else if(!col.equals("")){
            if(pid==-99){
                sql = "SELECT * FROM `products` WHERE `details` LIKE '%"+col+"%'";
            }else{
                sql = "select * from products where "+col+"=" + pid + "";
            }
            
        }
        PreparedStatement ps;
        ArrayList<Products> productses = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int brand = rs.getInt("brand");
                int cateory = rs.getInt("cateory");
                int sub_category = rs.getInt("sub_category");
                int sub_sub_category = rs.getInt("sub_sub_category");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                String thumbnail = rs.getString("thumbnail");
                String main_image = rs.getString("main_image");
                String details = rs.getString("details");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                productses.add(new Products(id, user_id, brand, cateory, sub_category, sub_sub_category, status, name, unit, thumbnail, main_image, details, created_at, updated_at));

            }
            con.close();
        } catch (SQLException e) {

        }
        return productses;
    }
}
