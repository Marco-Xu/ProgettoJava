package it.univpm.ProjectOOP.Exceptions;

/**Rappresenta un'eccezione personalizzata di tipo Exception.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class DateFormatException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DateFormatException() {
		super();
	}
	
	public DateFormatException(String msg) {
		super(msg);
	}

}
