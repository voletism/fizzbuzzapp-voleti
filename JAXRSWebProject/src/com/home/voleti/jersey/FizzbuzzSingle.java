package com.home.voleti.jersey;

import java.lang.annotation.Repeatable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

	//The class registers its methods for the HTTP GET request using the @GET annotation. 
	//Using the @Produces annotation, it defines that it can deliver several MIME types,
	//text, XML and HTML. 

	//The browser requests per default the HTML MIME type.

	//Sets the path to base URL + /fizzbuzz
	@Path("/fizzbuzz/{number1}")
	public class FizzbuzzSingle {

		  // This method is called if HTML is request
		  @GET
		  @Produces(MediaType.TEXT_HTML)
		  public String getFizzbuzzNumber(@PathParam("number1") String number1) {
			
			String printString = Fizzbuzz.getStringFromInputNumber(number1, number1);
			
		    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + printString + "</body></h1>" + "</html> ";
		  }
	}
