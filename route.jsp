<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="myDs" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ola" user="root" password="java"/>
<sql:query dataSource="${myDs}" var="rt">
select * from route;
</sql:query>
<table border="1">
	<c:forEach var="row" items="${rt.rows }">
	<tr>
		<th>Id</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Duration</th>
	</tr>
		<tr>
			<td><c:out value="${row.routId }"></c:out></td>
			<td><c:out value="${row.source }"></c:out></td>
			<td><c:out value="${row.destination }"></c:out></td>
			<td><c:out value="${row.duration }"></c:out></td>
			<td><button type="submit" formaction="successful.java">Book</button>
</c:forEach>
</body>
</html>