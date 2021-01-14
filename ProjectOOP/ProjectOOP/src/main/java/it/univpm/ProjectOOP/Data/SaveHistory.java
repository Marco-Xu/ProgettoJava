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
	public static boolean save(String city) {
		String file = city + ".dat";
		int maxTime = 0;
		Vector<MyData> data = new Vector<MyData>();
		MyData md = new MyData();
		String dir = (System.getProperty("user.dir"));
		dir += "/data";
		File actualFile = new File (dir, file);
		boolean exists = actualFile.exists();

		try {
			md = (DataWeather.parse(city));
		}
		catch (CityNotFoundException e) {
			e.printStackTrace();
		}
		
		if(exists)
			try {

				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(actualFile)));
				data = (Vector<MyData>)in.readObject();
				in.close();
				
				for(MyData a : data)
					if(maxTime < a.getDate())
						maxTime = a.getDate();
				if(md.getDate() > (maxTime + 3600)) {
					data.add(md);
					ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(actualFile)));
					out.writeObject(data);
					out.close();
					return true;
				}
				return false;
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		else
			try {

				data.add(md);
				
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(actualFile)));
				out.writeObject(data);
				out.close();
				return true;
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
