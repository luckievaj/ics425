<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Address Input</title>
</head>
<body>
	<h1>Name</h1>
		<p>First Name: ${contactName.firstName } </p>
		<p>Last Name: ${contactName.lastName } </p>
		
		
  
    <form method="POST" action='AddressServlet' name="AddAddress">
        Street : <input type="text" name="street"
            value="<c:out value="${address.street}" />" /> <br /> 
        City : <input type="text" name="city"
            value="<c:out value="${address.city}" />" /> <br /> 
        State : <input type="text" name="state"
            value="<c:out value="${address.state}" />" /> <br /> 
        Zip Code : <input type="text" name="zipCode"
            value="<c:out value="${address.zipCode}" />" /> <br /> 
        
            
        <input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
    </form>
</body>
</html>