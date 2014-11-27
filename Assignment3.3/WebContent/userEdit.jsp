<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User Details</title>
</head>
<body>
	<form method="POST" action='UserController' name="frmAddUser">
		<p style="color: red">${message}</p>
		User ID : <input type="text" readonly name="userid"
			value="<c:out value="${user.userid}" />" /> <br /> 
		First Name : <input type="text" name="firstName"
			value="<c:out value="${user.firstName}" />" /> <br /> 
		Last Name : <input type="text" name="lastName"
			value="<c:out value="${user.lastName}" />" /> <br /> 
		Username : <input type="text" name="userName"
			value="<c:out value="${user.userName}" />" /> <br /> 
			
		<input type="submit" value="Submit" />
		<input type="submit" value="Cancel" />
		
	</form>
</body>
</html>