package AdminModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Admin {
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
	public String createEmployees(String name,String nic,String email,String pwd,String status)


	{
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
	public String deleteEmployee(String patientID,String status,String status2)

	{
		String output="";
		if(status.equals("patient") && (status2.equals("delete")))
		{
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from patient_details where patient_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(patientID));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully patient";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		
	}
		//return output;
		else if(status.equals("doctor") && (status2.equals("delete")))
		{
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from doctor_details where doc_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(patientID));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully doctor";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		
	}
		//return output;
		else if(status.equals("hospital") && (status2.equals("delete")))
		{
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from hospital_details where hos_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(patientID));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully hospital";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		
	}
		//return output;
		else if(status.equals("appointment") && (status2.equals("delete")))
		{
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from appointment_details where patient_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(patientID));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		
	}
		return output;
	}
	public String updateEmployees(String name,String nic,String email,String password,String status)

	{
		String output="";
	
		 if(status.equals("doctor"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE doctor_details SET doc_name=?,doc_email=?,doc_password=? "
						+ "where doc_nic=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, email);
						pStatement.setString(3, password);
						pStatement.setString(4, nic); 
						
						pStatement.execute();
						connection.close();
						
						output="updated successfully";
			}
			catch (Exception e) {
				// TODO: handle exception
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
			
		}
		
		else if(status.equals("patient"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE patient_details SET patient_name=?,patient_email=?,patient_pwd=? "
						+ "where patient_nic=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, email);
						pStatement.setString(3, password);
						pStatement.setString(4, nic); 
						
						pStatement.execute();
						connection.close();
						
						output="updated successfully";
			}
			catch (Exception e) {
				// TODO: handle exception
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
		}
		else if(status.equals("hospital"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE hospital_details SET hos_name=?,hos_email=?,hos_pwd=? "
						+ "where hos_nic=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, email);
						pStatement.setString(3, password);
						pStatement.setString(4, nic); 
						
						pStatement.execute();
						connection.close();
						
						output="updated successfully";
			}
			catch (Exception e) {
				// TODO: handle exception
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
			
			
		}
		return output;
	}

}
