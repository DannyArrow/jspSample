<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserAccountModify</title>
</head>
<%@ page import="springwork.model.User" %>
<body>

<% User u = (User)session.getAttribute("userkey"); %>
<h1>Change UserInformation </h1>
	<div class = "container">
		<form action = "submit_changes" method="POST">
		
		<div class = "sub_field">
			<label for ="name">User name </label><br>
			<input id = "name" name="username" type = "text" value=<%=u.getUsername() %>  />		
		</div>
		<br>
		<div class = "sub_field">
			<label for ="password">Password</label><br>
			<input type = "password" id = "pass" name="password" value=<%=u.getPassword() %> />		
		</div>
		<br>
		<div class = "sub_field">
			<label for ="email">email</label><br>
			<input type = "email" id = "email" name="email" value=<%=u.getEmail() %>  />		
		</div>
		
		<br><br>
		<div class = "btn">
			<input type = "submit" name = "submit"  value = "Change Info" />		
		</div>			
		
		</form>			
	
	</div>


</body>
</html>