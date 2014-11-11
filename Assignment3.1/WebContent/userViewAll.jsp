<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,com.abc.model.User,com.abc.model.Address,com.abc.service.UserService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Users</title>
</head>
<body>
	<center>
		<h1>List of All Users</h1>
		<%
			List<User> user = (List<User>) request.getAttribute("user");
			if (null == user) {
				user = UserService.getAllUsers();
			}
		%>
		<table>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>User Name</td>

				<%
					for (User usr : user) {
				%>
			
			<tr>
				<td><%=usr.getFirstName()%></td>
				<td><%=usr.getLastName()%></td>
				<td><%=usr.getUserName()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<button onclick="location.href = 'index.jsp';" id="home"
			class="float-left submit-button">Home</button>
		<button onclick="location.href = 'userCreate.jsp';" id="userCreate"
			class="float-left submit-button">Create a New User</button>

	</center>
</body>
</html>