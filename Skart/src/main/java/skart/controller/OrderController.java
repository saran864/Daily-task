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
		String userid = (String) session.getAttribute("uname");
		int prodId= (Integer.parseInt((String)session.getAttribute("prodId")));
		String pname = request.getParameter("ProductName");
		int pprice = Integer.parseInt(request.getParameter("ProductPrice"));
		int pQty = Integer.parseInt(request.getParameter("Quantity"));
		String paymentMethod = request.getParameter("Payment");
		int Deliverycharge = Integer.parseInt(request.getParameter("Deliverycharge"));
		long mobileNumber = Long.parseLong(request.getParameter("mobilenum"));
		String vendorNAme = (String) session.getAttribute("vname");
		String streetAddress = request.getParameter("streetaddress");
		String town_city = request.getParameter("town");
		String state_country = request.getParameter("state");
		int postcode = Integer.parseInt(request.getParameter("zipcode"));
		
		SkartOrder order = new SkartOrder(userid,prodId, pname, pprice, pQty, paymentMethod, Deliverycharge, vendorNAme);
		
	

		DeliveryAddress delivery = new DeliveryAddress(streetAddress, town_city, state_country, postcode, mobileNumber);
		OrderDAO.placeOrder(order);
	OrderDAO.deliveyAddress(delivery) ;
		
		RequestDispatcher rd = request.getRequestDispatcher("/UserHome.jsp");
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
