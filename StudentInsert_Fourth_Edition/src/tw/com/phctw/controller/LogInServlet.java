package tw.com.phctw.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tw.com.phctw.bean.Photo;
import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.PhotoDao;
import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.service.StudentService;
import tw.com.phctw.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//step1 get datum
			String emailFromFront = request.getParameter("email");
			String passwordFromFront = request.getParameter("password");
			
			System.out.println("emailFromFront: "+emailFromFront);
			System.out.println("passwordFromFront: "+passwordFromFront);
			
			//for testing the whole process from jsp to servlet to db and go backward
			int count = adminlogin(emailFromFront, passwordFromFront);
	 	
			if(count > 0) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}			
			//for testing the whole process from jsp to servlet to db and go backward
			
			StudentService sService = new StudentService();
			String checkEmail = sService.getEmailCount(emailFromFront);
			String checkPassword = sService.getPasswordCount(passwordFromFront);
			
			System.out.println("checkEmail: "+checkEmail);
			System.out.println("checkPassword: "+checkPassword);
			if(emailFromFront.equals("")|| passwordFromFront.equals("")) 
			{
				//if (!"success".equals(statusCheck))
				if(emailFromFront.equals("")&&!passwordFromFront.equals("")) 
				{
					request.setAttribute("mailEmptyError","請輸入信箱");
//					request.getRequestDispatcher("/StudentInsert_Fourth_Edition/WebContent/jsp/login.jsp").include(request, response);
					System.out.println("up getRequestDispatcher");
					RequestDispatcher rd=request.getRequestDispatcher("personal.jsp");  
			        rd.include(request,response); 
			    	System.out.println("up getRequestDispatcher");
				} 
				if(passwordFromFront.equals("")) 
				{
					request.setAttribute("passwordEmptyError","請輸入密碼");
				}
//				request.getRequestDispatcher("login.jsp").forward(request,response);
			} else { //確定登入
				if(checkEmail.equals("1") && checkPassword.equals("1")) {
					PhotoDao pDao = new PhotoDao();
					request.getSession().setAttribute("headshot",pDao.getPhotoPath("2"));
					/////get photo as head shot
					System.out.println(pDao.getPhotoPath("2"));
					
					//////get email as account
					StudentDao sDao = new StudentDao();
					System.out.println(sDao.getEmail(emailFromFront));
					request.getSession().setAttribute("email", sDao.getEmail(emailFromFront));
//					response.sendRedirect("personal.jsp");
					 return;
				} else {//
//					 response.sendRedirect("index.jsp");
					 return;
				}
			}
			
			
			
			
			
			
//			System.out.println(emailFromDb);111
//			
//			request.setAttribute("selectList", list);
//			request.getRequestDispatcher("showStudent.jsp").forward(request, response);
//			return;
			
		//step2 verify datum
			 //varify email
//			 String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//		     Pattern pattern = Pattern.compile(regex);
//		     Matcher matcher = pattern.matcher((CharSequence) email);
//		     ---------------------------------------
			
//				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//				Boolean emailVaildator = email.matches(EMAIL_REGEX);
//				System.out.println("is e-mail: "+email+" :Valid = " + emailVaildator);
		     
		     
		     //varify password
			
			
			
			
		//step3 send datum
			
		//redirect and forward 
//			if(emailVaildator==true){
//				request.getRequestDispatcher("insertStudent.jsp").forward(request,response);
//			}
				
	}
	
	//for testing the whole process from jsp to servlet to db and go backward
	private int adminlogin(String email, String password) {
		
		String sqlSyntax = "select count(*) emailCount from student where email = ? and password = ? ";
		Connection conn = null;
		PreparedStatement stm = null;
		int num = 0;
		try {
			conn = JDBCUtil.getDb();
			stm = conn.prepareStatement(sqlSyntax);
			stm.setString(1, email);
			stm.setString(2, password);
			num = stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally //一定要做這件事
		{
			if(conn!=null)//如果連線不等於null就關閉連線
			{	
				try {
					stm.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return num;
	}
	//for testing the whole process from jsp to servlet to db and go backward
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
