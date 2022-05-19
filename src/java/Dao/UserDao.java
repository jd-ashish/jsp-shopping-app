/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.DBConnect;
import Helper.Utils;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modal.User;

/**
 *
 * @author Dell1
 */
public class UserDao {
    public static boolean checkEmail(String email){
        Connection con = DBConnect.getConnection();
        String sql = "select * from user where email='"+email+"'";
        PreparedStatement ps;
        
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                con.close();
                return true;
            }
        }catch(SQLException e){
            
        }
        return false;
    }
    public static User getUser(String email){
        Connection con = DBConnect.getConnection();
        String sql = "select * from user where email='"+email+"'";
        PreparedStatement ps;
        User user = null;
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String emails = rs.getString("email");
                String type = rs.getString("type");
                String created_at = rs.getString("created_at");
                String updated_at = rs.getString("updated_at");
                user = new User(id, name, emails, type, created_at, updated_at);
                con.close();
            }
        }catch(SQLException e){
            
        }
        return user;
    }
    public static boolean login(String email,String pass){
        Connection con = DBConnect.getConnection();
        String sql = "select * from user where email='"+email+"' and password='"+Utils.getMD5(pass)+"' ";
        PreparedStatement ps;
        
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                con.close();
                return true;
            }
        }catch(SQLException e){
            
        }
        return false;
    }
    
    public static void addUser(User user){
        Connection con = DBConnect.getConnection();
        String sql = "insert into user (name,email,password,created_at,updated_at) values(?,?,?,?,?)";
        PreparedStatement ps;
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String created_at = simpleDateFormat.format(new Date());
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, Utils.getMD5(user.getPassword()));
            ps.setString(4, created_at);
            ps.setString(5, created_at);
            ps.executeUpdate();
            con.close();
        }catch(SQLException e){
            
        }
    }
}
