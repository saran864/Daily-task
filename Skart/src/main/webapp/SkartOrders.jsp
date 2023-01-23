
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



input[type=text], input[type=password], input[type=number] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #04AA6D;
	box-sizing: border-box;
}

a {

display: block;
color: black;
border-radius: 8px;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
.button
{

  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

}
button {
	background-color: #04AA6D;
	color: black;
	padding: 14px 20px;
	margin: 5px 0;
	border: none;
	cursor: pointer;
	width: 15%;
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


span {
  	width: 12%;
	padding: 12px 15px;
	margin: 5px 0;
	display: inline-block;
	border: 1px solid #04AA6D;
	box-sizing: border-box;
    background-color:white;
}


	.cancelbtn {
		width: 50%;
	}
}
</style>
</head>
<%
PrintWriter pw=response.getWriter();
String productid = request.getParameter("click");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select productName,productPrice,vendorId,productCount,productImageUrl from Products where productId=? ");
ps.setString(1, productid);
ResultSet rs = ps.executeQuery();
String pname ="";
int pprice = 0;
String vname="";
int pQty=0;
String imageurl="";
while (rs.next()) {
	pname = rs.getString("productName");
	pprice = rs.getInt("productPrice");
	vname =rs.getString("vendorId");
	pQty=rs.getInt("productCount");
	imageurl=rs.getString("productImageUrl");
}
session.setAttribute("prodId", productid );
session.setAttribute("vname", vname);


%>

<script>
let quantity = 0;
let costPerItem =<%=pprice%>;
let productQty=<%=pQty%>;
function increment() {
	 if (quantity < productQty ) {
	quantity++;
    document.getElementById("quantity-display").innerHTML = quantity;
    document.getElementById("quantity").value = quantity;
    updateTotalCost();
    checkQuantity();
   
}
}
function decrement() {
    if (quantity > 1) {
        quantity--;
        document.getElementById("quantity-display").innerHTML = quantity;
        document.getElementById("quantity").value = quantity;
        updateTotalCost();
        checkQuantity();
    }
}
function updateTotalCost() {
    let Cost = quantity *<%=pprice%>;
    let totalCost=Cost+50;
    costPerItem=totalCost;
    document.getElementById("totalcost-display").innerHTML = totalCost;
    document.getElementById("totalcost").value =totalCost;
}
function checkQuantity(){
	if(quantity==productQty)
		{
		alert("Out of Stack !! Sorry We have only "+<%=pQty%>+" Products ");
		}
}
</script>


<body>	
	
	<center>
		<form action="OrderController" method="post">
		<img src="https://png.pngtree.com/png-vector/20190729/ourlarge/pngtree-shopping-garments-buy-online-shop-flat-color-icon-vector-png-image_1622644.jpg"
				alt="Avatar" class="avatar">
				<br>
	<input type="text" name="ProductName"placeholder="Product Name" value="<%=pname%>"required readonly  ><br>
		<input type="text" name="ProductPrice"placeholder="Product price" value="<%=pprice%>"required readonly  ><br>
		 <input type="hidden" name="image"  value="<%=imageurl%>" />
		 <input type="text" name="Deliverycharge" class="form-control" placeholder="Deliverycharge" value="50" required readonly><br>
			    <input type="hidden" name="quantity" id="quantity" value="" />
			    <input type="hidden" name="totalcost" id="totalcost" value="" />
<input type="button" onclick="decrement()" value="-">
<span id="quantity-display" ontenteditable="true"><%=1%></span>
<input type="button" onclick="increment()" value="+">
<span id="totalcost-display" ><%=pprice+50%></span><br>
		<input type="radio" name="Payment" value="Cash on Delivery" >Cash on Delivery<input type="radio" name="Payment" value="Online Payment" >Online Payment<br>
	    <input type= "text" name="streetaddress" class="form-control" placeholder="Street Address"><br> 
		<input type= "text" name="town" class="form-control" placeholder="Town/City"><br>
		<input type= "text" name="state" class="form-control" placeholder="State/County"><br> 
		<input type= "text" name="zipcode" class="form-control" placeholder="Postcode/ZIP"><br> 
		<input type= "text" name="mobilenum" class="form-control" placeholder="Phone"><br>
			 <button class="button"  onclick="transfer()">Place Order</button>
			 
		</form>
	</center>
</body>
</html>