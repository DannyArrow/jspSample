<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/20/18
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        .body{
            background-color: RoyalBlue
        }
        .container{

            padding: 250px;
            border: 5px solid black;
            border-radius: 10px;
            align-content: center;
            background-color: Magenta;

        }

        .soap{
            border: 5px solid red;
            border-radius: 10px;
            padding-top: 50px;
            padding-right: 30px;
            padding-left: 30px;
            padding-bottom: 50px;
            position: absolute;
            left: 180px;
            top: 150px;

        }

        .softner{
            border: 5px solid red;
            border-radius: 10px;
            padding-top: 50px;
            padding-right: 30px;
            padding-bottom: 50px;
            padding-left: 30px;
            position: absolute;
            right: 180px;
            top: 150px;

        }

        .title{

            padding-bottom: 2px
        }

        .button{
            position: absolute;
            right: 540px;
            bottom: 70px;


        }


    </style>
    }

</head>
<body class="body">
<%@include file="header.html"%>
<!-- Group of material radios - option 1 -->
<div class="container ">
    <form action="soapfabric" method="post">
    <div class="soap ">
        <h3 class="title"> Choose Soap </h3>
        <br>

             <c:forEach items="${soaplist}" var="soap" >


                 <div class="radio">
                 <label><input type="radio" name="soap"  value="${soap.soapid}">${soap.name}:   ${soap.price}$</label>
                 </div>


             </c:forEach>



        </div>



    <div class="softner">
        <h3 class="title"> Choose fabric softner</h3>
        <br>
        <c:forEach items="${softnerlist}" var="softnerr" >


            <div class="radio">
                <label><input type="radio" name="softnerr"  value="${softnerr.softerid}">${softnerr.name}:   ${softnerr.price}$</label>
            </div>


        </c:forEach>


</div>
    <button class="button btn btn-primary btn-lg center">Submit</button>
</div>
</form>
<%@include file="footer.html"%>
</body>
</html>
