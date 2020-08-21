package br.com.bruno.felix.api.gateway.unit.service;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import br.com.bruno.felix.api.gateway.model.User;
import br.com.bruno.felix.api.gateway.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private UserRepository userRepository;
	
	private User user;
		
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testInsert() throws Exception {
		this.user = new User("YXBpZ2F0ZXdheVBvcnRhbCBkbyBNaW5pc3TDqXJpbyBkYSBTYcO6ZGU=", "Portal do Ministério da Saúde", new Date(System.currentTimeMillis()));
		
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(this.user);
		userRepository.save(this.user);
		verify(userRepository).save(this.user);
	}
	

}
