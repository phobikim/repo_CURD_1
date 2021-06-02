package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

public class DetailBookAction implements CRUDAction {

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BookDao dao = BookDao.getIntance();
		BookVo vo  = dao.getDetailList(no);
		request.setAttribute("vo", vo);
		
		return "detailBook.jsp";
	}

}
