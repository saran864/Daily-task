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

//import com.google.gson.Gson;

@WebServlet("/Skart")
public class Skart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Skart() {
		super();

	}

	static UserDAO sc = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int a = Integer.parseInt(age);
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String adds = request.getParameter("address");

		SkartUser userRegister = new SkartUser(name, a, uname, pwd, adds);
		
		if(sc.register(userRegister))
		{
			Connection c;
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
				PreparedStatement getQuery = c
						.prepareStatement("select  RegNo from Register where Username=?");
				getQuery.setString(1, uname);
		        
				ResultSet rs = getQuery.executeQuery();
				
				int regid=0;
				
				if (rs.next()) { 
					regid=rs.getInt("RegNo");
				  System.out.print(regid);
				  session.setAttribute("regid",regid); 
				  session.setAttribute("uname",uname); 
				  session.setAttribute("name",name); 
				RequestDispatcher rd=request.getRequestDispatcher("/UserHome.jsp");
              rd.forward(request, response);	
					
				}
					
				}catch (Exception e)
			{
					e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/UserHome.jsp");
		rd.forward(request, response);
		

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		SkartUser login = new SkartUser(uname, pwd);

		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			PreparedStatement getQuery = c
					.prepareStatement("select  RegNo,RegisterName from Register where Username=? and Password=?");
			getQuery.setString(1, login.getUsername());
			getQuery.setString(2, login.getPassword());
			
			ResultSet rs = getQuery.executeQuery();
			
			int regid=0;
			
			if (rs.next()) {
			
				  String usname=rs.getString("RegisterName");
				  regid=rs.getInt("RegNo");
				  session.setAttribute("regid",regid); 
				  session.setAttribute("name",usname); 
				  session.setAttribute("uname", uname);
				RequestDispatcher rd=request.getRequestDispatcher("/UserHome.jsp");
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

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
