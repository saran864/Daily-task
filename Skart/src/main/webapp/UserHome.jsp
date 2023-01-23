<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<Html>   
<Head>   
<link rel="stylesheet" href="Skart.css"> 
<Title>   
 Shopping 
</Title>

</Head>

<Body>
<% 
String name=(String)session.getAttribute("name");
Integer regid=(Integer)session.getAttribute("regid");
String  uname=(String) session.getAttribute("uname");
PrintWriter pw=response.getWriter();
session.setAttribute("name",name); 
session.setAttribute("regid",regid); 
session.setAttribute("uname",uname); 
if((String)session.getAttribute("uname")==null)
{
	
	                pw.println("<html>");
	                pw.println("<script>");
					pw.println( "alert('Session Expired Try Again')");
					pw.println("setTimeout(myURL, 2000);");
					pw.println("function myURL() { document.location.href = 'Login.jsp'}");
					pw.println("</script>");
					pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif' style='height:450px; width:450px;'></center></body>");
					pw.println("</html>");
} 

%>

<header>
<h1> <marquee width="40%" direction="left" >SKART</marquee></h1>
<nav><ul>
<li><a ><b><%=session.getAttribute("name")%></b></a></li>
<li><a href="MyOrders.jsp"><b>My Orders</b></a></li>
<li><a href="MyCart.jsp"> <b>My Cart </b> </a></li>
<li><a href="HomePage.jsp"><b>Logout</b></a> </li>
</ul>
</nav>
</header>
<br>
<br>
<br>
<%Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select * from Products ");
ResultSet resultset  = ps.executeQuery(); %>
<% while(resultset.next()){ %>
<table >
<div class="content" id="myDiv"> 
<center>
<br>
<img src="<%=resultset.getString(2)%>" style="height:250px; width:230px;" id="myImage"></img>
<h4> <%= resultset.getString(3) %></h4>
<p><%=resultset.getString(4) %></p>
<h3>&#8377;<%=resultset.getInt(5) %></h3>
<ul>
<br><br>
<a href="SkartCarts?click=<%=resultset.getString(1)%>" class="cart" >ADD TO CART</a>
<a href="SkartOrders.jsp?click=<%=resultset.getString(1)%>" class="buynow">BUY NOW</a> </ul></tr>
		
<%} %>
</div>
</center>
</tr>
</table>
</Body> 
</Html>

 
