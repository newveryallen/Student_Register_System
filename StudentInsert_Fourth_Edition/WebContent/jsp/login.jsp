<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登入頁面</h1>
	
	 <form action="${pageContext.request.contextPath}/LogInServlet"  method="get">
		信箱   :  <input type="text" name="email" value="${param.email}" /><font color="red">${mailEmptyError}</font><br><br> 
		密碼   :  <input type="text" name="password" value="${param.password}" /><font color="red">${passwordEmptyError}</font><br><br>	 
		<button name="login" type="submit" >登入</button>
	 </form>
	 <br><br>
	<a href="forgetPassowrd.jsp">忘記密碼</a><br><br>
	<a href="index.jsp">回首頁</a>
</body>
</html>