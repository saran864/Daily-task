package Whatsapp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Message {
   Scanner sc=new Scanner(System.in);
	public void sendMessage() {
	Userinfo userinfo=new Userinfo();
	userinfo. Viewcontact();
		System.out.println("Enter No to Message");
	   int messagechoice=sc.nextInt();
	   System.out.println("Type a Message!");
	   String message=sc.next();
	  
	   
	   
	   PreparedStatement stmt=null;
	   System.out.println("Sending..!");
	   try
	   {
		 stmt=Jdbc.jdbcConnection().prepareStatement("UPDATE  contactdetails SET message=? WHERE cus_id=?");
		 stmt.setString(1,message);
		 stmt.setLong(2,messagechoice);
	
		 stmt.executeUpdate();
	   }
	   catch(SQLException e) {
		  e.printStackTrace(); 
	   }
	System.out.println("Message send");
	   
	   
	}
	public void receiveMessage() {
		
	}
	

}
