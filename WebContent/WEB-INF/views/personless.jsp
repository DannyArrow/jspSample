<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
  <meta charset="UTF-8">
  <title>Styling radio buttons</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto'>

      <link rel="stylesheet" href="css/style.css">
<style type="text/css">
  * {
  box-sizing: border-box;
}

body {
    <%@include file="header.html"%>

  background-color: #1E90FF;
  font-family: Roboto, sans-serif;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 960px;
  
  margin: 0 auto;
}

.title{
  text-align: center;
  padding-top: 40px;
  font-size: 40px;
  border: 5px solid black;
     border-radius: 10px;

}

.list {
  flex: 0 80%;
}
.list__item {
  position: relative;
}
.list__item:hover label {
  color: #BB4430;
}
.list__item:hover .label::before {
  border: 7px solid #BB4430;
  margin-right: 30px;
}

.radio-btn {
  position: absolute;
  visibility: hidden;
}
.radio-btn:checked ~ .label {
  color: #BB4430;
}
.radio-btn:checked ~ .label::before {
  margin-right: 30px;
  border: 7px solid #BB4430;
  background: #F8F7FF;
}

.label {
  display: flex;
  align-items: center;
  padding: 25px 0 25px 20px;
  color: #F8F7FF;
  font-size: 20px;
  font-weight: 300;
  text-transform: uppercase;
  cursor: pointer;
  transition: all 0.25s linear;
}

.label::before {
  display: block;
  content: '';
  border: 7px solid #F8F7FF;
  border-radius: 50%;
  height: 18px;
  width: 18px;
  margin-right: 10px;
  transition: all .25s linear;
}
.button{
    position: absolute;
         left: 180px;
         top: 450px;
}
</style>
  </br>
  </br>
  </br>
</head>
<h2 class ="title"> Not home? no problem just choose the personless pickup and drop off option</h2>
<body>
  <div class="container">
 <ul class="list">
  <li class="list__item">
   <input type="radio" class="radio-btn" name="choise" id="a-opt" />
   <label for="a-opt" class="label">Personless pickup</label>
  </li>
  <li class="list__item">
   <input type="radio" class="radio-btn" name="choise" id="b-opt" />
   <label for="b-opt" class="label">Personless dropOff</label>
  </li>
  <li class="list__item">
   <input type="radio" class="radio-btn" name="choise" id="c-opt" />
   <label for="c-opt" class="label">Both personless pickup and drop off</label>
  </li>
  <li class="list__item">
   <input type="radio" class="radio-btn" name="choise" id="d-opt" />
   <label for="d-opt" class="label">Don't need the personless option, going be home</label>
  </li>
 </ul>


</div>
  
   <button class="button btn btn-primary btn-lg">submit personless form</button>
<%@include file="footer.html"%>
</body>
</html>
