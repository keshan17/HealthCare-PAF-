package PaymentModel;

import java.sql.*;

public class Payment {
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
	public String addPayment(String invoiceNumber,String amount,String nic,String cardnumber,String cardname,String expdate,String cvv)
	{
	String Output ="";
	
	try {
		//patientDatabase newp = new patientDatabase();
		Connection con = connect();

		if (con == null) {
			//return "Error while connectingto the database for inserting";
		}

		String query = " insert into payment (`invoiceNumber`,`amount`,`payment_nic`, `cardnumber`, `cardname`,`expdate`,`cvv`) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		preparedStmt.setInt(1, Integer.parseInt(invoiceNumber) );
		preparedStmt.setInt(2, Integer.parseInt(amount) );
		preparedStmt.setString(3, nic);
		preparedStmt.setInt(4, Integer.parseInt(cardnumber) );
		preparedStmt.setString(5,cardname );
		preparedStmt.setString(6,expdate );
		preparedStmt.setString(7,cvv );
		
		
		
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
	public String deletePayment(String cardnumber)
	{
		String output="";
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from payment where cardnumber=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(cardnumber));
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
		}
		catch(Exception e)
		{
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String updatePayment(String nic,String cardnumber,String cardname,String expdate,String cvv)
	{
		String output="";
		
		try {
			Connection connection=connect();
			if(connection==null)
			{
				return "error while connecting to the database for updating";
			}
			
			String query="UPDATE payment SET cardnumber=?,cardname=?,expdate=?,cvv=? "
					+ "where payment_nic=? ";
					
					PreparedStatement pStatement=connection.prepareStatement(query);
					
					//pStatement.setString(1, appointmentNum);
					
					pStatement.setInt(1, Integer.parseInt(cardnumber));
					pStatement.setString(2, cardname);
					pStatement.setString(3, expdate);
					pStatement.setString(4, cvv);
					pStatement.setString(5, nic);
					
					
					
					
					pStatement.execute();
					connection.close();
					System.out.print("updated");
					output="updated successfully";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print("not updated");
			output="error while updating the appointment";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readPayment()
	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
			
			output = "<table border=\"1\"><tr><th>invoiceNumber</th>"
					 +"<th>amount</th>"
					 + "<th>patient nic</th>"
					 +"<th>cardnumber</th>"
					 +"<th>cardname</th>"
					 +"<th>expdater</th></tr>";
					 //+"<th>hospital</th></tr>";
					// + "<th>Update</th><th>Remove</th></tr>"; 
			String  query="select * from payment ";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			while (rs.next())
			{
				
				String invNumberString=Integer.toString(rs.getInt("invoiceNumber"));
				String amount=Integer.toString(rs.getInt("amount"));
				String nic=rs.getString("payment_nic");
				String cardNo=Integer.toString(rs.getInt("cardnumber"));
				String cardname=rs.getString("cardname");
				String expdate=rs.getString("expdate");
				
				
				
				output += "<tr><td>" + invNumberString + "</td>"; 
				output += "<td>" + amount + "</td>"; 
				output += "<td>" + nic + "</td>"; 
				output += "<td>" + cardNo + "</td>"; 
				output += "<td>" + cardname + "</td>"; 
				output += "<td>" + expdate + "</td>"; 
				
				
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

}
