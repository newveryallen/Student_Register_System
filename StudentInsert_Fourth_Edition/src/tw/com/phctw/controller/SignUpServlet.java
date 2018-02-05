package tw.com.phctw.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.service.StudentService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		StudentService sService = new StudentService();
		//step1 get datum 取值
		
		String sFname = request.getParameter("sfname");
		String sLname = request.getParameter("slname");
		String sAge = request.getParameter("sage");
		String sSex = request.getParameter("ssex");
		String sId = request.getParameter("sid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//step2  validation 驗証
		System.out.println(sId);
		System.out.println(sService.idValidator(sId));
		if(sService.emailValidator(email)==false || sService.idValidator(sId)==false || sAge == null || sAge == "") {
             
			if(sService.emailValidator(email)==false) {
				request.setAttribute("emailErromsg","請輸入正確的email格式");
			}
			if(sService.idValidator(sId)==false) {
				request.setAttribute("idErromsg","請輸入正確的身份證格式");
				System.out.println(123);
			}
			if(sAge.equals(null) || sAge == "") {
				request.setAttribute("sAgeErromsg","請輸入年齡");
			}
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		} else { //如果輸入都符合標準就把值送進db並導到studentinsert.jsp

			int studentAge = Integer.parseInt(sAge);
			//step3 send datum 傳值
			Student student = new Student();
			student.setSno(sService.selsno());//自動產生學號
			student.setSfname(sFname);
			student.setSlname(sLname);
			student.setSage(studentAge);
			student.setSsex(sSex);
			student.setSid(sId);
			student.setEmail(email);
			student.setPassword(sService.Md5Encrypt(password));//密碼加密
			
			StudentDao sd = new StudentDao();
			sd.insert(student);
			
			//step4 導頁
			response.sendRedirect("insertStudent.jsp");
		}
		
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
