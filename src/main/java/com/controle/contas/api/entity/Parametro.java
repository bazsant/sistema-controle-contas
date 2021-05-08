package com.controle.contas.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parametro {
	@Id
	private String chave;
	private String valor;
	private String descricao;
	
	public Parametro() { }
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
