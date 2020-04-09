<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
				<h3>---WELCOME TO ORDER METHOD REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="orderMethod">
					<div class="row">
						<div class="col-4">
							<label for="orderMode">Order Mode </label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="Sale" />
							Sale
							<form:radiobutton path="orderMode" value="Purchase" />
							Purchase<br>
						</div>
						<div class="col-4">
							<span id="orderModeError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="orderCode">Order Code</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="orderCodeError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="orderType">Order Type</label>
						</div>
						<div class="col-4">
							<form:select path="orderType" class="form-control">
								<form:option value="">---SELECT---</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="orderTypeError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">Order Accept</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAccept" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="orderAccept" value="Accept Return" />
							Accept Return<br>
						</div>
						<div class="col-4">
							<span id="orderAcceptError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="orderDesc">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="orderDesc" class="form-control" />
						</div>
						<div class="col-4">
							<span id="orderDescError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input id="register" type="submit" value="Create Order Method"
								class="btn btn-success">
						</div>
					</div>
				</form:form>
			</div>
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(
				function() {
					// 1. Hide ERROR Section
					$("#orderModeError").hide();
					$('#orderCodeError').hide();
					$('#orderTypeError').hide();
					$('#orderAcceptError').hide();
					$('#orderDescError').hide();

					// 2. Define ERROR Variable
					var orderModeError = false;
					var orderCodeError = false;
					var orderTypeError = false;
					var orderDescError = false;
					var orderAcceptError = false;

					// 3. Define VALIDATE FUNCTION for INPUT

					// ORDER MODE
					function validate_orderMode(){
						var val = $('input[type="radio"][name="orderMode"]:checked').length
						if(val==0){
							$("#orderModeError").show();
							$("#orderModeError").html("<b>Please choose one Order Mode</b>");
							$("#orderModeError").css('color', 'red');
							orderModeError = false;
							}
						else{
							$("#orderModeError").hide();
							orderModeError = true;
							}
						return orderModeError;
						}					
				
					// ORDER CODE
					function validate_orderCode() {
						var val = $('#orderCode').val();
						if (val == '') {
							$('#orderCodeError').show();
							$('#orderCodeError').html(
									'<b>*Please Enter the Order Code</b>')
							$('#orderCodeError').css('color', 'red')
							orderCodeError = false;
						} else {
							$('#orderCodeError').hide();
							orderCodeError = true;
						}
						return orderCodeError;
					}

					// ORDER TYPE
					function validate_orderType() {
						var val = $('#orderType').val();
						if (val == '') {
							$('#orderTypeError').show();
							$('#orderTypeError').html(
									'<b>*Please Choose Order Type</b>');
							$('#orderTypeError').css('color', 'red');
							orderTypeError = false;
						} else {
							$('#orderTypeError').hide();
							orderTypeError = true;
						}

						return orderTypeError;
					}

					// ORDER ACCEPT	
					// ORDER MODE
					function validate_orderAccept(){
						var val = $('input[type="checkbox"][name="orderAccept"]:checked').length
						if(val==0){
							$("#orderAcceptError").show();
							$("#orderAcceptError").html("<b>Please choose one Order Accept</b>");
							$("#orderAcceptError").css('color', 'red');
							orderAcceptError = false;
							}
						else{
							$("#orderAcceptError").hide();
							orderAcceptError = true;
							}
						return orderAcceptError;
						}					
					

					// ORDER DESC
					function validate_orderDesc() {
						var val = $('#orderDesc').val();
						if (val == '') {
							$('#orderDescError').show();
							$('#orderDescError').html(
									'<b>*Please Enter Description</b>');
							$('#orderDescError').css('color', 'red');
							orderDescError = false;
						} else {
							$('#orderDescError').hide();
							orderDescError = true;

						}
						return orderDescError;
					}

					// 4. Link FUNCTION with ACTION EVENT
					$('input[type="radio"][name="orderMode"]').change(function() {
						validate_orderMode();
					});
									
					$('#orderCode').keyup(function() {
						validate_orderCode();
					});

					$('#orderType').change(function() {
						validate_orderType();
					});
					
					$('input[type="checkbox"][name="orderAccept"]').change(function() {
						validate_orderAccept();
					});
					
					$('#orderDesc').keyup(function() {
						validate_orderDesc();
					});

					// 5. ON CLICK SUBMI button
					$('#register').click(function() {
						orderModeError = false;
						orderCodeError = false;
						orderTypeError = false;
						orderAcceptError = false;
						orderDescError = false;

						validate_orderMode();
						validate_orderCode();
						validate_orderType();
						validate_orderAccept();
						validate_orderDesc();
						
						if(orderModeError && orderCodeError && orderTypeError && orderAcceptError && orderDescError){
							return true;
							}
						else{
							return false;
							}

					});

				}); // end
	</script>
</body>
</html>
