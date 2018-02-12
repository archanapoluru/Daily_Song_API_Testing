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
	    public void header_is_supplied_for_delete() throws Throwable {
	        System.out.println("Header is supplied");
	    }


	    @When("^Delete request is made with the \"([^\"]*)\"$")
	    public void delete_request_is_made_with_the_something(String Url) throws Throwable {
	        responsebody.Deletemethod(Url);
	    }

	   

	    @Then("^Expected response code is 204$")
	    public void expected_response_code_is_204() throws Throwable {
	        
	    
	    		int code = responsebody.response.getStatusLine().getStatusCode();
	    	
	        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, code);
	        System.out.println(code);
	    	
	    }

	    @And("^Expected response body is \"([^\"]*)\"$")
	    public void expected_response_body_is_something(String strArg1) throws Throwable {
	        System.out.println(strArg1);
	    }

	    

}
