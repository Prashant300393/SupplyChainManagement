<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Part Data Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty list }">
			<table border="1">
				<tr>
					<th>CODE</th>
					<th>LENGTH</th>
					<th>WIDTH</th>
					<th>HEIGHT</th>
					<th>BASE COST</th>
					<th>BASE CURRENCY</th>
					<th>UOM</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.partCode}</td>
						<td>${ob.partLen}</td>
						<td>${ob.partWid}</td>
						<td>${ob.partHgt}</td>
						<td>${ob.baseCost}</td>
						<td>${ob.baseCurrency}</td>
						<td>${ob.uomOb.uomModel}</td>
						<td>${ob.pdesc}</td>
						<td><a href="delete?oid=${ob.partId}"><img alt="DELETE"
								src="../resources/images/del.png" width="25" height="23"></a></td>
						<td><a href="edit?oid=${ob.partId }"><img alt="EDIT"
								src="../resources/images/edit.png" width="25" height="23"></a></td>
						<td><a href="view?oid=${ob.partId }"><img alt="VIEW"
								src="../resources/images/view.png" width="25" height="23"></a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="excel"><img alt="Export-Excel"
				src="../resources/images/export-excel.png" width="60" height="60"></a>
			<a href="pdf"><img alt="Export-Pdf"
				src="../resources/images/pdf.png" width="60" height="60"></a>
		</c:when>
		<c:otherwise>
			<h3>NO DATA FOUND</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>