<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<th>ID</th>
	<th>TYPE</th>
	<th>MODEL</th>
	<th>NOTE</th>
	<th>DELETE</th>
</tr>
<c:forEach items="${list }" var="ob">
<tr>
	<td>${ob.uomId }</td>
	<td>${ob.uomType }</td>
	<td>${ob.uomModel }</td>
	<td>${ob.uomDesc }</td>
	<td><a href="delete?uid=${ob.uomId }">DELETE</a></td>
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