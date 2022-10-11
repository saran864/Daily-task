package TrainReserve;


public class Passenger {
	private String mailid;
	private String  name;
	private byte age;
	private String  password;
	

	 
	Passenger(String mailid,String name,byte age,String password){
		this.name=name;
		this.mailid=mailid;
		this.age=age;
		this.password=password;
		
	}
		Passenger(){}
	
	public String getMailid() { 
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		
	}
}
