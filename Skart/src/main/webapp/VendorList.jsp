<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,skart.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Skart</title>
<style>
a{
text-decoration :none;
color :black;
}
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
body {
	background-color: #DBF9FC;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

<%
PreparedStatement ps =Jdbc.getInstance().prepareStatement( "select * from Vendor") ;
        ResultSet resultset  = ps.executeQuery() ;
 %> td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<center>
		<H1>Skart Vendors List</H1>
		<table>
			<tr>
				<th>Supplier No</th>
				<th>Supplier Name</th>
				<th>Company Name</th>
				<th>Email Id</th>
				<th>Mobile Number</th>
				<th>Verify Status</th>
			</tr>
			<% while(resultset.next()){ %>
			<tr>
				<TD><%= resultset.getString(1) %></td>
				<TD><%= resultset.getString(2) %></td>
				<TD><%= resultset.getString(3) %></TD>
				<TD><%= resultset.getString(6) %></TD>
				<TD><%= resultset.getLong(7) %></TD>
				<TD><%if(resultset.getInt(8)==1){%>Verified<%}else{%>Not Verified<%} %></TD>
			</tr>
			<%} %>
			
		
		</table>
		<button ><a href="AdminPage.jsp" >Back</a></button>
</body>
</html>


