package it.univpm.ProjectOOP.Data;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

/**Rappresenta la classe per il salvataggio automatico dei dati.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
@Configuration
@EnableScheduling
public class SaveAll {
	
	/**
	 * Metodo per il salvataggio automatico dei dati.
	 * @throws CityNotFoundException se la citta&#768; inserita e&#768; errata
	 */
	@Scheduled(fixedRate = 60000)
	public static void saveAll() throws CityNotFoundException {
		History.save("Rimini");
		History.save("Ancona");
		History.save("San Marino");
	}
}
