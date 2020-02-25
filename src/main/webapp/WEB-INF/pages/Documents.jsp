<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
ID: <input type="text" name="fileId"><br>
DOC: <input type="file" name="fileOb" ><br>
       <input type="submit" value="Upload File">
</pre>
</form>
${msg}
</body>
</html>