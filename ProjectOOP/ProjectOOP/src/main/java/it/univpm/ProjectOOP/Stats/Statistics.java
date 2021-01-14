package it.univpm.ProjectOOP.Stats;

import java.util.Vector;
import it.univpm.ProjectOOP.Data.*;

public class Statistics{
	
	public AverageData setValori(String city) {
		
		Vector<MyData> data = History.check(city);
		AverageData av = new AverageData();
		
		for(MyData a : data) {
			av.addNormalTemp(a.getNormalTemp());
			av.addMaximalTemp(a.getMaximalTemp());
			av.addMinimalTemp(a.getMinimalTemp());
			av.addFeelsLikeTemp(a.getFeelsLikeTemp());
			av.increaseN();
		}
		return av;
	}
}
