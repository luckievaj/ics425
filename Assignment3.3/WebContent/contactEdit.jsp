<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Contact Details</title>
</head>
<body>
<form method="POST" action='ContactController' name="frmAddContact">
		<p style="color: red">${message}</p>

		First Name: <input type="text"  name="firstName"
			value="<c:out value="${contactName.firstName }"/>"/> <br/>
		Last Name: <input type="text"  name="lastName"
			value="<c:out value="${contactName.lastName }"/>"/> <br/>
		Street: <input type="text"  name="street"
			value="<c:out value="${address.street }"/>"/> <br/>
		City: <input type="text"  name="city"
			value="<c:out value="${address.street }"/>"/> <br/>
		State: <input type="text"  name="state"
			value="<c:out value="${address.street }"/>"/> <br/>
		Zip Code: <input type="text"  name="zipCode"
			value="<c:out value="${address.street }"/>"/> <br/>
		Phone 1: <input type="text"  name="phone1"
			value="<c:out value="${phone.phone1}"/>"/> <br/>
		Phone 2: <input type="text"  name="phone2"
			value="<c:out value="${phone.phone2}"/>"/> <br/>		
		Email 1: <input type="text"  name="email1"
			value="<c:out value="${email.email1}"/>"/> <br/>
		Email 2: <input type="text"  name="email2"
			value="<c:out value="${email.email2}"/>"/> <br/>
		Anniversary 1: <input type="text"  name="annDate1"
			value="<c:out value="${credentials.annDate1}"/>"/> <br/>
		Description 1: <input type="text"  name="annDesc1"
			value="<c:out value="${credentials.annDesc1}"/>"/> <br/>			
		Anniversary 2: <input type="text"  name="annDate2"
			value="<c:out value="${credentials.annDate2}"/>"/> <br/>
		Description 2: <input type="text"  name="annDesc2"
			value="<c:out value="${credentials.annDesc2}"/>"/> <br/>
		Anniversary 3: <input type="text" name="annDate3"
			value="<c:out value="${credentials.annDate3}"/>"/> <br/>
		Description 3: <input type="text" name="annDesc3"
			value="<c:out value="${credentials.annDesc3}"/>"/> <br/>

		<input type="submit" name="confirm" value="Confirm" /> 
		<input type="submit" name="cancel" value="Cancel" />
	</form>
</body>
</html>