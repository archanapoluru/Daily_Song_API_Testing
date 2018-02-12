package com.api.util.base;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.java.Before;
import gherkin.deps.com.google.gson.JsonElement;


public class TestBase {
	
	
	
    public HttpResponse response;
    public String url;
    private static final String SONG = "song";
	 private static final String ARTIST = "artist";
	 private static final String PUBLISHDATE = "publishDate";
	 private static final String Videos = "videos";
	 private static final String DESC = "desc";
	 private static final String TITLE = "title";
	 
	 public  String JsonBodyvideo(String song, String artist, String pubdate) {
		 JsonObject jsonObject = new JsonObject();
		 jsonObject.addProperty(SONG, song);
		 jsonObject.addProperty(ARTIST, artist);
		 jsonObject.addProperty(PUBLISHDATE, pubdate);
		 
		  return jsonObject.toString();

		 }
	

		 
		 
	 
	 
	 
	 public String JsonBodyPlaylist(String desc, String title) {
		 JsonObject jsonObject1 = new JsonObject();
		 jsonObject1.addProperty(DESC, desc);
		 jsonObject1.addProperty(TITLE, title);
		 
		
		 return jsonObject1.toString();
}	    		
	 
	 
	 public String ValidateJson(JSONObject responseJson, String jpath) {
			Object obj = responseJson;
			for(String s : jpath.split("/"))
				if(!s.isEmpty())
					if(!(s.contains("[") || s.contains("]")))
						obj = ((JSONObject)obj).get(s);
					else if (s.contains("[")|| s.contains("]"))
						obj = ((JSONArray) ((JSONObject)obj)
								.get(s.split("\\[")[0]))
						.get(Integer.parseInt(s.split("\\[")[1].replace("\\]", "")));
			return obj.toString();
		 }
	
	 
	public void Getmethod(String url) throws ClientProtocolException, IOException {
		url = "http://turing.niallbunting.com:3005" + url;
		 response =  Request.Get(url).execute().returnResponse();
  	  
	}
  	
  	public void Postmethod(String url, String json) throws ClientProtocolException, IOException {
  		url = "http://turing.niallbunting.com:3005" + url;
  		response = Request.Post(url).addHeader("Content-Type", "application/json")
  				.bodyString(json, ContentType.APPLICATION_JSON).execute().returnResponse();
  		
  		
  		
  	}
  	
  	public void Deletemethod(String url) throws ClientProtocolException, IOException {
		url = "http://turing.niallbunting.com:3005" + url;
		 response =  Request.Delete(url).addHeader("Content-Type", "application/json").execute().returnResponse();

  	
  	} 
  	
  	public void Patchmethod(String url, String json)throws ClientProtocolException, IOException {
  		url = "http://turing.niallbunting.com:3005" + url;
  		response = Request.Patch(url).addHeader("Content-Type", "application/json")
  				.bodyString(json, ContentType.APPLICATION_JSON).execute().returnResponse();
  	}
  	
	
}
