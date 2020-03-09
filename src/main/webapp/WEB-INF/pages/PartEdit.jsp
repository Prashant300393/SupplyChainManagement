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
		---WELCOME TO PART EDIT PAGE--- </span>
	<br>
	<br>
	<div class="container" style="width: 47%">
		<form:form action="update" method="post" modelAttribute="part">
			<div class="row">
				<div class="col-2">
					<form:label path="partId">ID :</form:label>
				</div>
				<form:input path="partId" readonly="true" />
			</div>

			<div class="row">
				<div class="col-2">
					<form:label path="partCode">Code:</form:label>
				</div>
				<form:input path="partCode" />
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="dimen">Dimensions :</form:label>
				</div>
				<div class="col-10">
					<form:label path="partLen">Length :</form:label>
					<form:input style="width:65px; height:28px" path="partLen" />
					<form:label path="partWid">Width :</form:label>
					<form:input style="width:65px; height:28px" path="partWid" />
					<form:label path="partHgt">Height :</form:label>
					<form:input style="width:65px; height:28px" path="partHgt" />
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="baseCost">Base Cost :</form:label>
				</div>
				<form:input path="baseCost" />
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="baseCurrency">Base Currency</form:label>
				</div>
				<form:select path="baseCurrency">
					<form:option value="">--SELECT--</form:option>
					<form:option value="INR">INR</form:option>
					<form:option value="USD">USD</form:option>
					<form:option value="AUD">AUD</form:option>
					<form:option value="ERU">ERU</form:option>
				</form:select>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="uomOb">Uom</form:label>
				</div>
				<form:select path="uomOb.uomId">
					<%-- FOREIGN KEY PATH --%>
					<form:option value="">--SELECT--</form:option>
					<%-- 			<form:options items="${uomList}" itemValue="uomId"  itemLabel="uomModel" /> --%>
					<form:options items="${uomMap}" />
				</form:select>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="orderMethodOb">Order Mode</form:label>
				</div>
				<form:select path="orderMethodOb.orderId">
					<form:option value="">--SELECT--</form:option>
					<form:options items="${orderMap}" />
				</form:select>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="pdesc">Description</form:label>
				</div>
				<form:textarea path="pdesc" />
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