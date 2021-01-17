package it.univpm.ProjectOOP.Exceptions;

public class TemperatureTypeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TemperatureTypeException() {
		super();
	}
	
	public TemperatureTypeException(String msg){
		super(msg);
	}
}
