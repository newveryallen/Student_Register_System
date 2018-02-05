package tw.com.phctw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tw.com.phctw.service.PhotoService;


@MultipartConfig(location = "D:/workspaces/forjobuse/StudentInsert_Third_Edition/WebContent/images")
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PhotoService photoService = new PhotoService();
		
		try {
			request.setCharacterEncoding("UTF-8");
			Part part = request.getPart("photo");
			String filename = photoService.getFilename(part);
			part.write(filename);
			 response.sendRedirect("personal.jsp");
		}
		catch(Exception e) { //
			 response.sendRedirect("personal.jsp");
		}
		
	}

//	private String getFilename(Part part) { //取得上傳檔名
//		String header = part.getHeader("Content-Disposition");
//		String filename = 
//				header.substring(header.indexOf("filename=\"") + 10,
//				header.lastIndexOf("\""));
//		return filename;
//	}

//	private void writeTo(String filename, Part part) throws IOException, FileNotFoundException{
//		InputStream in = part.getInputStream();
//		OutputStream out = 
//				new FileOutputStream("D:/workspaces/forjobuse/StudentInsert_Third_Edition/WebContent/images" + filename);
//		byte[] buffer = new byte[1024];
//		int length= -1;//大概是跟指標有關
//		while ((length = in.read(buffer)) != -1) {
//			out.write(buffer, 0, length);
//		}
//		in.close();
//		out.close();
//	}
	
}
