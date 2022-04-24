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
 		<form> 
 			<h4 style="color:Tomato;"> Congratulations Booking confirmed  </h4><br><br>
 			
 			<h4> Hello ${customer.firstName} ${customer.lastName}  </h4><br>
			
			<h4 style="color:Tomato;"> Your Flight Details <br>
 				From ${routes.fromCity}<br>
 			  	  To ${routes.toCity}<br>
 			  	  by ${routes.airline}v
 			      cost ${routes .price}<br><br>
			 </h4>
			 
			<a href="${pageContext.request.contextPath}/">Home</a> <br>
		</form>	
		
 	</div>
</body>
</html>