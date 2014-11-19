<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	jstl/core web add jstl jar plays well with expressions
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

	<script type="text/javascript">
		function editCustomer(cid) {
			url = "customerEdit";
			window.location.href = "http://localhost:8086/Assignment3.1/" + url
					+ "?cid" + id;
		}
	</script>
	<center>
		<h1>List of All Customers</h1>
		<%
			List<Customer> customers = (List<Customer>) request
					.getAttribute("custList");
			if (null == customers) {
				customers = CustomerService.getAllCustomers();
			}
		%>
		<table>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>

			</tr>
			<%
				for (Customer cust : customers) {
			%>
			<tr>
				<td><input type="hidden" value=<%=cust.getCustomerID()%>></td>
				<td><%=cust.getFirstName()%></td>
				<td><%=cust.getLastName()%></td>

				<!-- New code -->

				<%-- 				<td><input type="submit" value="Edit" name="edit" onclick="editCustomer(<%=cust.getCustomerID() %>);"></td>
				<td><input type="submit" value="Delete" name="delete" onclick="deleteCustomer(<%=cust.getCustomerID() %>);"></td>
				 --%>
				<!-- Original code -->

				<td><form action="customerDetail.jsp" method="post">
						<input type="hidden" value="${customer.customerId }"> 
						<input type="submit" value="View">
					</form></td>
				<td><form action="customerEdit.jsp" method="post">
						<input type="hidden" value="${customer.customerId }"> 
						<input type="submit" value="Edit">
					</form></td>
				<td><form action="customerDelete.jsp" method="post">
						<input type="hidden" value="${customer.customerId }"> 
						<input type="submit" value="Delete">
					</form></td>
			</tr>
			<%-- value=<%= cust.getCustomerID %> --%>
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
		<!-- 		<p>
			<a href="customerCreate.jsp">Click here to add a customer</a>
		</p> -->
		<!-- <button onclick="location.href = 'index.jsp';" id="homeButton">Home</button>
		<button onclick="location.href = 'customerCreate.jsp';"id="ccreateButton">Create a New Customers</button> -->
	</center>
</body>
</html>