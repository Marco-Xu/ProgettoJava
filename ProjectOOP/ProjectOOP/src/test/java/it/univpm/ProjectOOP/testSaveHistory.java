package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.SaveHistory;


@SpringBootTest
public class testSaveHistory {	
	@Test
	void contextLoads() {
		SaveHistory.save("Rimini");
		SaveHistory.save("Ancona");
		SaveHistory.save("San Marino");
	}
}
