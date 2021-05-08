package com.controle.contas.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.contas.api.entity.Conta;
import com.controle.contas.api.request.ContaInserirCreditoRequest;
import com.controle.contas.api.request.ContaRequest;
import com.controle.contas.api.response.ContaResponse;
import com.controle.contas.api.service.ContaService;
import com.controle.contas.api.utils.MapperConfiguration;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {
	MapperConfiguration _mapper;
	@Autowired
	ContaService _contaService;
	
	public ContaController() {
		_mapper = new MapperConfiguration();
	}
	
	@PostMapping
	public ContaResponse Criar(@RequestBody ContaRequest request) {
		var domain = _mapper.map(request, Conta.class);
		var result = _contaService.Criar(domain);
		return _mapper.map(result, ContaResponse.class);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<ContaResponse> Obter(@PathVariable("id") Integer id) {
		var optionalResult = _contaService.Obter(id);
		return optionalResult.map(conta -> MapearConta(conta));
	}

	private ContaResponse MapearConta(Conta conta) {
		return _mapper.map(conta, ContaResponse.class);
	}
	
	@PatchMapping(value = "/{id}/inserirCredito")
	public Optional<ContaResponse> InserirCredito(
			@PathVariable("id") Integer id, 
			@RequestBody ContaInserirCreditoRequest requestBody) {
		
		var optionalResult = _contaService.InserirCredito(id, requestBody.getValor());
		return optionalResult.map(conta -> _mapper.map(conta, ContaResponse.class));
	}
}
