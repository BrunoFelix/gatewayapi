package br.com.bruno.felix.api.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.bruno.felix.api.gateway.service.DataService;
import br.com.bruno.felix.api.gateway.service.UserService;


@RestController
@RequestMapping(value="/api/data")
public class DataController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DataService dataService;
	
	@GetMapping(value = "/country")
	public ResponseEntity<String> getCountry (){
		final String uri = "https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalGeralApi";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}

