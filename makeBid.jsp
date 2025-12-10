

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make a Bid</title>
    </head>
    <body>
	
	<h1>Make a bid</h1>

	<p>Enter the ID of the item you want to bid on please</p>
	
	<s:form action="makeBid">
		<s:textfield name="itemId" label="Item ID" />
		<s:textfield name="bidAmount" label="Bid Amount" />
		<s:submit value="Place Bid" />
	</s:form>

	<a href="loginSuccess.jsp">Back to Dashboard</a>
    </body>
</html>










