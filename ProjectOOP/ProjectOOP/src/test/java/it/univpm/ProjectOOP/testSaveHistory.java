package it.univpm.ProjectOOP;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.SaveHistory;


@SpringBootTest
public class testSaveHistory {
	@Before
	static void setup() {
		
	}
	
	@Test
	void contextLoads() {
		//Assertions.assertThrows(CityNotFoundException.class, () -> {
		    SaveHistory.save("Rimini");
		  //});
		
	}
}
