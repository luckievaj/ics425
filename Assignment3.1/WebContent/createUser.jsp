<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
	<center>
		<h1>Create a New User</h1>
		<form action="UserServlet" method="post">
			<p>
				First:<input type="text" name="firstName" value="${user.firstName}" />
			</p>
			<p>
				Last:<input type="text" name="lastName" value="${user.lastName}" />
			</p>
			<p>
				User Name:<input type="text" name="userName"
					value="${user.userName}" />
			</p>

			<input type="submit" name="create" value="Create" /> <input
				type="submit" name="cancel" value="Cancel" />
		</form>
	</center>
</body>
</html>