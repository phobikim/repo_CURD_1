package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

public class DeleteBookList implements CRUDAction{

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = BookDao.getIntance();
		int no = Integer.parseInt(request.getParameter("no"));
		int re = dao.deleteBookList(no);
		return "msg" + re;
	}

}
