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

	<div>
 		<form action="${pageContext.request.contextPath }/password-process" method ="post"> 
 			UserId &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 			<input type="text" id="userName"name="userName" placeholder="User ID" required><br>
			Current Password <input type="password" id="oldPassword"name="oldPassword" placeholder="Current Password" required><br>
			New Password &nbsp&nbsp&nbsp&nbsp<input type="password" id="newPassword"name="newPassword" placeholder="New Password" required><br>
			<button type="submit">Change</button> &nbsp;
			<a href="${pageContext.request.contextPath}/">Cancel</a> <br>
		</form>	
 	</div>
</body>
</html>