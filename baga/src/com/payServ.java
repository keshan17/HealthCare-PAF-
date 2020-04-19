package com;


import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import PaymentModel.Payment;

@Path("/Payment")
public class payServ {

	Payment p1 = new Payment();
	Connection con = p1.connect();

	
	//Read Data
	@GET
	@Path("/")
    @Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return p1.readPayment();
	
	}
	
	
	//insert data
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String addPayment(@FormParam("invoiceNumber") String invoiceNumber,
				@FormParam("amount") String amount,
				@FormParam("nic") String nic,
				@FormParam("cardnumber") String cardnumber,
				@FormParam("cardname") String cardname,
				@FormParam("expdate") String expdate,
				@FormParam("cvv") String cvv)
		{
			String output = p1.updatePayment( nic, cardnumber, cardname, expdate, cvv);
			return output;
		}
		
		//update
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatePayment(String paymentData)
		{
			//Convert the input string to a JSON object
			JsonObject paymentObj = new JsonParser().parse(paymentData).getAsJsonObject();

			//Read the values from the JSON object

			String nic = paymentObj.get("nic").getAsString();
			String cardnumber = paymentObj.get("cardnumber").getAsString();
			String cardname = paymentObj.get("cardname").getAsString();
			String expdate = paymentObj.get("expdate").getAsString();
			String cvv = paymentObj.get("cvv").getAsString();

			String output = p1.updatePayment( nic, cardnumber, cardname, expdate, cvv);
			return output;
		}

		//Delete
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletePayment(String payData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(payData, "", Parser.xmlParser());

		
		 String cardnumber = doc.select("cardnumber").text();
		 String output = p1.deletePayment(cardnumber);
		return output;
		}
	
}
