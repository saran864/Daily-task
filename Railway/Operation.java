package TrainReserve;


import java.util.Scanner;

public class Operation {
	Admin admin = new Admin();
	User user=new User();
	Scanner getInput = new Scanner(System.in);
	public  void function() {

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
				admin.adminAccess();
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
