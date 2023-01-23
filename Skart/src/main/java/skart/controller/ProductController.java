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
import javax.servlet.http.HttpSession;


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
			HttpSession session=request.getSession();
		    int prodId =0;
			System.out.println("connected Successfuly");
			PreparedStatement getQuery = Jdbc.getInstance().prepareStatement("insert into Products values(?,?,?,?,?,?,?)");
			getQuery.setInt(1, prodId);
			getQuery.setString(3, request.getParameter("productName"));
			getQuery.setString(2,  request.getParameter("productImgUrl"));
			getQuery.setString(4, request.getParameter("productDescripton"));
			getQuery.setInt(5, Integer.parseInt(request.getParameter("productPrice")));
			getQuery.setInt(6, Integer.parseInt(request.getParameter("productCount")));
			getQuery.setString(7, (String)session.getAttribute("vendorId"));
			getQuery.executeUpdate();
			getQuery.close();
			PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<script>");
			pw.println( "alert('Product Added Successfully')");
			pw.println("setTimeout(myURL, 3000);");
			pw.println("function myURL() { document.location.href = 'AddProduct.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
			pw.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NotConnected");
		}
	}

}
