package it.univpm.ProjectOOP.Stats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import it.univpm.ProjectOOP.Exceptions.DateFormatException;
import it.univpm.ProjectOOP.Type.PeriodFilter;

public class FilterUtils {
	private PeriodFilter period;
	
	public FilterUtils() {
	}

	public FilterUtils(PeriodFilter period) {
		this.period = period;
	}

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
	
	private void init(String body) throws DateFormatException {
		JSONObject obj = new JSONObject(body);
		String temp = "";
		try {
			temp = obj.getString("startDate");
			period.setStart(dateConv(temp));
			temp = obj.getString("endDate");
			period.setEnd(dateConv(temp));
		}
		catch (NullPointerException e){
			throw new DateFormatException("Formato della data errata");
		}
		catch (JSONException e) {
			throw new DateFormatException("Formato della data errata");
		}
	}
	
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
