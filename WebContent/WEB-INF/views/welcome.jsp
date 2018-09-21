<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/11/18
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        form  {

            color: black;
            padding: 100px;
            text-align: center;
            margin-top: 50px;
            border: 1px solid black;
        }
        #body{
            background-color: lightblue;
        }
        #zip{
            border: 1px solid black;
            height: 25px;
            width: 150px;
        }
        #submit{
            height: 50px;
            width: 250px;
            border: 1px solid black;
        }
    </style>
</head>
<body id = "body">



<%@include file="header.html"%>



<form action = "user_area" method="POST">
    zipcode <br>
    <input id = "zip" type="text" name="zipcode" value="">
    <br>
    <br>
    <input id="submit" type="submit" value="Submit">
</form>

<b>

</b>

<% String x = request.getParameter("zipcode");
    ArrayList<String> list = new ArrayList();
    list.add("10601");
    list.add("10602");
    list.add("10603");
    list.add("10604");
    list.add("10605");
    list.add("10606");
    list.add("10607");
    list.add("10610");

    if(list.contains(x)){
     %>
       <jsp:forward page = "form_register.jsp" />
        <%
    }else if(x != null){
       %> <jsp:forward page = "NotinArea.jsp" />
<%
    }
%>

<%@include file="footer.html"%>
</div>
</body>
</html>


