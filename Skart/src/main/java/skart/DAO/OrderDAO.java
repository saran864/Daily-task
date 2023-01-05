package skart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import skart.model.DeliveryAddress;
import skart.model.SkartOrder;


public class OrderDAO {
	
	public static   void placeOrder( SkartOrder skorder)
	{
		 Connection c;
		 try { 
			 System.out.println("order");
			 c =DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root","password"); 
		          int orderId =0;
		          int total=(((int)skorder.getProductQty()*(int)skorder.getProductPrice())+(int)skorder.getDeliveryCharge());
		          PreparedStatement getQuery =c.prepareStatement("insert into customerOrders values(?,?,?,?,?,?,?,?,?,?)");
				  getQuery.setInt(1, orderId); 
				  getQuery.setString(2,skorder.getUserId());
				  getQuery.setString(3,skorder.getProductName());
				  getQuery.setInt(4,skorder.getProductPrice()); 
		          getQuery.setInt(5, skorder.getProductQty()); 
				  getQuery.setString(6,skorder.getPaymentType());
				  getQuery.setInt(7,skorder.getDeliveryCharge());
				  SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				  String date = sdf.format(new Date());
				  getQuery.setString(8, date);
				  getQuery.setString(9,skorder.getVendorId());
				  getQuery.setInt(10,total);
				  PreparedStatement getQuery2 =c.prepareStatement("update  Products set  productCount=productCount-"+skorder.getProductQty()+" where productId=?");
				  getQuery2.setInt(1, skorder.getProdId()); 
				  getQuery2.executeUpdate();
				  getQuery.close();
			 

		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
			
		 }
	}
	public static void   deliveyAddress(DeliveryAddress delivery)
	
	{
		 Connection c; try { 
			 System.out.println("delivery");
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root","password"); 
		  int orderid=0;
          PreparedStatement getQuery =c.prepareStatement("insert into DeliveryAddress values(?,?,?,?,?,?)");
          getQuery.setInt(1,orderid );
          getQuery.setString(2,delivery.getStreetAddress());
          getQuery.setString(3, delivery.getTown_city());
          getQuery.setString(4, delivery.getState_country());
          getQuery.setInt(5, delivery.getPostcode());
          getQuery.setLong(6, delivery.getmobno());
          getQuery.executeUpdate();
          getQuery.close();
        
        
          
          

		 } catch(Exception e)
		 {
		    e.printStackTrace();
			
		 }
		
	}
	
	
	
	
	
	
	
	

}
