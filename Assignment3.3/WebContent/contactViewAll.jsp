<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Contacts</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Contact Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Phone 1</th>
                <th>Phone 2</th>
                <th>Email 1</th>
                <th>Email 2</th>
                <th>Anniversary 1</th>
                <th>Description</th>
                <th>Anniversary 2</th>
                <th>Description</th>
                <th>Anniversary 3</th>
                <th>Description</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
          
            
                <tr>
                    <td><c:out value="${contactName.contactId}" /></td>
                    <td><c:out value="${contactName.firstName}" /></td>
                    <td><c:out value="${contactName.lastName}" /></td>
                    <td><c:out value="${address.street}" /></td>
                    <td><c:out value="${address.city}" /></td>
                    <td><c:out value="${address.state}" /></td>
                    <td><c:out value="${address.zipCode}" /></td>
                    <td><c:out value="${phone.phone1}" /></td>
                    <td><c:out value="${phone.phone2}" /></td>
                    <td><c:out value="${email.email1}" /></td>
                    <td><c:out value="${email.email2}" /></td>
     	 			<td><c:out value="${credentials.annDate1}" /></td>
                    <td><c:out value="${credentials.annDesc1}" /></td>
                    <td><c:out value="${credentials.annDate2}" /></td>
                    <td><c:out value="${credentials.annDesc2}" /></td>
                    <td><c:out value="${credentials.annDate3}" /></td>
                    <td><c:out value="${credentials.annDesc3}" /></td>
                   
                    <td><a href="ContactController?action=edit&contactId=<c:out value="${contactName.contactId}"/>">Update</a></td>
                    <td><a href="ContactController?action=delete&contactId=<c:out value="${contactName.contactId}"/>">Delete</a></td>
                </tr>
          
        </tbody>
    </table>
    <p><a href="ContactController?action=insert">Add Contact</a></p>
</body>
</html>