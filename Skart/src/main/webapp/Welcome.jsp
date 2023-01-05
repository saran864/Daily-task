<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Skart</title>
<style>
body {

   background-image:url(https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);


}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}


<%

Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select * from Register");
        ResultSet resultset  = ps.executeQuery();
%>
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
<body><center>
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
   <TD> <%= resultset.getString(1) %></td>
      <TD> <%= resultset.getString(2) %></td>
               <TD> <%= resultset.getString(3) %></TD>
               <TD> <%= resultset.getString(6) %></TD>
  </tr>
 <%} %> 
</table>
</body>
</html>


