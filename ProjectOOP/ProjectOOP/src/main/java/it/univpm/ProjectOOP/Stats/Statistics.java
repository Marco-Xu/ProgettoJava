package it.univpm.ProjectOOP.Stats;

import java.util.Vector;

import it.univpm.ProjectOOP.Data.*;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Exceptions.NotIntegerException;
import it.univpm.ProjectOOP.Type.AverageData;
import it.univpm.ProjectOOP.Type.MyData;

public class Statistics{
	
	public static AverageData setValori(String city, int period) throws CityNotFoundException, NotIntegerException {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		av.setCity(city);
		int dateNow = (int)(System.currentTimeMillis()/1000);
		
		period *= (60*60*24);
		period += dateNow;
		for(MyData a : data) {
			if(a.getDate() <= period) {
			av.addData(a);
			}
		}
		av.calc();
		return av;
	}
	
}
