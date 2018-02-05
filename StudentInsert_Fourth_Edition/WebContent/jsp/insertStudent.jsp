<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
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
<title>產生學生資料頁面</title>
</head>
<body>
		<h1>產生學生資料</h1>
		
		<form action="InsertStudent"  method="get">
			請輸入筆數: <input type="text" name="times" /> 
			  <button name="insert" type="submit" >Insert!!</button>
		</form>
		<!-- 顯示:成功筆數與失敗筆數 -->
		<h1>成功或失敗筆數</h1>
		成功: <c:out  value="${successCount}" /><br>
		失敗: <c:out  value="${failCount}" />
		
		
		<div align="left">
        <table border="1" cellpadding="5">
            <caption><h2>學生資料</h2></caption>
            <tr>
                <th>產生之前筆數</th>
                <th>產生之後筆數</th>
                <th>插入筆數</th>
            </tr>
            <c:forEach var="sno_count" items="${sno_counts.rows}">
                <tr>
                     <td><c:out  value="${request.BeforeInsertNumber}" /></td> 
<!--                     var="Before_insert" -->
                     <td><c:out  value="${sno_count.count}" /></td>
<!--                     var="After_insert"  -->
                     <td><c:out   value="${param.times}" /></td>
<!--                     var="insert_count" -->
                </tr>
            </c:forEach>
        </table>
    </div>
		
		<br><br>
		<!-- 最後下方有一個按鈕可以點查詢學生資料。 -->
		<!-- 點下去會導頁到showStudent.jsp -->
		<form action="showStudent.jsp"  method="get">
		    <button name="student" type="submit" >查看所有學生</button>
		</form>
		<br>
		<form action="index.jsp"  method="get">
		    <button name="backtoindex" type="submit" >回首頁</button>
		</form>
		<br>
	    <form action="personal.jsp"  method="get">
		    <button name="backtoindex" type="submit" >回個人空間</button>
		</form>
</body>
</html>