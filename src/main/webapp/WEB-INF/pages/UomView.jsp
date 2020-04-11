<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="conatiner">
		<div class="card">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<c:choose>
						<c:when test="${!empty uom }">
							<div class=" card-header text-center bg-primary text-white">
								<h3>WELCOME TO UOM DATA PAGE</h3>
							</div>
							<br>
							<table border="1"
								class="table table-bordered table-hover tbody tr:hover table-dark text-center">
								<tr class="table-primary text-dark font ">
								<tr>
									<th>ID</th>
									<td>${uom.uomId}</td>
								</tr>
								<tr>
									<th>TYPE</th>
									<td>${uom.uomType}</td>
								</tr>
								<tr>
									<th>MODEL</th>
									<td>${uom.uomModel }</td>
								</tr>
								<tr>
									<th>NOTE</th>
									<td>${uom.uomDesc }</td>
								</tr>
							</table>
							<div class="card-footer text-white text-center">
								<div class="row">
								<div class="col-4"></div>
									<div class="col-2">
										<div class="col-4"></div>
										<a href="excel?id=${uom.uomId }"
											class="btn btn-outline-primary"><img alt="Export-Excel"
											src="../resources/images/export-excel.png" width="40"
											height="40"></a>
									</div>
									<div class="col-2">
										<a href="pdf?id=${uom.uomId }" class="btn btn-outline-primary"><img
											alt="Export-Pdf" src="../resources/images/pdf.png" width="40"
											height="40"></a>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<h2>NO DATA FOUND</h2>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>