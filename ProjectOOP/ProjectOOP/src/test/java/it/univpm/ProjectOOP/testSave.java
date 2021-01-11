package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.DataWeather;
import it.univpm.ProjectOOP.Data.MyData;
import it.univpm.ProjectOOP.Data.saveHistory;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.ApiGet;

@SpringBootTest
public class testSave {
	@Test
	void contextLoads() throws CityNotFoundException {
		saveHistory sv = new saveHistory();
		sv.save("Ancona");
	}
}
