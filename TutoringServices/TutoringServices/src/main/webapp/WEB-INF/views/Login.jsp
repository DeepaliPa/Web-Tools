<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>	
<head>
<title>Levy Flat Registration Form Flat Responsive Widget Template  : w3layouts</title>
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
			<h2>Login Form</h2>				
					<form:form name="form" id="form" action="loginPost.htm" commandName="user" method="post">
						<div class="form-info">						
						<form:input path="username" id="username" name="username" class="text" placeholder="User Name" /><font color="red"><form:errors path="username"/></font>
						<form:input path="password" id="password"  name="password" class="text" placeholder="Password" /><font color="red"><form:errors path="password"/></font>
					    </div>
					    <input type="submit" value="LOGIN" onclick="return validate(this);">
					</form:form><!-- form -->
					<ul class="bottom-icons">
					
					</ul>
							<div class="clear"> </div>
		</div>
		<script>

				
				var ck_username = /^[A-Za-z0-9_]{1,20}$/;
				var ck_password =  /^[A-Za-z0-9!@#$%^&*()_]{1,20}$/;
	
					 function validate(form){
						 
						 
						 var username =document.getElementById("username").value;
						 var password = document.getElementById("password").value;
						 

						
						 var errors = [];
						  
						 
						  if (!ck_username.test(username)) {
						   errors[errors.length] = "You valid UserName no special char .";
						  }
						  if (!ck_password.test(password)) {
						   errors[errors.length] = "You must enter a valid Password ";
						  }
						  
						  if (errors.length > 0) {

						   reportErrors(errors);
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