<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改和刪除學生</title>
</head>
<body>
	<h1>修改學生資料</h1>
	<form action="StudentUpdateServlet" method="get">
修改姓:		<input type="text" name="slname"/>
修改名子:	<input type="text" name="sfname"/><br><br>
修改年紀		<input type="text" name="sage"/><br><br>
修改姓別:	<input type="text" name="ssex"/><br><br>
修改身份證:	<input type="text" name="sid"/><br><br>
修改信箱:	<input type="text" name="email"/>
修改密碼:	<input type="text" name="password"/><br><br>
			<input type="submit" value="1"/>
	</form>
	
	
	<h1>刪除學生資料</h1>
	<form action="updateDeleteStudentServlet" method="get">
刪除學生:	<input type="text" name="sno"/>
			<input type="submit" value="2"/>
	</form>
	<font color="green">${deleteDone} </font>
	<font color="red">${deleteFail} </font>

    	
	
	
</body>
</html>