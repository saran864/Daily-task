package Whatsapp;

import java.util.*;

public class Setup {
	Userinfo user=new Userinfo();
	Scanner input=new Scanner(System.in);
	boolean start= true;
	
public void process()
     {
   	 
   	 while (start)
   	 {
   	  System.out.println("1.Open App\n2.Close App\n");
   	  System.out.println("enter any option");  
   	  int option =input.nextInt();
   	Authentication auth=new Authentication();
   	
   	  switch(option)
   	  {
   	  case 1:
   	  {     start= false;
   		  System.out.println("1.Register\n2.Login\n");
   		  int choice =input.nextInt();
   		  switch(choice)
   		  {
   		  case 1:
   		  {  
   			
   			  System.out.println("Enter the Name");
   			  String name =input.next();
   			  System.out.println("enter the email");
   			  String email=input.next();
   			  System.out.println("enter the mobilenumber");
   			   long mobno=input.nextLong();
   			  System.out.println("enter the password");
   			  String pass =input.next();
   			  auth.register(name,email,mobno,pass);
                  start=false;
   			  

   			   break;  
   		  }
   		  case 2 :
   		  { System.out.println("Enter the mobilenumber: ");
   		  long mobno=input.nextLong();
   		  System.out.println("Enter the password : ");
   		  String pass=input.next();
   	       auth.login(mobno,pass);
   			  break;
   		  }
   		  }
   		 
   		  break;
   	  }
   		  
   	  case 2:
   	      {
   	    	  start=false;
   	    	   break;
   	      }
   	  }
   		  
   	  }
  }
public void userAccess()
{  
	boolean view =true;
	while(view)
{
	 System.out.println("1.Save Contact\n2.View Contact\n3.Chat\n4.Exit\n");
	int options= input.nextInt();
	switch(options) {
	case 1:
	{
		System.out.println("Enter the MobileNumber: ");
	  long saveno=input.nextLong();
	  System.out.println("Enter the Name : ");
	  String savename=input.next();
	  
	     user.Savecontact(savename,saveno);
	  break;
	}
	case 2:
		{  
		user.Viewcontact();
		break;
		}
	case 3:
	{  
		view =false;
		user.Wchat();
		break;
	}
	case 4:
	{
		view=false;
		break;
	}
	}
	}


	}

}








