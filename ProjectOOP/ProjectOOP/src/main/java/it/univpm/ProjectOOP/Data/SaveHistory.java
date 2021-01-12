package it.univpm.ProjectOOP.Data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

public class SaveHistory {

	@SuppressWarnings("unchecked")
	public static void save(String city) {
		String file = city + ".dat";
		File temp = new File(file);
		boolean exists = temp.exists();
		Vector<MyData> data = new Vector<MyData>();
		MyData md = new MyData();
		try {
			md = (DataWeather.parse(city));
		}
		catch (CityNotFoundException e) {
			
		}
		
		if(exists)
			try {
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				data = (Vector<MyData>)in.readObject();
				in.close();
			
				data.add(md);
				
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				out.writeObject(data);
				out.close();
			}
			catch (IOException e) {
			}
			
			catch (Exception e) {
			}
		else
			try {
				data.add(md);
				
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				out.writeObject(data);
				out.close();
			}
		catch (Exception e) {
			
		}

	}

}
