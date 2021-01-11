package it.univpm.ProjectOOP.Data;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.ApiGet;

public class DataWeather {
	public static MyData Parse(String luogo) throws CityNotFoundException{
		
		String city = "";
		String description = "";
		double normalTemp = 0;
		double maximalTemp = 0;
		double minimalTemp = 0;
		double feelsLikeTemp = 0;
		int date = 0;
		
		JSONObject object = ApiGet.Read(city);
		
		if(!checkCity(object))
			throw new CityNotFoundException("Città non trovata");
		
		try {
			city = luogo;
		
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
	
	public static boolean checkCity(JSONObject obj) {
		String mess = "";
		try {
			mess = obj.getString("message");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mess.equals("city not found"))
			return false;
		return true;
	}
}
