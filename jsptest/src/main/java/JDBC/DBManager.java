package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection conn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.105:1521:xe";
		String user = "MIN";
		String pwd = "min";
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs) throws Exception {	
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}
}
