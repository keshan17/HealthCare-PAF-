package appointmentModel;




import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;



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

	
public String createAppoitnment(String NIC, String DoctorSpec, String Doctor, String Date, String Time, String hospital) {
		
		int id= 0;
		String Output ="";
		
		try {
			//patientDatabase newp = new patientDatabase();
			Connection con = connect();

			if (con == null) {
			return "Error while connectingto the database for inserting";
			}

			String query = " insert into appointment_details (`appointment_id`,`patient_nic`,`doc_speciality`, `doc_name`, `appointment_date`,`appointment_time`, `appointment_hospital`) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";
		//	Date date = Calendar.getInstance().getTime();
		//	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		//	String strDate = dateFormat.format(date);
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, NIC);
			preparedStmt.setString(3, DoctorSpec);
			preparedStmt.setString(4, Doctor);
	//		preparedStmt.setString(5, strDate);
			preparedStmt.setString(6, Time);
			preparedStmt.setString(7, hospital);
			
			
	    	String appointment = "select appointment_id from appointment_details where patient_nic="+NIC ;
	    	
	    	

			preparedStmt.execute();
			con.close();
			System.out.println("inserted");
			Output = "Inserted successfully"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" not inserted");
		}

		return Output;
	}

	
	
	
	

	
	
	
}
