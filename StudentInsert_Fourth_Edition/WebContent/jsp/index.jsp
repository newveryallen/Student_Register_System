<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	  <!--內容:首頁點進去後，會導頁到inserStudent.jsp -->
<%--       <jsp:forward page="insertStudent.jsp"/> --%>
      <h1>學生登入首頁</h1>
      
       <form action="signUp.jsp"  method="get">
			<button name="signUp" type="submit">註冊</button>
<!-- 		<a href="MyServlet_001.do">MyServlet_001</a>	   -->
	   </form>
      <script type="text/javascript">
      
      
      
      </script>
      <br><br>
      
      <form action="login.jsp"  method="get">
			<button name="login" type="submit" >登入</button>
<!-- 		<a href="MyServlet_001.do">MyServlet_001</a>	   -->
	  </form>
      
      <br><br>
      
      
     
</body>
</html>