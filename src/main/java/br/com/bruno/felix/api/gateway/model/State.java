package br.com.bruno.felix.api.gateway.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("_id")
	public String id;
	@JsonProperty("nome")
	public String name;
	@JsonProperty("casosAcumulado")
	public long accumulatedCases;
	@JsonProperty("obitosAcumulado")
	public long accumulatedDeaths;
	@JsonProperty("populacaoTCU2019")
	public String populationTCU2019;
	@JsonProperty("incidencia")
	public String incidence;
	@JsonProperty("incidenciaObito")
	public String incidenceDeath;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccumulatedCases() {
		return accumulatedCases;
	}
	public void setAccumulatedCases(long accumulatedCases) {
		this.accumulatedCases = accumulatedCases;
	}
	public long getAccumulatedDeaths() {
		return accumulatedDeaths;
	}
	public void setAccumulatedDeaths(long accumulatedDeaths) {
		this.accumulatedDeaths = accumulatedDeaths;
	}
	public String getPopulationTCU2019() {
		return populationTCU2019;
	}
	public void setPopulationTCU2019(String populationTCU2019) {
		this.populationTCU2019 = populationTCU2019;
	}
	public String getIncidence() {
		return incidence;
	}
	public void setIncidence(String incidence) {
		this.incidence = incidence;
	}
	public String getIncidenceDeath() {
		return incidenceDeath;
	}
	public void setIncidenceDeath(String incidenceDeath) {
		this.incidenceDeath = incidenceDeath;
	}
}
