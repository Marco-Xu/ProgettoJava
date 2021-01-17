package it.univpm.ProjectOOP;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.History;
import it.univpm.ProjectOOP.Exceptions.CityNotFoundException;
import it.univpm.ProjectOOP.Type.MyData;

import java.io.File;
import java.util.Vector;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class TestHistory {
	
	@Test
	void testCheck() {
		CityNotFoundException exception = Assertions.assertThrows(CityNotFoundException.class, () -> {History.check("a");});
		Assertions.assertEquals("Città non trovata.", exception.getMessage());
	}
	
	@Test
	void testGetDir() {
		File file = new File("C:\\Users\\Davide\\Desktop\\ProgettoJava\\ProjectOOP\\ProjectOOP\\data\\Ancona.dat");
		Assertions.assertEquals(file, History.getDir("Ancona"));
	}
	
	@Test
	void testGetData() {
		File file = new File("C:\\hkbd");
		Vector<MyData> data = new Vector<MyData>();
	
		Assertions.assertEquals(History.getData(file), data);
	}
	
	@Test
	void testWriteData() {
		File file = new File("C:\\hkbd");
		Vector<MyData> data = new Vector<MyData>();
		
		Assertions.assertEquals(History.writeData(file, data), false);
	}
	
	@Test
	void testCheckUpperCase() {
		String word = "Maiuscolo";
		Assertions.assertEquals(History.checkUpperCase("maiuscolo"), word);
	}
	
	@Test
	void testDateConv() {
		String date = History.dateConv(1610903522);
		System.out.println(date);
	}
}
