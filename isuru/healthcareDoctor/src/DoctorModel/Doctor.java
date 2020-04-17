package DoctorModel;


import java.sql.*;


public class Doctor {
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
	public String addSession(String nic,String Specialization,String hospital,String room,String datee,String time,String time2)
	{
	String Output ="";
	
	try {
		//patientDatabase newp = new patientDatabase();
		Connection con = connect();

		if (con == null) {
			//return "Error while connectingto the database for inserting";
		}

		String query = " insert into doctor_portal (`doc_nic`,`doc_specialization`,`doc_hospital`, `room_no`, `date`,`time`,`time2`) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1, nic);
		preparedStmt.setString(2, Specialization);
		preparedStmt.setString(3, hospital);
		preparedStmt.setInt(4, Integer.parseInt(room) );
		preparedStmt.setString(5, datee);
		preparedStmt.setString(6, time);
		preparedStmt.setString(7, time2);
		
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