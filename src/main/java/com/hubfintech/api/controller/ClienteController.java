package com.hubfintech.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.hubfintech.api.model.Cliente;
import com.hubfintech.api.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository _clienteRepository;
	
	@GetMapping
	public List<Cliente> Listar()
	{
		return _clienteRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Cliente> Obter(@PathVariable Integer id) {
		return _clienteRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente Incluir(@RequestBody Cliente model) {
		return _clienteRepository.save(model);
	}
	
	
	@PutMapping(path = "/{id}")
	public Cliente Editar(@RequestBody Cliente model, @PathVariable Integer id) {
		model.setId(id);
		return _clienteRepository.save(model);
	}
	
	@DeleteMapping(path = "/{id}")
	public void Excluir(@PathVariable Integer id) {
		_clienteRepository.deleteById(id);
	}
}
