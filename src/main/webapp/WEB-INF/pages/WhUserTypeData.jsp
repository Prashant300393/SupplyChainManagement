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
			<table border="1">
				<tr>
					<th>User id</th>
					<th>USER_TYPE</th>
					<th>CODE</th>
					<th>USER_FOR</th>
					<th>MAIL</th>
					<th>CONTACT</th>
					<th>ID_TYPE</th>
					<th>OTHER</th>
					<th>ID_NUMBER</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.userId}</td>
						<td>${ob.userType }</td>
						<td>${ob.userCode }</td>
						<td>${ob.userFor }</td>
						<td>${ob.userMail }</td>
						<td>${ob.userContact }</td>
						<td>${ob.userIdType }</td>
						<c:choose>
							<c:when test="${ob.other==null }">
								<td>---NONE---</td>
							</c:when>
							<c:otherwise>
								<td>${ob.other}</td>
							</c:otherwise>
						</c:choose>
						<td>${ob.idNumber}</td>
						<td><a href="delete?wid=${ob.userId }"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?wid=${ob.userId }"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?wid=${ob.userId }"><img alt="VIEW"
								src="../resources/images/view.png" width="25" height="23"></a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="excel"><img alt="Export-Excel"
				src="../resources/images/export-excel.png" width="60" height="60"></a>
			<a href="pdf"><img alt="Export-Pdf"
				src="../resources/images/pdf.png" width="60" height="60"></a>

		</c:when>
		<c:otherwise>
			<h2>NO DATA FOUND</h2>
		</c:otherwise>
	</c:choose>
	${msg }
</body>
</html>