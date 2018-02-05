package tw.com.phctw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;

/**
 * Servlet implementation class GetAllStudent
 */
@WebServlet("/GetAllStudent")
public class GetAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  
		StudentService service = new StudentService();
		List<Student> list = new ArrayList();
		list = service.selectAll();
		System.out.println(list);
		request.setAttribute("selectList", list);
		request.getRequestDispatcher("showStudent.jsp").forward(request, response);
		return;
//          request.getRequestDispatcher("insertStudent.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
