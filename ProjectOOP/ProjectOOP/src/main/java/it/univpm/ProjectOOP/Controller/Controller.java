package it.univpm.ProjectOOP.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Stats.Statistics;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.InfData;
import it.univpm.ProjectOOP.Type.MyData;

/**Rappresenta la classe Controller che gestisce tutte le richieste accessibili dall'utente.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */

@RestController
public class Controller {
	
	/**
	 * Risponde alla richiesta GET /metadata.
	 * @return Vector di oggetti InfData
	 */
	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public Vector<InfData> getDataWeather() {
		return new MetaData().getMetadata();
	}
	
	
	/**
	 * Risponde alla richiesta GET/weather?city="city".
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @return un oggetto di MyData
	 * @throws CityNotFoundException se la città inserita non esiste
	 */
	@RequestMapping(value = "weather", method = RequestMethod.GET, params = "city")
	public MyData getDataWeather(@RequestParam(value = "city") String city) throws CityNotFoundException{
		MyData dw = DataWeather.parse(city);
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		return dw;
	}
	
	
	/**
	 * Risponde alla richiesta GET/weather?city="city"&unit="type". 
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @param type rappresenta l'unità di misura da utilizzare
	 * @return un oggetto di MyData
	 * @throws TemperatureTypeException se l'unità di misura inserita non è accettabile
	 * @throws CityNotFoundException se la città inserita non esiste
	 */
	@RequestMapping(value = "weather", method = RequestMethod.GET, params = {"city", "unit"})
	public MyData getDataWeather(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String type) throws TemperatureTypeException, CityNotFoundException {
		MyData dw = DataWeather.parse(city);
		
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		
		if(!dw.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		
		return dw;
	}
	
	
	/**
	 * Risponde alla richiesta GET/save?city="city".
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @return un messaggio in formato String
	 * @throws CityNotFoundException se la città inserita non esiste
	 */
	@RequestMapping(value = "save", method = RequestMethod.GET, params = "city")
	public String saving(@RequestParam(value = "city") String city) throws CityNotFoundException {
	
		if(History.save(city))
			return "Dati salvati.";
			
		return "Tempo trascorso dall'ultimo slavataggio insufficiente.\nMancano : " + History.getTime() + " minuti";
	}

	
	/**
	 * Risponde alla richiesta GET/check?city="city".
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @return un Vector di oggetti MyData
	 * @throws CityNotFoundException se la città inserita non esiste
	 */
	@RequestMapping(value = "check", method = RequestMethod.GET, params = "city")
	public Vector<MyData> check(@RequestParam(value = "city") String city) throws CityNotFoundException {
		Vector<MyData> data = History.check(city);
		return data;
	}
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city"&period="period".
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @param period rappresenta il periodo in cui si vuole visualizzare le statistiche
	 * @return un oggetto di AverageData
	 * @throws CityNotFoundException se la città inserita non esiste
	 * @throws NotIntegerException se il formato inserito del periodo non è corretto
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city", "period"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") String period) throws CityNotFoundException, NotIntegerException {
		int date;
		try {
		   date = Integer.parseInt(period);
		}
		catch (NumberFormatException e) {
		   throw new NotIntegerException("Formato di 'period' non valido.");
		}
		
		AverageData av = Statistics.setValori(city, date);
		return av;
	}
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city"&period="period"&unit="type".
	 * @param city rappresenta la città sul quale si vuole ottenere i dati meteo
	 * @param period rappresenta il periodo in cui si vuole visualizzare le statistiche
	 * @param type rappresenta l'unità di misura da utilizzare
	 * @return
	 * @throws CityNotFoundException se la città inserita non esiste
	 * @throws NotIntegerException se il formato inserito del periodo non è corretto
	 * @throws TemperatureTypeException se l'unità di misura inserita non è accettabile
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city", "period", "unit"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") String period, @RequestParam(value = "unit") String type) throws CityNotFoundException, NotIntegerException, TemperatureTypeException {
		int date;
		try {
		   date = Integer.parseInt(period);
		}
		catch (NumberFormatException e) {
		   throw new NotIntegerException("Formato di 'period' non valido.");
		}
		AverageData av = Statistics.setValori(city, date);
		
		if(!av.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		
		return av;
	}
}
