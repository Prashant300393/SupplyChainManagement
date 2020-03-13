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
			<h3>WELCOME TO PURCHASE ORDER DATA PAGE</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>SHIPMENT CODE</th>
					<th>VENDOR</th>
					<th>REF NO</th>
					<th>QUALTY CHECK</th>
					<th>STATUS</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<!-- for(PurchaseOrder ob : list) { ...  } -->
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.id}</td>
						<td>${ob.poOrderCode}</td>
						<td>${ob.shipOb.shipCode}</td>
						<td>${ob.whVendor.userCode}</td>
						<td>${ob.poRefNum}</td>
						<td>${ob.poQltyCheck}</td>
						<td>${ob.poStatus}</td>
						<td>${ob.poDesc}</td>
						<td><a href="delete?id=${ob.id}"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?id=${ob.id}"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?id=${ob.id}"><img alt="VIEW"
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