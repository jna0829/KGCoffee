package com.kgcoffee.web.order.domain.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kgcoffee.web.common.DBConn;


public class BasketRepository {

	
	
	private Connection con;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String sql;

	public BasketRepository() {
		// TODO Auto-generated constructor stub
	
		this.con= DBConn.getInstance().getCon();
	
	}
	
	

    public void save(int product_count, int total_amount, int fk_menu_id, String fk_user_id){
        
     


        sql = "INSERT INTO BASEKT(prodcut_count, total_amount, fk_menu_id, fk_user_id) values(?, ?, ?, ?)";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, product_count);
            pst.setInt(2, total_amount);
            pst.setInt(3, fk_menu_id);
            pst.setString(4, fk_user_id);
            pst.executeUpdate();
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
    }

    public void delete(int basket_id){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "DELETE FROM BASKET WHERE BASKET_ID = ?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, basket_id);
            int o = pst.executeUpdate();
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
    }

    public void update(int basket_id, int new_val){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "UPDATE BASKET SET PRODUCT_COUNT = ? WHERE BASKET_ID = ?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, new_val);
            pst.setInt(2, basket_id);
            int o = pst.executeUpdate();
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
    }



    public ArrayList<BasketDto> findAllBasketsByUserId(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BASKET INNER JOIN MENU ON FK_MENU_ID = MENUID WHERE FK_USER_ID=?";
        String tmpId = "test";
        ArrayList<BasketDto> arrayList = new ArrayList<>();
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, tmpId);
            pst.executeUpdate();
            rs = pst.executeQuery();
            while(rs.next()){
                BasketDto basketDto = new BasketDto(rs.getInt("basket_id"), rs.getInt("product_count"),
                        rs.getInt("menuPrice"), rs.getString("menuName"), rs.getInt("fk_menu_id"), rs.getString("fk_user_id"));
                arrayList.add(basketDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return arrayList;
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
