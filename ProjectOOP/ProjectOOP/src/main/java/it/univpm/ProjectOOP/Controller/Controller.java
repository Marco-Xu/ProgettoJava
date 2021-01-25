package it.univpm.ProjectOOP.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.DateFormatException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;
import it.univpm.ProjectOOP.Stats.FilterUtils;
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
	 * @return Vector di oggetti InfData in formato JSON
	 */
	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public Vector<InfData> getDataWeather() {
		return new MetaData().getMetadata();
	}
	
	
	/**
	 * Risponde alla richiesta GET/weather?city="city".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @return un oggetto di MyData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	@RequestMapping(value = "weather", method = RequestMethod.GET, params = "city")
	public MyData getDataWeather(@RequestParam(value = "city") String city) throws CityNotFoundException{
		return ControllerUtils.setCity(city);
	}
	
	
	/**
	 * Risponde alla richiesta GET/weather?city="city"&amp;unit="type". 
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @param type rappresenta l'unita&#768; di misura da utilizzare
	 * @return un oggetto di MyData in formato JSON
	 * @throws TemperatureTypeException se l'unita&#768; di misura inserita non e&#768; accettabile
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	@RequestMapping(value = "weather", method = RequestMethod.GET, params = {"city", "unit"})
	public MyData getDataWeather(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String type) throws TemperatureTypeException, CityNotFoundException {
		MyData dw = ControllerUtils.setCity(city);
		return ControllerUtils.setUnit(dw, type);
	}
	
	
	/**
	 * Risponde alla richiesta POST/save?city="city".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @return un messaggio in formato String 
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST, params = "city")
	public String saving(@RequestParam(value = "city") String city) throws CityNotFoundException {
		if(History.save(city))
			return "Dati salvati.";
		return "Tempo trascorso dall'ultimo salvataggio insufficiente.\nMancano : " + History.getTime() + " minuti.";
	}

	
	/**
	 * Risponde alla richiesta POST/check?city="city".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @return un Vector di oggetti MyData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	@RequestMapping(value = "check", method = RequestMethod.POST, params = "city")
	public Vector<MyData> check(@RequestParam(value = "city") String city) throws CityNotFoundException {
		Vector<MyData> data = History.check(city);
		return data;
	}
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city"&amp;period="period".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @param period rappresenta il periodo in cui si vuole visualizzare le statistiche
	 * @return un oggetto di AverageData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 * @throws NotIntegerException se il formato inserito del periodo non e&#768; corretto
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city", "period"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") String period) throws CityNotFoundException, NotIntegerException {
		int date = ControllerUtils.setPeriod(period);
		AverageData av = Statistics.setValori(city, date);
		return av;
	}
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city"&amp;period="period"&amp;unit="type".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @param period rappresenta il periodo in cui si vuole visualizzare le statistiche
	 * @param type rappresenta l'unita&#768; di misura da utilizzare
	 * @return un oggetto di AverageData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 * @throws NotIntegerException se il formato inserito del periodo non e&#768; corretto
	 * @throws TemperatureTypeException se l'unita&#768; di misura inserita non e&#768; accettabile
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city", "period", "unit"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") String period, @RequestParam(value = "unit") String type) throws CityNotFoundException, NotIntegerException, TemperatureTypeException {
		int date = ControllerUtils.setPeriod(period);
		AverageData av = Statistics.setValori(city, date);
		return ControllerUtils.setUnit(av, type);
	}
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @param bodyRequest possibilita&#768; di inserire in formato JSON il periodo desiderato
	 * @return un oggetto di AverageData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 * @throws DateFormatException se il formato JSON del periodo non e&#768; corretto
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city"})
	public AverageData statsFilter(@RequestParam(value = "city") String city, @RequestBody(required = false) String bodyRequest) throws DateFormatException, CityNotFoundException {
		FilterUtils fu = new FilterUtils(bodyRequest);
		AverageData av = Statistics.setValori(city, fu.getPeriod());
		return av;
    }
	
	
	/**
	 * Risponde alla richiesta POST/stats?city="city"&amp;unit="type".
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @param type rappresenta l'unita&#768; di misura da utilizzare
	 * @param bodyRequest possibilita&#768; di inserire in formato JSON il periodo desiderato
	 * @return un oggetto di AverageData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 * @throws DateFormatException se il formato JSON del periodo non e&#768; corretto
	 * @throws TemperatureTypeException se l'unita&#768; di misura inserita non e&#768; accettabile
	 */
	@RequestMapping(value = "stats", method = RequestMethod.POST, params = {"city", "unit"})
	public AverageData statsFilter(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String type, @RequestBody(required = false) String bodyRequest) throws DateFormatException, CityNotFoundException, TemperatureTypeException {
		FilterUtils fu = new FilterUtils(bodyRequest);
		AverageData av = Statistics.setValori(city, fu.getPeriod());
		return ControllerUtils.setUnit(av, type);
    }
}
