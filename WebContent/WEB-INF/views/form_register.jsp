<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>regester</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        .btn {
            width:100px;
            margin-top:35px;
        }
        .error {color:red}
    </style>
</head>
<body>

<%@include file="header.html"%>
<h3 class="text-center"> Register account </h3>
<div class="container" >

    <form:form method="POST" action="register" modelAttribute="command">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label> FirstName</label>
                <form:input path="firstName" cssClass="form-control .input-sm"  name="firstName" id="firstname" placeholder="Firstname"/>
                <form:errors path="lastname" cssClass="error" />
            </div>
            <div class="form-group col-md-6">
                <label> LastName</label>
                 <form:input path="lastname" cssClass="form-control .input-sm"  name="lastname" id="lastname" placeholder="lastname"/>
                <form:errors path="lastname" cssClass="error" />
            </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-6">
            <label> EmailAdress</label>
            <form:input  path="email" cssClass="form-control .input-sm"  name="email" id="email" placeholder="email"/>
            <form:errors path="email" cssClass="error" />
        </div>
            <div class="form-group col-md-6">
                <label>Phone</label>
                <form:input type="tel" path="phone" cssClass="form-control .input-sm"  name="phone" id="phone" placeholder="phone"/>
                <form:errors path="phone" cssClass="error" />
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Password</label>
                <form:input type = "password" path="password" cssClass="form-control .input-sm"  name="password" id="password" placeholder="password"/>
                <form:errors path="password" cssClass="error" />
            </div>

            <div class="form-group col-md-6">
                <label> confirm Password </label>
                <form:input type = "password"  path="confirmpassword" cssClass="form-control .input-sm"  name="confirmpassword" id="confirmpassword" placeholder="confirmpassword"/>
                <form:errors path="confirmpassword" cssClass="error" />
            </div>
        </div>
        <div class="form-group">
            <label>Address</label>
            <form:input path="street" cssClass="form-control .input-sm"  name="street" id="street" placeholder="Street"/>
            <form:errors path="street" cssClass="error" />
        </div>
        <div class="form-group">
            <label>Address 2</label>
            <form:input path="streetdetails" cssClass="form-control .input-sm"  name="street" id="street" placeholder="Apartment, studio, or floor"/>
            <form:errors path="streetdetails" cssClass="error" />
        </div>



        <div class="form-row">

            <div class="form-group col-md-4">
                <label>City</label>
                <form:select path = "cities" cssClass="form-control .input-sm">
                <form:option value = "NONE" label = "Select"/>
                <form:options items = "${citylist}" />
                </form:select>
                <%--<label>City</label>--%>
                <%--<form: select name="cities" id="citties" class="form-control .input-sm">--%>
                    <%--<option selected>select city</option>--%>
                    <%--<c:forEach items="${citylist}" var="cities">--%>
                    <%--<option >${cities} </option>--%>
                    <%--</c:forEach>--%>

                <%--</select>--%>
            </div>

            <div class="form-group col-md-4">
                <label>state</label>
                <select name="State" class="form-control .input-sm">
                    <option selected>New York</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <label>Zip</label>
                <input type="text" id="zip" class="form-control .input-sm" name="zip">
                <form:errors path="zip" cssClass="error" />
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-3">
                <label>type of building</label>
                <select name="type_of_building" class="form-control .input-sm">
                    <option selected>Choose...</option>
                    <option>apartment</option>
                    <form:errors path="type_of_building" cssClass="error" />
                </select>
            </div>

                 <div class="form-group col-md-3"></div>


                <div class="form-group col-md-4">
                    <button type="submit" class="btn btn-primary btn-lg" value="Submit">Sign in</button>
                </div>

        </div>
    </form:form>
</div>

<%@include file="footer.html"%>

</body>
</html>