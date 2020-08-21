package br.com.bruno.felix.api.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.bruno.felix.api.gateway.model.response.ErrorObject;

/**
 * Responsible class handle the return of thrown exceptions
 * @author Bruno
 *
 */

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { RestException.class })
	public ResponseEntity<ErrorObject> handleObjecNotFound(RestException ex, WebRequest request) {
		String requestURI = ((ServletWebRequest)request).getRequest().getRequestURI();
		ErrorObject response = new ErrorObject(HttpStatus.NOT_FOUND, ex.getMessage(), requestURI);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
