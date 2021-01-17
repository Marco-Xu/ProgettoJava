package it.univpm.ProjectOOP.Exceptions;

/**Rappresenta un'eccezione personalizzata di tipo Exception.
 * 
 * @author Davide Balducci
 * @author Marco Xu
 */
public class CityNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CityNotFoundException() {
		super();
	}
	
	public CityNotFoundException(String msg) {
		super(msg);
	}
}
