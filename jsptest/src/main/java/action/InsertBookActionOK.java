package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

public class InsertBookActionOK implements CRUDAction{

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json");
		
		String name = request.getParameter("name");
		String publisher = request.getParameter("publisher");
		String writer = request.getParameter("writer");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVo vo = new BookVo(name,publisher,writer,price);
		BookDao dao = BookDao.getIntance();
		int re = dao.insertBookList(vo);
		
		return "msg:"+re;
	}


}
