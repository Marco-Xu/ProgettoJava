package it.univpm.ProjectOOP.Stats;

import java.util.Vector;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;

public class Statistics{
	
	public static AverageData setValori(String city) throws CityNotFoundException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		
		for(MyData a : data) {
			av.addNormalTemp(a.getNormalTemp());
			av.addMaximalTemp(a.getMaximalTemp());
			av.addMinimalTemp(a.getMinimalTemp());
			av.addFeelsLikeTemp(a.getFeelsLikeTemp());
			av.increaseN();
		}
		
		av.calc();
		return av;
	}
	
	public static AverageData setValori(String city, int period) throws CityNotFoundException, NotIntegerException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		av.setCity(city);
		int dateNow = 0;
		try {
			dateNow = (DataWeather.parse("rimini")).getDate();
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
