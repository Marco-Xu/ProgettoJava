package it.univpm.ProjectOOP.Exceptions;

/**Rappresenta un'eccezione personalizzata di tipo Exception.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
public class TemperatureTypeException extends Exception{

	private static final long serialVersionUID = 1L;

	public TemperatureTypeException() {
		super();
	}
	
	public TemperatureTypeException(String msg){
		super(msg);
	}
}
