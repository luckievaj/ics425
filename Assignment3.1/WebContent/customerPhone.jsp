<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone</title>
</head>
<body>
	<%-- 	<h1>Name</h1>
	<p>${person.firstName}${person.lastName}</p> --%>
	<h2>Enter Phone Numbers</h2>
	<form action="PhoneServlet" method="post">
		<p>
			Phone Number 1:<input type="text" name="phone1"
				value="${phn.phone1}" />
		</p>
		<p>
			Phone Number 2:<input type="text" name="phone2"
				value="${phn.phone2}" />
		</p>
		<input type="submit" name="next" value="Next" /> <input type="submit"
			name="previous" value="Previous" /> <input type="submit"
			name="cancel" value="Cancel" />
	</form>
</body>
</html>