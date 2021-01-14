package it.univpm.ProjectOOP.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;
import it.univpm.ProjectOOP.Stats.Statistics;

@RestController
public class Controller {

	@RequestMapping(value = "weather", method = RequestMethod.GET, params = "city")
	public MyData getDataWeather(@RequestParam(value = "city") String city) throws CityNotFoundException{
		MyData dw = DataWeather.parse(city);
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		return dw;
	}
	
	@RequestMapping(value = "weather", method = RequestMethod.GET, params = {"city", "unit"})
	public MyData getDataWeather(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String type) throws TemperatureTypeException, CityNotFoundException {
		MyData dw = DataWeather.parse(city);
		
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		
		if(!dw.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		
		return dw;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.GET, params = "city")
	public String saving(@RequestParam(value = "city") String city) {
		
		if(History.save(city))
			return "Dati salvati.";
		return "Tempo trascorso dall'ultimo slavataggio insufficiente.";
	}

	@RequestMapping(value = "check", method = RequestMethod.GET, params = "city")
	public Vector<MyData> check(@RequestParam(value = "city") String city) {
		Vector<MyData> data = History.check(city);
		return data;
	}
	
	@RequestMapping(value = "stats", method = RequestMethod.GET, params = {"city", "period"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") int period) {
		period *= (60*60*24);
		AverageData av = Statistics.setValori(city, period);
		return av;
	}
	
	@RequestMapping(value = "stats", method = RequestMethod.GET, params = {"city", "period", "unit"})
	public AverageData stats(@RequestParam(value = "city") String city, @RequestParam(value = "period") int period, @RequestParam(value = "unit") String type) {
		period *= (60*60*24);
		AverageData av = Statistics.setValori(city, period);
		av.changeTemp(type);
		return av;
	}
}
