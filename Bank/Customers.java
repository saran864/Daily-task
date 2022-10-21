package BankingApplication;

public class Customers {

	String customerName;
	String emailid ;
	String password;
	int age;
	Customers(){}
    public String getCustomerName() {
		return customerName;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	String gender;
	
    Customers(String customerName, String emailid,String Password,int age, String gender) {
		this.customerName = customerName;
		this.emailid = emailid;
		this.password=Password;
		this.age=age;
		this.gender=gender;
	}
	
}
