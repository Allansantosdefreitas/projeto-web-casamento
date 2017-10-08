package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;

public interface CasamentoRepository extends JpaRepository<Casamento, Integer>{

}
