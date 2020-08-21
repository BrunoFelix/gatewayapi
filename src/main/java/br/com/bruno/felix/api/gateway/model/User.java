package br.com.bruno.felix.api.gateway.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@Column(name="api_key", nullable = false, unique = true)
	private String apiKey;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "create_at")
	private Date createAt;
	
	public User() {
		
	}
	
	public User(String apiKey, String name, Date createAt) {
		this.apiKey = apiKey;
		this.name = name;
		this.createAt = createAt;
	}

	/**
	 * Getters and Setters
	 */
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
