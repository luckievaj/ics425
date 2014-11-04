<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.abc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Name</title>
</head>
<body>
	<form action="CustomerServlet" method="post">
        <p>First:<input type="text" name="firstName" value="${person.firstName}" /></p>
        <p>Last:<input type="text" name="lastName" value="${person.lastName}" /></p>
                
        <input type="submit" name="next" value="Next" />
        <input type="submit" name="cancel" value="Cancel" />        
    </form>
	
</body>
</html>