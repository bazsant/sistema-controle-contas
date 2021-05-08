package com.controle.contas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.contas.api.response.ParametroResponse;
import com.controle.contas.api.service.ParametroService;
import com.controle.contas.api.utils.MapperConfiguration;

@RestController
@RequestMapping(value = "/parametros")
public class ParametroController {
	
	@Autowired
	ParametroService _parametroService;
	MapperConfiguration _mapper;
	
	public ParametroController() {
		_mapper = new MapperConfiguration();
	}
	
	@GetMapping
	public List<ParametroResponse> Listar() {
		var result = _parametroService.Listar();
		return _mapper.mapList(result, ParametroResponse.class);
	}
}
