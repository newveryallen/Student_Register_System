package tw.com.phctw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;

/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		   
		
		   //step1 get value
		   String timesString = request.getParameter("times");
		   int timesNumber = Integer.parseInt(timesString);
		   StudentService studentService = new StudentService();
		   int successCount = 0;
		   int failCount = 0;
//		   List<Student> list;
		   		   
		   for(int i = 0; i < timesNumber; i++) {
			   try {
				   if(studentService.insertStudent() == true) {
					   successCount++;
				   } else {
					   failCount++;
				   }
			   } catch (Exception e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
			     }
		   }
		   
		   
		  
		   //step2 check the value
		   
		   //step3 send value
//		   request.setAttribute("times", timesNumber);
		   request.setAttribute("successCount", successCount);
		   request.setAttribute("failCount", failCount);
		   //step4 forward to the next page
           request.getRequestDispatcher("insertStudent.jsp").forward(request,response);
		   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
