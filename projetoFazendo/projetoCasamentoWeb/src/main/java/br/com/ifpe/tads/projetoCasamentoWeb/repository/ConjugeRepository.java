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
		String sqlLogin = "From TB_conjuge c where c.login = " + login;
		
		//Executa a query
		Query query = entityManager.createQuery(sqlLogin);
		
		//Encontra o conjuge pelo login
		Conjuge conjuge = (Conjuge) query.getSingleResult();
		Conjuge conjugeFinal = null;

		if(conjuge != null) {
			
			//Procura o conjuge agora pelo login e a senha, utilizando o salt para verificar a senha já encriptada
//			String sqlSenha = "From Conjuge c where c.login = " + login + " and c.senha = AES_ENCRYPT(" + senha + "," + conjuge.getSalt() + ")";
//			Query novaQuery = entityManager.createQuery(sqlSenha);
//			
//			//Executa a query
//			conjugeFinal = (Conjuge) novaQuery.getSingleResult();
		}
		
		//Retorna o conjuge encontrado ou não (é preciso verificar se o conjuge foi encontrado ou não)
		return conjugeFinal;
	}
	
	public Conjuge autenticar2(String login, String senha) {
		//Busca o entity manager
		EntityManager entityManager = getEntityManager();

		//Prepara a busca do conjuge pelo login
		String sqlLogin = "SELECT id_Casamento FROM TB_conjuge c INNER JOIN TB_usuario u ON c.idConjuge = u.idUsuario WHERE u.login = ?1 and u.senha = ?2";
		
		//Executa a query
		Query query = entityManager.createNativeQuery(sqlLogin);
		query.setParameter(1, login);
		query.setParameter(2, senha);
		
		CasamentoRepository casamentoRepository = new CasamentoRepository();
		
		Conjuge conjuge = new Conjuge();
		
		conjuge.setCasamento(casamentoRepository.buscar((Long) query.getSingleResult() ));
		
		return conjuge;

	}
}
