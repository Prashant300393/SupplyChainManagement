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
				<h4>WELCOME TO SALE ORDER REGISTER PAGE</h4>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="saleOrder">
					<div class="row">
						<div class="col-4">
							<label for="saleCode">Order Code</label>
						</div>
						<div class="col-4">
							<form:input path="saleCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="saleCodeError"></span>
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
								<form:options items="${shipMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<span id="shipObError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="whCust">Customer</label>
						</div>
						<div class="col-4">
							<form:select path="whCust.userId" class="form-control">
								<form:option value="">--SELECT---</form:option>
								<form:options items="${whMap}" />
							</form:select>
						</div>
						<div class="col-4">
							<span id="whCustError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="saleRefNo">Reference Number</label>
						</div>
						<div class="col-4">
							<form:input path="saleRefNo" class="form-control" />
						</div>
						<div class="col-4">
							<span id="saleRefNoError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="stockMode">Stock Mode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" value="Grade" />
							Grade
							<form:radiobutton path="stockMode" value="Margin" />
							Margin
						</div>
						<div class="col-4">
							<span id="stockModeError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="stockSource">Stock Source</label>
						</div>
						<div class="col-4">
							<form:select path="stockSource" class="form-control">
								<form:option value="">--SELECT---</form:option>
								<form:option value="Open">Open</form:option>
								<form:option value="Avail">Avail</form:option>
								<form:option value="Refund">Refund</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="stockSourceError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="status">DEFAULT STATUS</label>
						</div>
						<div class="col-4">
							<form:input path="status" readonly="true" class="form-control" />
						</div>
						<div class="col-4">
							<span id="statusError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="saleDesc">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="saleDesc" class="form-control" />
						</div>
						<div class="col-4">
							<span id="saleDescError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input id="register" type="submit" value="Create Sale Order" class="btn btn-success btn-center"> 
							<input id="register"	type="reset" value="Reset" class="btn btn-success btn-center">
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

	$(document).ready(function(){

		// 1. Hide Error Section
		$('#saleCodeError').hide();
		$('#shipObError').hide();
		
		// 2. Define Error Variable
		var saleCodeError = false;
		var shipObError = false;

		// 3. Define Validate Function
		function validate_saleCode(){
			var val = $('#saleCode').val();
			if(val==''){
				$('#saleCodeError').show();
				$('#saleCodeError').html('<b>*Please Enter the Code</b>');
				$('#saleCodeError').css('color', 'red');
				saleCodeError = false;
				}
			else{
				$('#saleCodeError').hide();
				saleCodeError = true;
				}
			return saleCodeError;
			}

			// ShipmentCode
			function validate_shipOb(){

				var val = $('#shipOb.shipId').val();
				if(val==''){
					$('#shipObError').show();
					$('#shipObError').html('<b>*Please Select Shipment Code</b>');
					$('#shipObError').css('color', 'red');
					shipObError = false;
					}
				else{
					$('#shipObError').hide();
					shipObError = true;
					}
				return shipObError;
				}
		
		//4. Link Action with Function
		$('#saleCode').keyup(function(){
			validate_saleCode();
			});

		$('#shipOb.shipId').change(function(){
			validate_shipOb();
			});

		
});
</script>
</body>
</html>