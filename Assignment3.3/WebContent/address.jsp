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
		<p>${name.firstName } ${name.lastName }</p>
  
    <form method="POST" action='AddressServlet' name="AddAddress">
        Street : <input type="text" name="street"
            value="<c:out value="${add.street}" />" /> <br /> 
        City : <input type="text" name="city"
            value="<c:out value="${add.city}" />" /> <br /> 
        State : <input type="text" name="state"
            value="<c:out value="${add.state}" />" /> <br /> 
        Zip Code : <input type="text" name="zipCode"
            value="<c:out value="${add.zipCode}" />" /> <br /> 
        Phone 1: <input type="text" name="phone1"
            value="<c:out value="${add.phone1}" />" /> <br /> 
        Phone 2: <input type="text" name="phone2"
            value="<c:out value="${add.phone2}" />" /> <br /> 
        Email 1: <input type="text" name="email1"
            value="<c:out value="${add.email1}" />" /> <br />
        Email 2: <input type="text" name="email2"
            value="<c:out value="${add.email2}" />" /> <br /> 
            
        <input type="submit" name="next" value="Next" />
	    <input type="submit" name="previous" value="Previous" />
	    <input type="submit" name="cancel" value="Cancel" />
    </form>
</body>
</html>