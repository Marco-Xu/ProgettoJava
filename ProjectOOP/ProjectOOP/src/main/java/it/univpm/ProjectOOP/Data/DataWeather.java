package it.univpm.ProjectOOP.Data;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.ApiGet;

public class DataWeather {
	public static MyData parse(String city) throws CityNotFoundException{
		
		String description = "";
		double normalTemp = 0;
		double maximalTemp = 0;
		double minimalTemp = 0;
		double feelsLikeTemp = 0;
		int date = 0;
		
		
		JSONObject object = ApiGet.Read(city);

		try {
			
		
			JSONArray arr = object.getJSONArray("weather");
			for(int i = 0; i < arr.length(); i++) 
				description = arr.getJSONObject(i).getString("description");
		
			normalTemp = object.getJSONObject("main").getDouble("temp");
			maximalTemp = object.getJSONObject("main").getDouble("temp_max");
			minimalTemp = object.getJSONObject("main").getDouble("temp_min");
			feelsLikeTemp = object.getJSONObject("main").getDouble("feels_like");
			date = object.getInt("dt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MyData(city, description, normalTemp, maximalTemp, minimalTemp, feelsLikeTemp, date);
	}
	
}
