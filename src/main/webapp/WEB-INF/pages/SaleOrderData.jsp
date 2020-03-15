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
			<h3>WELCOME TO SALE ORDER DATA PAGE</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>SHIPMENT CODE</th>
					<th>CUSTOMER</th>
					<th>REF NO</th>
					<th>STOCK MODE</th>
					<th>STOCK SOURCE</th>
					<th>STATUS</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<!-- for(SaleOrder ob : list) { ...  } -->
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.saleId}</td>
						<td>${ob.saleCode}</td>
						<td>${ob.shipOb.shipCode}</td>
						<td>${ob.whCust.userCode}</td>
						<td>${ob.saleRefNo}</td>
						<td>${ob.stockMode}</td>
						<td>${ob.stockSource}</td>
						<td>${ob.status}</td>
						<td>${ob.saleDesc}</td>
						<td><a href="delete?id=${ob.saleId}"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?id=${ob.saleId}"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?id=${ob.saleId}"><img alt="VIEW"
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