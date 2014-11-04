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
				<td>Email</td>
				<td>Street</td>
				<td>City</td>
				<td>State</td>
				<td>Zip Code</td>
				<td>Phone 1</td>
				<td>Phone 2</td>
				<td>Email 1</td>
				<td>Email 2</td>
				<td>Anniversary Date 1</td>
				<td>Anniversary Description 1</td>
				<td>Anniversary Date 2</td>
				<td>Anniversary Description 2</td>
				<td>Anniversary Date 3</td>
				<td>Anniversary Description 3</td>

			</tr>
			<%
				for (Customer cust : customers) {
			%>
			<tr>
				<td><%=cust.getFirstName()%></td>
				<td><%=cust.getLastName()%></td>
				<td><%=cust.getAddress().getEmail1()%></td>
				<td><%=cust.getAddress().getEmail2()%></td>
				<td><%=cust.getAddress().getPhone1()%></td>
				<td><%=cust.getAddress().getPhone2()%></td>
				<td><%=cust.getAddress().getStreet()%></td>
				<td><%=cust.getAddress().getCity()%></td>
				<td><%=cust.getAddress().getState()%></td>
				<td><%=cust.getAddress().getZipCode()%></td>
				<td><%=cust.getAddress().getPhone1()%></td>
				<td><%=cust.getAddress().getPhone2()%></td>
				<td><%=cust.getAddress().getEmail1()%></td>
				<td><%=cust.getAddress().getEmail2()%></td>
				<td><%=cust.getCredentials().getAnn_Date1()%></td>
				<td><%=cust.getCredentials().getAnn_Desc1()%></td>
				<td><%=cust.getCredentials().getAnn_Date2()%></td>
				<td><%=cust.getCredentials().getAnn_Desc2()%></td>
				<td><%=cust.getCredentials().getAnn_Date3()%></td>
				<td><%=cust.getCredentials().getAnn_Desc3()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<a href="customer.jsp">Click here to add a customer</a>
		</p>
	</center>
</body>
</html>