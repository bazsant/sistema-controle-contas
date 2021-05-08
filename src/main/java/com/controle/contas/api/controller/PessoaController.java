package com.controle.contas.api.controller;

import java.util.List;

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
import com.controle.contas.api.request.PessoaRequest;
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
	public List<PessoaResponse> Listar()
	{
		var domain = _pessoaService.Listar();
		return _mapper.mapList(domain, PessoaResponse.class);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaResponse Incluir(@RequestBody PessoaRequest request) {
		var domain = _mapper.map(request, Pessoa.class);
		var result = _pessoaService.Incluir(domain);
		return _mapper.map(result, PessoaResponse.class);
	}
	
	@PutMapping(value = "/{id}")
	public PessoaResponse Editar(@RequestBody PessoaRequest request, @PathVariable("id") Integer id) {
		var domain = _mapper.map(request, Pessoa.class);
		var result = _pessoaService.Editar(id, domain);
		return _mapper.map(result, PessoaResponse.class);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void Excluir(@PathVariable("id") Integer id) {
		_pessoaService.Excluir(id);
	}
	
}
