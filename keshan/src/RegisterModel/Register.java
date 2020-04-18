package RegisterModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Register {
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
	public String getRegistrationInfo(String name, String nic, String email, String pwd, String status)

	 {

		//String newStatus;
		//newStatus=status;
		//System.out.println(newStatus);
		String output="";
		
		if (status.equals("patient")) {
			//String output = "";
			try {
				//patientDatabase newp = new patientDatabase();
				Connection con= connect();
				if (con == null) 
				{
					
					return "Error while connectingto the database for inserting";
				}

				String query = " insert into patient_details (`patient_name`, `patient_nic`, `patient_email`, `patient_pwd`, `patient_date`) "
						+ "values(?, ?, ?, ?, ?)";
				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				String strDate = dateFormat.format(date);
				
				PreparedStatement preparedStmt = con.prepareStatement(query);

				preparedStmt.setString(1, name);
				preparedStmt.setString(2, nic);
				preparedStmt.setString(3, email);
				preparedStmt.setString(4, pwd);
				preparedStmt.setString(5, strDate);

				preparedStmt.execute();
				con.close();
				
				
				System.out.print("i run insert patient");
				output = "Inserted Successfully to the Patient";
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("i dont run insert patient");
				
			}
			//return output;
			
		}
		else if  (status.equals("doctor")) {
			//String output = "";
			 
				try {
					//patientDatabase newp = new patientDatabase();
					Connection conn =connect();

					if (conn == null) 
					{
						return "Error while connectingto the database for inserting";
					}

					String query = " insert into doctor_details (`doc_name`, `doc_nic`, `doc_email`, `doc_password`,`doc_date`) "
							+ "values(?, ?, ?, ?, ?)";

					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, nic);
					preparedStmt.setString(3, pwd);
					preparedStmt.setString(4, email);
					preparedStmt.setString(5, strDate);

					preparedStmt.execute();
					conn.close();
					output = "Inserted Successfully to the Doctor";
				} catch (Exception e) {
					e.printStackTrace();
				}
				//return output;

			}
			else if(status.equals("hospital"))   {
				
				//String output = "";
				try {
					//patientDatabase newp = new patientDatabase();
					Connection conn = connect();

					if (conn == null) {
						return "Error while connectingto the database for inserting";
					}

					String query = " insert into hospital_details (`hos_name`, `hos_nic`, `hos_email`,`hos_password`) "
							+ "values(?,?,?,?)";

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, nic);
					preparedStmt.setString(3, email);
					preparedStmt.setString(4, pwd);

					preparedStmt.execute();
					conn.close();
					output = "Inserted Successfully to the hospital";
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//return output;
			}
			
		
	
		return output;	
	 }

}
