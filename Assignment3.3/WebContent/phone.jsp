<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.abc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone Input</title>
</head>
<body>
	<h2>Name</h2>
		<p>First Name: ${cName.firstName } </p>
		<p>Last Name: ${cName.lastName } </p>
		
	<h2>Address</h2>
    	<p>Street: ${address.street}</p>
    	<p>City:${address.city}</p>
    	<p>State: ${address.state}</p>
    	<p>Zip code: ${address.zipCode}</p>
    	
    	<form action="PhoneServlet" method="post">
		<p>Phone 1:<input type="text" name="phone1" value="${phone.phone1 }"/></p>
		<p>Phone 2:<input type="text" name="phone2" value="${phone.phone2 }"/></p>
		<input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
	</form>
	
</body>
</html>