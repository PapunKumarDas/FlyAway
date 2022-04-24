<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<style>
	h1  {text-align: center;}
	h2  {text-align: center;}
	h3  {text-align: right; STYLE="background-color:red;"}
	h4  {text-align: center;STYLE="color:Tomato;"}
	p 	{text-align: center;}
	div {text-align: center;}
	form{text-align: center;}
	table {
  		font-family: arial, sans-serif;
  		border-collapse: collapse;
  		width: 100%;
	}
	td, th {
 	 	border: 1px solid #dddddd;
 	 	text-align: left;
  		padding: 8px;
	}

	tr:nth-child(even) {
  	background-color: #dddddd;
	}
</style>

<title><c:out value="${title}">Flyaway Home</c:out></title>
<h3 STYLE="background-color:red;"> <c:out value="${error}"></c:out> </h3>
<h3 STYLE="background-color:lightblue;"> <c:out value="${info}"></c:out> </h3>
<h3 STYLE="background-color:yellow;"> <c:out value="${warn}"></c:out> </h3>

<body>
 <body style="background-color:lightblue;">
</body>
</html>