<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.abc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
	<h2>Name</h2>
	<p>${person.firstName} ${person.lastName}</p>
<h2>Address</h2>
    <p>Street: ${address.street}</p>
    <p>City:${address.city}</p>
    <p>State: ${address.state}</p>
    <p>Zip code: ${address.zipCode}</p>
<h2>Credentials</h2>
	<p>Username: ${credentials.username }</p>
	<p>Password: ${credentials.password}</p>
	
	<% session.invalidate(); %>
</body>
</html>