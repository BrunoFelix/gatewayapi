package br.com.bruno.felix.api.gateway.exception;

public class RestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestException() {		
	} 
	
	public RestException (String message) {
		super(message);
	}
}
