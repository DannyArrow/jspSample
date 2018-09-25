<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/23/18
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        .container{
            height: 450px;
            width: 80%;
            background-color: powderblue;
            text-align: center;
            margin: auto;
            border: 3px solid green;
        }


        .date{
            width:240px;
            padding: 60px;
            margin:auto;
            height: 30px;
            margin-bottom: 50px
        }

        .button{
            width: 100px;
            margin-left: 450px

        }



    </style>
</head>
<body>
<%@include file="header.html"%>
<br><br><br><br><br>

<div class="container">
    <h2>Schedule your drop off date and time</h2>
    <br><br>


    <h4>Drop Off Date</h4>
    <br>
    <form action="dropoff", method="post">
    <select name = "date" class="form-control form-control-sm date">
        <c:forEach items="${dropoff}" var="entry">
            <option value=${entry.key}>${entry.value}</option>
        </c:forEach>
    </select>
    <h4>Drop off Time</h4>
    <br>
    <select  name = "time" class="form-control form-control-sm date">
        <option value="am">0:700 am to 12:00 pm</option>
        <option value="pm">0:600 pm to 10:00 pm</option>
    </select>
    <button class="btn btn-primary btn-lg button">Next</button>
    </form>
</div>
<%@include file="footer.html"%>

</body>
</html>
