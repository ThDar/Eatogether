package com.eatogether.Controller;

import java.sql.*;

public class ConnectDB {

	
	/*static final String DB_URL = "jdbc:mysql://localhost/Eatogether?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "root";*/
	static final String DB_URL = "jdbc:postgresql://ec2-54-217-216-149.eu-west-1.compute.amazonaws.com:5432/dbmc625is0bgja";
	static final String USER = "murccgzmysuuhr";
	static final String PASS = "13908b7882288ef1be9fc8a9c54db1a8c559cff998088f1794cb618ec02c1d42";
	public Connection getConnexion() throws Exception {
		Class.forName("org.postgresql.Driver");
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