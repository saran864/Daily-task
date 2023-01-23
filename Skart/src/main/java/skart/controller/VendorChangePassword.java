package skart.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

@WebServlet("/VendorChangePassword")
public class VendorChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VendorChangePassword() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String password = request.getParameter("password"); 
	HttpSession session =request.getSession();
		try {
			
			PreparedStatement statement = Jdbc.getInstance().prepareStatement("update Vendor set password =? where username=? ");
			statement.setString(1, password);
			statement.setString(2,(String )session.getAttribute("vendorId"));
			statement.executeUpdate();
			PreparedStatement statement1 = Jdbc.getInstance().prepareStatement("update Vendor set checked=1 where username=? ");
			statement1.setString(1,(String )session.getAttribute("vendorId"));
			statement1.executeUpdate();
			pw.println("<html>");
			pw.println("<script>");
			pw.println( "alert('Password Successfully Changed')");
			pw.println("setTimeout(myURL, 5000);");
			pw.println("function myURL() { document.location.href = 'VendorPage.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
			pw.println("</html>");
		} catch (SQLException e) {
     e.printStackTrace();
			pw.println("<html>");
			pw.println("<script>");
			pw.println( "alert('Something went Wrong!! Try Again ')");
			pw.println("setTimeout(myURL, 5000);");
			pw.println("function myURL() { document.location.href = 'VendorChangePassword.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
			pw.println("</html>");
		}
	}
		
		
		
		
		
	

}
