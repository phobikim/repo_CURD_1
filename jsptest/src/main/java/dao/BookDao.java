package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.BookVo;


public class BookDao {
	private static BookDao dao;
	private BookDao() {
		
	}
	
	public static BookDao getIntance() {
		if(dao == null) {
			dao = new BookDao();
		}
		return dao;
	}
	
	//테이블 내용 가져오기 Read : 전체 테이블
	public ArrayList<BookVo> getAllList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		//sql문 생성
		String sql = "select * from book2";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.105:1521:xe";
			String user = "MIN";
			String pwd = "min";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BookVo book = new BookVo();
				book.setNo(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setWriter(rs.getString(4));
				book.setPrice(rs.getInt(5));
				list.add(book);
			}
		}catch (Exception e) {
			System.out.println("예외 발생:"+e.getStackTrace()+e.getMessage());
			
		}
		return list;
	}
}