<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header text-center bg-primary text-white">
				<h1>Welcome to Uom Register Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="POST"
					modelAttribute="uom">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="uomType"> UOMTYPE</label>
						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="-NA-">-NA-</form:option>
							</form:select>
						</div>
						<div class="col-4" >
							<span id="uomTypeError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="uomModel"> UOMMODEL</label>
						</div>
						<div class="col-4">
							<form:input path="uomModel" class="form-control" />
						</div>
						<div class="col-4">
							<span id="uomModelError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="uomDesc">UOMDESC</label>
						</div>
						<div class="col-4">
							<form:textarea path="uomDesc" class="form-control" />
						</div>
						<div class="col-4" >
							<span id="uomDescError"></span>
						</div>
					</div>
					<br>
					<div class="row"><div class="col-5"></div>
					<input type="submit" value="Register" id="register"
						class="btn btn-success btn-center" />
					</div>
				</form:form>
			</div>
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</div>
	</div>
<script>

$(document).ready(function(){
	// 1. Hide Error section
	$("#uomTypeError").hide();
	$("#uomModelError").hide();
	$("#uomDescError").hide();
	
	// 2. Define Error Variable
	var uomTypeError = false;
	var uomModelError = false;
	var uomDescError = false;
	
	// 3. Define Validate Function FOR UOMTYPE
	function validate_uomType()	{

		// 1. Read input values
		var val = $("#uomType").val();

		// 2. Check Valid or not
		if(val== ''){

			$("#uomTypeError").show();
			$("#uomTypeError").html("<b>*Please Choose one Uom Type </b>");
			$("#uomTypeError").css("color", "red");

			uomTypeError = false;
		}
		else{
			$("#uomTypeError").hide();
			uomTypeError = true;
		}
			return uomTypeError;
		}

		// UOM MODEL
		function validate_uomModel() {

			var val = $("#uomModel").val();
			var exp = /^[A-Z]{2,8}$/;
			if(val==''){
				$("#uomModelError").show();
				$("#uomModelError").html("<b>*Please Enter Uom Model</b>");
				$("#uomModelError").css("color", "red");
				uomModelError = false;
				}
			else if(!exp.test(val)){
				$("#uomModelError").show();
				$("#uomModelError").html("<b>*Please Enter 2-8 UpperCase Letters</b>");
				$("#uomModelError").css("color", "red");
				uomModelError = false;
				}
			else{
				$("#uomModelError").hide();
				uomModelError = true;
				}

			return uomTypeError;
			}

		// UOM DESC
		function validate_uomDesc() {

			var val = $("#uomDesc").val();
			var exp = /^[A-Za-z0-9\_\-\.\ ]{8,150}$/;
			if(val==''){
				$("#uomDescError").show();
				$("#uomDescError").html("<b>*Please Enter Description</b>");
				$("#uomDescError").css("color", "red");
				uomDescError = false;
				}
			else if(!exp.test(val)){
				$("#uomDescError").show();
				$("#uomDescError").html("<b>*Please Enter between 8-150 words</b>");
				$("#uomDescError").css("color", "red");
				uomDescError = false;
				}
			else{
				$("#uomDescError").hide();
				uomDescError = true;
				}
			
			return uomDescError;
			}
	
	// 4. Link Function with Action Events
	$("#uomType").change(function(){

		validate_uomType();
		});
	
	$("#uomModel").keyup(function(){

		validate_uomModel();
		});

	$("#uomDesc").keyup(function(){

		validate_uomDesc();
	
		});

		// 5. On click Submit Button
	$("#register").click(function()	{

		// 1. Reset flags to False
			uomTypeError = false;
		 	uomModelError = false;
		 	uomDescError = false;

		 	// 2. call Validate Function
		 	validate_uomType();
		 	validate_uomModel();
		 	validate_uomDesc();

		 	// 3. Check if All are TRUE then only Submit
		 	if (uomTypeError && uomModelError && uomDescError){
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