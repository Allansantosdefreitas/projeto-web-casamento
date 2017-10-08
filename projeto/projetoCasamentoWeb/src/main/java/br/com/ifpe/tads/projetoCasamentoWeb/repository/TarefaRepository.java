package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
