package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	//상세목록 가져오기
	public BookVo getDetailList(int no) {
		BookVo vo = new BookVo();
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book2 where no = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.105:1521:xe";
			String user = "MIN";
			String pwd = "min";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPublisher(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setPrice(rs.getInt(5));
			}
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외 발생:"+e.getStackTrace()+e.getMessage());
			
		}
		return vo;
		
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

			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("예외 발생:"+e.getStackTrace()+e.getMessage());
			
		}
		return list;
	}
}