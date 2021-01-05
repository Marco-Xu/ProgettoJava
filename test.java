
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

//api.openweathermap.org/data/2.5/weather?q=Rimini&appid=ffb7e697fda1e224fa8c50d16e4b3bca
public class test {
	public static void main(String[] args) {
		/*
		String url_void = "api.openweathermap.org/data/2.5/weather?q=";
		String city = "Rimini";
		String key = "ffb7e697fda1e224fa8c50d16e4b3bca";
		String url = url_void + city + "&appid=" + key;
		*/
		Scanner input = new Scanner(System.in);
		System.out.println("Seleziona la città:");
		
		//String url = "https://api.openweathermap.org/data/2.5/weather?q=Rimini&appid=ffb7e697fda1e224fa8c50d16e4b3bca";
		
		try {
			String city = input.nextLine();
			String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ffb7e697fda1e224fa8c50d16e4b3bca";
			
			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("GET");
			
			openConnection.setRequestProperty("appid","ffb7e697fda1e224fa8c50d16e4b3bca");
			openConnection.setRequestProperty("q",city);
			
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true);
			/*
			String jsonBody = "{\r\n" + 
					"    \"path\": \"/Photos/Sample Album/img001.jpg\",\r\n" + 
					"    \"include_media_info\": true,\r\n" + 
					"    \"include_deleted\": false,\r\n" + 
					"    \"include_has_explicit_shared_members\": false\r\n" + 
					"}";

			try (OutputStream os = openConnection.getOutputStream()) {
				byte[] input = jsonBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
			*/
			InputStream in = openConnection.getInputStream();
		
			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
					System.out.println(line);
				}
			} finally {
				in.close();
			}
			//JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			System.out.println("OK");
		//} catch (IOException | ParseException e) {
		//	e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore...");
		}
	}
}

