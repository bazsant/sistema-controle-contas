package com.controle.contas.api.request;


public class ContaInserirCreditoRequest {
	private Float valor;
	private String sumario;

	public ContaInserirCreditoRequest() { }
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;		
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}	
	
}