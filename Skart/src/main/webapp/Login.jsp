<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<center>
	<h1>Login</h1>
</center>
<style>
body {
	 background-image:url( https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
background-size:cover;
}
input[type=text], input[type=password], input[type=text], input[type=text],
	input[type=text] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px ;
    display: inline-block;
	border: 1px solid #04AA6D;
	box-sizing: border-box;
}
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
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
span.psw {
	float: right;
	padding-top: 16px;
}
</style>
</head>
<script>
function myFunction() {
  var x = document.getElementById("myPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
<body>
		
	<center>
		<form action="Skart" method="get">
			<img
				src="https://p.kindpng.com/picc/s/78-785904_block-chamber-of-commerce-avatar-white-avatar-icon.png"
				alt="Avatar" class="avatar"><br>
			<input type="text" name="username"placeholder="Username" required ><br>
	         <input type="password"  name="password" class="form-control" placeholder="Password" id="myPassword" required><br>
	           <input type="checkbox" onclick="myFunction()" >Show Password<br>
                <button>Login</button><br>
                <a href="ForgetPassword.jsp" >Forget Password</a><br>
                <a href="VendorLogin.jsp" >Vendor Login</a><br>
                <a href="AdminLogin.jsp" >Admin Login</a>
		</form>
	</center>
</body>
</html>