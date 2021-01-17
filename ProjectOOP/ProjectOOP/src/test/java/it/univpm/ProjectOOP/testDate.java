package it.univpm.ProjectOOP;

import java.util.Vector;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Data.History;
import it.univpm.ProjectOOP.Type.MyData;

@SpringBootTest
public class testDate {
	@Test
	public void getDate() {
		Vector<MyData> data = History.getData(History.getDir("Ancona"));
		int dateNow = (int)(System.currentTimeMillis()/1000);
		for(MyData a : data) {
			System.out.println((dateNow - a.getDate())/(60*60));
		}
	}
}
