package AdminModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Admin {
	//db connection
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
	//admin can read doctors
	public String readDoctors()

	{
		String output= "";
		
		
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
			
			output = "<table border=\"1\"><tr><th>Doctor name</th>"
					 +"<th>Doctor nic</th>"
					 + "<th>doctor email</th></tr>";
			
		
			
					
					
			String  query="select * from doctor_details";
			//String query2="select * from hospital_details";
			Statement stmtStatement=con.createStatement();
			//Statement stmtStatement2=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			//ResultSet rs2=stmtStatement2.executeQuery(query2);
			
			while (rs.next())
			{
				String did=Integer.toString(rs.getInt("doc_id"));
				String dname=rs.getString("doc_name");
				String dnic=rs.getString("doc_nic");
				String demail=rs.getString("doc_email");
				
				
				output += "<tr><td>" + dname + "</td>"; 
				output += "<td>" + dnic + "</td>"; 
				output += "<td>" + demail + "</td>"; 
				
				
			}

			
			con.close();
			
			output+="</table>";
			
		}
		catch(Exception e)
		{
			output="error while inserting the doctors";
			System.err.println(e.getMessage());
		}
		return output;	
		
		
	
	}
	//admin can view appointment
	public String readAppointment()


	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
			
			output = "<table border=\"1\"><tr><th>appointment number</th>"
					 +"<th>patient nic</th>"
					 + "<th>doctor speclization</th>"
					 +"<th>doctor name</th>"
					 +"<th>date</th>"
					 +"<th>time</th>"
					 +"<th>hospital</th></tr>";
					// + "<th>Update</th><th>Remove</th></tr>"; 
			String  query="select * from appointment_details";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			while (rs.next())
			{
				String pid=Integer.toString(rs.getInt("appointment_id"));
				String pnic=rs.getString("patient_nic");
				String dspecilaztionString=rs.getString("doc_speciality");
				String dname=rs.getString("doc_name");
				String adate=rs.getString("appointment_date");
				String atime=rs.getString("appointment_time");
				String ahospital=rs.getString("appointment_hospital");
				
				output += "<tr><td>" + pid + "</td>"; 
				output += "<td>" + pnic + "</td>"; 
				output += "<td>" + dspecilaztionString + "</td>"; 
				output += "<td>" + dname + "</td>"; 
				output += "<td>" + adate + "</td>"; 
				output += "<td>" + atime + "</td>"; 
				output += "<td>" + ahospital + "</td>"; 
				
			}
			con.close();
			
			output+="</table>";
			
		}
		catch(Exception e)
		{
			output="error while reading the appointment";
			System.err.println(e.getMessage());
		}
		return output;	
		
	}
	// admin can view hospitals
	public String readHospitals()

	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
			
			output = "<table border=\"1\"><tr><th>Hospital name</th>"
					 +"<th>Hospital license number</th>"
					 + "<th>telephone number</th>"
					 +"<th>emergancy number</th>"
					 +"<th>facilities</th>"
					 +"<th>Room numbers</th></tr>";
					 //+"<th>hospital</th></tr>";
					// + "<th>Update</th><th>Remove</th></tr>"; 
			String  query="select * from hospital ";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			while (rs.next())
			{
				String name=rs.getString("hos_name");
				String license=Integer.toString(rs.getInt("hos_license"));
				String number=Integer.toString(rs.getInt("hos_telephone"));
				String emergancy=Integer.toString(rs.getInt("hos_emergancy"));
				String facilities=rs.getString("hos_facilities");
				String roomno=Integer.toString(rs.getInt("hos_rooms"));
				
				
				output += "<tr><td>" + name + "</td>"; 
				output += "<td>" + license + "</td>"; 
				output += "<td>" + number + "</td>"; 
				output += "<td>" + emergancy + "</td>"; 
				output += "<td>" + facilities + "</td>"; 
				output += "<td>" + roomno + "</td>"; 
				
				
			}
			con.close();
			
			output+="</table>";
			System.out.println("table can be view");
		}
		catch(Exception e)
		{
			output="error while reading the appointment";
			System.err.println(e.getMessage());
			System.out.println("table can't be view");
		}
		return output;	
		
	}
	//admin can create all the users example doctor,patient,and hospital via the status attribute
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
			else if(status.equals("hospital1"))   {
				
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
					System.out.printf("inserted");
					output = "Inserted Successfully to the hospital";
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("not inserted");
				}
				
				//return output;
			}
			
		
	
		return output;	
	}
	//admin can also delete the employees via status and status2 attribute
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
		
		else if(status.equals("hospital1") && (status2.equals("delete")))
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
	//admin can update the employees who registered to the system.
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
		else if(status.equals("hospital1"))
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
