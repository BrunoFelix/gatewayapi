package br.com.bruno.felix.api.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
	
	@JsonProperty("_id")
	public String id;
	@JsonProperty("interior")
	public RegionInland regionInland;
	@JsonProperty("metropolitana")
	public RegionMetropole regionMetropole;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RegionInland getRegionInland() {
		return regionInland;
	}

	public void setRegionInland(RegionInland regionInland) {
		this.regionInland = regionInland;
	}

	public RegionMetropole getRegionMetropole() {
		return regionMetropole;
	}

	public void setRegionMetropole(RegionMetropole regionMetropole) {
		this.regionMetropole = regionMetropole;
	}
	
	public class RegionInland{
		
		@JsonProperty("_id")
		public String id;
		@JsonProperty("casosAcumulado")
		public long accumulatedCases;
		@JsonProperty("obitosAcumulado")
		public long accumulatedDeaths;
		@JsonProperty("interior")
		public long inland;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
		public long getInland() {
			return inland;
		}
		public void setInland(long inland) {
			this.inland = inland;
		}
	}
	
	public class RegionMetropole{
		
		@JsonProperty("_id")
		public String id;
		@JsonProperty("casosAcumulado")
		public long accumulatedCases;
		@JsonProperty("obitosAcumulado")
		public long accumulatedDeaths;
		@JsonProperty("metropolitana")
		public long metropole;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
		public long getMetropole() {
			return metropole;
		}
		public void setMetropole(long metropole) {
			this.metropole = metropole;
		}
	}
}
