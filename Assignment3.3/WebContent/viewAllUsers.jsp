<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>View All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Contact Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
         <tbody>
          
            
                <tr>
                    <td><c:out value="${user.userId}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.userName}" /></td>
                    
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userId}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.userId}"/>">Delete</a></td>
                </tr>
          
        </tbody>
    </table>
    <p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>