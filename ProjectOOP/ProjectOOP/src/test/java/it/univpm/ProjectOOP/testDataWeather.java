package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.DataWeather;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

@SpringBootTest
public class testDataWeather {
	@Test
	void contextLoads() {
		try {
			DataWeather.parse("Ancona");
		} catch (CityNotFoundException e) {
			e.printStackTrace();
		}
	}
}
