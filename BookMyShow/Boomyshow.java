import java.util.*;

class Boomyshow {

	    User us=new User();
	    Admin an=new Admin();
	    Scanner sc = new Scanner(System.in);
	     String adminid="saran@bms";
	     String password="bms@123";
		 boolean c=true;
	    public void function(){
	    	
	    	  while(c) {
			      System.out.println("----------------------------------");
			         System.out.println("Welcome to Book My Show");
				    System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
				  System.out.println("----------------------------------");
				  
		 boolean b=true;
		 while(b)
		  {    int userint=sc.nextInt();
			  switch(userint)
			  {
				  case 1:
				  { 
					  us.signUp();
				     break;
				       
				   
				    
				  }
				   case 2:
				  {
				       us.logIn();
				       break;
				    	
				       
				  }
				   
				   case 3:
					  {
						  boolean d;
						  System.out.println("->Enter Loginid :"); 
						  String adminmail=sc.next();
						  System.out.println("->Enter password:");
						  String adminpass=sc.next();
						  if(adminid.equals(adminmail)&&adminpass.equals(password))
						  {   d= true;
					        while(d){
								  
							 System.out.println("Welcome Admin\n");
						       System.out.println("1.Add Theatres\n2.View Theatres\n3.View Customers\n4.View Bookings\n5.Back");
						       int ipt=sc.nextInt();
							   c=false;
						       switch(ipt)
						       {
						       case 1:
						       { an.addtheatre();
						    	   break;
						       }
						       case 2:
						       {
						    	   an.viewTheatre();
						    	   break;
						       }
						       
						       case 3:
						    	   {
						    		   us.viewdata();
						    		   break;
						    	   }
						    	      
						       case 5:
						       {
						    	   c=true;
								   d=false;
								   System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
									  break;
						       }
						    	   
						       }							};
						  }
						  else
						  { System.out.println("Wrong credentials");
						  System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
						  }
					  }
					 case 4:
					  {
					      b=false;
						  c=false;
						  break;
					  }
					   
					  default:
					  {
					      System.out.println("Enter Correct Choice !");
					  }

					  
					   
	          }
		  }
	   }
	}
	    }
