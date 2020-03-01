<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${om.orderId}</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${om.orderMode}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${om.orderCode}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${om.orderType}</td>
		</tr>
		<tr>
			<th>ACCEPT</th>
			<td>${om.orderAccept}</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${om.orderDesc}</td>
		</tr>
	</table>
	<a href="excel?id=${om.orderId}"><img alt="Export-Excel"
		src="../resources/images/export-excel.png" width="60" height="60"></a>
	<a href="pdf?id=${om.orderId}"><img alt="Export-Pdf"
		src="../resources/images/pdf.png" width="60" height="60"></a>
</body>
</html>