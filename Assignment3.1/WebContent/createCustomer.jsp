<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Name</title>
</head>
<body>
	<center>
		<h1>Create a New Customer</h1>

		<form action="CustomerServlet" method="post">
			<p>
				First Name:<input type="text" name="firstName"
					value="${cust.firstName}" />
			</p>
			<p>
				Last Name:<input type="text" name="lastName" value="${cust.lastName}" />
			</p>

			<input type="submit" name="next" value="Next" /> <input
				type="submit" name="cancel" value="Cancel" />
		</form>
	</center>

</body>
</html>