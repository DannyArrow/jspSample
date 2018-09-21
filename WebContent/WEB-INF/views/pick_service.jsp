<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/12/18
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <title>service</title>
    <style type="text/css">
        .container{
            margin-top: 100px;
            padding: 90px 30px;
            border: 3px solid green;
        }
        .button1{
            display: block;
            margin: auto;


        }
    </style>
</head>
<body>
<%@include file="header.html"%>
<div class="container">
    <h1 class="text-center"> pick a service </h1>
    <form  action="service" method="post">
    <div class = "row">
        <div class = "col-sm-6 col-md-8">
            <a href = "#" class = "thumbnail">
                <input type="image" src='<c:url value="/files/thedrycleaning.jpg"></c:url>' name = "service" value="drycleaning"/>
            </a>
        </div>

        <div class = "col-sm-6 col-md-3">
            <a href = "#" class = "thumbnail">
                <input type="image" src = "../../files/wash-dry-fold.jpg" alt = "Generic placeholder thumbnail" name = "service" value="wash&fold">
            </a>
        </div>
    </div>
        <button class="btn primary btn-lg button1" name = "service" value="washfold&drycleaning">pick both wash&fold and service</button>
    </div>
    </form>

<%@include file="footer.html"%>
</body>
</html>
