package com.get.StepDfn;

import org.apache.http.HttpStatus;

import com.api.util.base.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DELaPlaylist {
	
	private TestBase responsebody;
	   
	   public DELaPlaylist(TestBase responsebody){
		   this.responsebody = responsebody;
	   }
	
	 @Given("^Header is accepted for DELETE$")
	    public void deletePL() throws Throwable {
	        System.out.println("Header is accepted");
	    }

	    @When("^Delete request is made with the Playlist ID \"([^\"]*)\"$")
	    public void deletePLID(String Url) throws Throwable {
	        responsebody.Deletemethod(Url);
	    }

	    @Then("^Expected response code for this is 204$")
	    public void deletePLCode() throws Throwable {
	        int code = responsebody.response.getStatusLine().getStatusCode();
	        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, code);
	        System.out.println(code);
	    }

	    @And("^Expected response body has \"([^\"]*)\"$")
	    public void deletePLResponse(String strArg1) throws Throwable {
	        System.out.println(strArg1);
	        
	    }

}
