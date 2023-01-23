
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*,skart.DAO.*,skart.model.*,skart.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify Email</title>
<center>
	<h1>Verify</h1>
	<h4 style="color:red;">Successfully OTP Sent to EmailAddress Please Verify!! </h4>
</center>
<style>
body {

  background-image:url(https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);

   background-repeat:no-repeat;

   background-size:cover;

}




input[type=text], input[type=password], input[type=text], input[type=text],
	input[type=text] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #04AA6D;
	box-sizing: border-box;
	border-radius =8px;
}

button {
	background-color: #04AA6D;
	color: black;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
	border-radius: 8px;
	text-decoration: none;

	padding: 14px 20px;

}
.button
{
border-radius: 8px;
width: 10%;
background-color: #04AA6D;
padding: 14px 20px;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

img.avatar {
	width: 10%;
	border-radius: 50%;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

.container {
	padding: 16px;ain’:
}

span.psw {
	float: right;
	padding-top: 16px;
}

@media screen and (max-width: 200px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 50%;
	}
}
</style>
</head>
<body>
 <%
  SkartUser skartRegister=(SkartUser)session.getAttribute("UserRegister");
UserDAO userdao=new UserDAO();
%>
	
<script>
function validateForm() {
	  let x = document.forms["myForm"]["otp"].value;
	  if (x == "<%=(String)session.getAttribute("OTP")%>"  ) {
		  alert(" Successfully Verified!");
		 
	 sd
	  }
	  else
		  {
		  alert(" Sorry Otp Not Match!");
		   
		  }  
	}	
</script>
	<center>			
		<form name="myForm" action="RegisterController" method="post"  >
		<br> 
		<input type="text" name="otp" class="form-control" placeholder="Enter otp" required><br>
			 <button  class="button"  onclick="validateForm()">Verify</button><br>
		</form>
	</center>
</body>
</html>