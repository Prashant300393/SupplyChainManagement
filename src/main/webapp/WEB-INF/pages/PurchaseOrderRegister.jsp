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
				<h4>WELCOME TO PURCHASE ORDER REGISTER PAGE</h4>
			</div>
			<div class="card-body">
				<form:form action="save" method="post"
					modelAttribute="purchaseOrder">
					<div class="row">
						<div class="col-4">
							<label for="poOrderCode">Order Code</label>
						</div>
						<div class="col-4">
							<form:input path="poOrderCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="poOrderCodeError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="shipOb">Shipment Code</label>
						</div>
						<div class="col-4">
							<form:select path="shipOb.shipId" class="form-control">
								<form:option value="">--SELECT---</form:option>
								<form:options items="${shipMap}" />
							</form:select>
						</div>
						<div class="col-4">
							<span id="shipObError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="whVendor">Vendor</label>
						</div>
						<div class="col-4">
							<form:select path="whVendor.userId" class="form-control">
								<form:option value="">--SELECT---</form:option>
								<form:options items="${whMap}" />
							</form:select>
						</div>
						<div class="col-4">
							<span id="whVendorError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="poRefNum">Reference Number</label>
						</div>
						<div class="col-4">
							<form:input path="poRefNum" class="form-control" />
						</div>
						<div class="col-4">
							<span id="poRefNumError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="poQltyCheck">Quality Check</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="poQltyCheck" value="Required" />
							Required
							<form:radiobutton path="poQltyCheck" value="Not Required" />
							Not Required
						</div>
						<div class="col-4">
							<span id="poQltyCheckError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<form:label path="poStatus">DEFAULT STATUS</form:label>
						</div>
						<div class="col-4">
							<form:input path="poStatus" readonly="true" class="form-control" />
						</div>
						<div class="col-4">
							<span id="poStatusError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="poDesc">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="poDesc" class="form-control" />
						</div>
						<div class="col-4">
							<span id="poDescError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input id="register" type="submit" value="Create Purchase Order"
								class="btn btn-success btn-center"> <input id="register"
								type="reset" value="Reset" class="btn btn-success btn-center">
						</div>
					</div>
				</form:form>
			</div>
			
			<div class="card-footer bg-info text-center text-white">
				<b>${msg}</b>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(
				function() {

					// 1. Hide Error Section
					$('#poOrderCodeError').hide();
					$('#shipObError').hide();

					// 2. Define Error Variable
					var poOrderCodeError = false;
					var shipObError = false;

					// 3. Define Validate Function
					function validate_poOrderCode() {
						var val = $('#poOrderCode').val();
						if (val == '') {
							$('#poOrderCodeError').show();
							$('#poOrderCodeError').html(
									'<b>*Please Enter the Code</b>');
							$('#poOrderCodeError').css('color', 'red');
							poOrderCodeError = false;
						} else {
							$('#poOrderCodeError').hide();
							poOrderCodeError = true;
						}
						return poOrderCodeError;
					}

					// ShipmentCode
					function validate_shipOb() {

						var val = $('#shipOb.shipId').val();
						if (val == '') {
							$('#shipObError').show();
							$('#shipObError').html(
									'<b>*Please Select Shipment Code</b>');
							$('#shipObError').css('color', 'red');
							shipObError = false;
						} else {
							$('#shipObError').hide();
							shipObError = true;
						}
						return shipObError;
					}

					//4. Link Action with Function
					$('#poOrderCode').keyup(function() {
						validate_poOrderCode();
					});

					$('#shipOb.shipId').change(function() {
						validate_shipOb();
					});

				});
	</script>
</body>
</html>

<%-- 
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
		---WELCOME TO PURCHASE ORDER REGISTER PAGE--- </span>
	<br>
	<br>
	<div class="container" style="width: 47%">
		<form:form action="save" method="post" modelAttribute="purchaseOrder">
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
		<input type="submit" value="Place Order">
		<div class="col-1"></div>
		<input type="reset" value="Reset">
	</div>
	</form:form>
	</div>
	${msg}
</body>
</html> --%>