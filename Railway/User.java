package TrainReserve;

import java.util.*;

class User
{
    Admin ad=new Admin();
    
   ArrayList <Passenger> user=new ArrayList <> ();
   
   User()
   {
	 user.add( new Passenger ("saran@gmail.com","saran",(byte)21,"sara123"));
	 user.add(new Passenger ("suren@gmail.com","suren",(byte)22,"suren@123"));
	 user.add(new Passenger ("manoaran@gmail.com","mano",(byte)22,"mano@123"));
 	 user.add( new Passenger ("raj@gmail.com","raj",(byte)22,"raj@1213"));
   }
   
    public void userList(){
    
 	 for(Passenger pk : user )
          {
              System.out.println(pk.getName());
          }
    }
    Scanner sc=new Scanner(System.in);
   
  
    public void signUp(){
           System.out.println("Enter Name :");
          String name=sc.next();
          System.out.println("Enter Age :");
          byte age=sc.nextByte();
          System.out.println("Enter Email :");
          String mail=sc.next();
           System.out.println("Enter Password :");
          String pass=sc.next();
           user.add(new Passenger(mail,name,age,pass));
         System.out.println("Data added Successfully!");
         System.out.println();
          System.out.println("Welcome!"+name);
          ad.ticket();
          
         
        
        
      }
    public void logIn(){
        boolean check =false;
        String loginname="";
     System.out.println("Enter Email :");
          String mail=sc.next();
           System.out.println("Enter Password :");
         String pass=sc.next();
         for(Passenger pk : user )
         {
         if (pk.getMailid().equals(mail)&&pk.getPassword().equals(pass))
         {
          loginname=pk.getName();
             check=true;
         }
                
         }
         if(check==true)
         {
          System.out.println("Welcome "+loginname);
                  ad.ticket();
         }
    
         else
         System.out.println("Username or password wrong!");
    }

}	