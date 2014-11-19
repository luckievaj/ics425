<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address</title>
</head>
<body>
	<%-- 	<h1>Name</h1>
	<p>${person.firstName}${person.lastName}</p> --%>
	<h2>Enter Address</h2>
	<form action="AddressServlet" method="post">
		<p>
			Street:<input type="text" name="street" value="${address.street}" />
		</p>
		<p>
			City:<input type="text" name="city" value="${address.city}" />
		</p>
		<p>
			State: <input type="text" name="state" value="${address.state}" />
		</p>
		<p>
			Zip Code:<input type="text" name="zipCode" value="${address.zipCode}" />
		</p>
		<input type="submit" name="next" value="Next" /> <input type="submit"
			name="previous" value="Previous" /> <input type="submit"
			name="cancel" value="Cancel" />
	</form>
</body>
</html>