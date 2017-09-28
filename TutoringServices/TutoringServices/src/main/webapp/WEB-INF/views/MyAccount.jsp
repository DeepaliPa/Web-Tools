<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>MyAccout</title>

<script>

var username=null;
var email=null;
var gender=null;
var age=null;
var subjectCategory=null;
var tutoringType=null;
var newPassword=null;
	function updatePassw(){
		 newPassword= document.getElementById("newPassword").value;;
	
		document.forms.form1.newPass.value=newPassword;
		
		$.ajax({
			type : "POST",
			url : "updatePassword.htm?newPassword="+newPassword,
			//data :{"newPassword":newPassword},
			contentType: "application/json",
			dataType : "json",
			success : function(response) {
				alert("Success!");
			},
		
			error : function(){
				alert("Success!!");
				//write whatever you want here
			}

		});
	}

	function sampleAjax() {

		$.ajax({
			type : "POST",
			url : "getUserDetails.htm",
			contentType: "application/json",
			dataType : "json",
			success : function(response) {
				alert(response);
				displayTheContent(response);
			},
		
			error : function(){
				alert("Error");
				//write whatever you want here
			}

		});

	}
	
	function getRequest() {

		$.ajax({
			type : "POST",
			url : "getStudentRequestDetails.htm",
			contentType: "application/json",
			dataType : "json",
			success : function(response) {
				alert(response);
				displayContent(response);
			},
		
			error : function(){
				alert("Error");
				//write whatever you want here
			}

		});

	}
	function displayContent(response){
		$("#resultsRequest").empty();
		$("#results").empty();

			var x = document.createElement("TABLE");
            x.setAttribute("id", "myTable");
            x.setAttribute("border", "2");
            document.getElementById("results").appendChild(x);
            var y = document.createElement("TR");
            y.setAttribute("id", "myTr");
            document.getElementById("myTable").appendChild(y);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("RequestID");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Category");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            

            var z = document.createElement("TH");
            var t = document.createTextNode("SubCategory");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Request Information");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Additional Information");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Name");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Usrename");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Delete");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
           
            	
        	for(var i=0, l = response.length; i < l; i++){
            var A = document.createElement("TR");
            A.setAttribute("id", "myTr" + i);
            document.getElementById("myTable").appendChild(A);

            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].requestId);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].category);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].subjectCat);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].requestInfo);
            z.appendChild(t);
           document.getElementById("myTr" + i).appendChild(z);
            
            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].additionalInfo);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);
            
            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].name);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);
            
            var z = document.createElement("TD");
            var t = document.createTextNode(response[i].username);
            z.appendChild(t);
            document.getElementById("myTr" + i).appendChild(z);
            
            var z = document.createElement("TD");
            var a = document.createElement('a');
            var id = response[i].requestId;
            var rowID = "myTr" + i;
            var linkText = document.createTextNode("Delete");
            a.appendChild(linkText);
            a.title = "Delete";
            a.onclick = (function (id, rowID) {
                return function () {
                    deleteRow(id, rowID);
                }
            })(id, rowID);
            z.appendChild(a);
            document.getElementById("myTr" + i).appendChild(z);

	}}
        	 function deleteRow(userID, rowID) {
        		
        		
        		
        		$.ajax({
        			type : "POST",
        			url : "deleteUserDetails.htm?userID="+userID,
        			
        			contentType: "application/json",
        			dataType : "json",
        			success : function(response) {
        				alert(response);
        				var row = document.getElementById(rowID);
                        row.parentNode.removeChild(row);
        			},
        		
        			error : function(){
        				alert("Error");
        				//write whatever you want here
        			}

        		});
        	}
	
	function displayTheContent(response){
		$("#results").empty();
		$("#resultsRequest").empty();
		for(var i=0, l = response.length; i < l; i++){
			    var user = response[i];
			    username= user.username;
				email= user.email;
		    	gender= user.gender;
			    age= user.age;
			    subjectCategory= user.subjectCategory;
		        tutoringType= user.tutoringType;
			
			alert(username +" " + email+" " + gender +" " + age +" " + subjectCategory+" " + tutoringType );
			
		}
			
			var x = document.createElement("TABLE");
            x.setAttribute("id", "myTable");
            x.setAttribute("border", "2");
            document.getElementById("results").appendChild(x);
            var y = document.createElement("TR");
            y.setAttribute("id", "myTr");
            document.getElementById("myTable").appendChild(y);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Username");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Email");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            

            var z = document.createElement("TH");
            var t = document.createTextNode("Gender");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Age");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Subject Category");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
            var z = document.createElement("TH");
            var t = document.createTextNode("Tutoring Type");
            z.appendChild(t);
            document.getElementById("myTr").appendChild(z);
            
           
            	
            for (var count = 0; count < 1; count++) {
            var A = document.createElement("TR");
            A.setAttribute("id", "myTr" + count);
            document.getElementById("myTable").appendChild(A);

            var z = document.createElement("TD");
            var t = document.createTextNode(username);
            z.appendChild(t);
           document.getElementById("myTr" + count).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(email);
            z.appendChild(t);
         document.getElementById("myTr" + count).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(gender);
            z.appendChild(t);
          document.getElementById("myTr" + count).appendChild(z);

            var z = document.createElement("TD");
            var t = document.createTextNode(age);
            z.appendChild(t);
     document.getElementById("myTr" + count).appendChild(z);
            
            var z = document.createElement("TD");
            var t = document.createTextNode(subjectCategory);
            z.appendChild(t);
        document.getElementById("myTr" + count).appendChild(z);
            
            var z = document.createElement("TD");
            var t = document.createTextNode(tutoringType);
            z.appendChild(t);
            document.getElementById("myTr" + count).appendChild(z);
            }
            
            var myTable = document.getElementById('myTable ');
            myTable.style.border="1px solid red";}
		
	
</script>
</head>
<body>
 
	<div> 
			<h1><img height="150" width="150" src="${requestScope.pictureName}" /></h1>
	</div>
    <div>
		<input type="submit" onclick="sampleAjax()" value="View My Details" />
	</div>
	<div id="results"></div>
	
	<div>
		<input type="submit" onclick="getRequest()" value="View My Request" />
	</div>
	<div id="resultsRequest"></div>
<div>
	<form action="updateP.htm">
		<input type="submit"  value="Update Password" />
	</form>
	</div>
	
	
<p><a href="redirect.htm">Go To Home Page!</a></p>
</body>
</html>