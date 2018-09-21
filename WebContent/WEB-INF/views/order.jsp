<%--
  Created by IntelliJ IDEA.
  User: stephanysanchez
  Date: 9/20/18
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"><!--browser that will process your work-->

    <title> Order Summary </title><!--title of the page-->
    <link href="stylesheet.CSS" rel="stylesheet"> <!--Links this page to the CSS styling file-->
</head>

<body>
<!-- Nav ends here-->

<%@include file="header.html"%>


<section class="VisaOrderLine"> <!-- Circle on page-->

    <section class="s1">
        <p class="p4"> Order Summary</p>

        <p> LOCATION PICK UP/ DROP OFF</p>

        <textarea rows="2" cols="45">    </textarea>


        <p> PICK UP DATE &amp; TIME </p>

        <textarea class="curveb" rows="2" cols="60">    </textarea>


        <p> DROP OFF DATE &amp; TIME </p>

        <textarea class="curveb" rows="2" cols="60">    </textarea>

        <p> Service</p>
        <ul type="circle">
            <li>Wash and fold natural care package 2.99 </li>
            <li>Dry Cleaning *</li>
            <li> </li>
        </ul>


        <p> Soap</p>
        <ul type="circle">
            <li>Mrs. Meyers </li>
            <li>Seventh generation soap</li>
        </ul>

        <p> Softners</p>
        <ul type="circle">
            <li>Downy Ultra infusions Liquid Fabric Softener </li>
            <li>Seventh generation soap</li>
        </ul>

    </section>
</section>
<%@include file="footer.html"%>

</body>
</html>