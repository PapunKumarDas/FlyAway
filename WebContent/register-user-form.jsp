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
<h2>Registration</h2>

	<div>
 		<form action="${pageContext.request.contextPath }/payment-process" method ="post"> 
 			<input type="hidden" id="routeId"name="routeId" value="${route.routeId}" STYLE="color:lightblue;" >
			<input type="hidden" id="fromCity"name="fromCity" value="${route.fromCity}" STYLE="color:lightblue;">
			<input type="hidden" id="toCity" 	name="toCity" value="${route.toCity}" STYLE="color:lightblue;" >
			<input type="hidden" id="airline" name="airline" value="${route.airline}" STYLE="color:lightblue;" >
			<input type="hidden" id="price" name="price" value="${route.price}" STYLE="color:lightblue;"><br><br>
 		
 			<h4 style="color:Tomato;"> Your Flight Details <br>
 				From ${route.fromCity}
 			  	  To ${route.toCity}
 			  	  by ${route.airline}
 			      cost ${route.price}<br><br>
			 </h4>
			<h4> To Book Your Flight - Please register below </h4>
 	
 			First Name<input type="text" id="firstName"name="firstName" placeholder="First Name" required><br>
 			Last Name <input type="text" id="lastName"name="lastName" placeholder="Last Name" required><br>
			e-mail Id <input type="email" id="emailId"name="emailId" placeholder="example@gmail.com" required><br>
			Phone No  <input type="text" id="phoneNo"name="phoneNo" placeholder="Phone No" required><br>
			Password  <input type="password" id="password" name="password" placeholder="password" required><br><br>
			<button type="submit">Register & Pay </button> &nbsp;
			<a href="${pageContext.request.contextPath}/">Cancel</a> <br>
		</form>	
		
 	</div>
</body>
</html>