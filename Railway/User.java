package TrainReserve;

import java.util.*;
public class User 
{
	 Admin admin=new Admin();
	    
	   ArrayList <Passenger> userList=new ArrayList <> ();
	   
	   User()
	   {
		 userList.add( new Passenger ("saran@gmail.com","Saran",(byte)21,"sara123"));
		 userList.add(new Passenger ("suren@gmail.com","Suren",(byte)22,"sur@123"));
		 userList.add(new Passenger ("mani@gmail.com","Mani",(byte)22,"mani*12"));
	 	 userList.add( new Passenger ("raj@gmail.com","Raj",(byte)22,"raj#13"));
	   }
	   
	    public void userList(){
	    
	 	 for(Passenger passenger : userList )
	          {
	              System.out.println("Passenger Name: "+passenger.getName()+"Ps");
	          }
	    }
	    Scanner userInput=new Scanner(System.in);
	   
	  
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
	          admin.ticket();
	          
	         
	        
	        
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
	          admin.ticket();
	         }
	    
	         else
	         System.out.println("Username or password wrong!");
	    }

}
