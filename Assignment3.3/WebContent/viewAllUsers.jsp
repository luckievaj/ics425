<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page
	import="java.util.List,com.abc.model.User,com.abc.model.Address,com.abc.dao.UserService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>View All Users</title>
</head>

<body>
	<center>
		<h1>List of All Users</h1>
		<%
			List<User> users = (List<User>) request.getAttribute("users");
			if (null == users) {

				users = UserService.getAllUsers();

			}
		%>
		<table>
			<tr>
				<td>User ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>User Name</td>

				<%
					for (User usr : users) {
				%>
			
			<tr>
				<td><%=usr.getUserid()%></td>
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
		<button onclick="location.href = 'user.jsp';" id="userCreate"
			class="float-left submit-button">Create a New User</button>
	</center>
</body>
</html>