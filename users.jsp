

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
	
	<h1>All Users</h1>
	<p>
	Logged in as
	<s:property value="#session.currentUser" />
	</p>
	
	<table>
	<s:iterator value="usernames">
		<tr>
			<td><s:property /></td>
			<td><a href="viewUser.action?username=<s:property />">
				View Profile
			</a>
		</tr>
	</s:iterator>
</table>
	<a href="loginSuccess.jsp">Back to Dashboard</a>
    </body>
</html>










