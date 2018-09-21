<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/19/18
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-color: #A286C8
        }

        .img {
            width: 300px; /*set the width or max-width*/
            height: 300px; /*this makes sure to maintain the aspect ratio*/
        }
        .center{
            text-align: center;
            padding-bottom: 100px
        }




    </style>

</head>
<body>
<%@include file="header.html"%>
<div class="container">
    <h2 class="center">Please choose package</h2>
    <form action="package" method="post"></form>
    <div class="row">
        <form action = "package" method="POST">
            <div class="col-md-3">
                <div class="thumbnail">
                    <input class="img" type="image" name="laundrycarepackage" value="colorcare" src='<c:url value="/files/colorcare.jpg"></c:url>' alt="colorcare" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
                    </div>

                </div>
            </div>
            <div class="col-md-3">
                <div class="thumbnail">
                    <input class="img" type="image" name="laundrycarepackage" value="shapecare" src='<c:url value="/files/shapecare.jpg"></c:url>' alt="Nature" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
                    </div>

                </div>
            </div>
            <div class="col-md-3">
                <div class="thumbnail">
                    <input class="img" type="image" name="laundrycarepackage" value="naturalcare" src='<c:url value="/files/naturalcare.jpg"></c:url>' alt="Fjords" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
                    </div>

                </div>
            </div>
            <div class="col-md-3">
                <div class="thumbnail">
                    <input class="img" type="image" name="laundrycarepackage" value="custompackage" src='<c:url value="/files/custom-package.jpg"></c:url>' alt="Fjords" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
                    </div>

                </div>
            </div>
        </form>
    </div>

</div>
<%@include file="footer.html"%>
</body>
</html>
