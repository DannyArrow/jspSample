<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserAccountPage</title>
</head>
<%@ page import="springwork.model.User" %>
<body>
<% User u = (User)session.getAttribute("userkey"); %>
Username: ${userkey.username} <br><br>
password: ${userkey.password} <br><br>
email: ${userkey.email}<br><br>

email from Session: <%=u.getEmail() %><br><br>

<a href="modify">Modify</a>

</body>
</html>