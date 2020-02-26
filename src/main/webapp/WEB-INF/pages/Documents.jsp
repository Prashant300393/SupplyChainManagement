<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Uploading Form</title>
</head>
<body>
<h2>WELCOME TO DOCUMENTS UPLOAD PAGE</h2>
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
ID: <input type="text" name="fileId" required="required"><br>
DOC: <input type="file" name="fileOb" ><br>
       <input type="submit" value="Upload File">
</pre>
<br><br>
<h3>BELOW ARE UPLOADED FILES</h3>
<c:choose>
<c:when test="${! empty list }">
<table border="1">
<tr>
	<th>FILE ID</th>
	<th>FILE NAME</th>
	<th>DOWNLOAD LINK</th>
</tr>
<c:forEach items="${list }" var="ob">
<tr>
	<td>${ob[0] }</td>
	<td>${ob[1] }</td>
	<td><a href="download?id=${ob[0] }">DOWNLOAD</a></td>
</tr>
</c:forEach>

</table>
</c:when>
<c:otherwise>
<h3>NO FILES FOUND</h3>
</c:otherwise>
</c:choose>
</form>
</body>
</html>