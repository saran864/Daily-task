package TrainReserve;
import java.sql.*;//step :1 
public class Jdbc {


    public static Connection jdbcConnection(){
        try
        {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainTicketBooking","root","password");//step 2
         
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    
	}
	
	
	
	
}
