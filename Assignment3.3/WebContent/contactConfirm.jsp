<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Confirm Page</title>
</head>
<body>
		<h1>New Contact details Confirmation</h1>
		<h2>Name</h2>
		<p>First Name: ${contactName.firstName }</p>
		<p>Last Name: ${contactName.lastName }</p>
		
		<h2>Address</h2>
		<p>Street: ${address.street}</p>
		<p>City:${address.city}</p>
		<p>State: ${address.state}</p>
		<p>Zip Code: ${address.zipCode}</p>
		<p>Phone 1: ${phone.phone1}</p>
		<p>Phone 2: ${phone.phone2}</p>
		<p>Email 1: ${email.email1}</p>
		<p>Email 2: ${email.email2}</p>
		<h2>Credentials</h2>
		<p>Anniversary 1: ${credentials.annDate1}</p>
		<p>Description: ${credentials.annDesc1}</p>
		<p>Anniversary 2: ${credentials.annDate2}</p>
		<p>Description: ${credentials.annDesc2}</p>
		<p>Anniversary 3: ${credentials.annDate3}</p>
		<p>Description: ${credentials.annDesc3}</p>
<form>
 		<input type="submit" name="previous" value="Previous" /> 
 		<input type="submit" name="confirm" value="Confirm" /> 
		<input type="submit" name="cancel" value="Cancel" />
</form>	

<!-- 
		<button onclick="location.href = 'credentials.jsp';" id="backBtn">Back</button>
		<button onclick="location.href = 'contactViewAll.jsp';"
			id="submitBtn">Submit</button>
		<button onclick="location.href = 'index.jsp';" id="cancelBtn">Cancel</button>
		
 -->		
</body>
</html>