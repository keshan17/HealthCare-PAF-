package appointmentModel;




import java.sql.Connection;
import java.sql.DriverManager;

//import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;



public class Appointment {
	public Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}
	
}
