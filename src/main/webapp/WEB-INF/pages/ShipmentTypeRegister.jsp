<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<link href="../resources/css/ShipmentTypeRegister.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h3 style="text-align: center; font-size: 28px">WELCOME TO
		SHIPMENT TYPE REGISTER</h3>
	<div class="container">
		<form:form action="save" method="post" modelAttribute="shipmentType">
			<div class="row">
				<div class="col-2">
					<form:label path="shipMode">Shipment Mode</form:label>
					</div>
				<span id="shipModeError"></span>
				</div>
			<form:select path="shipMode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="Air">Air</form:option>
				<form:option value="Truck">Truck</form:option>
				<form:option value="Ship">Ship</form:option>
				<form:option value="Train">Train</form:option>
			</form:select>
			<br>
			
			<div class="row">
				<div class="col-2">
					<form:label path="shipCode">Shipment Code</form:label>
				</div>
				<span id="shipCodeError"></span>
			</div>
			<form:input path="shipCode" />
			<br>
			<div class="row">
				<div class="col-2">
					<form:label path="enbShip">Enable Shipment</form:label>
				</div>
				<span id="enbShipError"></span>
			</div>
			<form:select path="enbShip">
				<form:option value="">--SELECT--</form:option>
				<form:option value="YES">YES</form:option>
				<form:option value="NO">NO</form:option>
			</form:select>
			<br>
			
			<div class="row">
				<div class="col-2">
					<form:label path="shipGrade">Shipment Grade</form:label>
				</div>
				<span id="shipGradeError"></span>
			</div>
			<br>
			<form:radiobutton path="shipGrade" value="A" />
			A<br>
			<form:radiobutton path="shipGrade" value="B" />
			B<br>
			<form:radiobutton path="shipGrade" value="C" />
			C<br>
			<br>
			<div class="row">
			<div class="col-2">
				<form:label path="shipDesc">Description</form:label>
			</div>
			<span id="shipDescError"></span>
			</div>
			<form:textarea path="shipDesc" />
			<input id="register"   type="submit" value="Create Shipment">
		</form:form>
		${msg}
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					// 1. Hide error section
					$("#shipModeError").hide();
					$("#shipCodeError").hide();
					$("#enbShipError").hide();
					$("#shipGradeError").hide();
					$("#shipDescError").hide();
					
					// 2. Define error vaiable
					var shipModeError = false;
					var shipCodeError = false;
					var enbShipError = false;
					var shipGradeError = false;
					var shipDescError = false;
					
					// 3. Define validate Function
					function validate_shipMode() {

						// 1. Read input value
						var val = $("#shipMode").val();

						// 2. Check valid or not
						if (val == '') {// if not valid show Error Section with Error and Color
							$("#shipModeError").show();
							$("#shipModeError").html("*Please Choose One Shipment Mode");
							shipModeError = false;

						} else {
							$("#shipModeError").hide();
							shipModeError = true;
						}
						return shipModeError;
					}

					// ShipCode Error
					function validate_shipCode(){

						var val = $("#shipCode").val();
						if(val==''){
							$("#shipCodeError").show();
							$("#shipCodeError").html("*Please Enter Shipment Code");
							shipCodeError = false;
							}
						else{
							$("#shipCodeError").hide();
							shipCodeError = true;

							}
						return shipCodeError;
						}

					// Enable Ship
					function validate_enbShip(){
						var val = $("#enbShip").val();

						if(val == ''){
							$("#enbShipError").show();
							$("#enbShipError").html("*Please Choose Enable Shipment");
							enbShipError = false;
							}
						else{
							$("#enbShipError").hide();
							enbShipError = true;
							}
						return enbShipError;
						}
		
					// SHIPGRADE  Error
					function validate_shipGrade(){

						var val = $("#shipGrade").val();

						if (val==''){
							$("#shipGradeError").show();
							$("#shipGradeError").html("*Please select Shipment Grade");
							shipGradeError = false;
							}
						else{
							$("#shipGradeError").hide();
							shipGradeError = true;
							}
					
						return shipGradeError;
						}
					
					// SHIPDESC Error
					function validate_shipDesc(){

						var val = $("#shipDesc").val();
						if(val==''){
							$("#shipDescError").show();
							$("#shipDescError").html("*Please Enter Description");
							shipDescError = false;
							}
						else{
							$("#shipDescError").hide();
							shipDescError = true;
							}
						
						return shipDescError;
						}
					
					// 4. Link Function with Action event 
					$("#shipMode").change(function() {
							validate_shipMode();
						});

					$("#shipCode").keyup(function(){
							validate_shipCode();
						});

					$("#enbShip").change(function(){
						validate_enbShip();
						});

					$("#shipGrade").change(function(){
						validate_shipGrade();
						});

					$("#shipDesc").keyup(function(){
						validate_shipDesc();
						});

					// ON CLICK Submit Form
					$("#register").click(function(){

						// 1. Reset Flags to FALSE
						 shipModeError = false;
						 shipCodeError = false;
						 enbShipError = false;
						 shipGradeError = false;
						 shipDescError = false;
													
						// 2. call All Function
						validate_shipMode();
						validate_shipCode();
						validate_enbShip();
						validate_shipGrade();
						validate_shipDesc();

						// 3. Submit only if All are TRUE
						if(shipModeError && shipCodeError && enbShipError && shipGradeError && shipDescError ){
							return true;
							}
						else{
							return false;
							}
				});
	});
	</script>
</body>
</html>