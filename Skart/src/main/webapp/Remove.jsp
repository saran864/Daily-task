<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,skart.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Items</title>
</head>
<script>

setTimeout(myURL, 2000);
function myURL() { document.location.href = 'MyCart.jsp'}
</script>
<body>
<center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  >
<%
try {
	PreparedStatement ps=Jdbc.getInstance().prepareStatement("delete from Mycart where CusId=? and prodId=?");
	ps.setString(1,(String) session.getAttribute("uname"));
	ps.setInt(2, Integer.parseInt(request.getParameter("click")));
	ps.executeUpdate();
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</center>
</body>
</html>