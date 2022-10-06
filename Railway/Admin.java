package TrainReserve;
import java.util.*;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
class Admin {
	Scanner sc=new Scanner(System.in);
	Jdbc js=new Jdbc();
	   

	
	 
	 
	 public void viewTrainList() {
		  PreparedStatement stmt = null;
		 try {
			 stmt = Jdbc.jdbcConnection().prepareStatement("select * from railway");
			 ResultSet rs= stmt.executeQuery();
			 while(rs.next())
					  {
				 System.out.println("TrainNo     TrainName  TrainFrom       TrainTo       TicketCount      TicketCost");
				 System.out.println(" "+rs.getInt("trainno")+"  "+rs.getString("trainname")+""+rs.getString("trainfrom")+" "+rs.getString("trainto")+" "+rs.getInt("ticketno")+" "+rs.getString("ticketno"));
			 }
			 
		 }catch (SQLException e) 
			{
				e.printStackTrace();
			}
		 
		 
		 
		 
	 }
	   public void addTrain()
	   {   
		  
		   System.out.println("Enter Train Name : ");
		   String trainname=sc.next();
		   System.out.println("Enter Train From : ");
		   String trainfrom=sc.next();
		   sc.next();
		   System.out.println("Enter Train  To : ");
		   String trainto=sc.next();
		   System.out.println("Enter Ticket  Nos: ");
		   int ticketno=sc.nextInt();
		   System.out.println("Enter Ticket Rate in Rs₹ : ");
		   int ticketrate=sc.nextInt();
		   System.out.println("Added Successfully");
		   
		   

		   PreparedStatement stmt = null;
			try {
				stmt = Jdbc.jdbcConnection().prepareStatement("insert into railway values(?,?,?,?,?,?)");
				 Train train1=new Train();
				stmt.setInt(1,train1.getTrainNo());
				stmt.setString(2, trainname);
				stmt.setString(3, trainfrom);
				stmt.setString(4,trainto);
				stmt.setInt(5,ticketno);
				stmt.setInt(6,ticketrate);
            stmt.executeUpdate();

			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
}
	 
	

      boolean b=true;
      
	public void ticket() {
		while(b) {
		System.out.println("\n1.BookTicket\n2.SearchTrain\n3.Back");
	       int ipt=sc.nextInt();
	       
	       switch(ipt)
	       {
	       case 1:
	    	 {    
	    		 viewTrainList();
	    		 System.out.println("Enter the Train No");
	    		 int  tno=sc.nextInt();
	    			System.out.println("Enter no.of tickets:");
	    			int ticket = sc.nextInt();
	    			try {
	    				
	    					PreparedStatement ps1 = Jdbc.jdbcConnection().prepareStatement(
	    							"update railway set ticketcout =ticketcount-" + ticket + " where trainno=?");
	    					ps1.setInt(1,tno);
	    					int j = ps1.executeUpdate();
	    					PreparedStatement ps2 = Jdbc.jdbcConnection().prepareStatement(
	    							"select ticketno,trainname where trainno=?");
	    					ps2.setInt(1,tno);
	    					ResultSet rs = ps2.executeQuery();
	    					int amt=rs.getInt(1);
	    					String s=rs.getString(2);
	    					int total_amount=amt*ticket;
		    					System.out.println(
		    							"Train No = "+tno+
		    							"Train Name = "+s+
		    							"Total Amount  = "+total_amount
		  
		    							);
	    						
	    				

	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}

	    			 break;
	    	 }
	    	 case 2:
	    	     {
	    	            Train tr=new Train();
	    	            int temp=0;	
	    	         	System.out.println("Enter From Location => : ");
	    	            String trainfrom=sc.next();
	    	         	System.out.println("Enter To  Location <= : ");
	    	            String trainto=sc.next();
	    	            	System.out.println("--------Available Trains------- ");
	    	            	  System.out.println("TrainNo    TrainName                          From          To         TicketCount     Ticket Cost");
	    	      
         
         
         
         
        	         break;
	    	     
	    	     }
				  
	       case 3:
	    	  { 
			  System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
			  b=false;
	    	  break;
	    	   } 
		
	}
	 
	 
}


	 }

}


