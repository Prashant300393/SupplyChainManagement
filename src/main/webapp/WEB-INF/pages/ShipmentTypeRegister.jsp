<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 9px;
  border: 1px solid #ccc;
  border-radius: 2px;
  box-sizing: border-box;
  margin-top: 3px;
  margin-bottom: 10px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  width : 30%;
  border-radius: 5px;
  background-color: #d5f4e6;
  padding: 10px;
  margin: 30px;
}

.blinking{
    animation:blinkingText 1.5s infinite;
   }
@keyframes blinkingText{
	0%{     color: red;    }
    49%{    color: red; }
    60%{    color: transparent; }
    99%{    color:transparent;  }
    100%{   color: red;    }
}
</style>
</head>

<body> 
<form:form action="save" method="post" modelAttribute="shipmentType">
<span class="blinking"; style="font-weight: bold; text-align:center;  font-size: 25px; padding: 20%; margin: 7%">
---WELCOME TO SHIPMENT TYPE REGISTER PAGE---
</span><br><br>
<div class="container">
<form:label path="shipMode">Shipment Mode</form:label>
<form:select path="shipMode">
	<form:option value="">--SELECT--</form:option>
	<form:option value="Air">Air</form:option>
	<form:option value="Truck">Truck</form:option>
	<form:option value="Ship">Ship</form:option>
	<form:option value="Train">Train</form:option>
</form:select><br>

<form:label path="shipCode">Shipment Code</form:label>
<form:input path="shipCode"/><br>
<form:label path="enbShip">Enable Shipment</form:label>
	<form:select path="enbShip">
		<form:option value="">--SELECT--</form:option>
		<form:option value="YES" >YES</form:option>
		<form:option value="NO" >NO</form:option>
	</form:select><br>

<form:label path="shipGrade">Shipment Grade</form:label><br>
	<form:radiobutton path="shipGrade" value="A"/>A<br>
	<form:radiobutton path="shipGrade" value="B"/>B<br>
	<form:radiobutton path="shipGrade" value="C"/>C<br>
	<br>	
<form:label path="shipDesc">Description</form:label>
<form:textarea path="shipDesc"/>
      <input type="submit" value="Create Shipment">
</form:form>
</div>
${msg}
</body>
</html>