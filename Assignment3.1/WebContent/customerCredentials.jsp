<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credentials</title>
</head>
<body>
	<h1>Enter Verification Credentials</h1>

	<form action="CredentialsServlet" method="post">
		<p>
			Anniversary Date:<input type="text" name="annDate1"
				value="${credentials.annDate1}" />
		</p>
		<p>
			Anniversary Description:<input type="text" name="annDesc1"
				value="${credentials.annDesc1}" />
		</p>
		<p>
			Anniversary Date:<input type="text" name="annDate2"
				value="${credentials.annDate2}" />
		</p>
		<p>
			Anniversary Description:<input type="text" name="annDesc2"
				value="${credentials.annDesc2}" />
		</p>
		<p>
			Anniversary Date:<input type="text" name="annDate3"
				value="${credentials.annDate3}" />
		</p>
		<p>
			Anniversary Description:<input type="text" name="annDesc3"
				value="${credentials.annDesc3}" />
		</p>

		<input type="submit" name="next" value="Next" /> <input type="submit"
			name="previous" value="Previous" /> <input type="submit"
			name="cancel" value="Cancel" />
	</form>
</body>
</html>