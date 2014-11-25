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
		<h1>Database Management Console 2222</h1>


		<form action="viewAllUsers.jsp" method="post">
			<br /> <br /> <input type="submit" value="View All Users">
		</form>
		<form action="user.jsp" method="post">
			<br /> <br /> <input type="submit" value="Create a New User">
		</form>
		<!--  <p><a href="UserController?action=insert">Add User</a></p> HAS IT IN THE EXAMPLE WHERE THE PAGE SAYS ACTION=INSERT--> 
		<form action="contactViewAll.jsp" method="post">
			<br /> <br /> <input type="submit" value="View All Contacts">
		</form>
		<form action="contactName.jsp" method="post">
			<br /> <br /> <input type="submit" value="Create a New Contact">
		</form>

	</center>
</body>
</html>