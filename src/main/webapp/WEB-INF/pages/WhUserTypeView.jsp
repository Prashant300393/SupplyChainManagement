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
			<td>${ob.userId}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.userType}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.userCode}</td>
		</tr>
		<tr>
			<th>FOR</th>
			<td>${ob.userFor}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${ob.userMail}</td>
		</tr>
		<tr>
			<th>CONTACT</th>
			<td>${ob.userContact}</td>
		</tr>
		<tr>
			<th>IDTYPE</th>
			<td>${ob.userIdType}</td>
		</tr>
		<tr>
			<th>OTHER</th>
			<td>${ob.other}</td>
		</tr>
		<tr>
			<th>IDNUMBER</th>
			<td>${ob.idNumber}</td>
		</tr>
	</table>
	<a href="excel?id=${ob.userId}"><img alt="Export-Excel"
		src="../resources/images/export-excel.png" width="60" height="60"></a>
	<a href="pdf?id=${ob.userId }"><img alt="Export-Pdf"
		src="../resources/images/pdf.png" width="60" height="60"></a>
</body>
</html>