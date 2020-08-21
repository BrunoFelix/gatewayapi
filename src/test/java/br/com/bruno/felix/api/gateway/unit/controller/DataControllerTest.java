package br.com.bruno.felix.api.gateway.unit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bruno.felix.api.gateway.controller.DataController;
import br.com.bruno.felix.api.gateway.controller.UserController;
import br.com.bruno.felix.api.gateway.model.Country;
import br.com.bruno.felix.api.gateway.model.Region;
import br.com.bruno.felix.api.gateway.model.State;
import br.com.bruno.felix.api.gateway.model.User;
import br.com.bruno.felix.api.gateway.service.DataService;
import br.com.bruno.felix.api.gateway.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private UserService userService;
	
	@MockBean
	private DataService dataService;
	
	@MockBean
	private DataController dc;
	
	@Value("classpath:country.json")
	private Resource countryJSON;
	@Value("classpath:state.json")
	private Resource stateJSON;
	@Value("classpath:region.json")
	private Resource regionJSON;

	private User user;
	private User _user;
	private ResponseEntity<User> reu;
	private Country country;
	private State state;
	private List<State> states;
	private Region region;
	private List<Region> regions;
		
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testConsultCountryNoApiKey() throws Exception {
		this.country = new ObjectMapper().readValue(countryJSON.getInputStream(), Country.class);
		
		Mockito.when(dataService.getCountry(Mockito.any(String.class))).thenReturn(this.country);
		mockMvc.perform(get("/api/data/country")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testConsultCountryWithApiKeyWrong() throws Exception {
		this.country = new ObjectMapper().readValue(countryJSON.getInputStream(), Country.class);
		
		Mockito.when(dataService.getCountry(Mockito.any(String.class))).thenReturn(this.country);
		mockMvc.perform(get("/api/data/country")
				.param("apiKey", "123")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testConsultCountryWithApiKeyCorrect() throws Exception {
		this.user = new User(null, "Portal do Ministério da Saúde", null);
		this._user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this._user);
		mockMvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		
		this.country = new ObjectMapper().readValue(countryJSON.getInputStream(), Country.class);
		
		Mockito.when(dataService.getCountry(Mockito.any(String.class))).thenReturn(this.country);
		mockMvc.perform(get("/api/data/country")
				.param("apiKey", this._user.getApiKey())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testConsultStateNoApiKey() throws Exception {	
		this.state = new ObjectMapper().readValue(stateJSON.getInputStream(), State.class);
		
		Mockito.when(dataService.getState(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.state));
		mockMvc.perform(get("/api/data/state")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
		
	}
	
	@Test
	public void testConsultStateWithApiKeyWrong() throws Exception {
		this.state = new ObjectMapper().readValue(stateJSON.getInputStream(), State.class);
		
		Mockito.when(dataService.getState(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.state));
		mockMvc.perform(get("/api/data/state")
		    .param("apiKey", "123")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void testConsultStateWithApiKey() throws Exception {
		this.user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this.user);
		mockMvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		
		this.state = new ObjectMapper().readValue(stateJSON.getInputStream(), State.class);
		
		Mockito.when(dataService.getState(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.state));
		mockMvc.perform(get("/api/data/state")
		    .param("apiKey", this.user.getApiKey())
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void testConsultStateWithApiKeyAndIdState() throws Exception {
		this.user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this.user);
		mockMvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		
		this.state = new ObjectMapper().readValue(stateJSON.getInputStream(), State.class);
		
		Mockito.when(dataService.getState(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.state));
		mockMvc.perform(get("/api/data/state")
		    .param("apiKey", this.user.getApiKey())
		    .param("idState", "PE")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void testConsultRegionNoApiKey() throws Exception {	
		this.region = new ObjectMapper().readValue(regionJSON.getInputStream(), Region.class);
		
		Mockito.when(dataService.getRegion(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.region));
		mockMvc.perform(get("/api/data/region")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
		
	}
	
	@Test
	public void testConsulRegionWithApiKeyWrong() throws Exception {
		this.region = new ObjectMapper().readValue(regionJSON.getInputStream(), Region.class);
		
		Mockito.when(dataService.getRegion(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.region));
		mockMvc.perform(get("/api/data/region")
		    .param("apiKey", "123")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void testConsultRegionWithApiKey() throws Exception {
		this.user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userService.create(Mockito.any(String.class))).thenReturn(this.user);
		mockMvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new JSONObject(this.user).toString())
			.characterEncoding("UTF-8")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		
		this.region = new ObjectMapper().readValue(regionJSON.getInputStream(), Region.class);
		
		Mockito.when(dataService.getRegion(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(Arrays.asList(this.region));
		mockMvc.perform(get("/api/data/region")
		    .param("apiKey", this.user.getApiKey())
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
	}
}
