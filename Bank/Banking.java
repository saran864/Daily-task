package BankingApplication;
import java.util.ArrayList;
import java.util.Scanner;

	

	public class Banking {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customers> user = new ArrayList<Customers>();
		Customers cm = new Customers();

		Banking() {
			user.add(new Customers("Saran", "saran@gmail.com", "sara123", 23, "M"));
		}

		public void signup() {

			System.out.println("Enter Name: ");
			String name = sc.next();
			System.out.println("Enter emailid : ");
			String id = sc.next();
			System.out.println("Enter Password: ");
			String pass = sc.next();
			System.out.println("Enter Age: ");
			int age = sc.nextInt();
			System.out.println("Enter Gender: ");
			String gender = sc.next();
			user.add(new Customers(name, id, pass, age, gender));
//			Customers cm = new Customers();
//
//			cm = user.get(user.size() - 1);

			System.out.println("welcome..! " + name);
			System.out.println();
		}

		public void login() {
			boolean match = false;
			BankAccount ba=new BankAccount();
			System.out.println("Enter emailid : ");
			String id = sc.next();
			System.out.println("Enter Password: ");
			String pass = sc.next();
			for (Customers cm : user) {
				if (cm.getEmailid().equals(id) && cm.getPassword().equals(pass)) {
					match = true;
					
				}

			}
			System.out.println(match == true ? "Welcome " : "Sorry Wrong Credentials");
			if(match==true)
		    ba.operation();

		}
}
