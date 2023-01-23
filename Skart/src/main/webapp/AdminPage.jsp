<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Html>   
<Head>    
<Title>   
 Skart
</Title>
 <link rel="stylesheet" href="skart.css">
<style> 

header {
background-color: white ;
position: fixed;
margin :0px auto;
top: 0.1px;
height: 50px;
left :0;
right :0;
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
margin: 40px;
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
border-radius: 8px;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
body {
	font-family: Arial;
	background-image:url(https://pwpblog.wpengine.com/wp-content/uploads/2022/08/Ecommerce-Website-Promotion_Final.png);
	background-size:cover;
}


</style> 
</Head>
<Body>

<header>
<h1>SKART</h1>
<nav><ul>
<li><a href="VendorsRegister.jsp"><b>Add Vendors</b> </a></li>
<li><a href="VendorList.jsp"><b>View Vendors</b></a></li>
<li><a href="UserList.jsp"> <b>View Customers</b> </a></li>
<li><a href="HomePage.jsp"> <b>Home</b> </a></li>
</ul>
</header>



</Body> 
</Html>

 
