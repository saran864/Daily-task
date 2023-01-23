<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*,skart.DAO.*,skart.model.*,skart.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success..</title>
</head>
<script>
setTimeout(myURL, 5000);
function myURL() { document.location.href = 'Login.jsp'};
</script>
<body>
<%
SkartUser skartuser=(SkartUser)session.getAttribute("userRegister");
try{
	PreparedStatement c=Jdbc.getInstance().prepareStatement("update  Register set Password=? where Username=?");
	c.setString(2,skartuser.getUsername());
	c.setString(1,skartuser.getPassword());
	c.executeUpdate();
}catch(Exception e)
{
	e.printStackTrace();
}
%>

<center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center>
</body>
</html>