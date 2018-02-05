<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="SignUpServlet"  method="get">
	
		信箱   :  <input type="text" name="email" value="${param.email}"/><font color="red">${emailErromsg}</font><br><br> 
		密碼:    <input type="text" name="password" value="${param.password}"/><br><br>
		姓:      <input type="text" name="slname" value="${param.slname}"/><br><br>
		名:      <input type="text" name="sfname" value="${param.sfname}"/><br><br>
		年紀:    <input type="text" name="sage" value="${param.sage}"/><font color="red">${sAgeErromsg}</font><br><br>
		性別:    <input type="text" name="ssex" value="${param.ssex}"/><br><br>
		身份証:  <input type="text" name="sid" value="${param.sid}" /><font color="red">${idErromsg}</font><br><br>
		
		<button name="insert" type="submit" >確認送出</button>
	</form>
		<a href="index.jsp">回首頁</a>
</body>
</html>