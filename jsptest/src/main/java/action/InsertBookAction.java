package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

public class InsertBookAction implements CRUDAction{

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BookDao dao = BookDao.getIntance();
		BookVo vo = new BookVo();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		
		dao.insertBookList(null);
		return null;
	}

}
