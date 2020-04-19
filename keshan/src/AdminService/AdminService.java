package AdminService;

import AdminModel.Admin;





import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Admin") 
public class AdminService {
	
	Admin adminObj = new Admin();
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testService()
	 {
	 return "Hello";
	 } 
	
	@GET
	@Path("/Doc")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors()
	 {
	 return adminObj.readDoctors();
	 }
	
	@GET
	@Path("/Appointment")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointments()
	 {
	 return adminObj.readAppointment();
	 }
	

	@GET
	@Path("/hospital")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital()
	 {
	 return adminObj.readHospitals();
	 }
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(@FormParam("name") String name,
	 @FormParam("nic") String nic,
	 @FormParam("email") String email,
	 @FormParam("pwd") String pwd,
	 @FormParam("status") String status)
	 
	 
	{
	 String output = adminObj.createEmployees(name, nic, email, pwd,status);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployees(String adminData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(adminData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String nic = doc.select("nic").text();
	 String status1 = doc.select("status1").text();
	 String status2 = doc.select("status2").text();
	 
	 
	 String output = adminObj.deleteEmployee(nic,status1,status2);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployees(String adminData)
	{
	//Convert the input string to a JSON object
	 JsonObject adObject = new JsonParser().parse(adminData).getAsJsonObject();
	//Read the values from the JSON object
	 String name = adObject.get("name").getAsString();
	 String nic = adObject.get("nic").getAsString();
	 String email = adObject.get("email").getAsString();
	 String password = adObject.get("password").getAsString();
	 String status = adObject.get("status").getAsString();
	 
	 String output = adminObj.updateEmployees(name, nic, email, password, status);
	return output;
	}
	
	
	

}
