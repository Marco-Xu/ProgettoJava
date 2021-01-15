package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.OpenWeather.ApiGet;
import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.MyData;

@SpringBootTest
class ProjectOopApplicationTests {

	@Test
	void contextLoads() throws CityNotFoundException {
		ApiGet api = new ApiGet();
    	DataWeather dw = new DataWeather();
    	MyData a = new MyData();
    	//a = dw.Parse(api.Read("Ancona"), "Ancona");
    	System.out.println(a);
	}

}
