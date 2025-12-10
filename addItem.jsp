

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add item - BidHeaven</title>
    </head>
    <body>
	
	<h1>Add item for Sale</h1>
	<p>
		Logged in as
	<s:property value="#session.currentUser" />
	</p>
	
	<s:form action="addItem">
		<s:textfield name="title" label="Title" />
        <s:textarea name="description" label="Description" />
        <s:textfield name="startingPrice" label="Starting Price" />
        <s:submit value="Add Item" />
    </s:form>

	<a href="loginSuccess.jsp">Back to Dashboard</a>
    </body>
</html>










