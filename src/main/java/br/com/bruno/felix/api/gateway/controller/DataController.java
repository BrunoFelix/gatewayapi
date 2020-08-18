package br.com.bruno.felix.api.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.felix.api.gateway.exception.RestException;
import br.com.bruno.felix.api.gateway.model.Country;
import br.com.bruno.felix.api.gateway.model.Region;
import br.com.bruno.felix.api.gateway.model.State;
import br.com.bruno.felix.api.gateway.service.DataService;


@RestController
@RequestMapping(value="/api/data")
public class DataController {

	@Autowired
	private DataService dataService;
	
	@GetMapping(value = "/country")
	public ResponseEntity<Country> getCountry (@RequestParam(value = "api_key", required = true) String apiKey) throws RestException{
		Country country = dataService.getCountry(apiKey);
		return ResponseEntity.status(HttpStatus.OK).body(country);
	}
	
	@GetMapping(value = "/state")
	public ResponseEntity<List<State>> getState (@RequestParam(value = "api_key", required = true) String apiKey, @RequestParam(value = "id_state", required = false) String idState) throws RestException{
		List<State> states= dataService.getState(apiKey, idState);
		return ResponseEntity.status(HttpStatus.OK).body(states);
	}	
	
	@GetMapping(value = "/region")
	public ResponseEntity<List<Region>> getRegion (@RequestParam(value = "api_key", required = true) String apiKey, @RequestParam(value = "id_region", required = false) String idRegion) throws RestException{
		List<Region> regions = dataService.getRegion(apiKey, idRegion);
		return ResponseEntity.status(HttpStatus.OK).body(regions);
	}	
}

