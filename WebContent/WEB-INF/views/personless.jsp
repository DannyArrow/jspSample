<!DOCTYPE html>
<html>
<head>
  <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
  <style type="text/css">
   body{
    background-color: lightblue;
   }

    .container{
      height: 450px;
      width: 80%;
      background-color: powderblue;
      text-align: center;
       padding-top: 30px;
       margin: auto;
       border: 3px solid green;
    }

    .group{
      color: powderblue;
      background-color: powderblue;
      text-align: center;
      font-size: 20px;
      padding-top: 20px;
      text-decoration-color: black;
    }

    .ls{
      background-color: #e6e6ff;


    }
  </style>
</head>
<body>
<%@include file="header.html"%>

  <br><br><br>
<div class="container">

    <h2> please choose a pickup method </h2>

<div class="list-group group">
    <form action="personless" method="post">
  <a href="#" class="list-group-item list-group-item-action list-group-item-primary ls"><input type="radio" value="false pickup and dropoff" name="pickup"> I'm going be home for both pick up and drop off delivery</a>

  <a href="#" class="list-group-item list-group-item-action list-group-item-primary ls"><input type="radio" value="true pickup and drop off" name="pickup"> Pickup and drop off laundry when I'm not home</a>

  <a href="#" class="list-group-item list-group-item-action list-group-item-primary ls"><input type="radio" value="true pickup" name="pickup"> Pickup my laundry when I'm away from home</a>

  <a href="#" class="list-group-item list-group-item-action list-group-item-primary ls"><input type="radio" value="false pickup" name="pickup"> Drop off my laundry when I'm away from home</a>
        <br>
    <button  class="btn btn-primary btn-lg btn-block">Enter</button>
    </form>
</div>




</div>
<%@include file="footer.html"%>
</body>
</html>
