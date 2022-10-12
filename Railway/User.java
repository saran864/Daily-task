package TrainReserve;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class User 
{
	int train_no;
	 Admin admin=new Admin();
		Scanner getInput = new Scanner(System.in);

	   ArrayList <Passenger> userList=new ArrayList <> ();
	   
	   User()
	   {
		 userList.add( new Passenger ("saran@gmail.com","Saran",(byte)21,"sara123"));
		 userList.add(new Passenger ("suren@gmail.com","Suren",(byte)22,"sur@123"));
		 userList.add(new Passenger ("mani@gmail.com","Mani",(byte)22,"mani*12"));
	 	 userList.add( new Passenger ("raj@gmail.com","Raj",(byte)22,"raj#13"));
	   }
		boolean b = true;

		public void userAccess() {
			while (b) {
			 
				System.out.println("\n1.BookTicket\n2.SearchTrain\n3.Back");
				int ipt = getInput.nextInt();

				switch (ipt) {
				case 1: {
					ticketBooking();
					break;
				    }
				case 2: {
					searchTrain() ;
				
					break;

				}

				case 3: {
					b = false;
					break;
				}

				}

			}

		}
	   
	   
	   
	   
	   
	   
	    public void userList(){
	    
	 	 for(Passenger passenger : userList )
	          {
	              System.out.println("Passenger Name: "+passenger.getName()+"Ps");
	          }
	    }
	    Scanner userInput=new Scanner(System.in);
	   Passenger passenger=new Passenger();	  
	    public void signUp(){
	          System.out.println("Enter Name :");
	          String name=userInput.next();
	          System.out.println("Enter Age :");
	          byte age=userInput.nextByte();
	          System.out.println("Enter Email :");
	          String mail=userInput.next();
	          System.out.println("Enter Password :");
	          String pass=userInput.next();
	          userList.add(new Passenger(mail,name,age,pass));
	          System.out.println("Data added Successfully!");
	          System.out.println();
	          System.out.println("Welcome!"+name);
	          userAccess();
	          
	         
	        
	        
	      }
	    public void logIn(){
	        boolean checkIf =false;
	        String loginname="";
	     System.out.println("Enter Email :");
	          String mail=userInput.next();
	           System.out.println("Enter Password :");
	         String pass=userInput.next();
	         for(Passenger passenger : userList )
	         {
	         if (passenger.getMailid().equals(mail)&&passenger.getPassword().equals(pass))
	         {
	          loginname=passenger.getName();
	          checkIf=true;
	         }
	                
	         }
	         if(checkIf==true)
	         {
	          System.out.println("Welcome "+loginname);
	            userAccess();
	         }
	    
	         else
	         System.out.println("Username or password wrong!");
	    }
	    
	    
	    
	    private  void ticketBooking()
	    {
	    admin.viewTrainList();
		System.out.println("Enter the Train No");
		 train_no = getInput.nextInt();
		System.out.println("Enter no.of tickets:");
		int noOfTickets = getInput.nextInt();
		try {

			PreparedStatement ps1 = Jdbc.jdbcConnection().prepareStatement(
					"update train set ticket_count =ticket_count-" + noOfTickets + " where trainno=?");
			ps1.setInt(1, train_no);
			int queryExecution = ps1.executeUpdate();
			//ps1.close();
			PreparedStatement ps2 = Jdbc.jdbcConnection()
					.prepareStatement("select ticket_cost,train_name from train where trainno=?");
			ps2.setInt(1, train_no);
			//ps2.close();
			ResultSet rs = ps2.executeQuery();
			rs.next();
			
			
			int amt = rs.getInt(1);
			String trainname = rs.getString(2);
			int total_amount = amt * noOfTickets;
			System.out.println("************************");
			System.out.println("Train No = " + train_no + "\nTrain Name = " + trainname + "\nTotal Amount  = " + total_amount+"\nHappy journey With"+trainname);
		  System.out.println("************************");
		//  rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	    
	    }
	    private  void searchTrain()  
	    {System.out.println("1.Chennai-Senkottai\n2.Madurai-Chennai\n3.Chennai-Thanjavur\n4.Tuticorin-Chennai \n5.Trichy -Chennai\n6.Nagercoil-Chennai");
	    	int trainfromto = getInput.nextInt();
			switch (trainfromto)
			{
			case 1:
			{
				
			 train_no=122348;
			 
				break;
			}
			case 2:
			{train_no=122349;
				break;
			}
			case 3:
			{train_no=122350;
				break;
			}
			case 4:
			{train_no=122351;
				break;
			}
			case 5:
			{train_no=122352;
				break;
			}
			case 6:
			{train_no=122353;
				break;
			}
			}
			try {
			PreparedStatement ps3 = Jdbc.jdbcConnection()
					.prepareStatement("select * from train where trainno=?");
			ps3.setInt(1, train_no);
			ResultSet rs = ps3.executeQuery();
			rs.next();
			System.out.println("--------Available Trains------- ");
			System.out.println(
					"TrainNo    TrainName                     From            To         Tick.Count Tick.Cost");
			System.out.println(rs.getInt("trainno") + "\t" + rs.getString("train_name") +" \t"+ rs.getString("train_from") +"\t"+ rs.getString("train_to")
			 +"\t"+ rs.getInt("ticket_count") +"\t"+ rs.getString("ticket_cost"));}
			
			 catch (Exception e) {
					e.printStackTrace();
				}
	    	
	    	
	    	
	    	
	    }
	    
	    }
	    
	    
	    


