package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Despesa;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario;

public class DespesaRepository extends Repository<Despesa>{

	public DespesaRepository() {
		super(Despesa.class);
	}



	
}
