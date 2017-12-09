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
	public Usuario autenticarUsuario(String login, String senha) {
		
		//Busca o entity manager
		EntityManager entityManager = getEntityManager();

		//Prepara a busca do conjuge pelo login (por query nativa)
		//String sqlLogin = "SELECT idUsuarioProfissional FROM TB_profissional p INNER JOIN TB_usuario u ON p.idUsuarioProfissional = u.idUsuario WHERE u.login = ?1 and u.senha = ?2";
		String sqlLogin = "SELECT idUsuario FROM TB_usuario u WHERE u.login = ?1 and u.senha = ?2";
		
		//Executa a query nativa
		Query query = entityManager.createNativeQuery(sqlLogin);
		query.setParameter(1, login);
		query.setParameter(2, senha);

		UsuarioRepository usuarioRepository = new UsuarioRepository();
		
		Long idUsuario = (Long) query.getSingleResult();
		
		Usuario usuario = (Usuario) usuarioRepository.buscar(idUsuario);
		
		//conjuge.setCasamento(casamentoRepository.buscar((Long) query.getSingleResult() ));
				
		return usuario;

	}
}

