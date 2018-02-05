<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<sql:setDataSource var="datasource"
                  driver="oracle.jdbc.driver.OracleDriver"
                  url="jdbc:oracle:thin:@localhost:1521/xe"
                  user="test" password="123"/>
<sql:query var="sno_counts" dataSource="${datasource}">
  	select count(sno) as count from student 
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>個人空間</title>
</head>
<body>
	
	<h1>個人空間</h1>
	
     <b>你好: </b><font color="greed">${email}</font>已登入
	<form action="PersonalServlet" method="get">
		<img src="${headshot}" alt="Head Shot" style="width:100px;height:150;">
	<input type="submit" value="上傳" name ="upload"/>
	</form><br>
	
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		請選照片<input type="file" name="photo" value=""/><br><br>
		<input type="submit" value="上傳photo到folder" name ="upload"/>
	</form>
	<br><br>
	
	<a href="insertStudent.jsp">新增學生功能</a><br><br>
	<a href="updateDeleteStudent.jsp">修改學生功能</a><br><br>
	
	
	
	
	
		
		<!-- 最後下方有一個按鈕可以點查詢學生資料。 -->
		<!-- 點下去會導頁到showStudent.jsp -->
		<form action="showStudent.jsp"  method="get">
		    <button name="student" type="submit" >查看所有學生</button>
		</form>
		<br>
		<form action="index.jsp"  method="get">
		    <button name="backtoindex" type="submit" >回首頁</button>
		</form>
	
</body>
</html>