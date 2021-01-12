package it.univpm.ProjectOOP.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

@RestController
public class Controller {

	@RequestMapping(value = "/DataWeather/{city}", method = RequestMethod.GET)
	public MyData getDataWeather(@PathVariable String city) throws CityNotFoundException{
		
		return DataWeather.parse(city);
	}
	
	
	
}
