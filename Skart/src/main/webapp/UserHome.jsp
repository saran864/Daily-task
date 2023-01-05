<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.io.*,java.lang.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<Html>   
<Head>   
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<Title>   
 Shopping 
</Title>
<style> 
.button {
    display: block;
    width: 115px;
    height: 25px;
    top:0.5px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
    display: inline;
    text-decoration: none;
    top:-20px;
}

header {
background-color: white ;
position: fixed;
margin :0px auto;
top: 0.1px;
height: 50px;
left: 0;  
right: 0; 
display: flex;
align-items: center;
}
header ul{
list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  }

header * {
display: inline;

}
header li {
margin: 50px;
float: left;

}
li a:hover {
  background-color: #111;
  color: white;
}
header li a {
color: black;
display: block;
color: black;
text-align: center;
padding: 14px 16px;
text-decoration: none;
border-radius: 8px;
}
body {
	font-family: Arial;
	background-color: #DBF9FC;
	background-image:url(https://pwpblog.wpengine.com/wp-content/uploads/2022/08/Ecommerce-Website-Promotion_Final.png);
	background-size:cover;
}
.checked {
  color: orange;
}
.content{
top :1px;
background-color:white;
width:30%;
heigth:10%;
margin:15px;
box-sizing :border -box;
float :left;
border-radius :20px;
cursor: pointer;
padding-top;
box-shadow:0 14px 28px rgba(0,0,0,0.25);


}

h3{
text-align :center;
font-size :30px;
margin:0;
padding-top: 10px; 
}
.gallery{
display :flex;
flex-wrap :wrap;
width :100%;
align-items :center;
margin :50 px 0;
}
img{

align-items :center;
heigth :50%;
width :50%;
}



</style> 
</Head>

<Body>
<% 
String name=(String)session.getAttribute("name");
Integer regid=(Integer)session.getAttribute("regid");
String  uname=(String) session.getAttribute("uname");
session.setAttribute("name",name); 
session.setAttribute("regid",regid); 
session.setAttribute("uname",uname); 

%>

<header>
<h1>SKART</h1>
<nav><ul>
<li><a ><b><%=session.getAttribute("name")%></b></a></li>
<li><a href="#"><b>My Orders</b></a></li>
<li><a href="#"> <b>My Cart </b> </a></li>
<li><a href="HomePage.jsp"><b>Logout</b></a> </li>
</ul>
</nav>
</header>
<br>
<br>
<br>
<%Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
PreparedStatement ps=c.prepareStatement("select * from Products");
ResultSet resultset  = ps.executeQuery(); %>
<% while(resultset.next()){ %>
<div class="content"> 
<center>
<br>
<img src="<%=resultset.getString(2)%>"></img>
<h4> <%= resultset.getString(3) %></h4>
<p><%=resultset.getString(4) %></p>
<h3>&#8377;<%=resultset.getInt(5) %></h3>
<ul>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span>
<br><br>
<a href="#" class="button" onclick="alert('Added Succssfully!')">ADD TO CART</a>
<a href="SkartOrders.jsp?click=<%=resultset.getString(1) %>" class="button">BUY NOW</a></ul>
</center>
</div>

<%} %>

</Body> 
</Html>

 
