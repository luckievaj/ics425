<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, com.abc.model.Customer, com.abc.model.Address, com.abc.service.CustomerService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Customers</title>
</head>
<body>
	<center>
		<h1>List of All Customers</h1>
		<%
			List<Customer> customers = (List<Customer>) request
					.getAttribute("customers");
			if (null == customers) {
				customers = CustomerService.getAllCustomers();
			}
		%>
		<table>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Edit Customer Options</td>

			</tr>
			<%
				for (Customer cust : customers) {
			%>
			<tr>
				<td><%=cust.getFirstName()%></td>
				<td><%=cust.getLastName()%></td>
				<td><form action="viewCustomer.jsp" method="post"><input type="submit" value="View"></form></td>
				<td><form action="editCustomer.jsp" method="post"><input type="submit" value="Edit"></form></td>
				<td><form action="deleteCustomer.jsp" method="post"><input type="submit" value="Delete"></form></td>
			</tr>
			<%
				}
			%>
		</table>
		<!--	//how to identify which user you're passing thorough. 
				//link with customer variables  - getContactID to pass id to each button (edit, view, delete)
				
				//edit by turning these to input 
				
				//delete ps. execute update
				//utilize table joins and remember to delete foreign key  from join tables first, then use that reference to delete the secondary table. customer is eventualy last. 
			  -->
		<p>
			<a href="createCustomer.jsp">Click here to add a customer</a>
		</p>
	</center>
</body>
</html>