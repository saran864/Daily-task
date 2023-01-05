
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ page import= "java.sql.*"%>
	    <%@ page import= "java.io.*,java.lang.*,java.util.*,java.net.*,java.util.*,java.text.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>skart orders</title>
<center>
	<h1>Product Order form</h1>
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

<%
System.out.println(session.getAttribute("name"));
System.out.println(session.getAttribute("regid"));
System.out.println(session.getAttribute("uname"));


PrintWriter pw=response.getWriter();
String productid = request.getParameter("click");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select productName,productPrice,vendorId from Products where productId=? ");
ps.setString(1, productid);
ResultSet rs = ps.executeQuery();
String pname = "";
int pprice = 0;
String vname="";
while (rs.next()) {
	pname = rs.getString("productName");
	pprice = rs.getInt("productPrice");
	vname =rs.getString("vendorId");
}
session.setAttribute("vname", vname);
session.setAttribute("prodId", productid);
%>
<body>		
	<center>
		<form action="OrderController" method="post">
		<img src="https://png.pngtree.com/png-vector/20190729/ourlarge/pngtree-shopping-garments-buy-online-shop-flat-color-icon-vector-png-image_1622644.jpg"
				alt="Avatar" class="avatar">
				<br>
	<input type="text" name="ProductName"placeholder="Product Name" value="<%=pname%>"required readonly  ><br>
		<input type="text" name="ProductPrice"placeholder="Product price" value="<%=pprice%>"required readonly  ><br>
		<input type="text" name="Quantity" placeholder="Enter Quantity" required ><br>	
		<input type="radio" name="Payment" value="Cash on Delivery" >Cash on Delivery<input type="radio" name="Payment" value="Online Payment" >Online Payment<br>
	    <input type="text" name="Deliverycharge" class="form-control" placeholder="Deliverycharge" value="50"required readonly><br>
	    <input type= "text" name="streetaddress" class="form-control" placeholder="Street Address"><br> 
		<input type= "text" name="town" class="form-control" placeholder="Town/City"><br> 
		<input type= "text" name="state" class="form-control" placeholder="State/County"><br> 
		<input type= "text" name="zipcode" class="form-control" placeholder="Postcode/ZIP"><br> 
		<input type= "text" name="mobilenum" class="form-control" placeholder="Phone"><br> 
			 <button>Place Order</button>
		</form>
	</center>
</body>
</html>