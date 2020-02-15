<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>---WELCOME TO UOM REGISTER PAGE---</h2>
<form action="save" method="post">
<pre>
Uom Type:  <select name="uomType" required="required" >
		<option>--select--</option>
		<option>PACKING</option>
		<option>NO PACKING</option>
		<option>--NA--</option>
</select><br>
Uom Model: <input type="text" name="uomModel" size="12" required="required"><br>
Description: 
<textarea name="uomDesc"></textarea><br>
		<input type="submit" value="Create Uom">
</pre>
</form>
${msg }
</body>
</html>