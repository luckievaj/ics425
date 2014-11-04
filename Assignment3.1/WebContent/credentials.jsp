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
		<p>Email Address 1: ${address.email1}</p>
		<p>Email Address 2: ${address.email2}</p>
		<p>Phone Number 1: ${address.phone1}</p>		
		<p>Phone Number 2: ${address.phone2}</p>
	<form action="CredentialsServlet" method="post">
		<p>Anniversary Date:<input type="text" name="ann_date1" value="${credentials.ann_date1 }"/></p>
		<p>Anniversary Description:<input type="text" name="ann_desc1" value="${credentials.ann_desc1 }"/></p>
		<p>Anniversary Date:<input type="text" name="ann_date2" value="${credentials.ann_date2 }"/></p>
		<p>Anniversary Description:<input type="text" name="ann_desc2" value="${credentials.ann_desc2 }"/></p>
		<p>Anniversary Date:<input type="text" name="ann_date3" value="${credentials.ann_date3 }"/></p>
		<p>Anniversary Description:<input type="text" name="ann_desc3" value="${credentials.ann_desc3 }"/></p>
		
		<input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
	</form>
	
</body>
</html>