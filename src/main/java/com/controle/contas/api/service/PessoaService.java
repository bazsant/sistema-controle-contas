package com.controle.contas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.contas.api.entity.Pessoa;
import com.controle.contas.api.enums.TipoPessoa;
import com.controle.contas.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository _pessoaRepository;

	public List<Pessoa> Listar() {
		return _pessoaRepository.findAll();
	}
	
	public List<Pessoa> ListarPessoasFisicas() {
		return _pessoaRepository.findByTipoPessoa(TipoPessoa.Fisica);
	}
	
	public List<Pessoa> ListarPessoasJuridicas() {
		return _pessoaRepository.findByTipoPessoa(TipoPessoa.Juridica);
	}
	
	public Pessoa IncluirPessoaFisica(Pessoa pessoa) {
		pessoa.setTipoPessoa(TipoPessoa.Fisica);
		return _pessoaRepository.save(pessoa);
	}
	
	public Pessoa IncluirPessoaJuridica(Pessoa pessoa) {
		pessoa.setTipoPessoa(TipoPessoa.Juridica);
		return _pessoaRepository.save(pessoa);
	}
	
	public Pessoa Editar(Integer id, Pessoa pessoa) {
		pessoa.setId(id);
		return _pessoaRepository.save(pessoa);
	}

	public void Excluir(Integer id) {
		_pessoaRepository.deleteById(id);
	}


}
