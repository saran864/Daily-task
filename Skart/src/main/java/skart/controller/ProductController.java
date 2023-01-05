package skart.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    int prodId =0;
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			System.out.println("connected Successfuly");
			PreparedStatement getQuery = c.prepareStatement("insert into Products values(?,?,?,?,?,?,?)");
			getQuery.setInt(1, prodId);
			getQuery.setString(3, request.getParameter("productName"));
			getQuery.setString(2,  request.getParameter("productImgUrl"));
			getQuery.setString(4, request.getParameter("productDescripton"));
			getQuery.setInt(5, Integer.parseInt(request.getParameter("productPrice")));
			getQuery.setInt(6, Integer.parseInt(request.getParameter("productCount")));
			getQuery.setString(7, (String) request.getParameter("vid"));
			getQuery.executeUpdate();
			getQuery.close();
			PrintWriter pw=response.getWriter();
			  pw.println("<html>");
			  pw.println("<body><h1>Added Successfully!</h1></body>");
			  pw.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NotConnected");
		}
	}

}
