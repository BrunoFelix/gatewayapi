package br.com.bruno.felix.api.gateway.unit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.bruno.felix.api.gateway.controller.UserController;
import br.com.bruno.felix.api.gateway.model.User;
import br.com.bruno.felix.api.gateway.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private UserService userService;
	
	private User user;
	private User _user;

		
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testInsert() throws Exception {
		this.user = new User(null, "Portal do Ministério da Saúde", null);
		this._user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this._user);
		mockMvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.apiKey").value(this._user.getApiKey()))
			.andExpect(jsonPath("$.name").value(this._user.getName()));
	}
	
	@Test
	public void testInsertServiceNotFound() throws Exception {	
		this.user = new User(null, "Portal do Ministério da Saúde", null);
		this._user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this._user);
		mockMvc.perform(post("/api/user/test")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	
	
}
