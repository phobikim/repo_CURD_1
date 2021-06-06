package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CRUDAction;
import action.DeleteBookList;
import action.InsertBookActionOK;
import action.ListBookAction;
import action.UpdateBookAction;

/**
 * Servlet implementation class BookController
 */

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
		connect(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connect(request, response);
	}
	private void connect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		CRUDAction action;
		
		if(cmd.equals("listBook.min")) {
			action = new ListBookAction();
			String json = action.conn(request, response);
			PrintWriter out = response.getWriter();
			out.write(json);
		}
		else if(cmd.equals("insertBookOK.min")) {
			action = new InsertBookActionOK();
			action.conn(request, response);
		}
		else if(cmd.equals("updateBook.min")) {
			action = new UpdateBookAction();
			action.conn(request, response);
		}
		else if(cmd.equals("deleteBook.min")) {
			action = new DeleteBookList();
			action.conn(request, response);
		}

		
	}
}
