package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.DataWeather;
import it.univpm.ProjectOOP.Data.MyData;
import it.univpm.ProjectOOP.OpenWeather.ApiGet;

@SpringBootTest
class ProjectOopApplicationTests {

	@Test
	void contextLoads() {
		ApiGet api = new ApiGet();
    	DataWeather dw = new DataWeather();
    	MyData a = new MyData();
    	a = dw.Parse(api.Read("Ancona"), "Ancona");
    	System.out.println(a);
	}

}
