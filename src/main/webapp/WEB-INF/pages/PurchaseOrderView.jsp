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
			<td>${ob.id }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.poOrderCode}</td>
		</tr>
		<tr>
			<th>SHIPMENT CODE</th>
			<td>${ob.shipOb.shipCode}</td>
		</tr>
		<tr>
			<th>VENDOR</th>
			<td>${ob.whVendor.userCode}</td>
		</tr>
		<tr>
			<th>REF NO</th>
			<td>${ob.poRefNum}</td>
		</tr>
		<tr>
			<th>QUALITY CHECK</th>
			<td>${ob.poQltyCheck}</td>
		</tr>
		<tr>
			<th>STATUS</th>
			<td>${ob.poStatus}</td>
		</tr>
				<tr>
			<th>NOTE</th>
			<td>${ob.poDesc}</td>
		</tr>
	</table>
	<a href="excel?id=${ob.id }"><img alt="Export-Excel"
		src="../resources/images/export-excel.png" width="60" height="60"></a>
	<a href="pdf?id=${ob.id }"><img alt="Export-Pdf"
		src="../resources/images/pdf.png" width="60" height="60"></a>
</body>
</html>