package skart.model;

public class SkartUser {
	SkartUser() {
	}

	private String name;
	private int age;
	private String username;
	private String password;
	private String address;
	private String code;

	
	public SkartUser(String name, int age, String username, String password, String address,String code) {
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.address = address;
		this.code=code;

	}
	public SkartUser(String username, String password,String code) {

		this.username = username;
		this.password = password;
		this.code=code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
