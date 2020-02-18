<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
  <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${! empty list }">
<table border="1">
	<tr>
		<th>ID</th>	
		<th>MODE</th>	
		<th>CODE</th>	
		<th>ENABLE</th>	
		<th>GRADE</th>	
		<th>NOTE</th>	
		<th colspan="2">OPERATION</th>
	</tr>

	<!-- for(ShipmentType ob : list) { ...  } -->
	<c:forEach items="${list }" var="ob">
		<tr>
			<td>${ob.shipId }</td>
			<td>${ob.shipMode }</td>
			<td>${ob.shipCode }</td>
			<td>${ob.enbShip }</td>
			<td>${ob.shipGrade }</td>
			<td>${ob.shipDesc }</td>
			<td><a href="delete?sid=${ob.shipId }">DELETE</a>
			<td><a href="edit?sid=${ob.shipId}">EDIT</a>
		</tr>
	</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3>No DATA Found</h3>
</c:otherwise>
</c:choose>
${msg}
</body>
</html>