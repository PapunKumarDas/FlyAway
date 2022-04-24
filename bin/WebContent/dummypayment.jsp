<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./commonstyles.jsp" %>
</head>
<body>
<h1>FlyAway - Your well deserved vacation a click away</h1>
<h2>Registration</h2>

	<div>
 		<form action="success" method ="post"> 
 		
 			<h4> Hello ${customer.firstName} ${customer.lastName}  </h4><br>
			
			<h4 style="color:Tomato;"> Your Flight Details <br>
 				From ${route.fromCity}
 			  	  To ${route.toCity}
 			  	  by ${route.airline}
 			      cost ${route.price}<br><br>
			 </h4>
 	
 			<!--  pass key values for final confirmation screen -->
 			<input type="hidden" id="emailId"	name="emailId"  value="${customer.emailId}">		
 			<input type="hidden" id="routeId"	name="routeId" 	value="${route.routeId}">

 
 	
			<h4> Payment Details </h4>
 		
 			Full Name 	<input type="text" id="fullName"name="fullName" placeholder="Full Name" required><br>
 			Card Number	<input type="text" id="cardNumber"name="cardNumber" placeholder="1234-456-789" required><br>
			Expiry Date <input type="text" id="expiryDate"name="expiryDate" placeholder="mm-yyyy" required><br>
			CVV number 	<input type="number" id="cvvNo"name="cvvNo" placeholder="123" required><br>
			<button type="submit"> Pay </button> &nbsp;
			<a href="${pageContext.request.contextPath}/">Cancel</a> <br>
		</form>	
		
 	</div>
</body>
</html>