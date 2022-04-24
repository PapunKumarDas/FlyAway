<html>
<%@include file="./commonstyles.jsp" %>

<body>
	<h1>Flyaway - Your well deserved vacation a click away</h1>
	<div>
		<a href="${pageContext.request.contextPath}/admin">Admin</a> 
	</div>
	<br> 
	<br>

	<div>
 		<form action="search" method ="post"> 
 		
			<input type="text" id="fromCity"name="fromCity" 	placeholder="From City">
			<input type="text" id="toCity" 	name="toCity" 		placeholder="To City">
			<input type="text" id="airline" name="airline" 		placeholder="Airline">
			<input type="date" id="travelDate"name="travelDate" placeholder="Travel Date">
			
			<button type="submit">Search</button> &nbsp;
		</form>	
		
	</div>
	<div>
		<form action="" method="post" > 
		<table>
		  <tr>
		  	<th>Route Id</th>
		    <th>From City</th>
		    <th>To City</th>
		    <th>Airline</th>
		      <th>Price</th>
		    <th>Action</th>
		  </tr>
		  <c:forEach items="${routes}" var="route">
		    <tr>
		      <td>${route.routeId}</td>
		      <td>${route.fromCity}</td>
		      <td>${route.toCity}</td>
		      <td>${route.airline}</td>
		      <td>&#8377;${route.price}</td>
		      <td><a href="book?routeId=<c:out   value='${route.routeId}'/>">Book</a></td>    	       
		    </tr>
		  </c:forEach>
		</table>
		</form>
	</div>
	
<body>
</html>