package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;

public class ConjugeRepository extends Repository<Conjuge>{

	public ConjugeRepository() {
		super(Conjuge.class);
	}

	public Conjuge autenticar(String login, String senha) {
		//Busca o entity manager
		EntityManager entityManager = getEntityManager();

		//Prepara a busca do conjuge pelo login
		String sqlLogin = "From Conjuge c where c.login = " + login;
		
		//Executa a query
		Query query = entityManager.createQuery(sqlLogin);
		
		//Encontra o conjuge pelo login
		Conjuge conjuge = (Conjuge) query.getSingleResult();
		Conjuge conjugeFinal = null;

		if(conjuge != null) {
			
			//Procura o conjuge agora pelo login e a senha, utilizando o salt para verificar a senha já encriptada
			String sqlSenha = "From Conjuge c where c.login = " + login + " and c.senha = AES_ENCRYPT(" + senha + "," + conjuge.getSalt() + ")";
			Query novaQuery = entityManager.createQuery(sqlSenha);
			
			//Executa a query
			conjugeFinal = (Conjuge) novaQuery.getSingleResult();
		}
		
		//Retorna o conjuge encontrado ou não (é preciso verificar se o conjuge foi encontrado ou não)
		return conjugeFinal;
	}
}
