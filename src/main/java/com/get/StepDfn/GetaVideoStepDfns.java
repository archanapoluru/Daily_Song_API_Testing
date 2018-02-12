package com.get.StepDfn;

import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.api.util.base.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GetaVideoStepDfns {
	
	private TestBase responsebody;
	   
	   public GetaVideoStepDfns(TestBase responsebody){
		   this.responsebody = responsebody;
	   }
	
	

	@Given("^Header is supplied$")
    public void header_is_supplied() throws Throwable {
       System.out.println("Header is supplied"); 
    }

    @When("^GET Request is made to the API with id as \"([^\"]*)\"$")
    public void get_request_is_made_to_the_api_with_id_as_something(String Url) throws Throwable {
    	responsebody.Getmethod(Url); 
    }

    @Then("^Expected status code is 200$")
    public void expected_status_code_is_200() throws Throwable {
    	int code = responsebody.response.getStatusLine().getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK, code);
        System.out.println(code);
    }

    @And("^Artist expected is \"([^\"]*)\", and song is \"([^\"]*)\"$")
    public void artist_expected_is_something_and_song_is_something(String strArg1, String strArg2) throws Throwable {
    	String responseString = EntityUtils.toString(responsebody.response.getEntity(), "UTF-8");
    	 System.out.println(responseString);
    	 JSONObject responseJson = new JSONObject(responseString);
    	  System.out.println(responseJson);
    	  String artist1 = responsebody.ValidateJson(responseJson, "/data[0]/artist");
    	  String artist2 = responsebody.ValidateJson(responseJson, "/data[1]/artist");
    	  System.out.println(artist1);
    	  System.out.println(artist2);
    	  Assert.assertEquals(strArg1, artist1);
    	  Assert.assertEquals(strArg2, artist2);
    }
}
