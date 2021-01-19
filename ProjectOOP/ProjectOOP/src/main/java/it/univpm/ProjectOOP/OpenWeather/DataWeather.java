package it.univpm.ProjectOOP.OpenWeather;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Type.MyData;

/**Classe che popola un oggetto di MyData con gli elementi contenuti nell'oggetto JSONObject.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
public class DataWeather {
	
	/**
	 * Metodo che fa la conversione da JSON a un oggetto MyData.
	 * @param city rappresenta la citta della quale otterremo un oggetto MyData
	 * @return un oggetto MyData
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	public static MyData parse(String city) throws CityNotFoundException {
		MyData md = new MyData();
		String description = "";
		JSONObject object = ApiGet.Read(city);

		JSONArray arr = object.getJSONArray("weather");
		for(int i = 0; i < arr.length(); i++) 
			description = arr.getJSONObject(i).getString("description");
		
		md.setCity(city);
		md.setDescription(description);
		md.setNormalTemp(object.getJSONObject("main").getDouble("temp"));
		md.setMaximalTemp(object.getJSONObject("main").getDouble("temp_max"));
		md.setMinimalTemp(object.getJSONObject("main").getDouble("temp_min"));
		md.setFeelsLikeTemp(object.getJSONObject("main").getDouble("feels_like"));
		md.setDate(object.getInt("dt"));
		
		return md;
	}
	
}
