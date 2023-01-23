package skart.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import skart.DAO.OrderDAO;
import skart.model.DeliveryAddress;
import skart.model.SkartOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();

	}

	static OrderDAO orders = new OrderDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String imgurl=request.getParameter("image");
		String userid = (String) session.getAttribute("uname");
		int prodId= (Integer.parseInt((String) session.getAttribute("prodId")));
		String pname = request.getParameter("ProductName");
		int pQty=Integer.parseInt(request.getParameter("quantity"));
		int pprice = Integer.parseInt(request.getParameter("ProductPrice"));
		String paymentMethod = request.getParameter("Payment");
		int Deliverycharge = Integer.parseInt(request.getParameter("Deliverycharge"));
		int totalcost=Integer.parseInt(request.getParameter("totalcost"));
		long mobileNumber = Long.parseLong(request.getParameter("mobilenum"));
		String vendorNAme = (String) session.getAttribute("vname");
		String streetAddress = request.getParameter("streetaddress");
		String town_city = request.getParameter("town");
		String state_country = request.getParameter("state");
		int postcode = Integer.parseInt(request.getParameter("zipcode"));
	
		
	SkartOrder order = new SkartOrder(imgurl,userid,prodId, pname, pprice, pQty, paymentMethod, Deliverycharge, vendorNAme,totalcost);
	


		DeliveryAddress delivery = new DeliveryAddress(streetAddress, town_city, state_country, postcode, mobileNumber);
		OrderDAO.placeOrder(order);
	OrderDAO.deliveyAddress(delivery) ;
		
	PrintWriter pw1=response.getWriter();
	pw1.println("<html>");
	pw1.println("<script>");
	pw1.println( "alert('Product Ordered Successfully')");
	pw1.println("setTimeout(myURL, 3000);");
	pw1.println("function myURL() { document.location.href = 'UserHome.jsp'}");
	pw1.println("</script>");
	pw1.println("<body><center><br><br><img src='https://i.pinimg.com/originals/c1/bc/d8/c1bcd8a8c945b53da6b29f10a2a553c0.gif'  style='height:350px; width:350px;'  ></center></body>");
	pw1.println("</html>");


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
