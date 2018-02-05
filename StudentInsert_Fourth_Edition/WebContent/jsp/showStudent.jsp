<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %> 
<sql:setDataSource var="datasource"
                  driver="oracle.jdbc.driver.OracleDriver"
                  url="jdbc:oracle:thin:@localhost:1521/xe"
                  user="test" password="123"/>
<sql:query var="list_students" dataSource="${datasource}">
  	select * from student order by sno
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!--內容:查詢出所有的student的資料 -->
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>所有學生名單</h2></caption>
            <tr>
                <th>SNO</th>
                <th>SFNAME</th>
                <th>SLNAME</th>
                <th>SAGE</th>
                <th>SSEX</th>
                <th>SID</th>
            </tr>
	            <c:forEach var="student" items="${list_students.rows}">
	                <tr>
	                    <td><c:out value="${student.sno}" /></td>
	                    <td><c:out value="${student.sfname}" /></td>
	                    <td><c:out value="${student.slname}" /></td>
	                    <td><c:out value="${student.sage}" /></td>
	                    <td><c:out value="${student.ssex}" /></td>
	                    <td><c:out value="${student.sid}" /></td>
	                </tr>
	            </c:forEach>
                
<%--             <c:forEach var="student" items="${selectList}"> --%>
<!--                 <tr> -->
<%-- 					<td>${student.sno}</td> --%>
<%-- 				 	<td>${student.sfname}</td> --%>
<%-- 					<td>${student.slname}</td> --%>
<%-- 					<td>${student.sage}</td> --%>
<%-- 					<td>${student.ssex}</td> --%>
<%-- 					<td>${student.sid}</td> --%>
<!--                 </tr> -->
<%--             </c:forEach> --%>
        </table>
    </div>
      
</body>
</html>