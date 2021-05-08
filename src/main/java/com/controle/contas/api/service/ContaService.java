package com.controle.contas.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.contas.api.entity.Conta;
import com.controle.contas.api.entity.Parametro;
import com.controle.contas.api.enums.ChaveParametro;
import com.controle.contas.api.enums.TipoPessoa;
import com.controle.contas.api.repository.ContaRepository;
import com.controle.contas.api.repository.ParametroRepository;
import com.controle.contas.api.repository.PessoaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository _contaRepository;
	@Autowired
	PessoaRepository _pessoaRepository;
	@Autowired
	ParametroRepository _parametroRepository;
	
	public Conta Criar(Conta conta) {
		conta.setSaldo(0F);
		return _contaRepository.save(conta);
	}
	
	public Optional<Conta> Obter(Integer id) {
		return _contaRepository.findById(id);
	}
	
	public Optional<Conta> InserirCredito(Integer id, Float valor) {
		var conta = _contaRepository.findById(id);
		return conta.map(c -> AdicionarSaldo(c, valor));		
	}

	private Conta AdicionarSaldo(Conta conta, Float valor) {
		ValidarSeAdicionaSaldo(conta.getId(), valor);
		conta.addSaldo(valor);
		return _contaRepository.save(conta);
	}

	private boolean ValidarSeAdicionaSaldo(Integer id, Float valor) {
		return ValidarValorNaoNegativo(valor)
				&& ValidarValorPorTipoPessoa(id, valor);
	}

	private boolean ValidarValorNaoNegativo(Float valor) {
		return valor > 0F;
	}
	
	private boolean ValidarValorPorTipoPessoa(Integer contaId, Float valor) {
		var tipoPessoa = ObterTipoPessoa(contaId);
		return ValidarPessoaFisica(tipoPessoa, valor)
				|| ValidarPessoaJuridica(tipoPessoa, valor);
	}

	private boolean ValidarPessoaJuridica(TipoPessoa tipoPessoa, Float valor) {
		return EhPessoaJuridica(tipoPessoa)
				&& ValidarLimitePessoaJuridica(valor);
	}
	
	private boolean EhPessoaJuridica(TipoPessoa tipoPessoa) {
		return tipoPessoa == TipoPessoa.Juridica;
	}

	private boolean ValidarLimitePessoaJuridica(Float valor) {
		var limitePessoaJuridica = ObterLimiteTransacaoPessoaJuridica();
		return valor < limitePessoaJuridica;
	}

	private Float ObterLimiteTransacaoPessoaJuridica() {
		var parametroLimiteTransacaoPessoaJuridica = 
				_parametroRepository.findById(ChaveParametro.LimiteTransacaoPessoaJuridica.toString());
				
		return ConverterValorParametroLimiteTransacao(parametroLimiteTransacaoPessoaJuridica);
	}

	private Float ConverterValorParametroLimiteTransacao(Optional<Parametro> valorParametroLimiteTransacao) {
		return valorParametroLimiteTransacao				
				.map(parametro -> Float.parseFloat(parametro.getValor()))
				.orElse(Float.MAX_VALUE);
	}

	private boolean ValidarPessoaFisica(TipoPessoa tipoPessoa, Float valor) {		
		return EhPessoaFisica(tipoPessoa)
				&& ValidarLimitePessoaFisica(valor);
	}

	private boolean ValidarLimitePessoaFisica(Float valor) {
		var limitePessoaFisica = ObterLimiteTransacaoPessoaFisica();
		return valor < limitePessoaFisica;
	}

	private Float ObterLimiteTransacaoPessoaFisica() {
		var parametroLimiteTransacaoPessoaFisica = 
				_parametroRepository.findById(ChaveParametro.LimiteTransacaoPessoaFisica.toString());
		
		return ConverterValorParametroLimiteTransacao(parametroLimiteTransacaoPessoaFisica);
	}

	private boolean EhPessoaFisica(TipoPessoa tipoPessoa) {
		return tipoPessoa == TipoPessoa.Fisica;
	}

	private TipoPessoa ObterTipoPessoa(Integer contaId) {
		var pessoaId = ObterPessoaId(contaId);
		var pessoa = _pessoaRepository.findById(pessoaId).get();
		return pessoa.getTipoPessoa();
	}

	private Integer ObterPessoaId(Integer contaId) {
		var conta = _contaRepository.findById(contaId).get();
		return conta.getPessoaId();
	}	
	
}
