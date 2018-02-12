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
    public void getV() throws Throwable {
       System.out.println("Header is supplied"); 
    }

    @When("^GET Request is made to the API with id as \"([^\"]*)\"$")
    public void getVID(String Url) throws Throwable {
    	responsebody.Getmethod(Url); 
    }

    @Then("^Expected status code is 200$")
    public void getVIDCode() throws Throwable {
    	int code = responsebody.response.getStatusLine().getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK, code);
        System.out.println(code);
    }

    @And("^Artist expected is \"([^\"]*)\", and song is \"([^\"]*)\"$")
    public void getVIDResponse(String strArg1, String strArg2) throws Throwable {
    	String responseString = EntityUtils.toString(responsebody.response.getEntity(), "UTF-8");
    	 System.out.println(responseString);
    	 JSONObject responseJson = new JSONObject(responseString);
    	  System.out.println(responseJson);
    	  String artist1 = responsebody.ValidateJson(responseJson, "artist");
    	  System.out.println(artist1);
    	  Assert.assertEquals(strArg1, artist1);

    }
}
