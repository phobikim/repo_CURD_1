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
		
		return "insertBook.jsp";
	}

}
