package br.com.bruno.felix.api.gateway.exception;

public class RestException extends Exception{

	public RestException() {		
	} 
	
	public RestException (String message) {
		super(message);
	}
}
