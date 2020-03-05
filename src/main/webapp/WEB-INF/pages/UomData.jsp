<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
</head>
<body>
<div class="conatiner">
	<div class="card">
	<c:choose>
		<c:when test="${!empty list }">
			<div class=" card-header text-center bg-primary text-white">
			<h3>WELCOME TO UOM DATA PAGE</h3>
			</div><br>
			<table border="1" class="table table-bordered table-hover tbody tr:hover table-dark text-center table-primary th">
				<tr class="table-primary text-dark font ">
					<th>ID</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.uomType }</td>
						<td>${ob.uomModel }</td>
						<td>${ob.uomDesc }</td>
						<td><a href="delete?uid=${ob.uomId }" class="btn btn-danger"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?uid=${ob.uomId}" class="btn btn-info"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?uid=${ob.uomId}" class="btn btn-success"><img alt="VIEW"
								src="../resources/images/view.png" width="25" height="23"></a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div class="card-footer text-center">
			<a href="excel"><img alt="Export-Excel"
				src="../resources/images/export-excel.png" width="60" height="60" class="btn btn-info"></a>
			<a href="pdf"><img alt="Export-Pdf"
				src="../resources/images/pdf.png" width="60" height="60" class="btn btn-info"></a>
		</c:when>
		<c:otherwise>
			<h2>NO DATA FOUND</h2>
		</c:otherwise>
	</c:choose>
	${msg }
			</div>
	</div>
</div>
</body>
</html>