package it.univpm.ProjectOOP.Data;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

@Configuration
@EnableScheduling
public class SaveAll {
	@Scheduled(fixedRate = 1000)
	public static void saveAll() throws CityNotFoundException {
		History.save("Rimini");
		History.save("Ancona");
		History.save("San Marino");
	}
}
