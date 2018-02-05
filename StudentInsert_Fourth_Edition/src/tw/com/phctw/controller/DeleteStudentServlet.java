package tw.com.phctw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;
    
@WebServlet("/updateDeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentService sService = new StudentService();
		
		///////update student info//////////////
		String slname = request.getParameter("slname");
		String sfname = request.getParameter("sfname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String ssex = request.getParameter("ssex");
		String sid = request.getParameter("sid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Student bean = new Student();
		bean.setSlname(slname);
		bean.setSfname(sfname);
		bean.setSage(sage);
		bean.setSsex(ssex);
		bean.setSid(sid);
		bean.setEmail(email);
		bean.setPassword(password);
		sService.updateStudent(bean);
		/////////////////delete student///////////////
		String sno = request.getParameter("sno");
		
		System.out.println("what "+sService.deleteStudent(sno));
		if(sService.deleteStudent(sno) == true) {
			request.setAttribute("deleteDone", "刪除成功");
			request.getRequestDispatcher("updateDeleteStudent.jsp").forward(request, response);
		}
		else{
			request.setAttribute("deleteFail", "刪除失敗");
			request.getRequestDispatcher("updateDeleteStudent.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

}
