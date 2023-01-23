package skart.model;

public class Vendor {
	String email;
	String userName;
	String password;
	
  
	public Vendor(String userName,String email ,String password) {
		this.userName = userName;
		this.password = password;
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

    

}
