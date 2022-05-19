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
import modal.Category;
import modal.SubCategory;
import modal.User;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author Dell1
 */
public class SubCategoryDao {
    public static void create(HttpServletRequest request, SubCategory category) {
        Connection con = DBConnect.getConnection();
        String sql = "INSERT INTO `sub_category`(`user_id`, `brand_id`, `category_id`, `name`, `img`, `status`, `created_at`, `updated_at`) VALUES (?,?,?,?,?,?,?,?)";

        User user = new Auth(request).user();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, category.getBrand_id());
            ps.setInt(3, category.getCategory_id());
            ps.setString(4, category.getName());
            ps.setString(5, category.getImg());
            ps.setInt(6, 1);
            ps.setString(7, date);
            ps.setString(8, date);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+" SubCategoryDaoErrorLog");
        }
    }
    
    public static List<SubCategory> getSubCategoryList(){
        return getSubCategoryListCommon(-1,"");
    }
    
    public static List<SubCategory> getSubCategoryListByCategoryId(int cat_id){
        return getSubCategoryListCommon(cat_id,"category_id");
    }
    public static List<SubCategory> getSubCategoryListCommon( int cat_id , String col){
        Connection con = DBConnect.getConnection();
        String sql = "select * from sub_category";
        if(cat_id==-1){
            sql = "select * from sub_category";
        }else{
            sql = "select * from sub_category where "+col+"='"+cat_id+"'";
        }
        
        PreparedStatement ps;
        ArrayList<SubCategory> subCategorys = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int brand_id = rs.getInt("brand_id");
                int category_id = rs.getInt("category_id");
                int status = rs.getInt("status");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                subCategorys.add(new SubCategory(id, uid, status, brand_id, category_id, name, img, created_at, updated_at));
                
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error in getSubCategoryList "+e.getMessage());
        }
        return subCategorys;
    }
    public static SubCategory getCategoryById(int bid){
        SubCategory subCategory = null;
        for(SubCategory sc:getSubCategoryListCommon(bid,"id")){
            subCategory = new SubCategory(sc.getId(), sc.getUser_id(), sc.getStatus(), sc.getBrand_id(), sc.getCategory_id(), sc.getName(), sc.getImg(), sc.getCreated_at(), sc.getUpdated_at());
        }
        return subCategory;
    }
}
