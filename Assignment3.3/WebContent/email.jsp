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
<title>Email Input</title>
</head>
<body>
	<h2>Name</h2>
		<p>First Name: ${contactName.firstName } </p>
		<p>Last Name: ${contactName.lastName } </p>
	
	<h2>Address</h2>
    	<p>Street: ${address.street}</p>
    	<p>City:${address.city}</p>
    	<p>State: ${address.state}</p>
    	<p>Zip code: ${address.zipCode}</p>
    <h2>Phone</h2>
  		<p>Phone 1: ${phone.phone1}</p>
  		<p>Phone 2: ${phone.phone2}</p>
  		 
    <form method="POST" action='EmailServlet' name="AddEmail">
       <p> Email 1 : <input type="text" name="email1"
            value="<c:out value="${email.email1}" />" /> </p> 
        <p>Email 2 : <input type="text" name="email2"
            value="<c:out value="${email.email2}" />" /> </p> 
                    
        <input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
    </form>
</body>
</html>