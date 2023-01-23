package skart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import skart.DAO.UserDAO;
import skart.model.SkartUser;


@WebServlet("/Skart")
public class Skart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Skart() {
		super();

	}

	static UserDAO sc = new UserDAO();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int a = Integer.parseInt(age);
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String adds = request.getParameter("address");
		Verfication vf=new Verfication();
		String otp=vf.getRandomNumberString();
		SkartUser userRegister = new SkartUser(name, a, uname, pwd, adds,otp);
		   session.setAttribute("UserRegister", userRegister);
		if(vf.emailVerification(userRegister))
		{   session.setAttribute("OTP",otp);
			response.sendRedirect("Verify.jsp");
			}
		
		else {
			  pw.println("<html>");
			  pw.println("<body><h1>Otp Not Send !</h1></body>");
			  pw.println("</html>");
		}
		
	}
			

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session= request.getSession();
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		SkartUser login = new SkartUser(uname, pwd,pwd);

		try {
			PreparedStatement getQuery = Jdbc.getInstance()
					.prepareStatement("select  RegNo,RegisterName from Register where Username=? and Password=?");
			getQuery.setString(1, login.getUsername());
			getQuery.setString(2, login.getPassword());
			
			ResultSet rs = getQuery.executeQuery();
			
			int regid=0;
			if (rs.next()) {
			
				  String usname=rs.getString("RegisterName");
				  
				  session.setAttribute("name",usname); 
				  session.setAttribute("uname", uname);
				  pw.println("<html>");
					pw.println("<script>");
					pw.println("setTimeout(myURL, 2000);");
					pw.println("function myURL() { document.location.href = 'UserHome.jsp'}");
					pw.println("</script>");
					pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif' style='height:450px; width:450px;'></center></body>");
					pw.println("</html>");
				
			} else {
				pw.println("<html>");
				pw.println("<script>");
				pw.println( "alert('Wrong username or passwrod')");
				pw.println("setTimeout(myURL, 5000);");
				pw.println("function myURL() { document.location.href = 'Login.jsp'}");
				pw.println("</script>");
				pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
				pw.println("</html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

}
