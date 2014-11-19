<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email</title>
</head>
<body>
	<%-- 	<h1>Name</h1>
	<p>${person.firstName}${person.lastName}</p> --%>
	<h2>Enter Email</h2>
	<form action="EmailServlet" method="post">
		<p>
			Email Address 1:<input type="text" name="email1"
				value="${email.email1}" />
		</p>
		<p>
			Email Address 2:<input type="text" name="email2"
				value="${email.email2}" />
		</p>
		<input type="submit" name="next" value="Next" /> <input type="submit"
			name="previous" value="Previous" /> <input type="submit"
			name="cancel" value="Cancel" />
	</form>
</body>
</html>