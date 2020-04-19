package BasicAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import util.DBConnection;

public class Users {
	
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
	
 	 public static boolean isUserAllowed(final String username, final String password, final Set<String> statusset)
     {
         boolean isAllowed = false;
         String status = "" , user = "", psw = "" ;
         
         try {
        	 Connection con=connect();
        	 
     		if (con == null) {
     			
     			
     		}
     		// create a prepared statement
     		String query = "SELECT * FROM users where username='"+username+"' and password='"+password+"'";
     		PreparedStatement preparedStmt = con.prepareStatement(query);
     		
     	
     	   	preparedStmt.execute();
     //execute the statement
     		  ResultSet rs = preparedStmt.executeQuery(query);
     		 
     		  if(rs.next()) {
     			  user = rs.getString("username");
     			  psw = rs.getString("password");
     			  status=rs.getString("status");
     			 
     		  }
     		  con.close();
     		  
     		  
     	} catch (Exception e) {
     				
     				System.err.println(e.getMessage());
     			}
         
         if(username.equals(user) && password.equals(psw))
         {
              
             //Step 2. Verify user role
             if(statusset.contains(status))
             {
            	 
                 isAllowed = true;
                 System.out.println(username +" "+password );
             }
         }
         return isAllowed;
         
     }

}
