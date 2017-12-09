package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>{
	
	public UsuarioRepository() {
		super(Usuario.class);
	}
	
	
	// FALTA FAZER UM LOGIN QUE ABSTRAIA O TIPO DE USUÁRIO
	//ALLAN, 09/12
	//(03H02)
	public Conjuge autenticarUsuario(String login, String senha) {
		
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

