<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders List</title>
<style>
body {
	background-image:
		url(https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}


  td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<%
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps =c.prepareStatement( "Select  concat( 'skart ',LPAD(deliveryId, 3, 0)) as deliveryId, streetAddress,town_city,state_county,postcode_zip,mobno FROM DeliveryAddress as d INNER JOIN customerOrders as c ON d.deliveryId=c.orderId and c.vendorname=?") ;
ps.setString(1,(String)session.getAttribute("vendorId"));
ResultSet resultset  = ps.executeQuery();          
 %>
<body>
	<center>
		<H1>Delivery Address</H1>
		<table>
			<tr>
			     <th>OrderId</th>
			     <th>StreetAddress</th>
				<th>Town/City</th>
				<th>State/Country</th>
				<th>PostCode</th>
				<th>MobileNumber</th>
			</tr>
			<% while(resultset.next()){ %>
			<tr>
				<TD><%= resultset.getString(1) %></td>
				<TD><%= resultset.getString(2) %></td>
				<TD><%= resultset.getString(3) %></TD>
				<TD><%= resultset.getString(4) %></TD>
				<TD><%= resultset.getString(5) %></TD>
				<TD><%= resultset.getString(6) %></TD>
						
			</tr>
			<%} %>
		</table>
</body>
</html>


