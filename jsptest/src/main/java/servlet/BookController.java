package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVo;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*insert
		 * request.setCharacterEncoding("utf-8"); int no =
		 * Integer.parseInt(request.getParameter("no")); String name =
		 * request.getParameter("name"); String publisher =
		 * request.getParameter("publisher"); String writer =
		 * request.getParameter("writer"); int price =
		 * Integer.parseInt(request.getParameter("price"));
		 */
		BookDao dao = BookDao.getIntance();
		ArrayList<BookVo> list = dao.getAllList();
		PrintWriter out = response.getWriter();
		out.print(list.toString());
		out.print("listy");
		System.out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void connect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
	}
}
