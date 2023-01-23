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


@WebServlet("/SkartCarts")
public class SkartCarts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SkartCarts() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    HttpSession session =request.getSession();
		    int cardNo=0;
		    PrintWriter pw=response.getWriter();
		try {
			PreparedStatement ps=Jdbc.getInstance().prepareStatement("insert into Mycart values(?,?,?)");
			ps.setInt(1, cardNo);
			ps.setString(2,(String) session.getAttribute("uname"));
			ps.setInt(3, Integer.parseInt(request.getParameter("click")));
			ps.executeUpdate();
			pw.println("<html>");
			pw.println("<script>");
			pw.println("setTimeout(myURL, 1000);");
			pw.println("function myURL() { document.location.href = 'UserHome.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif' style='height:450px; width:450px;'></center></body>");
			pw.println("</html>");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			pw.println("<html>");
			pw.println("<script>");
			pw.println( "alert('Already this product added in your cart')");
			pw.println("setTimeout(myURL, 2000);");
			pw.println("function myURL() { document.location.href = 'UserHome.jsp'}");
			pw.println("</script>");
			pw.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif' style='height:450px; width:450px;'></center></body>");
			pw.println("</html>");
			
				
		}
		
	
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
