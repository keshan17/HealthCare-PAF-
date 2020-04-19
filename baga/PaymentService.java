package PaymentService;



import PaymentModel.*;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payment")
public class PaymentService {
	Payment payObj = new Payment();
	
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
	public String readPayment()
	 {
	 return payObj.readPayment();
	 }
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("invoiceNumber") String invoiceNumber,
	 @FormParam("amount") String amount,
	 @FormParam("nic") String nic,
	 @FormParam("cardnumber") String cardnumber,
	 @FormParam("cardname") String cardname,
	 @FormParam("expdate") String expdate,
	 @FormParam("cvv") String cvv)
	 
	{
	 String output = payObj.addPayment(invoiceNumber,amount,nic,cardnumber,cardname,expdate,cvv);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String payData)
	{
	//Convert the input string to a JSON object
	 JsonObject payObject = new JsonParser().parse(payData).getAsJsonObject();
	//Read the values from the JSON object
	 String nic = payObject.get("nic").getAsString();
	 String cardnumber = payObject.get("cardnumber").getAsString();
	 String cardname = payObject.get("cardname").getAsString();
	 String expdate = payObject.get("expdate").getAsString();
	 String cvv = payObject.get("cvv").getAsString();
	 
	 
	 String output = payObj.updatePayment(nic, cardnumber, cardname, expdate, cvv);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String payData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(payData, "", Parser.xmlParser());

	
	 String cardnumber = doc.select("cardnumber").text();
	 String output = payObj.deletePayment(cardnumber);
	return output;
	}
	
}
