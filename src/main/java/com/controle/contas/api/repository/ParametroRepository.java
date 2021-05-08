package com.controle.contas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.contas.api.entity.Parametro;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, String> {

}
