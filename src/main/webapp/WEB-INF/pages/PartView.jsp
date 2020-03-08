<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Part Data Page</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.partId}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.partCode}</td>
		</tr>
		<tr>
			<th>LENGTH</th>
			<td>${ob.partLen}</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.partWid}</td>
		</tr>
		<tr>
			<th>HEIGHT</th>
			<td>${ob.partHgt}</td>
		</tr>
		<tr>
			<th>BASECOST</th>
			<td>${ob.baseCost}</td>
		</tr>
		<tr>
			<th>BASECURRENCY</th>
			<td>${ob.baseCurrency}</td>
		</tr>
		<tr>
			<th>UOM</th>
			<td>${ob.uomOb.uomModel}</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.pdesc}</td>
		</tr>
	</table>
	<a href="excel?id=${ob.partId}"><img alt="Export-Excel"
		src="../resources/images/export-excel.png" width="60" height="60"></a>
	<a href="pdf?id=${ob.partId}"><img alt="Export-Pdf"
		src="../resources/images/pdf.png" width="60" height="60"></a>
</body>

</html>