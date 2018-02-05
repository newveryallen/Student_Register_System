package tw.com.phctw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Photo;
import tw.com.phctw.dao.PhotoDao;
import tw.com.phctw.dao.StudentDao;

@WebServlet("/PersonalServlet")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PhotoDao pDao = new PhotoDao();
//		System.out.println(pDao.getPhotoPath("2"));
//		request.setAttribute("headshot",pDao.getPhotoPath("2"));
//		response.sendRedirect("personal.jsp");
		Photo photo = new Photo();
		photo.setPhotoid("3");
		photo.setPhotopath("1234");
		pDao.insertPhotoPathAndId(photo);
	   
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
