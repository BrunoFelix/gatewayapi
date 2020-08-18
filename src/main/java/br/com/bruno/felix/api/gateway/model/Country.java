package br.com.bruno.felix.api.gateway.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	@JsonProperty("confirmados")
	public countryConfirm confirmeds;
	@JsonProperty("obitos")
	public countryDeath deaths;
	@JsonProperty("dt_updated")
	public Date dtUpdated;
	
	public Country() {
		
	}
	
	public Country(countryConfirm confirmeds, countryDeath deaths, Date dtUpdated) {
		this.confirmeds = confirmeds;
		this.deaths = deaths;
		this.dtUpdated = dtUpdated;
	}
	
	public countryConfirm getConfirmeds() {
		return confirmeds;
	}
	public void setConfirmeds(countryConfirm confirmeds) {
		this.confirmeds = confirmeds;
	}
	public countryDeath getDeaths() {
		return deaths;
	}
	public void setDeaths(countryDeath deaths) {
		this.deaths = deaths;
	}
	public Date getDtUpdated() {
		return dtUpdated;
	}
	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
	}
	
	public class countryConfirm{
		
		@JsonProperty("total")
		public String total;
		@JsonProperty("titulo")
		public String title;
		@JsonProperty("novos")
		public long recents;
		@JsonProperty("incidencia")
		public String incidence;
		@JsonProperty("recuperados")
		public String cureds;
		@JsonProperty("acompanhamento")
		public String accompaniment;
		@JsonProperty("percent")
		public String percent;
		
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public long getRecents() {
			return recents;
		}
		public void setRecents(long recents) {
			this.recents = recents;
		}
		public String getIncidence() {
			return incidence;
		}
		public void setIncidence(String incidence) {
			this.incidence = incidence;
		}
		public String getCureds() {
			return cureds;
		}
		public void setCureds(String cureds) {
			this.cureds = cureds;
		}
		public String getAccompaniment() {
			return accompaniment;
		}
		public void setAccompaniment(String accompaniment) {
			this.accompaniment = accompaniment;
		}
		public String getPercent() {
			return percent;
		}
		public void setPercent(String percent) {
			this.percent = percent;
		}
	}
		
	public class countryDeath{
		
		@JsonProperty("total")
		public String total;
		@JsonProperty("titulo")
		public String title;
		@JsonProperty("novos")
		public long recents;
		@JsonProperty("incidencia")
		public String incidence;
		@JsonProperty("letalidade")
		public String lethality;
		@JsonProperty("mortalidade")
		public String mortality;
		@JsonProperty("percent")
		public String percent;
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public long getRecents() {
			return recents;
		}
		public void setRecents(long recents) {
			this.recents = recents;
		}
		public String getIncidence() {
			return incidence;
		}
		public void setIncidence(String incidence) {
			this.incidence = incidence;
		}
		public String getLethality() {
			return lethality;
		}
		public void setLethality(String lethality) {
			this.lethality = lethality;
		}
		public String getMortality() {
			return mortality;
		}
		public void setMortality(String mortality) {
			this.mortality = mortality;
		}
		public String getPercent() {
			return percent;
		}
		public void setPercent(String percent) {
			this.percent = percent;
		}
	}
	
	@Override
	public String toString() {
		return "Country [Confirmeds=" + this.confirmeds + ", deaths=" + this.deaths + ", dt_updated=" + this.dtUpdated + "]";
	}
}
