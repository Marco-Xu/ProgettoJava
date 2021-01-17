package it.univpm.ProjectOOP.Stats;

import java.util.Vector;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;

/**
 * @author Davide Balducci
 * @author Marco Xu
 */
public class Statistics{
	
	/**
	 * Metodo che mostra i dati salvati in base al periodo inserito.
	 * @param city è la città sul quale applicare la statistica
	 * @param period sono i giorni delle statistiche da visualizzare
	 * @return un oggetto di AverageData
	 * @throws CityNotFoundException se la città inserita non esiste
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
	
}
