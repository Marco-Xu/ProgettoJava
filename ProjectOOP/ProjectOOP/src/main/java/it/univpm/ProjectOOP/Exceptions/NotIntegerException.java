package it.univpm.ProjectOOP.Exceptions;

/**Rappresenta un'eccezione personalizzata di tipo Exception.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class NotIntegerException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotIntegerException() {
		super();
	}
	
	public NotIntegerException(String msg) {
		super(msg);
	}

}
