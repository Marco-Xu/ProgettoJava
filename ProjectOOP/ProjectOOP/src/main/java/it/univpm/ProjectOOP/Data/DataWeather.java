package it.univpm.ProjectOOP.Data;

import org.json.JSONArray;
import org.json.JSONObject;


public class DataWeather {
	public MyData Parse(JSONObject object, String luogo) {
		
		String city = luogo;
		
		JSONArray arr = object.getJSONArray("weather");
		String description = "";
		for(int i = 0; i < arr.length(); i++) 
			description = arr.getJSONObject(i).getString("description");
		
		double normalTemp = object.getJSONObject("main").getDouble("temp");
		double maximalTemp = object.getJSONObject("main").getDouble("temp_max");
		double minimalTemp = object.getJSONObject("main").getDouble("temp_min");
		double feelsLikeTemp = object.getJSONObject("main").getDouble("feels_like");
		int date = object.getInt("dt");
		
		return new MyData(city, description, normalTemp, maximalTemp, minimalTemp, feelsLikeTemp, date);
	}
}
