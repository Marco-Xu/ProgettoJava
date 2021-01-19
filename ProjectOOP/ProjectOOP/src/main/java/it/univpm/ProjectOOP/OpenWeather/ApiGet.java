package it.univpm.ProjectOOP.OpenWeather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

/**Classe utilizzata per la chiamata all'API di OpenWeather.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class ApiGet {
	
	/**
	 * Metodo che esegue la chiamata all'API e crea un oggetto JSONObject con i dati letti dalla chiamata.
	 * @param city rappresenta la citta&#768; da cui prelevare i dati meteo
	 * @return un oggetto JSONObject
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	public static JSONObject Read(String city) throws CityNotFoundException {
		
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ffb7e697fda1e224fa8c50d16e4b3bca";
		JSONObject obj = new JSONObject();
		
		try {

			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			
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
			
			obj = new JSONObject(data);
			
		} catch (FileNotFoundException e) {
			throw new CityNotFoundException("Città non trovata.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
}