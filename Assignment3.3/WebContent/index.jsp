<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<center>
		<h1>Database Management Console</h1>


		<form action="userViewAll.jsp" method="post">
			<br /> <br /> <input type="submit" value="View All Users">
		</form>
		<form action="userCreate.jsp" method="post">
			<br /> <br /> <input type="submit" value="Create a New User">
		</form>
		<form action="customerViewAll.jsp" method="post">
			<br /> <br /> <input type="submit" value="View All Customers">
		</form>
		<form action="customerCreate.jsp" method="post">
			<br /> <br /> <input type="submit" value="Create a New Customer">
		</form>

	</center>
	</form>
</body>
</html>