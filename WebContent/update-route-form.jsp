<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./commonstyles.jsp" %>
</head>
<body>
<h1>Flyaway - Your well deserved vacation a click away</h1>
<h2>Admin Maintanance module</h2>

		<form action="update" method="post">
			Route Id :
			<input type="text" id="routeId" name="routeId"  value="${route.routeId}"  readonly><br>	
			<input type="text" id="fromCity"name="fromCity" value="${route.fromCity}"placeholder="From City" required><br>
			<input type="text" id="toCity" 	name="toCity"   value="${route.toCity}"  placeholder="To City"   required><br>
			<input type="text" id="airline" name="airline"  value="${route.airline}" placeholder="Airline"   required><br>
			<input type="date" id="fromDate"name="fromDate" value="${route.fromDate}"placeholder="From Date" required><br>
			<input type="date" id="toDate"  name="toDate"   value="${route.toDate}"  placeholder="To Date" required><br>			
			<input type="text" id="airline" name="price"    value="${route.price}"   placeholder="Price" required><br><br>
			<button type="submit">Update</button> &nbsp;
			<a href="${pageContext.request.contextPath}/admin-back">Back</a> <br>
			
		</form>	

</body>
</html>