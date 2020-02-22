<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h2>WELCOME TO UOM EDIT PAGE</h2><br>
<form:form action="update" method="post" modelAttribute="uom">
<pre>
Uom ID: <form:input path="uomId" readonly="true"/>
Uom Type: <form:select path="uomType">
					<form:option value="">--select--</form:option>
					<form:option value="PACKING">PACKING</form:option>
					<form:option value="NO PACKING">NO PACKING</form:option>
					<form:option value="-NA-">-NA-</form:option>
</form:select><br>
Uom Model: <form:input path="uomModel"/><br>
Descripiton: <form:textarea path="uomDesc"/><br>
	<input type="submit" value="Update">
</pre>
</form:form>
</body>
</html>