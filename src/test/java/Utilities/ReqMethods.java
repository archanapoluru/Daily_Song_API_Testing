package Utilities;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ReqMethods {
	
	public HttpResponse response;
    
	public void Getmethod(String url) throws ClientProtocolException, IOException {
		url = "http://turing.niallbunting.com:3005" + url;
		 response =  Request.Get(url).execute().returnResponse();
  	  ContentResponseHandler contentHandler = new ContentResponseHandler();
  	  
  	  String body = contentHandler.handleEntity(response.getEntity()).asString();
  	  int code = response.getStatusLine().getStatusCode();
  	  
  	System.out.println(code);
  	  System.out.println(body);
	}
	public void Getmethod1(String url) throws ClientProtocolException, IOException {
		url = "http://turing.niallbunting.com:3005" + url;
		 response =  Request.Get(url).execute().returnResponse();
  	  ContentResponseHandler contentHandler = new ContentResponseHandler();
  	  
  	  String body = contentHandler.handleEntity(response.getEntity()).asString();
  	  int code = response.getStatusLine().getStatusCode();
  	  
  	System.out.println(code);
  	  System.out.println(body);
	
	}
  	public void Postmethod(String url, String json) throws ClientProtocolException, IOException {
  		url = "http://turing.niallbunting.com:3005" + url;
  		response = Request.Post(url).addHeader("Content-Type", "application/json")
  				.bodyString(json, ContentType.APPLICATION_JSON).execute().returnResponse();
  		ContentResponseHandler contentHandler = new ContentResponseHandler();
    	  
    	  String body = contentHandler.handleEntity(response.getEntity()).asString();
    	  int code = response.getStatusLine().getStatusCode();
    	  System.out.println(code);
      	  System.out.println(body);
      	  
      	  String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
      	  JSONObject responseJson = new JSONObject(responseString);
      	  System.out.println(responseJson);
  		
  		
  	}
		

}
