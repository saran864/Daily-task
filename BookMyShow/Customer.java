class Customer{
    private String mailid;
	private String  name;
	private  byte  age;
	private String  password;
	private char gender;
	

	 
	 Customer(String mailid,String name,byte age,String password, char gender){
		this.name=name;
	    this.age=age;
		this.gender=gender;
		this.mailid=mailid;
		this.password=password;
		
	}
	Customer(){}
	
	public String getMailid() {
		return mailid;
	}

//	public void setMailid(String mailid) {
//		this.mailid = mailid;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public byte getAge() {
		return age;
	}

//	public void setAge(byte age) {
//		this.age = age;
//	}

	public String getPassword() {
		return password;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}
		public char getGender() {
		return gender;
	}

//	public void setGender(char gender) {
//		this.gender = gender;
//	}
	

}
