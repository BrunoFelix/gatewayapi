package br.com.bruno.felix.api.gateway.model.response;

import org.springframework.http.HttpStatus;

public class ErrorObject {

	/**
	 * Status HTTP response
	 */
	private HttpStatus httpStatus;
	
	/**
	 * message
	 */
	private String message;
	
	/**
	 * origin
	 */
	private String path;
	
	public ErrorObject () {
		
	}
	
	public ErrorObject(HttpStatus httpStatus, String message, String path) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.path = path;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
