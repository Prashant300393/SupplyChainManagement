<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div class="card-header text-center bg-primary text-white">
				<h2>WELCOME TO PURCHASE ORDER(DETAIL) SCREEN#2</h2>
			</div>
			<div class="">
				<table class="table table-bordered">
					<tr>
						<th>Order code</th>
						<td class="text-success"><b>${pOrder.poOrderCode}</b></td>

						<th>Status</th>
						<td class="text-success"><b>${pOrder.poStatus}</b></td>
					</tr>
				</table>

				<c:if
					test="${ 'OPEN' eq   pOrder.poStatus || 'PICKING' eq pOrder.poStatus}">
					<form:form action="addPart" method="post"
						modelAttribute="purchaseDtl">
						<div class="row">
							<div class="col-4">Select Part</div>
							<div class="col-4">
								<form:select path="part.partId" class="form-control">
									<form:options items="${partsMap}" />
								</form:select>
							</div>
						</div><br>
						<div class="row">
							<div class="col-4">Quantity</div>
							<div class="col-4">
								<form:input path="qty" class="form-control" />
							</div>
						</div><br>
						<div class="row">
							<div class="col-4"></div>
							<div class="col-4">
								<input type="submit" value="Add Part" class="btn btn-info">
							</div>
						</div>
						<br>
						<input type="hidden" name="po.id" value="${pOrder.id}">
					</form:form>
				</c:if>
			</div> <!-- card-body -->
			
			
			<table class="table table-bordered">
				<tr>
					<th>Slno</th>
					<th>Part Code</th>
					<th>Base Cost</th>
					<th>Quantity</th>
					<c:if test="${'PICKING' eq pOrder.poStatus }">
						<th>Operation</th>
					</c:if>
				</tr>
				<c:forEach items="${childDtl}" var="dtl">
					<tr>
						<td>${dtl.slNo}</td>
						<td>${dtl.part.partCode }</td>
						<td>${dtl.part.baseCost }</td>
						<td>${dtl.qty}</td>
						<!-- dtlId for deleting Part and PO id for come back to same page -->
						<c:if test="${'PICKING' eq pOrder.poStatus }">
							<td><a href="removePart?dtlId=${dtl.id}&poId=${pOrder.id}"  class="btn btn-danger">DELETE</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${'PICKING' eq pOrder.poStatus }">
				<a href="placeorder?poId=${pOrder.id}" class="btn btn-success">Confirm Order
					Order</a>
			</c:if>

		</div>
	</div>
</body>
</html>