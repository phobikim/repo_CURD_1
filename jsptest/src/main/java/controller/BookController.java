package controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CRUDAction;
import action.DetailBookAction;
import action.InsertBookAction;
import action.InsertBookActionOK;
import action.ListBookAction;
import dao.BookDao;
import vo.BookVo;

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
		System.out.println("Get 으로 호출");
		connect(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 으로 호출");
		connect(request, response);
	}
	private void connect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		CRUDAction action;
		String viewPage="";
		
		if(cmd.equals("listBook.min")) {
			action = new ListBookAction();
			viewPage = action.conn(request, response);
		}
		else if(cmd.equals("detailBook.min")) {
			action = new DetailBookAction();
			viewPage = action.conn(request, response);
		}
		else if(cmd.equals("insertBook.min")) {
			action = new InsertBookAction();
			viewPage = action.conn(request, response);
		}
		else if(cmd.equals("insertBookOK.min")) {
			action = new InsertBookActionOK();
			viewPage = action.conn(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
