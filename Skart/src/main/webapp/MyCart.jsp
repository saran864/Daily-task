<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,skart.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Skart</title>
<style>
button {
	background-color: #04AA6D;
	color: white;
	padding: 10px 5px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	border-radius: 8px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

a{
text-decoration :none;
color :black;
}

<%
PreparedStatement ps =Jdbc.getInstance().prepareStatement(" select m.prodId,p.productImageUrl,p.productName,p.productPrice from Products as p,Mycart as m where m.prodId=p.productId and m.CusId= ?") ;
       ps.setString(1,(String)session.getAttribute("uname"));
       ResultSet resultset  = ps.executeQuery() ;
 %> td, th {
	border: 1px solid #dddd;
	text-align: left;
	padding: 8pxl
}

tr:nth-child(even) {
	background-color: #ddddd;
}
</style>
</head>
<body>
	<center>
		<H1>My Cart</H1>
		<table>
			<tr>
				<th>Product </th>
				<th>ProductName</th>
				<th>ProductPrice</th>
				<th>Click</th>
			</tr>
			<% boolean b=false; while(resultset.next()){b=true; %>
			<tr>
			<td><img src="<%=resultset.getString(2)%>" style="height:150px; width:300px;"></img></td>
				<TD><h4> <%= resultset.getString(3) %></h4></td>
				<TD><h3>&#8377;<%=resultset.getInt(4) %></h3></TD>
				<TD><a href="SkartOrders.jsp?click=<%=resultset.getString(1)%>" >Buy Now</a><br><a href="Remove.jsp?click=<%=resultset.getString(1)%>">Remove</a></TD>
			</tr>
			
			<%}%>
			</table>
			<% if(b==false){%>
			<h1>No items Available in your Cart</h1>
			<%} %>
			<button ><a href="UserHome.jsp" >Back</a></button>
		
</body>
</html>


