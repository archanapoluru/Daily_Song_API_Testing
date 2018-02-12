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

public class PostAPlaylist {
	
	private TestBase responsebody;
	   
	   public PostAPlaylist(TestBase responsebody){
		   this.responsebody = responsebody;
	   }
	
	
	
	 @Given("^Accept the content in JSON format$")
	    public void postPL() throws Throwable {
	        System.out.println("Body is in Json format");
	    }

	 @When("^POST request is performed with desc as \"([^\"]*)\", title as \"([^\"]*)\" and uri as \"([^\"]*)\"$")
	    public void postPLDetails(String strArg1, String strArg2, String strArg3) throws Throwable {
		 String json = responsebody.JsonBodyPlaylist(strArg1, strArg2);
	        responsebody.Postmethod(strArg3, json);
	    }

	    @Then("^Expected Status code \"([^\"]*)\" should return$")
	    public void postPLCode(String strArg1) throws Throwable {
	        int code = responsebody.response.getStatusLine().getStatusCode();
	        Assert.assertEquals(HttpStatus.SC_CREATED, code);
	    }

	    

	    @And("^Response body should have descrition as \"([^\"]*)\", title as \"([^\"]*)\"$")
	    public void postPLResponse(String desc, String title) throws Throwable {
	    	String responseString = EntityUtils.toString(responsebody.response.getEntity(), "UTF-8");
	    	 System.out.println(responseString);
	    	  JSONObject responseJson = new JSONObject(responseString);
	    	  System.out.println(responseJson);
	    	  String desc1 = responsebody.ValidateJson(responseJson, "/desc");
	    	  String title1 = responsebody.ValidateJson(responseJson, "/title");
	    	  
	    	  Assert.assertEquals(desc, desc1);
	    	  Assert.assertEquals(title, title1);
	    }


}
