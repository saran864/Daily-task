package Whatsapp;

import java.sql.*;

public class Authentication {
	private int contact_id;
	Setup  setup=new Setup();
	public void register(String name,String email,long mobno,String pass)
	   {
		   PreparedStatement stmt=null;
		   try
		   {
			 stmt=Jdbc.jdbcConnection().prepareStatement("insert into contact values (?,?,?,?,?)");
			 stmt.setInt(1,contact_id);
			 stmt.setString(2,name);
			 stmt.setString(3, email);
			 stmt.setLong(4,mobno);
			 stmt.setString(5, pass);
			 stmt.executeUpdate();
			 System.out.println("Added Successfully");
		   }
		   catch(SQLException ex)
		   {
			  ex.printStackTrace(); 
		   }
	   }
	

	public void login(long mobno,String pass)
	   {
		   PreparedStatement stmt=null;
		   try
		   {
			 stmt=Jdbc.jdbcConnection().prepareStatement("select mobilenumber,password,name from contact  where mobilenumber=? ");
			 stmt.setLong(1,mobno);
			 ResultSet rs = stmt.executeQuery();
			 String password="";
			 long mobile=0;
			 String name="";
			while
				(rs.next()) 
			{
				password=rs.getString("password");
				mobile=rs.getLong("mobilenumber");
				name=rs.getString("name");
			}
			 if(password.equals(password)&&mobno==mobile)
			 { System.out.println("Login Succesfully !\n Welcome "+name);
			            setup.userAccess();
			 
			 }		
			 else 
			 {
			 System.out.println("Invalid Login"); 
			 }

				 
}
		   catch(SQLException ex)
		   {
			  ex.printStackTrace(); 
		   }

}
}
	
