package com.get.StepDfn;




import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.api.util.base.TestBase;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GETStepDfns {
	
	
   private TestBase responsebody;
   
   public GETStepDfns(TestBase responsebody){
	   this.responsebody = responsebody;
   }
	 
   @Given("^Headers are supplied$")
   public void headers_are_supplied() throws Throwable {
       System.out.println("Header and apiurl is supplied");
   }

   @When("^GET Request is made to the API with \"([^\"]*)\"$")
   public void get_request_is_made_to_the_api_with_something(String Url) throws Throwable {
       responsebody.Getmethod(Url);
   }

   @Then("^Expected status code is \"([^\"]*)\"$")
   public void expected_status_code_is_something(String strArg1) throws Throwable {
       int code = responsebody.response.getStatusLine().getStatusCode();
       Assert.assertEquals(HttpStatus.SC_OK, code);
       System.out.println(strArg1);
   }

   @And("^Artists expected are \"([^\"]*)\", and \"([^\"]*)\"$")
   public void artists_expected_are_something_and_something(String artist_1, String artist_2) throws Throwable {
	   
 	 String responseString = EntityUtils.toString(responsebody.response.getEntity(), "UTF-8");
 	 System.out.println(responseString);
 	  JSONObject responseJson = new JSONObject(responseString);
 	  System.out.println(responseJson);
 	  String artist1 = responsebody.ValidateJson(responseJson, "/data[0]/artist");
 	  String artist2 = responsebody.ValidateJson(responseJson, "/data[1]/artist");
 	  System.out.println(artist1);
 	  System.out.println(artist2);
 	  Assert.assertEquals(artist_1, artist1);
 	  Assert.assertEquals(artist_2, artist2);
   }
    
   
}
