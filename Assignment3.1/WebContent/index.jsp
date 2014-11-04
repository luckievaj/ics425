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


		<form action="viewAllUsers.jsp" method="post">
			<br />
			<!-- 			<h2>Please click on the Create button.</h2>
 -->
			<br /> <input type="submit" value="View All Users">
		</form>
		<form action="createUser.jsp" method="post">
			<br />
			<!-- 			<h2>Please click on the Create button.</h2>
 -->
			<br /> <input type="submit" value="Create a New User">
		</form>
		<form action="viewAllCustomers.jsp" method="post">
			<br />
			<!-- 			<h2>Please click on the Create button.</h2>
 -->
			<br /> <input type="submit" value="View All Customers">
		</form>
		<form action="customer.jsp" method="post">
			<br />
			<!-- 			<h2>Please click on the Create button.</h2>
 -->
			<br /> <input type="submit" value="Create a New Customer">
		</form>

		<!-- <form method="get">
		<button type="button"
			onclick="viewAllUsers.jsp">View All Users</button>
			<button type="button"
			onclick="createUser.jsp">Create a new User</button>
			<button type="button"
			onclick="viewAllCustomer.jsp">View All Customers</button>
			<button type="button"
			onclick="name.jsp">Create a new Customer</button> -->
	</center>
	</form>
</body>
</html>