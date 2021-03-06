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
		<c:when test="${! empty list }">
			<h3>WELCOME TO SHIPMENT TYPE DATA PAGE</h3>
			<table border="1">
				<tr>
					<th>MODE</th>
					<th>CODE</th>
					<th>ENABLE</th>
					<th>GRADE</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<!-- for(ShipmentType ob : list) { ...  } -->
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.shipMode }</td>
						<td>${ob.shipCode }</td>
						<td>${ob.enbShip }</td>
						<td>${ob.shipGrade }</td>
						<td>${ob.shipDesc }</td>
						<td><a href="delete?sid=${ob.shipId }"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?sid=${ob.shipId}"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?sid=${ob.shipId}"><img alt="VIEW"
								src="../resources/images/view.png" width="25" height="23"></a></td>
					</tr>
				</c:forEach>
			</table>
			<h3>
				<a href="excel"><img alt="Export-Excel"
					src="../resources/images/export-excel.png" width="60" height="60"></a>
				<a href="pdf"><img alt="Export-Pdf"
					src="../resources/images/pdf.png" width="60" height="60"></a>
			</h3>
		</c:when>
		<c:otherwise>
			<h3>No DATA Found</h3>
		</c:otherwise>
	</c:choose>
	${msg}
</body>
</html>