package com.controle.contas.api.response;

import java.util.List;

public class PessoaResponse {
	private List<PessoaFisicaResponse> pessoasFisicas;
	private List<PessoaJuridicaResponse> pessoasJuridicas;
	
	public PessoaResponse() { }	

	public PessoaResponse(List<PessoaFisicaResponse> pessoasFisicas, List<PessoaJuridicaResponse> pessoasJuridicas) {
		this.pessoasFisicas = pessoasFisicas;
		this.pessoasJuridicas = pessoasJuridicas;
	}

	public List<PessoaFisicaResponse> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoaFisicaResponse> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public List<PessoaJuridicaResponse> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(List<PessoaJuridicaResponse> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}
	
	
}
