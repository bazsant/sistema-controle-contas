package com.controle.contas.api.request;

import io.swagger.annotations.ApiModel;

@ApiModel
public class PessoaJuridicaRequest {
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}	
	
}
