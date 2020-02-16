<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<c:choose>
<c:when test="${!empty list }">
<table border="1" align="center">
<tr>
	<th>USER_ID</th>
	<th>USER_TYPE</th>
	<th>CODE</th>
	<th>USER_FOR</th>
	<th>MAIL</th>
	<th>CONTACT</th>
	<th>ID_TYPE</th>
	<th>OTHER</th>
	<th>ID_NUMBER</th>
	<th>DELETE</th>
</tr>
<c:forEach items="${list }" var="ob">
<tr>
	<td>${ob.userId }</td>
	<td>${ob.userType }</td>
	<td>${ob.userCode }</td>
	<td>${ob.userFor }</td>
	<td>${ob.userMail }</td>
	<td>${ob.userContact }</td>
	<td>${ob.userIdType }</td>
	<td>${ob.other}</td>
	<td>${ob.idNumber}</td>
	<td><a href="delete?wid=${ob.userId }">DELETE</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h2>NO DATA FOUND</h2>
</c:otherwise>
</c:choose>
${msg }	
</body>
</html>