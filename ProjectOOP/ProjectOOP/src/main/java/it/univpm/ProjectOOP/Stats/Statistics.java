package it.univpm.ProjectOOP.Stats;

import java.util.Vector;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.DateFormatException;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;
import it.univpm.ProjectOOP.Type.PeriodFilter;

/**Rapresenta i calcoli principali per le statistiche.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
public class Statistics{
	
	/**
	 * Metodo che mostra le statistiche in base al periodo inserito.
	 * @param city e&#768; la citta&#768; del quale vogliamo ottenere le statistiche
	 * @param period sono i giorni delle statistiche da visualizzare
	 * @return un oggetto di AverageData
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 */
	public static AverageData setValori(String city, int period) throws CityNotFoundException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		av.setCity(city);
		int dateNow = (int)(System.currentTimeMillis()/1000);
		
		period *= (60*60*24);
		dateNow -= period;
		for(MyData a : data) {
			if(a.getDate() >= dateNow) {
				av.addData(a);
			}
		}
		av.calc();
		return av;
	}
	
	
	/**
	 * Metodo che mostra le statistiche in base al periodo inserito.
	 * @param city e&#768; la citta&#768; del quale vogliamo ottenere le statistiche
	 * @param period e&#768; l'intervallo della quale si vogliono ottenere le statistiche
	 * @return un oggetto di AverageData
	 * @throws CityNotFoundException se la citta&#768; inserita non esiste
	 * @throws DateFormatException se il formato del periodo e&#768; errato
	 */
	public static AverageData setValori(String city, PeriodFilter period) throws CityNotFoundException, DateFormatException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		av.setCity(city);
		
		if(period.getEnd() < period.getStart())
			throw new DateFormatException("Data iniziale maggiore della data finale");
		
		for(MyData a : data) {
			if(a.getDate() <= period.getEnd() && a.getDate() >= period.getStart()) {
				av.addData(a);
			}
		}
		av.calc();
		return av;
	}
	
}
