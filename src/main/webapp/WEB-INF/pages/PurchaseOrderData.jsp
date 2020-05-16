<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<c:choose>
				<c:when test="${! empty list }">
					<div class="card-header text-center bg-primary text-white">
						<h3>WELCOME TO PURCHASE ORDER DATA PAGE</h3>
					</div>

					<table class="table">
						<tr>
							<th>ID</th>
							<th>CODE</th>
							<th>SHIPMENT CODE</th>
							<th>VENDOR</th>
							<th>REF NO</th>
							<th>QUALTY CHECK</th>
							<th>STATUS</th>
							<th>NOTE</th>
							<th colspan="5">OPERATION</th>
						</tr>

						<!-- for(PurchaseOrder ob : list) { ...  } -->
						<c:forEach items="${list }" var="ob">
							<tr>
								<td>${ob.id}</td>
								<td>${ob.poOrderCode}</td>
								<td>${ob.shipOb.shipCode}</td>
								<td>${ob.whVendor.userCode}</td>
								<td>${ob.poRefNum}</td>
								<td>${ob.poQltyCheck}</td>
								<td>${ob.poStatus}</td>
								<td>${ob.poDesc}</td>
								<%-- 								<td><a href="delete?id=${ob.id}"><img alt="DELETE"
										src="../resources/images/del.png" width="25" height="23"></a></td>
								<td><a href="edit?id=${ob.id}"><img alt="EDIT"
										src="../resources/images/edit.png" width="25" height="23"></a></td>
								<td><a href="view?id=${ob.id}"><img alt="VIEW"
										src="../resources/images/view.png" width="25" height="23"></a></td>
 --%>
								<!-- On click this it will redirected to SCREEN #2 -->
								<td><a href="parts?poId=${ob.id}" class="btn btn-primary">Add
										Parts</a></td>

								<td><c:choose>
										<c:when test="${'ORDERED' eq ob.poStatus}">
											<a href="invoiceOrder?poId=${ob.id}" class="btn btn-success">GENERATE
												INVOICE</a>
										</c:when>

										<c:when test="${'INVOICED' eq ob.poStatus}">
											<a href="downloadInvoice?poId=${ob.id}"
												class="btn btn-info">DOWNLOAD INVOICE</a>
										</c:when>
										<c:otherwise>
											<b class="text-danger">ORDER MUST BE PLACED</b>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>
					<h3>
						<a href="excel"><img alt="Export-Excel"
							src="../resources/images/export-excel.png" width="60" height="60"></a>
						<a href="pdf"><img alt="Export-Pdf"
							src="../resources/images/pdf.png" width="60" height="60"></a>
					</h3>
				</c:when>
				<c:otherwise>
					<div class="card-footer">
						<h3>No DATA Found</h3>
					</div>
				</c:otherwise>
			</c:choose>
			${msg}
		</div>
	</div>
</body>
</html>