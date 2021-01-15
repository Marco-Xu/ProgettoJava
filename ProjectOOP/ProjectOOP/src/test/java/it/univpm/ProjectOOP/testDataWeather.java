package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;

@SpringBootTest
public class testDataWeather {
	@Test
	void contextLoads() {
		try {
			System.out.println(DataWeather.parse("Ancona"));
		} catch (CityNotFoundException e) {
			e.printStackTrace();
		}
	}
}
