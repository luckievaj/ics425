<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
	<h2>New user has been successfully created.</h2>
	<p>Name: ${user.firstName} ${user.lastName}</p>
	<p>Username: ${user.userName }</p>

	<%
/* 		session.invalidate();
 */	%>

	<button onclick="location.href = 'index.jsp';" id="homeButton"
		class="float-left submit-button">Home</button>
	<button onclick="location.href = 'userViewAll.jsp';" id="uviewButton"
		class="float-left submit-button">View All Users</button>


</body>
</html>