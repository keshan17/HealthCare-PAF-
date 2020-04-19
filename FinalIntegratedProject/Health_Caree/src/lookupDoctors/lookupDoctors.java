package lookupDoctors;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class lookupDoctors {
	
	
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
	
	public String readLookupDoctors()
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
					
					// + "<th>Update</th><th>Remove</th></tr>"; 
			String  query="select * from doctor_details";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
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

}
