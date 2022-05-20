/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.BannerPosition;

/**
 *
 * @author Dell1
 */
public class BannerPositionDao {

    public static final String table = "banner_positions";

    public static List<BannerPosition> getBannerPosition() {
        Connection con = DBConnect.getConnection();
        String sql = "select * from " + table;

        PreparedStatement ps;
        ArrayList<BannerPosition> bannerPositions = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                int id = rs.getInt("id");
                int banner_id = rs.getInt("banner_id");
                String positions = rs.getString("positions");
                String created_at = rs.getString("updated_at");
                String updated_at = rs.getString("updated_at");

                bannerPositions.add(new BannerPosition(id, banner_id ,positions, created_at, updated_at));
            }
            con.close();
        } catch (SQLException e) {

        }
        return bannerPositions;
    }

}
