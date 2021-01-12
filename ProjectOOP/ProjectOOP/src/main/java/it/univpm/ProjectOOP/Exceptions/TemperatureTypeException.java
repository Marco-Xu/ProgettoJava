package it.univpm.ProjectOOP.Exceptions;

public class TemperatureTypeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public TemperatureTypeException() {
		super();
	}
	
	public TemperatureTypeException(String msg){
		super(msg);
	}
}
