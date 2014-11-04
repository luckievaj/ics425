<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, com.abc.model.Customer, com.abc.model.Address, com.abc.service.CustomerService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 4</title>
</head>
<body>
	<%
		List<Customer> customers = (List<Customer>) request
				.getAttribute("customers");
		if (null == customers) {
			customers = CustomerService.getAllCustomers();
		}
	%>
	<h1>Listing of Customers</h1>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Street</td>
			<td>City</td>
			<td>State</td>
			<td>Zip</td>
		</tr>
		<%
			for (Customer cust : customers) {
		%>
		<tr>
			<td><%=cust.getFirstName()%></td>
			<td><%=cust.getLastName()%></td>
			<td><%=cust.getEmailAddress()%></td>
			<td><%=cust.getAddress().getStreet()%></td>
			<td><%=cust.getAddress().getCity()%></td>
			<td><%=cust.getAddress().getState()%></td>
			<td><%=cust.getAddress().getZip()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		<a href="CreateCustomer.html">Click here to add a customer</a>
	</p>
</body>
</html>