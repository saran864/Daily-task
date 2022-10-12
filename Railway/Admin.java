package TrainReserve;
import java.util.*;


import java.sql.*;
import java.util.*;

import java.sql.*;

public class Admin {
	
	private int train;
	private String adminid = "admin001";
	private String password = "rrb@123";

	Scanner getInput = new Scanner(System.in);
	
	
	public void adminAccess() {

		boolean d;
		System.out.println("->Enter Loginid :");
		String adminmail = getInput.next();
		System.out.println("->Enter password:");
		String adminpass = getInput.next();
		if (adminid.equals(adminmail) && adminpass.equals(password)) {
			d = true;
			while (d) {

				System.out.println("Welcome Admin\n");
				System.out.println("1.Add Trains\n2.View Trains\n3.View Customers\n4.Back");
				int choice = getInput.nextInt();
				// c=false;
				switch (choice) {
				case 1: {
					addTrain();
					break;
				}
				case 2: {
					viewTrainList();
					break;
				}

				case 3: {
					User user = new User();
					user.userList();
					break;
				}

				case 4: {
					d = false;
					Operation operation =new Operation();
					 operation.function();
					
					break;
				}

				}

			}
		} else
			System.out.println("Worng Credentials...!");

	
	}
	
	
	
	
	

	public void viewTrainList() {
		System.out.println("TrainNo       TrainName                    Trainfrom     Trainto    Tic.Count   Tic.Cost   " );
		PreparedStatement stmt = null;
		try {
			stmt = Jdbc.jdbcConnection().prepareStatement("select * from train");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				System.out.println(rs.getInt("trainno") + "\t" + rs.getString("train_name") +" \t"+ rs.getString("train_from") +"\t"+ rs.getString("train_to")
						 +"\t"+ rs.getInt("ticket_count") +"\t"+ rs.getString("ticket_cost"));
				 //stmt.close();
				 //rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
 
	}

	public void addTrain() {

		System.out.println("Enter Train Name : ");
		String trainname = getInput.next();
		System.out.println(trainname);
		System.out.println("Enter Train From : ");
		String trainfrom = getInput.next();
		System.out.println(trainfrom);
		System.out.println("Enter Train  To : ");
		String trainto = getInput.next();
		System.out.println(trainto);
		
		System.out.println("Enter Ticket  Nos: ");
		int ticketno = getInput.nextInt();
		System.out.println("Enter Ticket Rate in Rs₹ : ");
		int ticketrate = getInput.nextInt();
		System.out.println("Added Successfully");

		PreparedStatement getQuery = null;
		try {
			getQuery = Jdbc.jdbcConnection().prepareStatement("insert into train values(?,?,?,?,?,?)");
			//getQuery = Jdbc.jdbcConnection().prepareStatement("insert into train(train_name,train_from,train_to,ticket_count,ticket_cost ) values("+trainname+","+trainfrom+","+trainto+","+ticketno+","+ticketrate+")");
			getQuery.setInt(1, train);
			getQuery.setString(2, trainname);
			getQuery.setString(3, trainfrom);
			getQuery.setString(4, trainto);
			getQuery.setInt(5, ticketno);
			getQuery.setInt(6, ticketrate);
			getQuery.executeUpdate();
			getQuery.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
