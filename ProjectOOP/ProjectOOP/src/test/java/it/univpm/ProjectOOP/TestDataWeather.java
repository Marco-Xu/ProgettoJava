package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.OpenWeather.DataWeather;
import it.univpm.ProjectOOP.Type.MyData;

@SpringBootTest
class TestDataWeather{

	@Test
	void contextLoads() {
    	MyData a = DataWeather.parse("Ancona");
    	System.out.println(a);
	}

}
