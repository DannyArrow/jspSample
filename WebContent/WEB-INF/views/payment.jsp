<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"><!--browser that will process your work-->

<title> payment</title><!--title of the page-->
    <style><%@include file="stylesheet.CSS"%></style> <!--Links this page to the CSS styling file-->
<!--Links this page to the CSS styling file-->
</head>

<body>
  <!-- Nav ends here-->
<%@include file="header.html"%>
<section class="VisaOrderLine"> <!-- Circle on page-->   


<p class="p5"> Payment Method</p>

<section class="pmParent">
    
    <section>
      
    
<p> Card Holder Name </p>

<textarea class="curveb" rows="2" cols="60">    </textarea>  
        
<p> Expire Date</p>
 <textarea class="curveb" rows="2" cols="10">    </textarea>  
     
    </section>
    
    
    <section class="paylin1" >
      
<p> Card Number </p>

<textarea class="curveb" rows="2" cols="60">    </textarea>  
        
<p> CVC / CVV NO. </p>
 <textarea class="curveb" rows="2" cols="10">    </textarea>        
        
    </section>   
</section>

<section class="paymentcenter"   >
   <p>Available Credit</p> 
   
    <textarea class="curveb" rows="2" cols="60">    </textarea> 
    
    <p>PROMOTION CODE</p> 
    
    <textarea class="curveb" rows="2" cols="20">    </textarea>  
    
     <p>PLACE ORDER</p>  
    
</section>

</section>
  <%@include file="footer.html"%>
</body>
</html>