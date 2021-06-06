package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

public class UpdateBookAction implements CRUDAction{

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = BookDao.getIntance();
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String publisher = request.getParameter("publisher");
		String writer = request.getParameter("writer");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookVo vo = new BookVo(no, name, publisher, writer, price);
		int re = dao.updateBookList(vo);

		return "msg:"+re;
	}


}
