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

public class History {
	public static boolean save(String city) throws CityNotFoundException {
		Vector<MyData> data = new Vector<MyData>();
		MyData md = new MyData();
		File actualFile = getDir(city);

		md = (DataWeather.parse(city));
		if(md.description == "")
			throw new CityNotFoundException("Città non trovata.");

		data = getData(actualFile);
		if(checkDate(data, md)) {
			data.add(md);
			if(writeData(actualFile, data))
				return true;
			return false;	
		}
		return false;
	}
	
	public static Vector<MyData> check(String city) throws CityNotFoundException {
		File actualFile = getDir(city);
		Vector<MyData> data = getData(actualFile);
		if(data.isEmpty())
			throw new CityNotFoundException("Città non trovata.");
		
		return data;
	}
	
	private static File getDir(String city) {
		city = checkUpperCase(city);
		String file = city + ".dat";
		String dir = (System.getProperty("user.dir"));
		dir += "/data";
		File actualFile = new File (dir, file);
		return actualFile;
	}
	
	@SuppressWarnings("unchecked")
	private static Vector<MyData> getData(File actualFile){
		Vector<MyData> data = new Vector<MyData>();
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(actualFile)));
			data = (Vector<MyData>)in.readObject();
			in.close();
		}
		catch (IOException e) {
			return data;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static boolean writeData(File actualFile, Vector<MyData> data) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(actualFile)));
			out.writeObject(data);
			out.close();
			return true;
		}
		catch (IOException e) {
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkDate(Vector<MyData> data, MyData md) {
		int maxTime = 0;
		for(MyData a : data)
			if(maxTime < a.getDate())
				maxTime = a.getDate();
		if(md.getDate() > (maxTime + 3600))
			return true;
		return false;
	}
	
	private static String checkUpperCase(String city) {
		boolean b = false;
		if(!Character.isUpperCase(city.charAt(0))) {
			String temp = city;
			char c = Character.toUpperCase(city.charAt(0));
			city = c + temp.substring(1,temp.length());
		}
		
		for(int i = 1; i < city.length(); i++) {
			if(b) {
				if(!Character.isUpperCase(city.charAt(i))) {
					String temp = city;
					char c = Character.toUpperCase(city.charAt(i));
					city = temp.substring(0, i) + c + temp.substring(i+1,temp.length());
				}
				b = false;
			}
			if(city.charAt(i) == ' ')
				b = true;
		}
		return city;
	}
}
