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
<title>���;ǥ͸�ƭ���</title>
</head>
<body>
		<h1>���;ǥ͸��</h1>
		
		<form action="InsertStudent"  method="get">
			�п�J����: <input type="text" name="times" /> 
			  <button name="insert" type="submit" >Insert!!</button>
		</form>
		<!-- ���:���\���ƻP���ѵ��� -->
		<h1>���\�Υ��ѵ���</h1>
		���\: <c:out  value="${successCount}" /><br>
		����: <c:out  value="${failCount}" />
		
		
		<div align="left">
        <table border="1" cellpadding="5">
            <caption><h2>�ǥ͸��</h2></caption>
            <tr>
                <th>���ͤ��e����</th>
                <th>���ͤ��ᵧ��</th>
                <th>���J����</th>
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
		<!-- �̫�U�観�@�ӫ��s�i�H�I�d�߾ǥ͸�ơC -->
		<!-- �I�U�h�|�ɭ���showStudent.jsp -->
		<form action="showStudent.jsp"  method="get">
		    <button name="student" type="submit" >�d�ݩҦ��ǥ�</button>
		</form>
		<br>
		<form action="index.jsp"  method="get">
		    <button name="backtoindex" type="submit" >�^����</button>
		</form>
		<br>
	    <form action="personal.jsp"  method="get">
		    <button name="backtoindex" type="submit" >�^�ӤH�Ŷ�</button>
		</form>
</body>
</html>