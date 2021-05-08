package com.controle.contas.api.request;

import java.util.Date;

public class PessoaFisicaRequest {
	private String cpf;
	private String nomeCompleto;
	private Date dataNascimento;
	
	public PessoaFisicaRequest() { }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
