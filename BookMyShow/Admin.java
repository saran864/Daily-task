import java.util.*;


class Admin {
	//Boomyshow bm=new Boomyshow();
	Scanner sc=new Scanner(System.in);
	 ArrayList <Manager> tlist=new ArrayList <> ();
	   
	 Admin()
	  {
		  theatreList();
	  }
	
	 
	 
	 public void viewTheatre()
	 {      System.out.println("TheatreNo    TheatreName  MovieName         TicketCount    Ticket Cost");
		 for(Manager mg :tlist)
 		{
 			System.out.println(" "+mg.getTheatreNo()+" "+mg.getTheatreName()+" "+mg.getMovieName()+"      "+mg.getTicketCount()+"              "+mg.getCostOfTicket());
 		}
	 }
	 
	 public Manager getTheatre(int a)
	 {
		return tlist.get(a);
	 }
	   public void addtheatre()
	   {
		   System.out.println("Enter theatre No : ");
		   byte theatno=sc.nextByte();
		   System.out.println("Enter theatre Name : ");
		   String theatname=sc.next();
		   System.out.println("Enter Movie Name : ");
		   String moviename=sc.next();
		   System.out.println("Enter Ticket  Nos: ");
		   int ticketno=sc.nextInt();
		   System.out.println("Enter Ticket Rate in Rs₹ : ");
		   int theatrate=sc.nextInt();
		   tlist.add(new Manager(theatno,theatname,moviename,ticketno,theatrate));
		   System.out.println("Data added Successfully");
	   }
	 
	 public void theatreList(){
	    	{  
	    		tlist.add(new Manager((byte)1,"Vetri Theatre     ","PS-I            ", 100, 120));
	    		tlist.add(new Manager((byte)2,"Sathyam Theatre   ","VTK             ",200, 150)); 
	    		tlist.add(new Manager((byte)3,"Devi Theatre      ","Tiruchirrambalam",150, 140));
	    		tlist.add(new Manager((byte)4,"Udhayam Theatre   ","Naane Varuven   ",150, 170));
	    		tlist.add(new Manager((byte)5,"Aravindh Cinemas  ","Cobra           ",100, 130));
	    		tlist.add(new Manager((byte)6,"Sona mina Cinemas ","Gulu gulu       ",150, 110));
	    		
	    			
	    			
	    	}
	    }
	 
	

      boolean b=true;
      
	public void Ticket() {
		while(b) {
		System.out.println("\n1.BookTicket\n2.Back");
	       int ipt=sc.nextInt();
	       switch(ipt)
	       {
	       case 1:
	    	 {    
	    		 viewTheatre();
	    		Manager m= new Manager();
	    	System.out.println("Enter Theatre number to Book Ticket :");
	    	int in=sc.nextInt();
	    	  m=tlist.get(--in);
	    	  System.out.println("Buy Ticket NOs:");
	    	    int  ticket=sc.nextInt();
	    	  int cost=ticket*m.getCostOfTicket();
	    	int count=m.getTicketCount()-ticket;
	    	  m.setTicketCount(count);
	    	System.out.println("Theatre Name :"+m.getTheatreName()+"\n"+"Movie Name :"+m.getMovieName()+"\n"+"Booked Tickets : "+ticket+"\nPay Amount :"+cost);
	    	System.out.println("Thanks For Booking Enjoy with "+m.getTheatreName());
	    	break;
	    	 }
				  
	       case 2:
	    	  { 
			  System.out.println("1.User Signup\n2.User Login\n3.Admin Login\n4.Exit");
			  b=false;
	    	  break;
	    	   } 
		}
	}
	 
	 
}
}


