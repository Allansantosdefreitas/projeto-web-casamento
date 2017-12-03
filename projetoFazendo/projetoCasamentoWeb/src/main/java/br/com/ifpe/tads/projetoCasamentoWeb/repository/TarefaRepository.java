package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;

public class TarefaRepository extends Repository<Tarefa>{

	public TarefaRepository() {
		super(Tarefa.class);
	}
	
	
	public List<Tarefa> listarTarefasPorCasamento(Long idCasamento) {
		
		//Busca o entity manager
		EntityManager entityManager = getEntityManager();
		String jpqlQuery = "SELECT t FROM Tarefa t WHERE t.casamento.idCasamento = ?1";
		Query query = entityManager.createQuery(jpqlQuery);
		query.setParameter(1, idCasamento);
		
		List<Tarefa> listaTarefas = query.getResultList();
		
		return listaTarefas;
	}
}
