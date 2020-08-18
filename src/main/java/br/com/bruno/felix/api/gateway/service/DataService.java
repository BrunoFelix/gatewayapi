package br.com.bruno.felix.api.gateway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bruno.felix.api.gateway.exception.RestException;
import br.com.bruno.felix.api.gateway.model.Country;
import br.com.bruno.felix.api.gateway.model.Region;
import br.com.bruno.felix.api.gateway.model.State;
import br.com.bruno.felix.api.gateway.repository.UserRepository;

@Service
public class DataService {

	private final String uri = "https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/";
	
	@Autowired
	private UserRepository userRep;
	
	public Country getCountry(String apiKey) throws RestException{
		validateUser(apiKey);

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri + "PortalGeralApi", Country.class);
	}
	
	public List<State> getState(String apiKey, String idState) throws RestException{
		validateUser(apiKey);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<State[]> responseEntity = restTemplate.getForEntity(uri + "PortalEstado", State[].class);
		List<State> states = new ArrayList<State>(Arrays.asList(responseEntity.getBody()));
		
		if (idState != null && !idState.isEmpty()) {
			for (int i = states.size()-1; i >= 0; i--) {
				if (!states.get(i).getId().toUpperCase().equals(idState.toUpperCase())) {
					states.remove(i);
				}
			}
		}
		
		if (states.isEmpty() && (idState != null && !idState.isEmpty())) throw new RestException ("ID State not found!");
		
		return states;
	}
	
	public List<Region> getRegion(String apiKey, String idRegion) throws RestException{
		validateUser(apiKey);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Region[]> responseEntity = restTemplate.getForEntity(uri + "PortalEstadoRegiao", Region[].class);
		List<Region> regions = new ArrayList<Region>(Arrays.asList(responseEntity.getBody()));
		
		if (idRegion != null && !idRegion.isEmpty()) {
			for (int i = regions.size()-1; i >= 0; i--) {
				if (!regions.get(i).getId().toUpperCase().equals(idRegion.toUpperCase())) {
					regions.remove(i);
				}
			}
		}
		
		if (regions.isEmpty() && (idRegion != null && !idRegion.isEmpty())) throw new RestException ("ID Region not found!");
		
		return regions;
	}
	
	
	public void validateUser(String apiKey) throws RestException{
		userRep.findById(apiKey).orElseThrow(() -> new RestException("Api Key user not found!"));
	}
}
