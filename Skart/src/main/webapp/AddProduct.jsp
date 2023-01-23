
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<center>
	<h1>Add Product</h1>
</center>
<style>
body {

  background-image:url(https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);

   background-repeat:no-repeat;

   background-size:cover;

}



input[type=text], input[type=password],
	input[type=number] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #04AA6D;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: black;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
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

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
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
<%
System.out.println(session.getAttribute("vendorId"));
%>
</head>
<body>		
	<center>
			<img src="https://png.pngtree.com/png-vector/20220910/ourlarge/pngtree-shopping-logo-deisgn-modern-style-with-bag-png-image_6155427.png"
				alt="Avatar" class="avatar">
		<form action="ProductController?vid=<%=session.getAttribute("vendorId")  %>" method="post">
		<br>
			<input type="text" name="productName" placeholder="Product Name" required ><br>
			<input type="text" name="productImgUrl"placeholder="Image Url" required  ><br>
			<input type="text" name="productDescripton"placeholder="Product Description" required  ><br>
		<input type="number" name="productPrice"placeholder="Product Price" required ><br>
		<input type="number" name="productCount" class="form-control" placeholder="Product Count" required><br>
			 <button>ADD PRODUCT</button>
		</form>
	</center>
</body>
</html>
</body>
</html>