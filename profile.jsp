

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
    </head>
    <body>
	
	<h1>My Profile</h1>
	<p>
	Logged in as
	<s:property value="#session.currentUser" />
	</p>

	<p>Username: <s:property value="username" /></p>
    <p>Email: <s:property value="email" /></p>
    <p>Full Name: <s:property value="fullName" /></p>

	<a href="loginSuccess.jsp">Back to Dashboard</a>
    </body>
</html>










