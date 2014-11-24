<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.abc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credentials</title>
</head>
<body>
	<h2>Name</h2>
		<p>${person.firstName} ${person.lastName}</p>
	<h2>Address</h2>
    	<p>Street: ${address.street}</p>
    	<p>City:${address.city}</p>
    	<p>State: ${address.state}</p>
    	<p>Zip code: ${address.zipCode}</p>
		<p>Email Address: ${address.email}</p>
		<p>Phone Number: ${address.phone}</p>
	<form action="CredentialsServlet" method="post">
		<p>Username:<input type="text" name="username" value="${credentials.username }"/></p>
		<p>Password:<input type="password" name="password" value="${credentials.password }"/></p>
		<input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
	</form>
	
</body>
</html>