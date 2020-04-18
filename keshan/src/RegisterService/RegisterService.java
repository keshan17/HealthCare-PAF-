package RegisterService;

import RegisterModel.Register;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import AdminModel.Admin;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Register")
public class RegisterService {
	Register regObj = new Register();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerSystem(@FormParam("name") String name,
	 @FormParam("nic") String nic,
	 @FormParam("email") String email,
	 @FormParam("pwd") String pwd,
	 @FormParam("status") String status)
	 
	 
	{
	 String output = regObj.getRegistrationInfo(name, nic, email, pwd,status);
	return output;
	}
	
}

