package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

public class ListBookAction implements CRUDAction{

	@Override
	public String whichJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = BookDao.getIntance();
		ArrayList<BookVo> list = dao.getAllList();
		
		request.setAttribute("list", list);
		return "listBook.jsp";
	}

}
