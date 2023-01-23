
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<center>
	<h1>SignUp</h1>
	<h4 style="color:red;">Please Give original EmailAddress  For Verification !! </h4>
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
	padding: 16px;
}




</style>
</head>
<body>


	<center>
			<img src="https://p.kindpng.com/picc/s/78-785904_block-chamber-of-commerce-avatar-white-avatar-icon.png"
				alt="Avatar" class="avatar">
				
		<form action="Skart" method="post">
		<br> 
			<input type="text" name="name" placeholder="Fullname" required ><br>
			<input type="text" name="age"placeholder="Age" required  ><br>
			<input type="text" name="username"placeholder="Email Id" required > <br>
		<input id=password"  type="password" name="password" class="form-control" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"required><br>
	
		<input type= "text" name="address" class="form-control" placeholder="Address"><br>
			 <button  class="button" >Verify</button><br>
			 	<p style="color:blue;">
Use a mix of alphabetical and numeric, a mixture of upper and lowercase, and special characters</p>
			
		</form>
	</center>
</body>
</html>