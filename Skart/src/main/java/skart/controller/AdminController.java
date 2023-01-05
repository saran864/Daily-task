package skart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skart.model.Admin;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		Admin admin=new Admin(uname,pwd);

		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			PreparedStatement getQuery = c
					.prepareStatement("select userName from Admin where userName=? and password=?");
			getQuery.setString(1, admin.getUserName());
			getQuery.setString(2, admin. getPassword());
			ResultSet rs = getQuery.executeQuery();
			
			if (rs.next()) {
				  RequestDispatcher rd = 
				            getServletContext().getRequestDispatcher("/AdminPage.jsp");
				        rd.forward(request, response);
				
			} else {
				  pw.println("<html>");
				  pw.println("<body><h1>Wrong Passoword !</h1></body>");
				  pw.println("</html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doGet(request, response);
	}



}

