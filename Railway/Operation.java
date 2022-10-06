package TrainReserve;

import java.util.Scanner;

class Operation{
    
    User us=new User();
    Admin an=new Admin();
     private String adminid="railway@1213";
	 private String password="rrb@123";
    public void function(){
     
	 boolean b=true;
	  while(b)
	  {     
		  int userint=0;
boolean flag=false;
Scanner sc = new Scanner(System.in);

		  do {
	      System.out.println("----------------------------------");
	         System.out.println("Welcome to Railway Reservation System");
		    System.out.println("1.Signup\n2.Login\n3.Admin Login\n4.Exit");
		  System.out.println("----------------------------------");
		 
		  try{
			
			  userint=sc.nextInt();
			  if (userint>4)
				  throw new Exception();
			  else
				  flag=true;
			  }
		 
		  catch(Exception e) 
		  {
			  System.out.println ("please enter the correct choice");
			  flag=true;
		  }
		  
		  }while(flag==false);
		  
		  
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
						       System.out.println("1.Add Trains\n2.View Trains\n3.View Customers\n4.Back");
						       int ipt=sc.nextInt();
							  //c=false;
						       switch(ipt)
						       {
						       case 1:
						       { an.addTrain();
						    	   break;
						       }
						       case 2:
						       {
						    	   an.viewTrainList();
						    	   break;
						       }
						       
						       case 3:
						    	   {
						    		   us.userList();
						    		   break;
						    	   }
						    	      
						       case 4:
						       {
						    	   //c=true;
								   d=false;
								   System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
									  break;
						       }
						    	   
						       }		
				
				  }
						  }
						  else
							  System.out.println("Worng Credentials...!");
						  
						  
						  
				  }
			   case 4:
				  {
					   b=false;
					  break;
				  }
			   case 5:
				  {
				      b=false;
					  break;
				  }
			  
			
          
	  
   }
		 
		  
} 
}
    
}
