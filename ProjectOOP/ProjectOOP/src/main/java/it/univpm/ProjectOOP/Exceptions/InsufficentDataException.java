package it.univpm.ProjectOOP.Exceptions;

public class InsufficentDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	InsufficentDataException() {
		super();
	}
	
	InsufficentDataException(String msg){
		super(msg);
	}
}
