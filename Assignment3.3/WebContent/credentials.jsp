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
		<p>First Name: ${cName.firstName } </p>
		<p>Last Name: ${cName.lastName } </p>
		
	<h2>Address</h2>
    	<p>Street: ${address.street}</p>
    	<p>City:${address.city}</p>
    	<p>State: ${address.state}</p>
    	<p>Zip code: ${address.zipCode}</p>
    <h2>Phone</h2>
		<p>Phone Number 1: ${phone.phone1}</p>
		<p>Phone Number 2: ${phone.phone2}</p>
    <h2>Email</h2>
  		<p>Email Address 1: ${email.email1}</p>
		<p>Email Address 2: ${email.email2}</p>
	
		
	<form action="CredentialsServlet" method="post">
		<p>
			Anniversary Date:<input type="text" name="annDate1"
				value="${cred.AnnDate1}" /></p>
		<p>
			Anniversary Description:<input type="text" name="annDesc1"
				value="${cred.AnnDesc1}" /></p>
		<p>
			Anniversary Date:<input type="text" name="annDate2"
				value="${cred.AnnDate2}" /></p>
		<p>
			Anniversary Description:<input type="text" name="annDesc2"
				value="${cred.AnnDesc2}" /></p>
		<p>
			Anniversary Date:<input type="text" name="annDate3"
				value="${cred.AnnDate3}" /></p>
		<p>
			Anniversary Description:<input type="text" name="annDesc3"
				value="${cred.AnnDesc3}" /></p>

		<input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
	</form>
	
</body>
</html>