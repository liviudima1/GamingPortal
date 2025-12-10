

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
	
	<h1>Welcome to BidHeaven</h1>

	<p>
	Logged in as
	<s:property value="#session.currentUser" />
	</p>
		
	<li><a href="profile.action">View my profile</a></li>
	<li><a href="users.action">View all users</a></li> 
	<li><a href="addItem.jsp">Add item for sale</a></li>
	<li><a href="viewItems.action">View all items for sale</a></li>
	  

</body>
</html>










