package Whatsapp;

	import java.sql.*;
	public class Jdbc {
		
		public static Connection jdbcConnection(){
			
	        try{
	           return DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp1","root","password");
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }

	}		
	
	
	

