package skart.model;

public class SkartUser {
	SkartUser() {
	}

	private String name;
	private int age;
	private String username;
	private String password;
	private String address;

	public SkartUser(String name, int age, String username, String password, String address) {
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.address = address;

	}

	public SkartUser(String username, String password) {

		this.username = username;
		this.password = password;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

//		@Override
//		public String toString() {
//			return  "\"Person [Name ="+ name + ", Age = " + age + ", username= " + username+", password= "+password+ ", address= "+address+"]"; 
//		}
}
