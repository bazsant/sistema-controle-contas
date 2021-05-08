package com.controle.contas.api.controller;

import org.modelmapper.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controle.contas.api.entity.Pessoa;
import com.controle.contas.api.request.PessoaFisicaRequest;
import com.controle.contas.api.request.PessoaJuridicaRequest;
import com.controle.contas.api.response.PessoaFisicaResponse;
import com.controle.contas.api.response.PessoaJuridicaResponse;
import com.controle.contas.api.response.PessoaResponse;
import com.controle.contas.api.service.PessoaService;
import com.controle.contas.api.utils.MapperConfiguration;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	MapperConfiguration _mapper;
	
	public PessoaController() {
		_mapper = new MapperConfiguration();
	}
	
	@Autowired
	private PessoaService _pessoaService;
	
	@GetMapping
	public PessoaResponse Listar()
	{
		var pessoasFisicas = _pessoaService.ListarPessoasFisicas();
		var pessoasJuridicas = _pessoaService.ListarPessoasJuridicas();
		
		var response = new PessoaResponse(
				_mapper.mapList(pessoasFisicas, PessoaFisicaResponse.class),
				_mapper.mapList(pessoasJuridicas, PessoaJuridicaResponse.class));
		
		return response;
	}
	
	@PostMapping(value = "/pessoaFisica")
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaFisicaResponse IncluirPessoaFisica(@RequestBody PessoaFisicaRequest request) {
		var domain = _mapper.map(request, Pessoa.class);
		var result = _pessoaService.IncluirPessoaFisica(domain);
		return _mapper.map(result, PessoaFisicaResponse.class);
	}
	
	@PostMapping(value = "/pessoaJuridica")
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaJuridicaResponse IncluirPessoaJuridica(@RequestBody PessoaJuridicaRequest request) {
		var domain = _mapper.map(request, Pessoa.class);
		var result = _pessoaService.IncluirPessoaJuridica(domain);
		return _mapper.map(result, PessoaJuridicaResponse.class);
	}
	
	@PutMapping(value = "/{id}")
	public PessoaJuridicaResponse Editar(@RequestBody PessoaJuridicaRequest request, @PathVariable("id") Integer id) {
		var domain = _mapper.map(request, Pessoa.class);
		var result = _pessoaService.Editar(id, domain);
		return _mapper.map(result, PessoaJuridicaResponse.class);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void Excluir(@PathVariable("id") Integer id) {
		_pessoaService.Excluir(id);
	}
	
}
