class Manager
  {
  private byte theatreno;
  private String theatrename;
  private String moviename;
  private int ticketcount;
  private int costofticket;
  
  Manager(byte theatreno,String theatrename,String moviename,int ticketcount, int costofticket)
  {
	  this.theatreno=theatreno;
	  this.theatrename=theatrename;
	  this.moviename=moviename;
	  this.ticketcount=ticketcount;
	  this.costofticket=costofticket;
  }
Manager(){}
	   
  public byte getTheatreNo(){  return theatreno;}
//  public void setTheatreNo(byte theatreno){ this.theatreno=theatreno;
  
  public String getTheatreName(){  return  theatrename;}
//   public void setTheatreName(String theatrename){  this.theatrename=theatrename;}
   
  public String getMovieName(){  return moviename;}
//  public void setMovieNmae(String moviename){   this.moviename=moviename;}
  
  
  
  public int getTicketCount(){  return ticketcount;}
   public void setTicketCount(int ticketcount){  this.ticketcount=ticketcount;}
   
   public int getCostOfTicket(){  return costofticket;}
   
//  public void setCostOfTiclet(short costofticket){ this.costofticket=costofticket;}



 

  }
 
