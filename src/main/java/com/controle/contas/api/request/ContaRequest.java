package com.controle.contas.api.request;

public class ContaRequest {
	private String nome;
	private Integer pessoaId;
	
	public ContaRequest() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	
}