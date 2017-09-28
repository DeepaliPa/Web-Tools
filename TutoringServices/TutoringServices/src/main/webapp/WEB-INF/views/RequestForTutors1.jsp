<!DOCTYPE html>
<html>
<head>
  <title>Request For Tutors</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
.hidden {
  display: none;
  visibility: hidden;
} 
</style>

<body>

<div class="container-fluid">
  <h1></h1>

  <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
    
    	<div class="col-sm-2"></div>
    	<div class="col-sm-8">
    <form name="myForm" id="form1" action="">
    	<table>
    	 <tr>
    	    
            <h3>Choose category<h3>
            <input type="radio" name="category" value="information Systems" id="information">Information Systems<br>
            <input type="radio" name="category" value="Computer Science" id="computer">Computer Science<br>
            <input type="radio" name="category" value="Business Study" id="business">Business Study<br>
            <input type="radio" name="category" value="Project Management" id="project">Project Management<br>
            <input type="radio" name="category" value="Maths" id="maths">Maths<br>
           
    	 </tr>
    	 
    	 <tr id="tr1">
    	 <td>
    	 <input type="radio" name="subCategory" id="algorithm">Algorithms<br>
    	 <input type="radio" name="subCategory" id="webTools">Web Tools<br>
    	 <input type="radio" name="subCategory" id="WebDesign">Web Design<br>
    	 <div>
    	 <p></p>
    	       <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select City
              <span class="caret"></span></button>
                  <ul id="demolist" class="dropdown-menu">
                     <li><a href="#">Boston</a></li>
                     <li><a href="#">Waltham</a></li>
                     <li><a href="#">Framingham</a></li>
                  </ul>
         </div>
         </td>
    	 </tr>
    	 
    	 <tr id="tr2">
    	 <td>
    	 <input type="radio" name="subCategory" id="pdp">PDP<br>
    	 <input type="radio" name="subCategory" id="webDev">Web Development<br>
         <div>
    	 <p></p>	
    	      <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select City
              <span class="caret"></span></button>
                  <ul id="demolist" class="dropdown-menu">
                     <li><a href="#">Boston</a></li>
                     <li><a href="#">Waltham</a></li>
                     <li><a href="#">Framingham</a></li>
                  </ul>
         </div>
         </td>
    	 </tr> 
    	 
    	 <tr id="tr3">
    	 <td>
    	 <div>
    	 <h4>
    	 Assignment Detail:
    	 </h4>
    	 <h4>Request Info
    	 <textarea name="requestInfo" id="requestInfo" rows="4" cols="50" required></textarea></h4>
    	 <h4>Additional Info
    	 <textarea name="additionalInfo" id="additionalInfo" rows="4" cols="50" required></textarea></h4>
    	 </div>   	 
    	 </td>
    	 </tr>
    	 
    	 <tr id="tr4">
    	 <td>
    	 <h5>Have you registered before?</h5>
    	 <h5>
    	 <input type="radio" name="status" value="yes" id="yes">Yes &nbsp;&nbsp;&nbsp;
    	 <input type="radio" name="status" value="no" id="no">No
    	 </h5>
    	 </td>
    	 </tr>
    	 
    	 <tr>
       	 <input type="hidden" name="cat" value="">
    	 <input type="hidden" name="subCat" value="">
    	 <input type="hidden" name="reqInfo" value="">
    	 <input type="hidden" name="addInfo" value="">
    	 <input type="hidden" name="action" value="requestPage">
    	 </tr>
    	 
    	 <tr id="tr5">
    	 <td>
    	     <input type="submit" value="Login">	
    	 </td>
    	 </tr>
    	 
     	 <tr id="tr6">
    	 <td>
    	 <input type="submit" value="REGISTER">	
    	 </td>
    	 </tr> 

    	</table>
    	</form>	
    	</div>
    	<div class="col-sm-2"></div>

    </div>
    <div class="col-sm-2"></div>
  </div>
</div>
<script>
var value,val,status;

$(document).ready(function(){

	$("#tr1").addClass("hidden");
	$("#tr2").addClass("hidden");
	$("#tr3").addClass("hidden");
	$("#tr4").addClass("hidden");
	$("#tr5").addClass("hidden");
	$("#tr6").addClass("hidden");
 $('input[name=category]').click(function() { 
	 
    value= $(this).val();
	//alert("value is *****" + value);
	if(value=="information Systems"){
		alert("1");
		$("#tr2").addClass("hidden");
		 $("#tr1").removeClass("hidden");
	} 
    if(value=="Computer Science"){
		alert("2");
		$("#tr1").addClass("hidden");
		 $("#tr2").removeClass("hidden");
	}
	});
 
   
 $('#demolist li a').on('click', function(){
	val= $(this).text();
	//alert("val--->" + val);
	 $("#tr3").removeClass("hidden");
	 $("#tr4").removeClass("hidden");
	});
 
 $('input[name=status]').on('click', function(){
		status= $(this).val();
		//alert("status--->" + status);
		if(status=="yes"){
		 $("#tr5").removeClass("hidden");
		 $("#form1").attr("action","loginGet.htm");
		 
		}else if(status=="no"){
		 $("#tr6").removeClass("hidden");
		 $("#form1").attr("action","registrationGet.htm");
		 
		}
		});
 
 document.forms.form1.cat.value=value;
 document.forms.form1.subCat.value=val;
 document.forms.form1.reqInfo.value=document.getElementById("additionalInfo");
 document.forms.form1.addInfo.value=document.getElementById("additionalInfo");
 
});


</script>
<p><a href="redirect.htm">Go To Home Page!</a></p>
</body>
</html>