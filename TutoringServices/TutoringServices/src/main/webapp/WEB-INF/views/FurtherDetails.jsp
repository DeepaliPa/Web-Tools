<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Cofrestru Registration Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="resources/css/styleRegistration.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<style type="text/css">
body{
 background: url(resources/images/bg3.png);
	font-family: 'Open Sans', sans-serif;
	text-align: center;
}
a.facebook {
	  background: url(resources/images/img-sprite.png) no-repeat 8px 0px;
	  width: 38px;
	  height: 46px;
	  display: block;
}
a.twitter {
	  background: url(resources/images/img-sprite.png) no-repeat -25px 0px;
	  width: 38px;
	  height: 29px;
	  display: block;
}
a.gp {
	  background: url(resources/images/img-sprite.png) no-repeat -58px 0px;
	  width: 38px;
	  height: 30px;
	  display: block;
}
</style>

</head>
<body>
<div class="registration">
			<h2>Further Details Form</h2>				
					<form:form name="form" action="furtherDetailsPost.htm" commandName="user" method="post" enctype="multipart/form-data">
						<div class="form-info">
						<div>
						Type:<form:select id="first" path="type">
                             <form:option value="">--- Select ---</form:option>
                          <!--  <form:option value="Admin"></form:option> -->
                             <form:option value="Tutor"></form:option>
                             <form:option value="Student"></form:option>
                       </form:select>
						</div>
						<div>
						Gender:<form:select id="second" path="gender">
                             <form:option value="">--- Select ---</form:option>
                             <form:option value="Male"></form:option>
                             <form:option value="Female"></form:option>
                       </form:select>
                       </div>
                       <div>
                       Subject Category: <form:select id="third" path="subjectCategory">
                             <form:option value="">--- Select ---</form:option>
                             <form:option value="Business"></form:option>
                             <form:option value="Computers"></form:option>
                             <form:option value="Law"></form:option>
                             <form:option value="Mathematics"></form:option>
                       </form:select>
                       </div>
                       <div>
                       Tutoring Type:<form:select id="fourth" path="tutoringType">
                             <form:option value="">--- Select ---</form:option>
                             <form:option value="Home"></form:option>
                             <form:option value="Classes"></form:option>
                             <form:option value="Online"></form:option>
                       </form:select>
                       </div>
                       
                       <div>
                       <form:input path="age" class="text" id="age" name="age" placeholder="Enter your Age" />
                       </div>
						</div>
						<form:input type="file" id="filename" path="photo" value="Upload Picture"/>
						<input type="submit" value="REGISTER" onclick="return validate(this);">	
					   				    
					
					</form:form><!-- form -->
					
					
		</div>
		<script>
		
		
		var ck_age = /^(0?[1-9]|[1-9][0-9])$/;
		function validate(form){
			var age = document.getElementById("age").value;
			var filename = document.getElementById("filename").value;
			var type = document.getElementById("first").value;
			var gender = document.getElementById("second").value;
			var subjectCat = document.getElementById("third").value;
			var tutoringType = document.getElementById("fourth").value;

			 var errors = [];
			  
			  if (!ck_age.test(age)) {
			   errors[errors.length] = "You valid age .";
			  }
			  
			  if (errors.length > 0) {

				   reportErrors(errors);

				   return false;
				  }
			  
			 if(age=="" | type=="" | gender=="" | subjectCat=="" | tutoringType=="" | filename==""){
				 alert("Please select something!")
				 return false;
			 }
				   return true;
			
		}	
		
		function reportErrors(errors){
			  var msg = "Please Enter Valide Data...\n";
			  for (var i = 0; i<errors.length; i++) {
			  var numError = i + 1;
			   msg += "\n" + numError + ". " + errors[i];
			 }
			  alert(msg);
			 
			}
		</script>


</body>
</html>