package br.com.bruno.felix.api.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.felix.api.gateway.exception.RestException;
import br.com.bruno.felix.api.gateway.model.User;
import br.com.bruno.felix.api.gateway.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> create (@RequestBody String name) throws RestException{
		User user = userService.create(name);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}