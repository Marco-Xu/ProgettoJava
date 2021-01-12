package it.univpm.ProjectOOP.Data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;


public class CheckHistory {
	@SuppressWarnings("unchecked")
	public static void check(String city) {
		String file = city + ".dat";
		File actualFile = new File ("/home/marco/ProgettoJava/ProjectOOP/ProjectOOP/data", file);
		boolean exists = actualFile.exists();
		Vector<MyData> data = new Vector<MyData>();
		
		if(exists)
			try {
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(actualFile)));
				data = (Vector<MyData>)in.readObject();
				in.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		else {
			System.out.println("File not found");
		}
		if(!data.isEmpty())
			for(MyData a : data)
				System.out.println(a);
	}
}
