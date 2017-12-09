package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;

public class ServicoRepository extends Repository<Servico> {

	public ServicoRepository() {
		super(Servico.class);
	}

	public List<Servico> listarServicosPorProfissional(Long idProfissional) {

		// Busca o entity manager
		EntityManager entityManager = getEntityManager();
		String jpqlQuery = "SELECT s FROM Servico s WHERE s.profissional.idUsuario = ?1";
		Query query = entityManager.createQuery(jpqlQuery);
		
		query.setParameter(1, idProfissional);

		//List<Tarefa> listaTarefas = query.getResultList();
		List<Servico> listaServicos = query.getResultList();
		
		return listaServicos;
	}

}
