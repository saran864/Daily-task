package skart.controller;

import java.sql.Connection;
import java.sql.DriverManager;


import skart.controller.Jdbc;

public class Jdbc {
    static Connection con=null;
	private Jdbc() {
	}
	
	static {
		
			 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} 
	

	public static Connection getInstance() {
		return con;
	}

	
}
