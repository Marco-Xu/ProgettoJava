package it.univpm.ProjectOOP.Controller;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.Exceptions.TemperatureTypeException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;

/**Classe utile alla funzionalita&#768; della classe Controller.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
public class ControllerUtils {
	
	/**
	 * Metodo ottiene le informazioni meteo in formato MyData dall'API OpenWeather.
	 * @param city rappresenta la citta&#768; sul quale si vuole ottenere i dati meteo
	 * @return un oggetto di MyData in formato JSON
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	public static MyData setCity(String city) throws CityNotFoundException {
		MyData dw = DataWeather.parse(city);
		if(dw.getDescription() == "")
			throw new CityNotFoundException("Città non trovata.");
		return dw;
	}
	
	
	/**
	 * Metodo che imposta l'unita&#768; misura per un oggetto MyData.
	 * @param dw oggetto di MyData in formato JSON
	 * @param type  rappresenta l'unita&#768; di misura da utilizzare
	 * @return un oggetto di MyData in formato JSON
	 * @throws TemperatureTypeException se l'unita&#768; di misura inserita non e&#768; accettabile
	 */
	public static MyData setUnit(MyData dw, String type) throws TemperatureTypeException {
			if(!dw.changeTemp(type))
				throw new TemperatureTypeException("Unità di misura non valida.");
			return dw;
	}
	
	
	/**
	 * Metodo per impostare la periodicita&#768; nelle statistiche.
	 * @param period rappresenta il periodo in cui si vuole visualizzare le statistiche
	 * @return un valore intero
	 * @throws NotIntegerException se il formato inserito del periodo non e&#768; corretto
	 */
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
		
	
	/**
	 * Metodo che imposta l'unita&#768; misura per un oggetto AverageData.
	 * @param av
	 * @param type
	 * @return
	 * @throws TemperatureTypeException
	 */
	public static AverageData setUnit(AverageData av, String type) throws TemperatureTypeException {
		if(!av.changeTemp(type))
			throw new TemperatureTypeException("Unità di misura non valida.");
		return av;
	}
	
}
