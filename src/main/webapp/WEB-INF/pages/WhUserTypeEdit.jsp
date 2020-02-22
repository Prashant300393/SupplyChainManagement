<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h2>---WELCOME TO WH USER TYPE EDIT PAGE</h2>
<form:form action="update" method="post" modelAttribute="whUserType">
<pre>
User ID: <form:input path="userId" readonly="true" /><br>
User Type:  <form:radiobutton path="userType" value="Vendor"/>Vendor
	    <form:radiobutton path="userType" value="Customer"/>Customer<br>
User Code: <form:input path="userCode"/><br>
User For : <form:input path="userFor"/><br>
User Email : <form:input path="userMail" required="true"/><br>
User Contact: <form:input path="userContact" required="true"/><br>
User ID Type: <form:select path="userIdType">
						<form:option 	value="" >--select--</form:option>
						<form:option value="PANCARD">PANCARD</form:option>
						<form:option value="AADHAR CARD">AADHAR CARD</form:option>
						<form:option value="VOTER ID">VOTER ID</form:option>
						<form:option value="OTHER">OTHER</form:option>
</form:select><br>
OTHER: <form:input path="other" /><br>
ID Number: <form:input path="idNumber" required="true"/><br>
		<input type="submit" value="Update">
</pre>
</form:form>
</body>
</html>