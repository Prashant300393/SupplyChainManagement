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
	<td>${uom.uomId}</td>
</tr>
<tr>
	<th>TYPE</th>
	<td>${uom.uomType}</td>
</tr>
<tr>
	<th>MODEL</th>
	<td>${uom.uomModel }</td>
</tr>
<tr>
	<th>NOTE</th>
	<td>${uom.uomDesc }</td>
</tr>
</table>
<a href="excel?id=${uom.uomId }">EXCEL Export</a> | <a href="pdf?id=${uom.uomId }">PDF Export</a>
</body>
</html>