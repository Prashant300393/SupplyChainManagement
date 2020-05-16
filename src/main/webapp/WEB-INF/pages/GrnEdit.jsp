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
				<h1>Welcome to Grn Edit Page</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="update" method="POST"
					modelAttribute="grn">
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="id"> GRN ID</label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" class="form-control" />
						</div>
						<div class="col-4">
							<span id="idError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="grnCode"> GRN CODE</label>
						</div>
						<div class="col-4">
							<form:input path="grnCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="grnCodeError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="grnType"> GRN TYPE</label>
						</div>
						<div class="col-4">
							<form:input path="grnType" class="form-control" />
						</div>
						<div class="col-4">
							<span id="grnTypeError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="po"> PURCHASE ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:select path="po.id" class="form-control" >
								<form:options items="${poMap}" />
							</form:select>
						</div>
						<div class="col-4">
							<span id="poCodeError"></span>
						</div>
					</div>
					<br>
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="note">GRNDESC</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4">
							<span id="noteError"></span>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-5"></div>
						<input type="submit" value="Update" id="register"
							class="btn btn-success btn-center" />
					</div>
				</form:form>
			</div>
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</div>
	</div>
</body>
</html>