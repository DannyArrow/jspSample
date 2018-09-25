<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"><!--browser that will process your work-->

<title> Radio Buttons</title><!--title of the page-->
 <style><%@include file="stylesheet.CSS"%></style> <!--Links this page to the CSS styling file-->
</head>

<body>
<%@include file="header.html"%>
 <!-- Nav ends here-->    
 
 
<section class="iRadioButtons2">  
<p>
Washing preference
</p> 	
</section>


<section class="RadioButtonsLine"> <!-- Circle on page-->   






<section class="RadioButtonss1"> 
<form action="customwash" method="post">
<section>   
<p class="RadioButtonss3">COLOR</p>



<section class="box2 align">    



<section >
<p class="align">WASH TEMPERATURE</p>
<input type="radio" name="color_washtemp" value="COLD WASH " checked>COLD WASH 
<input type="radio" name="color_washtemp" value="WARM WASH">WARM WASH
</section>


<section>  
<p class="align">DRYER HEAT</p>
<input type="radio" name="color_dryer" value="LOW DRY  " checked>LOW DRY  
<input type="radio" name="color_dryer" value="REGULAR DRY">REGULAR DRY
</section>

</section>
</section>


<section>
<p class="RadioButtonss3">WHITES</p>



<section class="box2 align">   

 
  
<section>
<p class="align">WASH TEMPERATURE</p>
<input type="radio" name="white_washtemp" value="COLD WASH " checked>COLD WASH
<input type="radio" name="white_washtemp" value="WARM WASH">WARM WASH
</section>


<section>  
<p class="align">DRYER HEAT</p>
<input type="radio" name="white_dryer" value="LOW DRY  " checked>LOW DRY  
<input type="radio" name="white_dryer" value="REGULAR DRY">REGULAR DRY
</section>   
     

 
 </section>

</section>

  
</section>


<button class="buttonA2">NEXT</button>
 </form>

</section>
<%@include file="footer.html"%>
</body>
</html>