
package HospitalModel;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Hospital {
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", "");
			System.out.print(" hos Successfully connected");

		} catch (Exception e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return con;
	}

	public String createHospital(String name, String license, String telephone, String emergancy, String facilities,
			String rooms) {

		String Output = "";

		try {
			// patientDatabase newp = new patientDatabase();
			Connection con = connect();

			if (con == null) {
				return "Error while connectingto the database for inserting";
			}

			String query = " insert into hospital (`hos_id`,`hos_name`,`hos_license`, `hos_telephone`, `hos_emergancy`,`hos_facilities`, `hos_rooms`) "
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			// Date date = Calendar.getInstance().getTime();
			// DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			// String strDate = dateFormat.format(date);

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, Integer.parseInt(license));
			preparedStmt.setInt(4, Integer.parseInt(telephone));
			preparedStmt.setInt(5, Integer.parseInt(emergancy));
			preparedStmt.setString(6, facilities);
			preparedStmt.setInt(7, Integer.parseInt(rooms));

			System.out.print("i run insert patient");
			preparedStmt.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("i dont run insert patient");
		}

		return Output;
	}

	public String deleteHospital(String emergancyNum)

	{
		String output = "";

		try {
			Connection connection = connect();

			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}

			String query = "delete from hospital where hos_emergancy=?";

			PreparedStatement prepareStmt = connection.prepareStatement(query);

			prepareStmt.setInt(1, Integer.parseInt(emergancyNum));
			prepareStmt.execute();
			connection.close();

			output = "deleted successfully";
		} catch (Exception e) {
			output = "error while deleting the patient";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
