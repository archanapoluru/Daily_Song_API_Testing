package Utilities;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import gherkin.deps.com.google.gson.JsonObject;

public class PostUtil {
	
	public HttpResponse response;
	public String url;

	             
	             private static final String SONG = "song";
	    		 private static final String ARTIST = "artist";
	    		 private static final String PUBLISHDATE = "publishDate";
	    		 
	    		 private static final String DESC = "desc";
	    		 private static final String TITLE = "title";
	    		 
	    		/* private static int getRandomID() {
	    			 return (int)(1000*(Math.random()));
	    		 }*/
	    		 
	    		 public  String JsonBodyvideo(String song, String artist, String pubdate) {
	    			 JsonObject jsonObject = new JsonObject();
	    			 jsonObject.addProperty(SONG, song);
	    			 jsonObject.addProperty(ARTIST, artist);
	    			 jsonObject.addProperty(PUBLISHDATE, pubdate);
	    			 //jsonObject.addProperty(_Id, id == null ? getRandomID() + "" : id + "");
	    			 
	    			 return jsonObject.toString();
	    		 
	    		 } 
	    			 
	    			 public String JsonBodyPlaylist(String desc, String title) {
	    			 JsonObject jsonObject1 = new JsonObject();
	    			 jsonObject1.addProperty(DESC, desc);
	    			 jsonObject1.addProperty(TITLE, title);
	    			 
	    			 return jsonObject1.toString();
	    	}	    			 
	    			 
	    		 
	 
	    			 public String ValidateJson(JSONObject responsejson, String jpath) {
	    				Object obj = responsejson;
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
	    			 
	    			 public String Finaluri(String url) {
	    			  		url = "http://turing.niallbunting.com:3005" + url;
	    			  		return url;
	    			 }

}
