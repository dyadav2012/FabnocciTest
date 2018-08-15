package com.test.Fabinocci;

import org.testng.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{

	@org.testng.annotations.Test
		public void getFabnocciSeries()
		{
			// Specify the base URL to the RESTful web service // x is name of war file. localhost is used when code on same machine where api is triggered, else ip of system. 
			RestAssured.baseURI = "http://localhost:7003/x";
	 
			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();
	 
			// Make a GET request call directly by using RequestSpecification.get() method.
			// Make sure you specify the resource name. 
			Response response = httpRequest.get("/fib");
	 
			// Response.asString method will directly return the content of the body in string format
			
			System.out.println("Response Body is =>  " + response.asString());
			
			// we can get response code also // which is like 200 for success.
			
			int statusCode = response.getStatusCode();
			 
			// Assert that correct status code is returned.
			Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		}
	
	}
/*

There are a number of endpoints in this application. The following question needs to be answered:

When does the application STOP returning Fibonacci numbers in their correct sequence? -> when total number of fabnocci series is 9.
		
There are no automated checks for this application. Treating the application as a black box, produce appropriate automated checks against the applications interfaces. Consider that there is more than one interface into the application.

Use only RestAssured or RestEasy to test the REST interface. - Used Rest Assured. Having experience on http client.
Use only JUnit as a test harness. - Used Junit and TestNG in code as per experience.
Ensure that your tests can be executed with an appropriate goal from Maven. - "mvn test" will execute tests by adding test into testNG,xml.


API testing about pass request with correct url with appropriate parameters and validate result. This need to be automate as per business rules.
*/



