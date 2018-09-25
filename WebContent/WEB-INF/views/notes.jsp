<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/20/18
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
    .container{
        border: 5px solid black;
        margin: 0 auto;
        border-radius: 10px;
        height: 450px;
        width: 750px

    }
    h2{
        text-align: center;
    }
</style>
<body>
<%@include file="header.html"%>
<h2> ADDITIONAL INFORMATION</h2>
<div class="container">
    <br><br><br>
<form action="instruction" method="post">
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Delivery Pickup</label>
        <textarea name="pickupnotes" placeholder="do you have any special pickup instruction (e.g: doorbell not buzzing, driving direction, pick up back door or front door, pick laundry from doorman?)" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <br>
    <br>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">Dropping off</label>
        <textarea  name="dropoffnotes" placeholder="do you have any special drop off instruction (e.g: doorbell not buzzing, driving direction, pick up back door or front door, drop laundry with doorman?)" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <br>
    <button class="button btn btn-primary btn-lg center">Submit</button>
</form>
</div>
</div>
<%@include file="footer.html"%>
</body>
</html>
