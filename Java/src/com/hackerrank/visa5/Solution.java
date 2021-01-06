package com.hackerrank.visa5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class Solution {
    /*
     * Complete the function below.
     */
    static int getNumberOfMovies(String substr) throws IOException {
        /*
         * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
         */
    	
    	  URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
		 
		  con.setRequestMethod("GET");
		 
		  BufferedReader in = new BufferedReader(
		          new InputStreamReader(con.getInputStream()));
		  String output;
		  StringBuffer response = new StringBuffer();
		 
		  while ((output = in.readLine()) != null) {
		   response.append(output);
		  }
		  in.close();
		 
		  JsonParser parser = new JsonParser();
		  JsonElement el = parser.parse(response.toString());
		  
		  JsonObject ob = el.getAsJsonObject();
		  
		  return ob.get("total").getAsInt();
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }
        
        res = getNumberOfMovies(_substr);
        System.out.println(res);
    }
}