package it.univpm.ProjectOOP.Stats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.DateFormatException;
import it.univpm.ProjectOOP.Type.PeriodFilter;

/**Rappresenta la classe per il parsing del periodo.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class FilterUtils {
	private PeriodFilter period;
	
	public FilterUtils() {
	}

	public FilterUtils(PeriodFilter period) {
		this.period = period;
	}

	/**
	 * Costruttore tramite il parsing del JSONObject.
	 * @param body periodo in formato JSON
	 * @throws DateFormatException se il formato del periodo è errato
	 */
	public FilterUtils(String body) throws DateFormatException {
		try {
			period = new PeriodFilter();
			this.init(body);
		}
		catch(NullPointerException e) {
			period = new PeriodFilter(0, 2000000000);
		}
	}
	
	public PeriodFilter getPeriod() {
		return period;
	}

	public void setPeriod(PeriodFilter period) {
		this.period = period;
	}
	
	/**
	 * Metodo per la conversione in formato unix del body passato per argomento.
	 * @param body periodo in formato JSON
	 * @throws DateFormatException se il formato del periodo è errato
	 */
	private void init(String body) throws DateFormatException {
		String temp = "";
		try {
			JSONObject obj = new JSONObject(body);
			temp = obj.getString("startDate");
			period.setStart(dateConv(temp));
			temp = obj.getString("endDate");
			period.setEnd(dateConv(temp));
		}
		catch (NullPointerException | JSONException e){
			throw new DateFormatException("Formato della data errata");
		}
	}
	
	
	/**
	 * Metodo per la conversione della data da Stringa ad Intero.
	 * @param dateString data in formato dd-MM-yyyy
	 * @return data in formato Intero
	 * @throws DateFormatException se il formato del periodo è errato
	 */
	private int dateConv(String dateString) throws DateFormatException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		if(dateString.length() < 10)
			throw new DateFormatException("Formato data sbagliato -> (dd-MM-yyyy)");
		if(Integer.parseInt(dateString.substring(0, 2)) > 31 || Integer.parseInt(dateString.substring(0, 2)) < 1)
			throw new DateFormatException("Giorno inesistente");
		if(Integer.parseInt(dateString.substring(3, 5)) > 12 || Integer.parseInt(dateString.substring(3, 5)) < 1)
			throw new DateFormatException("Mese inesistente");
		if(Integer.parseInt(dateString.substring(6, 10)) < 1970)
			throw new DateFormatException("Anno troppo piccolo");
		
		try {
			Date date = format.parse(dateString);
			int timeStamp = (int)(date.getTime()/1000);
			return timeStamp;
		} catch (ParseException e) {
			throw new DateFormatException("Formato della data errata");
		}
	}
}
