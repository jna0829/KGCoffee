package com.kgcoffee.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.kgcoffee.web.board.vo.SnsVO;
import com.kgcoffee.web.common.DBConn;


public class SnsDAO {

	private static Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. 스스로 객체를 1개 생성합니다.
	private static SnsDAO instance;

	public SnsDAO() throws ClassNotFoundException, SQLException {
		con = DBConn.getInstance().getCon();
	}
	
	public static SnsDAO getInstance() throws ClassNotFoundException, SQLException {
		
		con = DBConn.getInstance().getCon();
		
		if(instance == null) {
			instance = new SnsDAO();
		}
		
		return instance;
	}

	// ------------------------------------------------------------------
	// 게시글 전체보기
	/*
	 * public ArrayList<SnsVO> getAllInfo() throws SQLException { ArrayList<SnsVO>
	 * sarray = new ArrayList<SnsVO>(); String sql =
	 * "select * from mvcsnsboard order by bunho desc";
	 * 
	 * pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery(); while
	 * (rs.next()) { int bunho = rs.getInt(1); String jemok = rs.getString(2);
	 * String writer = rs.getString(3); String content = rs.getString(4); Date date
	 * = rs.getDate(5); int count = rs.getInt(6);
	 * 
	 * SnsVO sv1 = new SnsVO(bunho, jemok, writer, content, date, count);
	 * 
	 * sarray.add(sv1); } return sarray; }
	 */

	// 게시글 전체보기 (+페이징)
	public ArrayList<SnsVO> getAllInfo(int page) throws SQLException {

		int startNum = (page - 1) * 10 + 1;
		int endNum = page * 10;

		String sql = "SELECT * FROM (" 
				+ " SELECT MVCSNSBOARD.*, ROWNUM row_num FROM (" 
				+ " SELECT * FROM MVCSNSBOARD order by bunho desc) MVCSNSBOARD"
				+ " ) WHERE row_num >= ? AND row_num <= ?";
		
		ArrayList<SnsVO> sarray = new ArrayList<SnsVO>();

		pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, startNum);
		pstmt.setInt(2, endNum);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			int bunho = rs.getInt(1);
			String jemok = rs.getString(2);
			String writer = rs.getString(3);
			String content = rs.getString(4);
			Date date = rs.getDate(5);
			int count = rs.getInt(6);
			String filename = rs.getString(7);

			SnsVO sv1 = new SnsVO(bunho, jemok, writer, content, date, count, filename);

			sarray.add(sv1);
		}
		return sarray;
	}

	// 게시글의 갯수를 count
	public int getAllCount() throws SQLException {

		String sql = "select count(*) count from MVCSNSBOARD";

		int count = 0;

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}

		return count;
	}
	
	//조회수 기능
	public void upHit(String bunho) throws SQLException {
		
		String sql = "update MVCSNSBOARD set snscnt = snscnt + 1 where bunho = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bunho);
		pstmt.executeUpdate();
		
	}
	
	// ----------------------------------------------------------------------

	public boolean insert(String jemok, String writer, String content, String filename) throws SQLException {
		String sql = "insert into MVCSNSBOARD"
					+ " values (mvcsnsboard_sequence1.NEXTVAL, ?, ?, ?,sysdate,0,?)";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, jemok);
		pstmt.setString(2, writer);
		pstmt.setString(3, content);
		pstmt.setString(4, filename);

		pstmt.executeUpdate();
		return true;
	}
	
	// ----------------------------------------------------------------------

	public SnsVO searchOne(int bunho2) throws SQLException {
		
		SnsVO sv1 = null;
		String sql = "select * from MVCSNSBOARD where bunho = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bunho2);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			int bunho = rs.getInt(1);
			String jemok = rs.getString(2);
			String writer = rs.getString(3);
			String content = rs.getString(4);
			Date date = rs.getDate(5);
			int count = rs.getInt(6);
			String filename = rs.getString(7);

			sv1 = new SnsVO(bunho, jemok, writer, content, date, count, filename);
		} else {
			sv1 = null;
		}
		return sv1;
	}

	
	public boolean update(String jemok1, String writer1, String content1, int bunho1, String filename) throws SQLException {
		String sql = "update MVCSNSBOARD set snsjemok=?, snswriter=?, snscontent=?, filename=? where bunho=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, jemok1);
		pstmt.setString(2, writer1);
		pstmt.setString(3, content1);
		pstmt.setString(4, filename);
		pstmt.setInt(5, bunho1);
		pstmt.executeUpdate();
		return true;
	}

	
	public boolean delete(int bunho1) throws SQLException {
		String sql = "delete from MVCSNSBOARD where bunho=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bunho1);
		pstmt.executeUpdate();
		return true;
	}


}
