package it.univpm.ProjectOOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.univpm.ProjectOOP.Exceptions.DateFormatException;
import it.univpm.ProjectOOP.Stats.FilterUtils;
import it.univpm.ProjectOOP.Type.PeriodFilter;

public class TestFilterUtils {

	@Test
	void test1() throws DateFormatException {
		
		FilterUtils fu = new FilterUtils("{\"startDate\" : \"12-01-2020\", \"endDate\" : \"16-01-2021\"}");
		PeriodFilter pf = new PeriodFilter(1578783600, 1610751600);
		Assertions.assertEquals(pf.getEnd(), fu.getPeriod().getEnd());
		Assertions.assertEquals(pf.getStart(), fu.getPeriod().getStart());	
	}
	
	@Test
	void test2() throws DateFormatException {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("{\"test\" : \"12-01-2020\", \"endDate\" : \"16-01-2021\"}");
			});
		
		Assertions.assertEquals("Formato della data errata", exception.getMessage());
	}
	
	@Test
	void test3() throws DateFormatException {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("test");
			});
		
		Assertions.assertEquals("Formato della data errata", exception.getMessage());
	}
	
	@Test
	void test4() {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("{\"startDate\" : \"12-1-2020\", \"endDate\" : \"16-01-2021\"}");
			});
		
		Assertions.assertEquals("Formato data sbagliato -> (dd-MM-yyyy)", exception.getMessage());
	}
	
	@Test
	void test5() {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("{\"startDate\" : \"35-01-2020\", \"endDate\" : \"16-01-2021\"}");
			});

		Assertions.assertEquals("Giorno inesistente", exception.getMessage());
	}
	
	@Test
	void test6() {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("{\"startDate\" : \"12-61-2020\", \"endDate\" : \"16-01-2021\"}");
			});

		Assertions.assertEquals("Mese inesistente", exception.getMessage());
	}
	
	@Test
	void test7() {
		DateFormatException exception = Assertions.assertThrows(DateFormatException.class, () -> {
			new FilterUtils("{\"startDate\" : \"12-01-2020\", \"endDate\" : \"16-01-0012\"}");
			});

		Assertions.assertEquals("Anno troppo piccolo", exception.getMessage());
	}
}
