package skart.controller;

import javax.servlet.http.HttpServlet;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VendorsController")
public class VendorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VendorsController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			PreparedStatement getQuery = c
					.prepareStatement("select username,password from Vendor where username=? and password=?");
			getQuery.setString(1,uname);
			getQuery.setString(2, pwd);
			
			ResultSet rs = getQuery.executeQuery();
			if (rs.next()) {
				
				RequestDispatcher rd=request.getRequestDispatcher("/VendorPage.jsp");
                rd.forward(request, response);	
			} else {
				  pw.println("<html>");
				  pw.println("<body><h1>Wrong Password !</h1></body>");
				  pw.println("</html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sName = request.getParameter("suppilername");
		String cName = request.getParameter("companyName");
		String uName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String emaiId = request.getParameter("email");
		Long contactNo = Long.parseLong(request.getParameter("contactNo"));
		try {
	    int supId =0;
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
		System.out.println("connected Successfuly");
		PreparedStatement getQuery = c.prepareStatement("insert into Vendor values(?,?,?,?,?,?,?)");
		getQuery.setInt(1, supId);
		getQuery.setString(2, sName);
		getQuery.setString(3, cName);
		getQuery.setString(4, uName);
		getQuery.setString(5, pwd);
		getQuery.setString(6, emaiId );
		getQuery.setLong(7, contactNo);
		getQuery.executeUpdate();
		getQuery.close();

	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("NotConnected");
	}

		
	}

}
