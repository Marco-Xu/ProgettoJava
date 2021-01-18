package it.univpm.ProjectOOP.Controller;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;

public class ControllerUtils {
	
	public static MyData setCity(String city) throws CityNotFoundException {
		MyData dw = DataWeather.parse(city);
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		return dw;
	}
	
	
	public static MyData setUnit(MyData dw, String type) throws TemperatureTypeException {
			if(!dw.changeTemp(type))
				throw new TemperatureTypeException("Unità di misura non valida.");
			return dw;
	}
	
	
	public static int setPeriod(String period) throws NotIntegerException {
		switch(period) {
			case "Giornaliero":
			case "giornaliero":
				return 1;
			case "Settimanale":
			case "settimanale":
				return 7;
			case "Mensile":
			case "mensile":
				return 30;
			default:
				try {
				   return Integer.parseInt(period);
				}catch (NumberFormatException e) {
				   throw new NotIntegerException("Formato di 'period' non valido.");
				}
			}
	}
		
	
	public static AverageData setUnit(AverageData av, String type) throws TemperatureTypeException {
		if(!av.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		return av;
	}
	
}
