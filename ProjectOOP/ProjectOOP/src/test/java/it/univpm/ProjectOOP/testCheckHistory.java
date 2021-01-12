package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import it.univpm.ProjectOOP.Data.CheckHistory;

@SpringBootTest
public class testCheckHistory {
	@Test
	void contextLoads() {
		CheckHistory.check("Rimini");
	}
}
