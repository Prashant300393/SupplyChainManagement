<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h3>---WELCOME TO ORDER METHOD EDIT PAGE</h3>
<form:form action="update" method="post" modelAttribute="orderMethod">
<pre>
Order ID: <form:input path="orderId" readonly="true"/>
Order Mode : <form:radiobutton path="orderMode" value="Sale"/>Sale
	     <form:radiobutton path="orderMode" value="Purchase"/>Purchase<br>
Order Code: <form:input path="orderCode"/><br>
Order Type: <form:select path="orderType">
					<form:option value="">---select---</form:option>
					<form:option value="FIFO">FIFO</form:option>
					<form:option value="LIFO">LIFO</form:option>
					<form:option value="FCFO">FCFO</form:option>
					<form:option value="FEFO">FEFO</form:option>
</form:select><br>
Order Accept: <form:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model
	      <form:checkbox path="orderAccept" value="Accept Return"/>Accept Return<br>
Description: 
	<form:textarea path="orderDesc"/><br>
		<input type="submit" value="Update Order Method">
	
</pre>
</form:form>
${msg}
</body>
</html>