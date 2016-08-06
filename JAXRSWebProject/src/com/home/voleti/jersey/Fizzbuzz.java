package com.home.voleti.jersey;

	import java.lang.annotation.Repeatable;

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	//Plain old Java Object it does not extend as class or implements 
	//an interface

	//The class registers its methods for the HTTP GET request using the @GET annotation. 
	//Using the @Produces annotation, it defines that it can deliver several MIME types,
	//text, XML and HTML. 

	//The browser requests per default the HTML MIME type.

	// @Path("/fizzbuzz/{number1}/{number2: (/number2/[^/]+?)?}")

	//Sets the path to base URL + /fizzbuzz
	@Path("/fizzbuzz/{number1}/{number2}")
	public class Fizzbuzz {

		  // This method is called if HTML is request
		  @GET
		  @Produces(MediaType.TEXT_HTML)
		  public String getFizzbuzzNumber(@PathParam("number1") String number1,
				  @PathParam("number2") String number2) {
			  
			String printString = getStringFromInputNumber(number1, number2);
			
		    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + printString + "</body></h1>" + "</html> ";
		  }
		  
		  public static String getStringFromInputNumber (String from, String to) {
		  
		  	StringBuffer myBuffer = new StringBuffer();
	      		int fromValue = 1;
	      		int toValue = 1;
	      
	      		if  (from != null && to != null) {		    	      
	    	  		fromValue = Integer.parseInt(from);
	    	  		toValue = Integer.parseInt(to);
	      		} 
	      		else if (from != null && to == null) {
	    	   		fromValue = Integer.parseInt(from);
	    	   		toValue = fromValue;
	       		}		       
	      		else if (from == null ) {
	    	   		fromValue  = 1;
	    		 	toValue = 1;
	      		}  
	      
	      		for (int i = fromValue;  i <= toValue; i++) {
	    	  		if (i % 3 == 0 && i % 5 == 0) {
	            			// When i is divisible by 3 and divisible by 5, then print "FizzBuzz"
	            			myBuffer.append(" FizzBuzz ");
	    	  		} else if (i % 5 == 0) {
	            		// When i is divisible by 5, then print "Buzz"
	            		myBuffer.append(" Buzz ");
	    	  		} else if ( i % 3 == 0 ) {
	    		  	// when i is divisible by 3, then print "Fizz"
	    		  	myBuffer.append(" Fizz ");
	    	  		} else {
	    		   	// myBuffer.append(new String (Integer.toString(i)));
	    		   	myBuffer.append(i);
	    		   	myBuffer.append(" ");
	    	  		}
	      		}
	      		return myBuffer.toString();
	   	}
	}
