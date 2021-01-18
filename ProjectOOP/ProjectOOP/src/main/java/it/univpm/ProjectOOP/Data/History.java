package it.univpm.ProjectOOP.Data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Vector;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.MyData;

/**Classe utilizzata per il salvataggio e la scrittura dei dati.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class History {
	private static int time = 0;
	
	
	/**
	 * Metodo che salva i dati meteo della città inserita.
	 * @param city rappresenta la città di cui salvare i dati
	 * @return true se salva i dati nel file, false se non è ancora passata un'ora dall'ultimo salvataggio
	 * @throws CityNotFoundException se la città passata come parametro è errata
	 */
	public static boolean save(String city) throws CityNotFoundException {
		Vector<MyData> data = new Vector<MyData>();
		MyData md = new MyData();
		File actualFile = getDir(city);

		md = (DataWeather.parse(city));
		
		data = getData(actualFile);
		if(checkDate(data, md)) {
			data.add(md);
			if(writeData(actualFile, data))
				return true;
			return false;	
		}
		return false;
	}
	
	
	/**
	 * Metodo che controlla la presenza dei dati della città inserita.
	 * @param city rappresenta la città da controllare
	 * @return un vettore di oggetti MyData con i dati salvati fino a quel momento
	 * @throws CityNotFoundException se la città passata come parametro è errata
	 */
	public static Vector<MyData> check(String city) throws CityNotFoundException {
		File actualFile = getDir(city);
		Vector<MyData> data = getData(actualFile);
		if(data.isEmpty())
			throw new CityNotFoundException("Città non trovata.");
		
		return data;
	}
	
	
	/**
	 * Metodo che restituisce il percorso del file per la citta indicata.
	 * @param city ci serve per ottenere il nome del file
	 * @return il percorso del file con il nome della città
	 */
	public static File getDir(String city) {
		city = checkUpperCase(city);
		String file = city + ".dat";
		String dir = (System.getProperty("user.dir"));
		dir += "/data";
		File actualFile = new File (dir, file);
		return actualFile;
	}
	
	
	/**
	 * Metodo che restituisce i dati meteo presenti nel file passato come parametro.
	 * @param actualFile file creato precedentemente
	 * @return un vettore di oggetti MyData, se vengono generate eccezioni viene ritornato un vettore vuoto
	 */
	@SuppressWarnings("unchecked")
	public static Vector<MyData> getData(File actualFile){
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
	
	
	/**
	 * Metodo per aggiungere dati meteo all'interno di un file.
	 * @param actualFile file da modificare
	 * @param data vettore di oggetti MyData da aggiungere
	 * @return true se il file inserito esiste ed avviene la scrittura, false se vengono generate eccezioni in seguito ad un errore di Input/Output del file
	 */
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
	
	
	/**
	 * Metodo che controlla il tempo rimanente per il prossimo salvataggio.
	 * @param data vettore di oggetti MyData
	 * @param md oggetto di MyData
	 * @return true se è passata più di un'ora dall'ultimo salvataggio, false se non è ancora passata un'ora dall'ultimo salvataggio
	 */
	public static boolean checkDate(Vector<MyData> data, MyData md) {
		int maxTime = 0;
		for(MyData a : data)
			if(maxTime < a.getDate())
				maxTime = a.getDate();
		if(md.getDate() > (maxTime + 3600))
			return true;
		time = 60 - ((int)(System.currentTimeMillis()/1000) - maxTime) / 60;
		return false;
	}
	
	
	/**
	 * Metodo che imposta la lettera maiuscola a tutte le città passategli come parametro.
	 * @param city rappresenta città da modificare
	 * @return la stringa city con l'iniziale maiuscola
	 */
	public static String checkUpperCase(String city) {
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
	
	
	/**
	 * Metodo per ottenere il tempo rimanente per la scrittura.
	 * @return ritorna il tempo rimanente per la prossima scrittura
	 */
	public static int getTime() {
		return time;
	}
	
	
	/**
	 * Metodo per convertire una data in formato string "dd-MM-yyyy"
	 * @param data int da convertire
	 * @return la stringa della data
	 */
	public static String dateConv(int date) {
		Date mills = new Date(date*1000L); 
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		String formattedDate = simpleDateFormat.format(mills);
		return formattedDate;
	}
}
