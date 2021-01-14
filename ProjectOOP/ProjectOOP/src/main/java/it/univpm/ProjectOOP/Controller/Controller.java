package it.univpm.ProjectOOP.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;

@RestController
public class Controller {

	@RequestMapping(value = "weather", method = RequestMethod.GET)
	public MyData getDataWeather(@RequestParam(value = "city") String city) throws CityNotFoundException{
		MyData dw = DataWeather.parse(city);
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		return dw;
	}
	
	@RequestMapping(value = "tempo", method = RequestMethod.GET)
	public MyData getDataWeather(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String type) throws TemperatureTypeException, CityNotFoundException {
		MyData dw = DataWeather.parse(city);
		
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		
		if(!dw.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		
		return dw;
	}
	
	
	@RequestMapping(value = "/{city}/save", method = RequestMethod.GET)
	public String saving(@PathVariable String city) {
		
		if(History.save(city))
			return "Dati salvati.";
		return "Tempo trascorso dall'ultimo slavataggio insufficiente.";
	}

	@RequestMapping(value = "/{city}/check", method = RequestMethod.GET)
	public Vector<MyData> check(@PathVariable String city) {
		Vector<MyData> data = History.check(city);
		return data;
	}
	
}
