package communication.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import communication.dao.impl.UserDaoImpl;

public class Util {

	private Connection conn;

	public Connection getConnection() {
		conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/communication?characterEncoding=utf-8", "root",
					"root");// 
//			System.out.println("succes");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeConn(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

