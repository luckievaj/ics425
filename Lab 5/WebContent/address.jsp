<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ics425.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<title>Address</title>
</head>
<body>
	<h1>Name</h1>
	<p>${person.firstName} ${person.lastName}</p>
	<h2>Enter Address</h2>
	<p style="color:red">${message}</p>
	<form action="AddressServlet" method="post">
	    <p>Street:<input type="text" name="street" value="${address.street}" /></p>
	    <p>City:<input type="text" name="city" value="${address.city}" /></p>
	    <p>State:<input type="text" name="state" value="${address.state}" /></p>
	    <p>Zip code:<input type="text" name="zipCode" value="${address.zipCode}" /></p>
	    <input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
	</form>    
</body>
</html>
	    
