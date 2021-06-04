package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.BookDao;
import vo.BookVo;

public class readAction implements CRUDAction{

	@Override
	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		BookDao dao = BookDao.getIntance();
		
		ArrayList<BookVo> list = dao.getAllList();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		return jsonList;
	}
}
