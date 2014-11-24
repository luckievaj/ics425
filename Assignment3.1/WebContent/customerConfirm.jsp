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
	<h1>New Customer details Confirmation</h1>
	<h2>Name</h2>
	<p>${cust.lastName},${cust.firstName}</p>
	<h2>Address</h2>
	<p>Street: ${add.street}</p>
	<p>City:${add.city}</p>
	<p>State: ${add.state}</p>
	<p>Zip Code: ${add.zipCode}</p>
	<p>Phone 1: ${phn.phone1}</p>
	<p>Phone 2: ${phn.phone2}</p>
	<p>Email 1: ${eml.email1}</p>
	<p>Email 2: ${eml.email2}</p>
	<h2>Credentials</h2>
	<p>Anniversary 1: ${cred.annDate1} : ${cred.annDesc1}</p>
	<p>Anniversary 2: ${cred.annDate2} : ${cred.annDesc2}</p>
	<p>Anniversary 3: ${cred.annDate3} : ${cred.annDesc3}</p>

	<%
	/* 	//	Pass the variables via the "customer" object to the method persistCustomer()
		customer.setFirstName((String) request.getParameter("firstName"));
		customer.setLastName((String) request.getParameter("lastName"));
		phone.setPhone1((String) request.getParameter("phone1"));
		phone.setPhone2((String) request.getParameter("phone2"));
		email.setEmail1((String) request.getParameter("email1"));
		email.setEmail2((String) request.getParameter("email2"));		
        cred.setAnnDate1((String)request.getParameter("annDate1"));
        cred.setAnnDesc1((String)request.getParameter("annDesc1"));
        cred.setAnnDate2((String)request.getParameter("annDate2"));
        cred.setAnnDesc2((String)request.getParameter("annDesc2"));
        cred.setAnnDate3((String)request.getParameter("annDate3"));
        cred.setAnnDesc3((String)request.getParameter("annDesc3"));            
        
        Customer customer = new Customer();
		CustomerService.persistCustomer(customer);

		request.setAttribute("customer", CustomerService.getAllCustomers()); */
		
	%>
	<button onclick="location.href = 'customerCredentials.jsp';"
		id="backBtn">Back</button>
	<button onclick="location.href = 'customerViewAll.jsp';" id="submitBtn">Submit</button>
	<button onclick="location.href = 'index.jsp';" id="cancelBtn">Cancel</button>


</body>
</html>