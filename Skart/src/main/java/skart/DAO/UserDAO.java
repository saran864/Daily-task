package skart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import skart.controller.Jdbc;
import skart.model.SkartUser;

public class UserDAO {

	public boolean register (SkartUser register) {
		try {
             int passid = 0;
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Skart", "root", "password");
			System.out.println("connected Successfuly");
			PreparedStatement getQuery = c.prepareStatement("insert into Register values(?,?,?,?,?,?)");
			getQuery.setInt(1, passid);
			getQuery.setString(2, register.getName());
			getQuery.setInt(3, register.getAge());
			getQuery.setString(4, register.getUsername());
			getQuery.setString(5, register.getPassword());
			getQuery.setString(6, register.getAddress());
			getQuery.executeUpdate();
			getQuery.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NotConnected");
			return false;
		}

	}


}
