<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<Html>   
<Head>    
<Title>   
 Skart
</Title>
<link rel="stylesheet" href="Skart.css"> 
<style>
.popup {
	 background-color: #ffffff;
    width: 420px;
    padding: 30px 40px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
    border-radius: 8px;
    font-family: "Poppins",sans-serif;
    display: none; 
    text-align: center;}</style>
</Head>
<script>
</script>
<Body class="Home">
<header>
<h1><marquee behaviour="slide" direction="left"   width = "50%">SKART</marquee></h1>
<nav>
<ul>
<li><a href="Register.jsp" ><b>SignUp</b> </a></li>
<li><a href="Login.jsp"><b>Login</b></a></li>
<li><a href=""><b>About us</b></a></li>
<li><b><a>Customer Care : 1800 232 546</a></b></li>
</ul>
</nav>
</header>
<br>
<br>
<br>
<center><div class="popup">
<h2>Thanks for visiting Skart </h2>
<p>please Login or Signup to  continue  </p><br>
<a class="button" href="Login.jsp"><b>Login</b></a>
<a class="button" href="Register.jsp" ><b>SignUp</b></a>
 </div>
 </center>
 <br>
<table >
<tr>
<%Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select * from Products");
ResultSet resultset  = ps.executeQuery(); %>
<% while(resultset.next()){ %>
<div class="content" id="myDiv"> 
<center>
<br>
<img src="<%=resultset.getString(2)%>" style="height:250px; width:230px;" id="myImage"></img>
<h4> <%= resultset.getString(3) %></h4>
<p><%=resultset.getString(4) %></p>
<h3>&#8377;<%=resultset.getInt(5) %></h3>
<ul>
<br><br>

<button  class="cart"  >ADD TO CART</button>
<button onclick="openForm()"  class="buynow" id="popup-button"> BUY NOW</button>

 </ul></tr>
</center>
</div>

<%} %>
</table>


</Body> 
</Html>

 
