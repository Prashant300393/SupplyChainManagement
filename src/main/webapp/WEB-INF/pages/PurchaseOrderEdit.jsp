<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 55%;
	padding: 9px;
	border: 1px solid #ccc;
	border-radius: 2px;
	box-sizing: border-box;
	margin-top: 3px;
	margin-bottom: 10px;
	resize: vertical;
	height: 35%;
	font-weight:  350;
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

input[type=reset] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=reset]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #d5f4e6;
	padding: 5px;
	margin: 30px;
}

.blinking {
	animation: blinkingText 1.5s infinite;
}

@
keyframes blinkingText { 0%{
	color: red;
}
49%{
color
:
 
red
;
 
}
60%{
color
:
 
transparent
;
 
}
99%{
color
:transparent
;
  
}
100%{
color
:
 
blue
;
    
}
}
</style>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<span class="blinking"
		; style="font-weight: bold; text-align: center; font-size: 25px; padding: 20%; margin: 7%">
		---WELCOME TO PURCHASE ORDER EDIT PAGE--- </span>
	<br>
	<br>
	<div class="container" style="width: 47%">
		<form:form action="update" method="post" modelAttribute="purchaseOrder">
			<div class="row">
				<div class="col-2">
					<form:label path="id">ID</form:label>
				</div>
				<form:input path="id" readonly="true"/>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="poOrderCode">Order Code</form:label>
				</div>
				<form:input path="poOrderCode" />
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="shipOb">Shipment Code</form:label>
				</div>
					<form:select path="shipOb.shipId">
						<form:option value="">--select---</form:option>
						<form:options items="${shipMap}" />
					</form:select>
				</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="whVendor">Vendor</form:label>
				</div>
					<form:select path="whVendor.userId">
						<form:option value="">--select---</form:option>
						<form:options items="${whMap}" />
					</form:select>
				</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="poRefNum">Reference Number</form:label>
				</div>
				<form:input path="poRefNum" />
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="poQltyCheck">Quality Check</form:label>
				</div>
				<div class="col-4">
					<form:radiobutton path="poQltyCheck" value="Required" />
					Required
					<form:radiobutton path="poQltyCheck" value="Not Required" />
					Not Required
				</div>
			</div>
	<br>
	<div class="row">
		<div class="col-2">
			<form:label path="poStatus">DEFAULT STATUS</form:label>
		</div>
		<div>
			<form:input path="poStatus" readonly="true" />
		</div>
	</div>
	<div class="row">
		<div class="col-2">
			<form:label path="poDesc">Description</form:label>
		</div>
		<form:textarea path="poDesc" />
	</div>
	<br>
	<div class="row">
		<div class="col-2"></div>
		<input type="submit" value="Update">
		<div class="col-1"></div>
		<input type="reset" value="Reset">
	</div>
	</form:form>
	</div>
	${msg}
</body>
</html>