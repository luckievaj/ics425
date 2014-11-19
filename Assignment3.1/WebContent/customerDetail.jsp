<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, java.util.Iterator, com.abc.model.Customer, com.abc.model.Address, com.abc.service.CustomerService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	<center>
		<h1>Customer Details</h1>
<script>




</script>
		<table>
			<%
				Iterator itr;
			%>
			<%
				List data= (List) request.getAttribute("custDetail");
				for (itr = data.iterator(); itr.hasNext();){
					%>
			<tr>
				<%
					String s = (String) itr.next();
				%>
				<td><%=s%></td>
				<td><%=itr.next()%></td>
				<td><%=itr.next()%></td>
				<td><input type="submit" value="View" name="view"
					onClick="viewCustomer(<%=s%>):"></td>
				<td><input type="edit" value="Edit" name="edit"
					onClick="editCustomer(<%=s%>):"></td>
				<td><input type="delete" value="Delete" name="delete"
					onClick="deleteCustomer(<%=s%>):"></td>

				<%-- value=<%= cust.getCustomerID %> //hint on how to pass customerID--%>
				<%
					}
				%>
			</tr>

		</table>

		<!--Old Code
				//how to identify which user you're passing thorough. 
				//link with customer variables  - getContactID to pass id to each button (edit, view, delete)
				
				//edit by turning these to input 
				
				//delete ps. execute update
				//utilize table joins and remember to delete foreign key  from join tables first, then use that 
				reference to delete the secondary table. customer is eventually last.

			<p>
				<button onclick="location.href = 'index.jsp';" id="homeButton"
					class="float-left submit-button">Home</button>
				<button onclick="location.href = 'customerCreate.jsp';"
					id="ccreateButton" class="float-left submit-button">Create
					a New Customers</button>
			</p> -->
		</form>
	</center>
</body>
</html>