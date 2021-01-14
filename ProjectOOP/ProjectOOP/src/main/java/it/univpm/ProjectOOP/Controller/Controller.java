package it.univpm.ProjectOOP.Controller;

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
		
		switch(type) {
		case "Celsius":
		case "celsius":
		case "C":
		case "c":
			dw.toCelsius();
			dw.roundNum();
			break;
			
		case "Fahrenheit":
		case "fahrenheit":
		case "F":
		case "f":
			dw.toFahrenheit();
			dw.roundNum();
			break;
			
		case "Kelvin":
		case "kelvin":
		case "K":
		case "k":
			break;
			
		default:
			throw new TemperatureTypeException("Unità di misura non valida.");
		}
		
		return dw;
	}
	
	
	@RequestMapping(value = "/{city}/save", method = RequestMethod.GET)
	public String saving(@PathVariable String city) {
		
		if(History.save(city))
			return "Dati salvati.";
		return "Tempo trascorso dall'ultimo slavataggio insufficiente.";
	}

	
	
}
