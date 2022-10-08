package Whatsapp;

import java.sql.*;
import java.util.Scanner;

public class Userinfo {
	private int cus_id;
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}


	Scanner input=new Scanner(System.in);
	public void Savecontact( String savename,long saveno)
	{
		String message="  ";
		 PreparedStatement stmt=null;
		   try
		   {
			 stmt=Jdbc.jdbcConnection().prepareStatement("insert into contactdetails values (?,?,?,?)");
			 stmt.setInt(1,cus_id);
			 stmt.setString(2,savename);
			 stmt.setLong(3, saveno);
			 stmt.setString(4, message);
			 stmt.executeUpdate();
			 System.out.println("Added Successfully");
		   }
		   catch(SQLException ex)
		   {
			  ex.printStackTrace(); 
		   }

		
	}
	public void Viewcontact()
	{  
		try {
			
			 
			   PreparedStatement 	stmt=Jdbc.jdbcConnection().prepareStatement("select * from contactdetails ");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("NO:"+rs.getInt("cus_id")+"   -  Name :"+rs.getString("name")+"  -   Mob.No :"+rs.getInt("mobno"));  			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	public void Wchat(){
		
		Message message=new Message();
       boolean  chatOption=true;
     while (chatOption)  {
    	 System.out.println("1.Sent Message!\n2.Recieved Message");
    	 int chat=input.nextInt();
    	 
    	 switch(chat)
    	 {
    	 case 1:
    	   	{chatOption=false;
    	   	 message.sendMessage();
    	   	  break;
    	   	}
    	 case 2:
    	   		{  
    	   			chatOption=false;
    	   		message.receiveMessage();
    	   		break;
    	   		} 
    	 }
       
       }
		
	}
      

}
