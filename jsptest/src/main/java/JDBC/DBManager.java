package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection conn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.105:1521:xe";
			String user = "MIN";
			String pwd = "min";
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			System.out.println("오류 발생 :"+e.getMessage());
		}
		
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs) throws Exception {	
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류 발생 :"+ e.getMessage());
		}
	}
}
