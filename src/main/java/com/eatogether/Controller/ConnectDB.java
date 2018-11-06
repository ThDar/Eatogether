package com.eatogether.Controller;

import java.sql.*;

public class ConnectDB {

	
	static final String DB_URL = "jdbc:mysql://localhost/Eatogether?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "root";
	   
	public Connection getConnexion() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}

	public void closeConnexion(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}