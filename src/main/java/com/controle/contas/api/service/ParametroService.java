package com.controle.contas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.contas.api.entity.Parametro;
import com.controle.contas.api.repository.ParametroRepository;

@Service
public class ParametroService {
	@Autowired
	ParametroRepository _parametroRepository;
	
	public List<Parametro> Listar() {
		return _parametroRepository.findAll();
	}
}
