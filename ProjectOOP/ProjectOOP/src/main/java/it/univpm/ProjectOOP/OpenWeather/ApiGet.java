package it.univpm.ProjectOOP.OpenWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class ApiGet {
	public JSONObject Read(String city) {
		
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ffb7e697fda1e224fa8c50d16e4b3bca";
		JSONObject obj = new JSONObject();
		
		try {

			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true);
			
			InputStream in = openConnection.getInputStream();
		
			String data = "";
			String line = "";
			
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(in));

				while ((line = buf.readLine()) != null) {
					data += line;
				}
			} finally {
				in.close();
			}
			
			obj = (JSONObject) JSONValue.parseWithException(data);
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
}