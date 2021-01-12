package it.univpm.ProjectOOP.Data;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class saveHistory {

	public static void save(String city) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(city)));
			out.writeObject(DataWeather.Parse(city));
			out.close();
		}
		catch (Exception e) {
			
		}
	}

}
