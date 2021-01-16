package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.OpenWeather.ApiGet;

@SpringBootTest
public class testApiGet {
	@Test
	void contextLoads() {
		System.out.print(ApiGet.Read("Ancona"));
	}
}
