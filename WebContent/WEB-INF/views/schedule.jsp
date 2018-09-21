<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/20/18
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"><!--browser that will process your work-->

    <title> schedule </title><!--title of the page-->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style><%@include file="stylesheet.CSS"%></style> <!--Links this page to the CSS styling file-->
</head>

<%@include file="header.html"%>

<br>
<br>
<br>


<section class="info2">
    <p>
        Schedule Your Pick Up And Deliver
    </p>
</section>
<br><br><br>

<section class="squareleLine"> <!-- Circle on page-->
    <section  class="InsidesquareleLine" >

        <p>

            Pick Up Date &amp; Time
            <br><br>
            <br>
            <br>

            <select name="date">
                <option value="volvo">Wednesday, August 22 2018</option>
                <option value="saab">Thursday, August 23 2018</option>
            </select>

            <select name="time">
                <option value="volvo">am</option>
                <option value="saab">pm</option>
            </select>
        </p>
    </section>


    <section class="InsidesquareleLine" >
        <p>
            Drop Off Date &amp; Time
            <br><br>
            <br>
            <br>
            <select name="date">
                <option value="volvo">Wednesday, August 22 2018</option>
                <option value="saab">Thursday, August 23 2018</option>
            </select>

            <select name="time">
                <option value="volvo">am</option>
                <option value="saab">pm</option>
            </select>
        </p>
    </section>
    <button class="btn btn-secondary btn-dark ">submit</button>

</section>
<%@include file="footer.html"%>


</body>
</html>
