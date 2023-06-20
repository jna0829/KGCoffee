package com.kgcoffee.web.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	
	private Connection con;
	
	
	
	public Connection getCon() {
		return con;
	}

	private static final DBConn dbConn = new DBConn();
	
	public static DBConn getInstance() {
		return dbConn;
		
	}
	private DBConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	}
