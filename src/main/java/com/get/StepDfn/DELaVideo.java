package com.get.StepDfn;


import org.apache.http.HttpStatus;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Response;

import com.api.util.base.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DELaVideo {
	
	private TestBase responsebody;
	   
	   public DELaVideo(TestBase responsebody){
		   this.responsebody = responsebody;
	   }
	
	   @Given("^Header is supplied for DELETE$")
	    public void deleteV() throws Throwable {
	        System.out.println("Header is supplied");
	    }


	    @When("^Delete request is made with the \"([^\"]*)\"$")
	    public void deleteVID(String Url) throws Throwable {
	        responsebody.Deletemethod(Url);
	    }

	   

	    @Then("^Expected response code is 204$")
	    public void deleteVCode() throws Throwable {
	        
	    
	    		int code = responsebody.response.getStatusLine().getStatusCode();
	    	
	        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, code);
	        System.out.println(code);
	    	
	    }

	    @And("^Expected response body is \"([^\"]*)\"$")
	    public void deleteVResponse(String strArg1) throws Throwable {
	        System.out.println(strArg1);
	    }

	    

}
