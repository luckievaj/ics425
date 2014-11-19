<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Customer</title>
</head>
<body>
	<form action="EditServlet" method="post">
		<h2>Edit Customer</h2>
		<table>
				<%ResultSet res = (ResultSet) request.getAttribute("EditCust");%>
				<%if(res.next()){%>

				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"
						value=<%res.getString("firstName");%>></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"
						value=<%res.getString("lastName");%>></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="Update" name="update"></td>
				</tr>
			<%
				}
			%>
		</table>

	</form>
</body>
</html>