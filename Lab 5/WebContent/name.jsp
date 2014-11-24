<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ics425.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<title>Name</title>
</head>
<body>
    <form action="NameServlet" method="post">
        <p style="color:red">${message}</p>
        <p>First:<input type="text" name="firstName" value="${person.firstName}" /></p>
        <p>Last:<input type="text" name="lastName" value="${person.lastName}" /></p>
                
        <input type="submit" name="next" value="Next" />
        <input type="submit" name="cancel" value="Cancel" />        
    </form>
</body>
</html>
