package tw.com.phctw.controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Email
 */
@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
                 sendMail("marshuang0817@gmail.com");
	}

	
	public boolean sendMail(String str_email)  //email 為收件者, password 為密碼
	 {
		     java.util.Properties property = new java.util.Properties();
		     property.put("mail.host", "smtp.tstartel.com");  //設定郵件伺服器
		     property.put("mail.transport.protocol", "smtp");     //設定通訊協定
		     Session sess = Session.getInstance(property, null);    //取得 Session
		     MimeMessage msg = new MimeMessage(sess);   //以Session 為參數 建立一封電子郵件  
		     try{
		         msg.setFrom(new InternetAddress("newveryallen@gmail.com"));  //寄件者
		         //將收件者的 InetAddress 物件新增給使用者
		  msg.addRecipient(Message.RecipientType.TO, new InternetAddress(str_email));  
		         msg.setSubject("找回密碼");   //郵件的主旨
		         msg.setText("http://localhost:9090/JSP_Test2/forgotToModify.jsp");
//		         msg.setText("密碼: "+ password);    //郵件的內容...使用者的密碼
		         msg.setSentDate(new java.util.Date());   //設定寄送日期  為現在
		         Transport.send(msg);   //寄送郵件
		         return true;
		     }catch(AddressException ae){
		         System.out.println(ae);
		         return false;   //記得要 return false
		     }catch(MessagingException me){
		         System.out.println(me);
		         return false;   //記得要 return false
		     }
	 }///////////////////////////////// 
	
}
