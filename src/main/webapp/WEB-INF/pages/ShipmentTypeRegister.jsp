<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src="https://code.jquery.com/jquery-3.5.0.min.js"
	integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
	crossorigin="anonymous"></script>

<!-- JQuery & AJAX Link -->
<script  src="https://code.jquery.com/jquery-3.4.1.min.js"> </script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<!-- Bootstrap link -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	
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
			<div class="row">
				<div class="col-8"></div>
				<input id="register" type="submit" value="Create Shipment">
				<input type="reset" value="Reset">
			</div>
		</form:form>
		${msg}
	</div>
	<script>
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
						var exp = /^[A-Z]{2,8}$/;
						if(val==''){
							$("#shipCodeError").show();
							$("#shipCodeError").html("*Please Enter Shipment Code");
							shipCodeError = false;
							}
						else if(!exp.test(val)){
							$("#shipCodeError").show();
							$("#shipCodeError").html("*Please Enter between 2-8 UpperCase Letters");
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

						var val = $('input[type="radio"][name="shipGrade"]:checked').length;
						if(val==0){
							$("#shipGradeError").show();
							$("#shipGradeError").html("<b>*Please select one Grade </b>");
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
						var exp = /^[A-Za-z0-9\_\-\.\ ]{8,150}$/;
						if(val==''){
							$("#shipDescError").show();
							$("#shipDescError").html("*Please Enter Description");
							shipDescError = false;
							}
						else if(!exp.test(val)){
							$("#shipDescError").show();
							$("#shipDescError").html("*Please Enter between 8-150 words");
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

					$('input[type="radio"][name="shipGrade"]').change(function(){
						validate_shipGrade();
						});

					$("#shipDesc").keyup(function(){
						validate_shipDesc();
						});

					$("#shipCode").blur(function(){
						validate_shipCode_ajax();
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

					/* JQuery AJAX function */
					function validate_shipCode_ajax(){
					     var val = $("#shipCode").val();

					     $.ajax({
					     	url : 'codeExist',
					     	data: { "code": $("#shipCode").val()},
					     	success:function(resTxt){
					          if(resTxt!=''){
					          	 $("#shipCodeError").show();
					     	         $("#shipCodeError").html(resTxt);
					     	         $("#shipCodeError").css("color","red");
					     	         $("#shipCode").focus();//place cursor back
					          }else{
					          	$("#shipCodeError").hide();
					          	$("#shipCodeError").html("");
					          }
					     	}	
					     });
					  }
			
});

</script>
</body>
</html>