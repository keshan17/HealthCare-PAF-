
package HospitalModel;

import java.sql.Connection;

import java.sql.DriverManager;

public class Hospital {
	public Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print(" hos Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}

}

