package cn.inspur.emps.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;



public class JdbcUtils {
	private static String driver = "com.mysql.jdbc.Driver";  //驱动程序
	private static String url = "jdbc:mysql://localhost:3306/emps?characterEncoding=utf-8";
	private static String username="root";
	private static String password="";
	static {
		try {
			Class.forName(driver);  //加载驱动程序
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con =null;
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
		return con;
	}
	public static void close(Connection con, PreparedStatement pstmt,ResultSet rs) {
		if(rs!=null) {
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(JdbcUtils.getConnection());
	}
}
