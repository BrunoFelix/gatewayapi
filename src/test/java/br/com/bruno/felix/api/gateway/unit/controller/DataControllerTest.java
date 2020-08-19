package br.com.bruno.felix.api.gateway.unit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.bruno.felix.api.gateway.controller.UserController;
import br.com.bruno.felix.api.gateway.model.Country;
import br.com.bruno.felix.api.gateway.model.Region;
import br.com.bruno.felix.api.gateway.model.State;
import br.com.bruno.felix.api.gateway.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private UserController userController;
	
	private User pms;
	private Country ct;
	private State st;
	private Region rg;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testConsultCountryNoApiKey() throws Exception {
		String url = "/api/data/country/";
		ResultActions response = this.mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON));
		response.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testConsultCountryWithApiKey() throws Exception {
		pms = new User(null, "Portal do Ministério da Saúde", null);
		
		Gson gson = new GsonBuilder().create();
		
		ResultActions response = this.mockMvc
				.perform(post("/api/user/create/").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(pms)));
		
		String url = "/api/data/country/";
		response = this.mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).param("apiKey", "YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU="));
		response.andExpect(status().isOk());
	}
	
}
