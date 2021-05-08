package com.controle.contas.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controle.contas.api.entity.Pessoa;
import com.controle.contas.api.enums.TipoPessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	@Query("SELECT p FROM Pessoa p WHERE p.tipoPessoa= ?1")
	public List<Pessoa> findByTipoPessoa(TipoPessoa tipoPessoa);
	
}

