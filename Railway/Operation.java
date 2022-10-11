package TrainReserve;


import java.util.Scanner;

public class Operation {
	User user = new User();
	Admin admin = new Admin();
	private String adminid = "admin001";
	private String password = "rrb@123";
	Scanner getInput = new Scanner(System.in);
	public void function() {

		boolean checkIf = true;
		while (checkIf) {
			int userinput = 0;
			boolean flag = false;
			

			do {
				System.out.println("----------------------------------");
				System.out.println("1.Signup\n2.Login\n3.Admin Login\n4.Exit");
				System.out.println("----------------------------------");

				try {
					
					userinput = getInput.nextInt();
					if (userinput > 4)
						throw new Exception();
					else
						flag = true;
				}

				catch (Exception e) {
					System.out.println("please enter the correct choice");
					flag = true;
				}

			} while (flag == false);

			switch (userinput) {
			case 1: {

				user.signUp();
				break;
			}
			case 2: {
				user.logIn();
				break;
			}
			case 3: {
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
							admin.addTrain();
							break;
						}
						case 2: {
							admin.viewTrainList();
							break;
						}

						case 3: {
							user.userList();
							break;
						}

						case 4: {
							// c=true;
							d = false;
							System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
							break;
						}

						}

					}
				} else
					System.out.println("Worng Credentials...!");

			}
			case 4: {
				checkIf = false;
				break;
			}
			case 5: {
				checkIf = false;
				break;
			}

			}

		}
	}

}
