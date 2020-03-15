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
			<td>${ob.saleId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.saleCode}</td>
		</tr>
		<tr>
			<th>SHIPMENT CODE</th>
			<td>${ob.shipOb.shipCode}</td>
		</tr>
		<tr>
			<th>CUSTOMER</th>
			<td>${ob.whCust.userCode}</td>
		</tr>
		<tr>
			<th>REF NO</th>
			<td>${ob.saleRefNo}</td>
		</tr>
		<tr>
			<th>STOCK MODE</th>
			<td>${ob.stockMode}</td>
		</tr>
		<tr>
			<th>STOCK SOURCE</th>
			<td>${ob.stockSource}</td>
		</tr>
		<tr>
			<th>STATUS</th>
			<td>${ob.status}</td>
		</tr>
				<tr>
			<th>NOTE</th>
			<td>${ob.saleDesc}</td>
		</tr>
	</table>
	<a href="excel?id=${ob.saleId }"><img alt="Export-Excel"
		src="../resources/images/export-excel.png" width="60" height="60"></a>
	<a href="pdf?id=${ob.saleId}"><img alt="Export-Pdf"
		src="../resources/images/pdf.png" width="60" height="60"></a>
</body>
</html>