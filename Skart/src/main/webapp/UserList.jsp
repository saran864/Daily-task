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
PreparedStatement ps =Jdbc.getInstance().prepareStatement( "select * from Register") ;
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
		<H1>Skart UsersList</H1>
		<table>
			<tr>
				<th>Regno</th>
				<th>FullName</th>
				<th>Age</th>
				<th>Address</th>
			</tr>
			<% while(resultset.next()){ %>
			<tr>
				<TD><%= resultset.getString(1) %></td>
				<TD><%= resultset.getString(2) %></td>
				<TD><%= resultset.getString(3) %></TD>
				<TD><%= resultset.getString(6) %></TD>
			</tr>
			<%} %>
		</table>
		<button ><a href="AdminPage.jsp" >Back</a></button>
</body>
</html>


