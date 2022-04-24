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
 		<form action="${pageContext.request.contextPath }/admin-process" method ="post"> 
			User Name<input type="text" id="userName"name="userName" placeholder="admin" required><br>
			Password &nbsp;&nbsp;<input type="password" id="password" name="password" placeholder="admin" required><br><br>
			<button type="submit">Login</button> &nbsp;
			<a href="${pageContext.request.contextPath}/changePwd">Change Password </a> &nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/">Cancel</a> <br>
		</form>	
 	</div>
</body>
</html>