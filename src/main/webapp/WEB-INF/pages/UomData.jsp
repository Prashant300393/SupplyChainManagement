<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="conatiner">
		<div class="card">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<c:choose>
						<c:when test="${!empty list }">
							<div class=" card-header text-center bg-primary text-white">
								<h3>WELCOME TO UOM DATA PAGE</h3>
							</div>
							<br>
							<table border="1"
								class="table table-bordered table-hover tbody tr:hover table-dark text-center table-primary th ">
								<tr class="table-primary text-dark font ">
									<th>TYPE</th>
									<th>MODEL</th>
									<th>NOTE</th>
									<th colspan="3">OPERATION</th>
									<th colspan="2">DOWNLOAD</th>
								</tr>
								<c:forEach items="${list }" var="ob">
									<tr>
										<td>${ob.uomType }</td>
										<td>${ob.uomModel }</td>
										<td>${ob.uomDesc }</td>
										<td><a href="delete?uid=${ob.uomId }"
											class="btn btn-outline-danger"><img alt="DELETE"
												src="../resources/images/del.png" width="25" height="23"></a></td>
										<td><a href="edit?uid=${ob.uomId}" class="btn btn-outline-warning"><img
												alt="EDIT" src="../resources/images/edit.png" width="25"
												height="23"></a></td>
										<td><a href="view?uid=${ob.uomId}"
											class="btn btn-outline-success"><img alt="VIEW"
												src="../resources/images/view.png" width="25" height="23"></a></td>
										<td><a href="excel" class="btn btn-outline-primary"><img alt="Export-Excel"
												src="../resources/images/export-excel.png" width="28"
												height="32" ></a></td>
										<td><a href="pdf" class="btn btn-outline-primary"><img alt="Export-Pdf" 
												src="../resources/images/pdf.png" width="25" height="25" 
												></a></td>
									</tr>
								</c:forEach>
							</table>
							<br>
							<div class="card-footer bg-info text-white text-center">
								${msg }
							</div>
						</c:when>
						<c:otherwise>
							<h2>NO DATA FOUND</h2>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
</body>
</html>