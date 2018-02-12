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

public class PostAVideo {
	
	
	private TestBase responsebody;
	   
	   public PostAVideo(TestBase responsebody){
		   this.responsebody = responsebody;
	   }
	
	 @Given("^Header is provided$")
	    public void postV() throws Throwable {
	        System.out.println("Header is provided");
	    }

	    @When("^Artist as \"([^\"]*)\",song as \"([^\"]*)\", publishdate as \"([^\"]*)\" and uri as \"([^\"]*)\"$")
	    public void postVDetails(String artist, String song, String pubdate, String url) throws Throwable {
	       
	    	String json = responsebody.JsonBodyvideo(song, artist, pubdate);
	    	responsebody.Postmethod(url, json); 
	    }

	    @Then("^Expected Status code \"([^\"]*)\" should be returned$")
	    public void postVCode(String strArg1) throws Throwable {
	        
	    	int code = responsebody.response.getStatusLine().getStatusCode();
	        System.out.println(code);
	        Assert.assertEquals(HttpStatus.SC_CREATED, code);
	    }

	    @And("^Response body should have artist as \"([^\"]*)\", song as \"([^\"]*)\"$")
	    public void postVResponse(String Artist, String Song) throws Throwable {
	    	String responseString = EntityUtils.toString(responsebody.response.getEntity(), "UTF-8");
	    	System.out.println(responseString);
	    	  JSONObject responseJson = new JSONObject(responseString);
	    	  System.out.println(responseJson);
	    	  String artist = responsebody.ValidateJson(responseJson, "/artist");
	    	  String song = responsebody.ValidateJson(responseJson, "/song");
	    	  
	    	  Assert.assertEquals(Artist, artist);
	    	  Assert.assertEquals(Song, song);
	    }

}
