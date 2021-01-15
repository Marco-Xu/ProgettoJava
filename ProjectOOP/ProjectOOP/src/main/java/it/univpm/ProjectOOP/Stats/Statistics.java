package it.univpm.ProjectOOP.Stats;

import java.util.Vector;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;

public class Statistics{
	
	public static AverageData setValori(String city, int period) throws CityNotFoundException, NotIntegerException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		av.setCity(city);
		int dateNow = 0;
		try {
			dateNow = (DataWeather.parse(city)).getDate();
		}
		catch(Exception e) {
		}
		
		period += dateNow;
		for(MyData a : data) {
			if(a.getDate() <= period) {
			av.addNormalTemp(a.getNormalTemp());
			av.addMaximalTemp(a.getMaximalTemp());
			av.addMinimalTemp(a.getMinimalTemp());
			av.addFeelsLikeTemp(a.getFeelsLikeTemp());
			av.increaseN();
			}
		}
		av.calc();
		return av;
	}
	
}
