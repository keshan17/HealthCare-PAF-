package LoginModel;
import java.sql.*;

public class LoginClass {
	
		public String checkLogin(String email, String password,String status) throws SQLException,
	            ClassNotFoundException
		{
			String output="";
			
	        String jdbcURL = "jdbc:mysql://localhost:3306/newdb";
	        String dbUser = "root";
	        String dbPassword = "";
	 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "SELECT * FROM doctor_details WHERE doc_nic = ? and doc_password = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, email);
	        statement.setString(2, password);
	 
	        ResultSet result = statement.executeQuery();
	 
	        //User user = null;
	 
	        if (result.next()) {
	            
	            String username=result.getString("doc_nic");
	            String password1=result.getString("doc_password");
	        }
	 
	        connection.close();
			return sql;
	 
	        
	    }
	

}
