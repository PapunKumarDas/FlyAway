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
<h2>Admin Maintenance module</h2>
<div>

	
 		<form action="insert" method ="post" > 
 			<select name="placeId">
        		<c:forEach items="${places}" var="place">
            		<option value="${place.placeId}">${place.sourceCity}</option>
        		</c:forEach>
    		</select>
    		
    		 <select name="placeId">
        		<c:forEach items="${places}" var="place">
            		<option value="${place.placeId}">${place.destinationCity}</option>
        		</c:forEach>
    		</select>
    		
	<!-- 		<input type="text" id="fromCity"name="fromCity" placeholder="From City" required>
			<input type="text" id="toCity"name="toCity" placeholder="To City" required>
	 -->		
			<select name="airlineId">
        		<c:forEach items="${airlines}" var="airline">
            		<option value="${airline.airlineId}">${airline.code}</option>
        		</c:forEach>
    		</select>
			<!-- <input type="text" id="airline"name="airline" placeholder="Airline" required> -->
			<input type="date" id="fromDate"name="fromDate" placeholder="From Date" required>
			<input type="date" id="toDate"name="toDate" placeholder="To Date" required>
			<input type="text" id="price" name="price" placeholder="price" required><br>

			<button type="submit">Add</button> &nbsp;&nbsp;&nbsp;
			
<%-- 			<a href="${pageContext.request.contextPath}/airlines">Airlines</a> &nbsp;
			<a href="${pageContext.request.contextPath}/places">Places</a>  --%>
			
			<a href="${pageContext.request.contextPath}/">Home</a> <br>
		</form>	
		
		<div>
		<form action="" method="post" > 
		<table>
		  <tr>
		  	<th>Route Id</th>
		    <th>From City</th>
		    <th>To City</th>
		    <th>Airline</th>
		    <th>From Date </th>
		    <th>To Date </th>
		    <th>Price</th>
		    <th>Action</th>
		  </tr>
		  <c:forEach items="${routes}" var="route">
		    <tr>
		      <td>${route.routeId}</td>
		      <td>${route.fromCity}</td>
		      <td>${route.toCity}</td>
		      <td>${route.airline}</td>
		      <td>${route.fromDate}</td>
		      <td>${route.toDate}</td>
		      <td>&#8377;${route.price}</td>
		      <td><a href="edit?routeId=<c:out   value='${route.routeId}'/>">Edit</a></td>    
		      <td><a href="delete?routeId=<c:out value='${route.routeId}'/>">Delete</a></td>		       
		    </tr>
		  </c:forEach>
		</table>
		</form>
		</div>
 	</div>
</body>
</html>