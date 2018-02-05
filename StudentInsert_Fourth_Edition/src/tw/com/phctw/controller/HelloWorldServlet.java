package tw.com.phctw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接前端送來的值
		// getParameter 是取 <input>的值
		String yName = request.getParameter("yourName");
		
	
		yName =  "Hello World !"  + yName ;
		
		//把加工後的值傳到前端
		//pack up processed data 
		request.setAttribute("showMegssage", yName);
		
		//導頁
		request.getRequestDispatcher("insertStudent.jsp").forward(request, response);
		
		return;	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
