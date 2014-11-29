<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page
	import="java.util.List,com.abc.model.*,com.abc.dao.ContactService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Contacts</title>
</head>
<body>
		<h1>List of All Contacts</h1>

		<%
			List<ContactName> contacts = (List<ContactName>) request.getAttribute("contacts");
			if (null == contacts) {

				contacts = ContactService.getAllContacts();

			}
		%>
    <table border=1>
        <thead>
            <tr>
                <th>Contact Id</th>
                <th>First Name</th>
                <th>Last Name</th>
    
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
          		<%
					for (ContactName cont : contacts) {
				%>
            
                <tr>
                    <td><c:out value="${cont.contactId}" /></td>
                    <td><c:out value="${cont.firstName}" /></td>
                    <td><c:out value="${cont.lastName}" /></td>
          
                    <td><a href="ContactController?action=edit&contactId=<c:out value="${cont.contactId}"/>">Update</a></td>
                    <td><a href="ContactController?action=delete&contactId=<c:out value="${cont.contactId}"/>">Delete</a></td>
                </tr>
				<%
					}
				%>          
        </tbody>
    </table>
    <p><a href="ContactController?action=insert">Add Contact</a></p>
</body>
</html>