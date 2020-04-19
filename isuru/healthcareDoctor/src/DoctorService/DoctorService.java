package DoctorService;


import DoctorModel.Doctor;
import appointmentModel.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Doctor") 
public class DoctorService {
	
		Doctor docObj = new Doctor();
		
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
		public String readSession()
		 {
		 return docObj.readSession();
		 }
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertSession(@FormParam("nic") String nic,
		 @FormParam("specialization") String Specialization,
		 @FormParam("hospital") String hospital,
		 @FormParam("room") String room,
		 @FormParam("datee") String datee,
		 @FormParam("Time") String time,
		 @FormParam("time2") String time2)
		 
		{
		 String output = docObj.addSession(nic,Specialization,hospital,room,datee,time,time2);
		return output;
		}
		
}
