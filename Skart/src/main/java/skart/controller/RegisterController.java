package skart.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import skart.DAO.UserDAO;
import skart.model.SkartUser;
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session=request.getSession();
	  SkartUser skartuser=( SkartUser)session.getAttribute("UserRegister");
	   UserDAO userdao =new UserDAO();
	   String otp=(String) session.getAttribute("OTP");
	   PrintWriter pw=response.getWriter();
		if(otp.equals(skartuser.getCode())&& userdao.register( skartuser) )
				{
		
				
				 session.setAttribute("name",skartuser.getName()); 
				  session.setAttribute("uname",skartuser.getUsername());
					pw.println("<html>");
					pw.println("<script>");
					pw.println("setTimeout(myURL, 2000);");
					pw.println("function myURL() { document.location.href = 'UserHome.jsp'}");
					pw.println("</script>");
					pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif' style='height:450px; width:450px;'></center></body>");
					pw.println("</html>");
			   
			       
				}
		else {
			 response.sendRedirect("Register.jsp");
			
		}
		
		doGet(request, response);
	}


}