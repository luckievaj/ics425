<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,com.abc.model.User,com.abc.model.Address,com.abc.service.CustomerService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Users</title>
</head>
<body>
	<%
		List<User> user = (List<User>) request.getAttribute("user");
		if (null == user) {
			user = UserService.getAllUsers();
		}
	%>
	<h1>List of Users</h1>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>User Name</td>

			<%
				for (User user : user) {
			%>
		
		<tr>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getLastName()%></td>
			<td><%=user.getUserName()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		<a href="createUser.jsp">Click here to add a customer</a>
	</p>
</body>
</html>