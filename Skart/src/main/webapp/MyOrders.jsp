<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyOrders</title>
<style>

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	border-radius :8px;
}
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

<%
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps =c.prepareStatement( " select concat( 'skart ',LPAD(orderId, 3, 0)) as orderId, imageurl, productName, productPrice, productQny,paymentType, orderDate, totalcost  from customerOrders where customer_id=?") ;
ps.setString(1,(String)session.getAttribute("uname"));
        ResultSet resultset  = ps.executeQuery() ;
        
 %> td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

</style>
</head>
<body>
	<center>
		<H1>My Orders</H1>
		<table>
			<tr>
			     <th>OrderId</th>
			     <th>Product</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Payment Type</th>
				<th>Order Date</th>
				<th>TotalCost</th>
				

			</tr>
			<% 
			boolean b=false;
			while(resultset.next()){ 
				
			%>
			<tr>
				<TD><%= resultset.getString(1) %></td>
				<TD><img src="<%=resultset.getString("imageurl")%>" style= "height:250px; width:400px;"></img></td>
				<TD><%= resultset.getString(3) %></TD>
				<TD><%= resultset.getString(4) %></TD>
				<TD><%= resultset.getString(5) %></TD>
				<TD><%= resultset.getString(6) %></TD>
				<TD><%= resultset.getString(7) %></TD>
				<TD><%= resultset.getString(8) %></td>
			</tr>
			<%  b=true;}%>
			
		</table>
				
			<% 
			if(b!=true)
			{%>
			<h1> Sorry !! No Orders Found</h1>
		<%} %>
		<button onclick="history.back()">Back</button>
	
</body>
</html>

