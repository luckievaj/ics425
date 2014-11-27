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
<title>Name Input</title>
</head>
<body>
  
    <form method="POST" action='ContactNameServlet' name="AddName">
    <p style="color:red">${message}</p>
    	Contact ID : <input type= "text" readonly = "readonly" name="contactId"
    		value="<c:out value="${contact.contactId}" />" /> <br />
        First Name : <input type="text" name="firstName"
            value="<c:out value="${contactName.firstName}" />" /> <br /> 
        Last Name : <input type="text" name="lastName"
            value="<c:out value="${contactName.lastName}" />" /> <br /> 
                          
     <input type="submit" name="next" value="Next" />
     <input type="submit" name="cancel" value="Cancel" />
    </form>
</body>
</html>