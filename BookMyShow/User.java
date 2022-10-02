import java.util.*;

class User
{
	Admin am=new Admin();
   ArrayList <Customer> user=new ArrayList <> ();
   
  User()
  {
	  userList();
  }
    public void userList(){
    	{
    	user.add(new Customer ("saran@gmail.com","saran",(byte)22,"sara123",'M'));
    	user.add(new Customer("suren@gmail.com","suran",(byte)22,"suren@123",'M'));
    	user.add(new Customer ("manoaran@gmail.com","mano",(byte)22,"mano@123",'M'));
    	user.add (new Customer("raj@gmail.com","raj",(byte)22,"raj@1213",'M'));
    	}
    }
    Scanner sc=new Scanner(System.in);
    
    
    
    
    
    
    public void viewdata()
    {
    	for(Customer pk :user)
    	{
    		System.out.println(" Name: "+pk.getName()+"     -   "+"Gender :"+pk.getGender());
    	}
    		
    		
    }
   
  
    public void signUp(){
           System.out.println("Enter Name :");
          String name=sc.next();
          System.out.println("Enter Age :");
          byte age=sc.nextByte();
          System.out.println("Enter Email :");
          String mail=sc.next();
           System.out.println("Enter Password :");
          String pass=sc.next();
          System.out.println("Enter gender M/F :");
         char gender=sc.next().charAt(0);
           user.add(new Customer(mail,name,age,pass,gender));
         System.out.println("Data added Successfully!");
         System.out.println("Welcome "+name);
         am.Ticket();
        
        
      }
    public void logIn(){
     System.out.println("Enter Email :");
          String mail=sc.next();
           System.out.println("Enter Password :");
         String pass=sc.next();
         int temp=user.size();
         for(Customer pk : user ) {
          if(pk.getMailid().equals(mail)&&pk.getPassword().equals(pass))
        	  
          {  System.out.println("Welcome "+pk.getName());
                       am.Ticket(); 
          }
          else
	    	   temp--;
          
    }
         if(temp==0)
		 {  System.out.println("Username or password wrong!");
		 System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
		 }
    
}
}
