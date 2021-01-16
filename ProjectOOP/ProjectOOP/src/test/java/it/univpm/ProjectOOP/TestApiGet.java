package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.History;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;

@SpringBootTest
public class TestApiGet {
	@Test
	void contextLoads() {
		CityNotFoundException exception = Assertions.assertThrows(CityNotFoundException.class, () -> {History.save("a");});
		Assertions.assertEquals("Città non trovata.", exception.getMessage());
	}
}
