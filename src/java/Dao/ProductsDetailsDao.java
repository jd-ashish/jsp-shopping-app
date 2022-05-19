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
import modal.Products;
import modal.ProductsStock;
import modal.User;

/**
 *
 * @author Dell1
 */
public class ProductsDetailsDao {
    public static int create(HttpServletRequest request, ProductsStock productsStock) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `stock`(`user_id`, `product_id`, `total_stock`, `sku`, `total_price`, "
                + "`offer_price`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, productsStock.getProduct_id());
            ps.setInt(3, productsStock.getTotal_stock());
            ps.setString(4, productsStock.getSku());
            ps.setInt(5, productsStock.getTotal_price());
            ps.setInt(6, productsStock.getOffer_price());
            ps.setInt(7, 1);
            ps.setString(8, date);
            ps.setString(9, date);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                insertid = rs.getInt(1);
            }
            
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+" errorLog");
        }
        return insertid;
    }
    
    public static int update(HttpServletRequest request, ProductsStock productsStock) {
        int insertid = 0;
        Connection con = DBConnect.getConnection();
        String sql = "UPDATE `stock` SET "
                + "`product_id`=?,`total_stock`=?,`sku`=?"
                + ",`total_price`=?,`offer_price`=?,`status`=?"
                + ",`updated_at`=? WHERE id='"+productsStock.getId()+"'";

        System.err.println("qwertyuiolkmn "+sql);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, productsStock.getProduct_id());
            ps.setInt(2, productsStock.getTotal_stock());
            ps.setString(3, productsStock.getSku());
            ps.setInt(4, productsStock.getTotal_price());
            ps.setInt(5, productsStock.getOffer_price());
            ps.setInt(6, 1);
            ps.setString(7, date);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                insertid = rs.getInt(1);
            }
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+" errorLog");
        }
        return insertid;
    }
    public static List<ProductsStock> getProductsStocks(int pid){
        Connection con = DBConnect.getConnection();
        String sql = "select * from stock where id="+pid+"";
        System.err.println("sqpsqpl "+sql);
        PreparedStatement ps;
        ArrayList<ProductsStock> productsStocks = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int product_id = rs.getInt("product_id");
                int total_stock = rs.getInt("total_stock");
                String sku = rs.getString("sku");
                int total_price = rs.getInt("total_price");
                int offer_price = rs.getInt("offer_price");
                int name = rs.getInt("status");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                productsStocks.add(new ProductsStock(id, user_id, product_id, total_stock, total_price, offer_price, name, sku, created_at, updated_at));
                
            }
            con.close();
        } catch (SQLException e) {

        }
        return productsStocks;
    }
    
    public static List<ProductsStock> getProductsStocksByProductId(int pid){
        Connection con = DBConnect.getConnection();
        String sql = "select * from stock where product_id="+pid+"";
        System.err.println("sqpsqpl "+sql);
        PreparedStatement ps;
        ArrayList<ProductsStock> productsStocks = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int product_id = rs.getInt("product_id");
                int total_stock = rs.getInt("total_stock");
                String sku = rs.getString("sku");
                int total_price = rs.getInt("total_price");
                int offer_price = rs.getInt("offer_price");
                int name = rs.getInt("status");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                productsStocks.add(new ProductsStock(id, user_id, product_id, total_stock, total_price, offer_price, name, sku, created_at, updated_at));
                
            }
            con.close();
        } catch (SQLException e) {

        }
        return productsStocks;
    }
}
