package br.com.bruno.felix.api.gateway.model;

public class DataCountry {

	private long total;
	private String titulo;
	private long novos;
	private double incidencias;
	private long recuperados;
	private long acompanhamento;
	private long percent;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public long getNovos() {
		return novos;
	}
	public void setNovos(long novos) {
		this.novos = novos;
	}
	public double getIncidencias() {
		return incidencias;
	}
	public void setIncidencias(double incidencias) {
		this.incidencias = incidencias;
	}
	public long getRecuperados() {
		return recuperados;
	}
	public void setRecuperados(long recuperados) {
		this.recuperados = recuperados;
	}
	public long getAcompanhamento() {
		return acompanhamento;
	}
	public void setAcompanhamento(long acompanhamento) {
		this.acompanhamento = acompanhamento;
	}
	public long getPercent() {
		return percent;
	}
	public void setPercent(long percent) {
		this.percent = percent;
	}
}
