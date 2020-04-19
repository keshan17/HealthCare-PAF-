package HospitalService;

import HospitalModel.Hospital;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Hospital")
public class HospitalService {
	Hospital hosObj = new Hospital();
	

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return "Hello";
	 } 

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital()
	 {
	 return hosObj.readHospitals();
	 }
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("name") String name,
	 @FormParam("license") String license,
	 @FormParam("telephone") String telephone,
	 @FormParam("emergancy") String emergancy,
	 @FormParam("facilities") String facilities,
	 @FormParam("rooms") String rooms)
	 
	{
	 String output = hosObj.createHospital(name,license,telephone,emergancy,facilities,rooms);
	return output;
	}
	
	
}


