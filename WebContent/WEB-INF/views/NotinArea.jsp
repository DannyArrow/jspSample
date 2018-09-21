<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/13/18
  Time: 2:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title></title>
    <style type="text/css">
        .container{
            margin-top: 100px;
            padding: 5px ;
        }
        .form{
            background-color: powderblue;

        }
        .Center {
            margin-top: 20px;
        }


        }


    </style>
</head>
<body>
<%@include file="header.html"%>
<div class="shadow-lg p-3 mb-5 bg-white rounded container">
    <h4 class="text-center pad"> Oops! It Seems that we do not serve in your area, if would like to be reminded once we do, fill your details below</h4>
    <form class="form  justify-content-center border border-dark">

        <div class="form-row ">
            <div class="form-group col-sm-4">
                <label> Firstname</label>
                <input type="text" class="form-control" id="firstname" placeholder="Firstname">
            </div>
            <div class="form-group col-sm-4">
            </div>
            <div class="form-group col-sm-4">
                <label> Lastname</label>
                <input type="text" class="form-control" id="Lastname" placeholder="Lastname">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-sm-3">
            </div>
            <div class="form-group col-sm-6">
                <label class="text-center">Email Adress</label>
                <input type="text" class="form-control" name="Email" placeholder="Email Address">
            </div>
        </div>
        <div class="form-group  text-center Center" >
            <button class="btn btn-primary btn-lg"> notify me</button>
        </div>
    </form>
<%@include file="footer.html"%>
</body>
</html>
