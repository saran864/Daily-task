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


import javax.servlet.http.HttpSession;

import skart.model.Vendor;


@WebServlet("/VendorsController")
public class VendorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VendorsController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String vname = request.getParameter("username");
		String pwd = request.getParameter("password");
		HttpSession session=request.getSession();
		
		Connection c;
		try {
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			PreparedStatement getQuery = c
					.prepareStatement("select username,password,checked from Vendor where username=? and password=?");
			getQuery.setString(1,vname);
			getQuery.setString(2, pwd);
			
			ResultSet rs = getQuery.executeQuery();
			if (rs.next()) {
				int check=rs.getInt("checked");
				session.setAttribute("vendorId", vname);
				if(check==0)
				{
					session.setAttribute("vendorId", vname);
					RequestDispatcher rd=request.getRequestDispatcher("/VendorChangePassword.jsp");
	                rd.forward(request, response);	
				}
				else
				{
					session.setAttribute("vendorId", vname);
					RequestDispatcher rd=request.getRequestDispatcher("/VendorPage.jsp");
	                rd.forward(request, response);	
				}
				
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
		Verfication vfy=new Verfication();
		
		try {
	    int supId =0;
		PreparedStatement getQuery = Jdbc.getInstance().prepareStatement("insert into Vendor values(?,?,?,?,?,?,?,?)");
		getQuery.setInt(1, supId);
		getQuery.setString(2, sName);
		getQuery.setString(3, cName);
		getQuery.setString(4, uName);
		getQuery.setString(5, pwd);
		getQuery.setString(6, emaiId );
		getQuery.setLong(7, contactNo);
		getQuery.setInt(8,0);
		getQuery.executeUpdate();
		getQuery.close();
		Vendor vendor=new Vendor(uName,emaiId,pwd);
		if(vfy.vendorsEmailVerification(vendor))
		{
			PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<script>");
			pw.println( "alert('Successfully Mail Sended to the Vendor')");
			pw.println("setTimeout(myURL, 3000);");
			pw.println("function myURL() { document.location.href = 'AdminPage.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
			pw.println("</html>");
		}

	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("NotConnected");
	}

		
	}

}
