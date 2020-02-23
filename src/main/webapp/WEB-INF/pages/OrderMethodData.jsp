<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<c:choose>
		<c:when test="${! empty list }">
			<table border="1">
				<tr>
					<th>MODE</th>
					<th>CODE</th>
					<th>TYPE</th>
					<th>ACCEPT</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.orderMode }</td>
						<td>${ob.orderCode }</td>
						<td>${ob.orderType }</td>
						<td>${ob.orderAccept }</td>
						<td>${ob.orderDesc }</td>
						<td><a href="delete?oid=${ob.orderId}">DELETE</a></td>
						<td><a href="edit?oid=${ob.orderId }">EDIT</a></td>
						<td><a href="view?oid=${ob.orderId }">VIEW</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="excel">EXPORT EXCEL</a>
		</c:when>
		<c:otherwise>
			<h3>NO DATA FOUND</h3>
		</c:otherwise>
	</c:choose>
	${msg}
</body>
</html>