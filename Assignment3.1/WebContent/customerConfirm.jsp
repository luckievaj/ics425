<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
	<center>
		<h1>New Customer details Confirmation</h1>
		<h2>Name</h2>
		<p>${customer.firstName}${customer.lastName}</p>

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
		<p>Anniversary 1: ${cred.ann_date1 }${cred.ann_desc1 }</p>
		<p>Anniversary 2: ${cred.ann_date2 }${cred.ann_desc2 }</p>
		<p>Anniversary 3: ${cred.ann_date3 }${cred.ann_desc3 }</p>

	</center>
	<%
		session.invalidate();
	%>

	<button onclick="location.href = 'index.jsp';" id="homeButton"
		class="float-left submit-button">Home</button>
	<button onclick="location.href = 'customerViewAll.jsp';" id="cviewButton"
		class="float-left submit-button">View All Customers</button>

</body>
</html>