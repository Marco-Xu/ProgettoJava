package it.univpm.ProjectOOP.Exceptions;

public class CityNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CityNotFoundException() {
		super();
	}
	
	CityNotFoundException(String msg) {
		super(msg);
	}
}
