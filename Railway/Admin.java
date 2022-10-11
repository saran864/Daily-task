package TrainReserve;
import java.util.*;


import java.sql.*;
import java.util.*;

import java.sql.*;

public class Admin {
	int train_no;
	private int train;

	Scanner getInput = new Scanner(System.in);

	public void viewTrainList() {
		System.out.println("TrainNo       TrainName                    Trainfrom     Trainto    Tic.Count   Tic.Cost   " );
		PreparedStatement stmt = null;
		try {
			stmt = Jdbc.jdbcConnection().prepareStatement("select * from train");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				System.out.println(rs.getInt("trainno") + "\t" + rs.getString("train_name") +" \t"+ rs.getString("train_from") +"\t"+ rs.getString("train_to")
						 +"\t"+ rs.getInt("ticket_count") +"\t"+ rs.getString("ticket_cost"));
				 stmt.close();
				 rs.close();
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

	boolean b = true;

	public void ticket() {
		while (b) {
			System.out.println("\n1.BookTicket\n2.SearchTrain\n3.Back");
			int ipt = getInput.nextInt();

			switch (ipt) {
			case 1: {
				viewTrainList();
				System.out.println("Enter the Train No");
				 train_no = getInput.nextInt();
				System.out.println("Enter no.of tickets:");
				int noOfTickets = getInput.nextInt();
				try {

					PreparedStatement ps1 = Jdbc.jdbcConnection().prepareStatement(
							"update train set ticket_count =ticket_count-" + noOfTickets + " where trainno=?");
					ps1.setInt(1, train_no);
					int queryExecution = ps1.executeUpdate();
					ps1.close();
					PreparedStatement ps2 = Jdbc.jdbcConnection()
							.prepareStatement("select ticket_cost,train_name from train where trainno=?");
					ps2.setInt(1, train_no);
					ps2.close();
					ResultSet rs = ps2.executeQuery();
					rs.next();
					
					
					int amt = rs.getInt(1);
					String trainname = rs.getString(2);
					int total_amount = amt * noOfTickets;
					System.out.println("************************");
					System.out.println("Train No = " + train_no + "\nTrain Name = " + trainname + "\nTotal Amount  = " + total_amount+"\nHappy journey With"+trainname);
				  System.out.println("************************");
				  rs.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}
			case 2: {
				System.out.println("1.Chennai-Senkottai\n2.Madurai-Chennai\n3.Chennai-Thanjavur\n4.Tuticorin-Chennai \n5.Trichy -Chennai\n6.Nagercoil-Chennai");
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
						"TrainNo    TrainName                     From            To           Tick.Count     Tick.Cost");
				System.out.println(rs.getInt("trainno") + "\t" + rs.getString("train_name") +" \t"+ rs.getString("train_from") +"\t"+ rs.getString("train_to")
				 +"\t"+ rs.getInt("ticket_count") +"\t"+ rs.getString("ticket_cost"));}
				 catch (Exception e) {
						e.printStackTrace();
					}
				
				
			
				break;

			}

			case 3: {
				System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
				b = false;
				break;
			}

			}

		}

	}
}
