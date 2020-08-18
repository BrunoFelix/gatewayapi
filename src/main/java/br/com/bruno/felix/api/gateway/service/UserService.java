package br.com.bruno.felix.api.gateway.service;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.felix.api.gateway.exception.RestException;
import br.com.bruno.felix.api.gateway.model.User;
import br.com.bruno.felix.api.gateway.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRep;
	
	public User create(String name) throws RestException {	
		String apiKey = new String(Base64.getEncoder().encodeToString(("apigateway" + name).getBytes()));
		User user = userRep.findById(apiKey).get();
		
		if (user != null && user.getApiKey().isEmpty()) {
			user.setName(name);
			user.setApiKey(apiKey);
			Date data = new Date(System.currentTimeMillis()); 
			user.setCreateAt(data);
			user = userRep.save(user);
		}
		
		return user;
	}
}
