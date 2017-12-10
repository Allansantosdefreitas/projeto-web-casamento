package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConjugeRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.UsuarioRepository;

/**
 * Servlet implementation class LoginUsuarioServlet
 */

public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// Pega a sessão
		HttpSession sessao = request.getSession();
		String resultado = "falha";
		String tipoUsuario = "";

		// Cria o repositorio do conjuge
		// ConjugeRepository conjugeRepository = new ConjugeRepository();
		UsuarioRepository usuarioRepository = new UsuarioRepository();

		// Pega os parâmetros de login e senha
		String loginUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");

		// Verifica se foi digitado algo nos campos
		if (loginUsuario != null && senhaUsuario != null) {

			// Verifica se o que foi digitado não é "espaço em branco"
			if (!loginUsuario.equalsIgnoreCase("") || !senhaUsuario.equalsIgnoreCase("")) {

				// Conjuge conjuge = conjugeRepository.autenticar2(loginUsuario, senhaUsuario);
				Usuario usuario = usuarioRepository.autenticarUsuario(loginUsuario, senhaUsuario);

				// Se o usuario for encontrado...
				// Verificar tipo de usuário e setar atributos de sessão conforme isso.
				if (usuario != null) {

					resultado = "sucesso";
					
					sessao.setAttribute("usuario", usuario);

					// se for conjuge
					if (usuario.getDiscUsuario().equals("CONJ")) {

						// atribui idUsuario na sessao
						sessao.setAttribute("idUsuario", usuario.getIdUsuario());

						// tipo usuario = conjuge
						sessao.setAttribute("tipoUsuario", "conjuge");
						tipoUsuario = "conjuge";

						ConjugeRepository conjugeRepository = new ConjugeRepository();
						
						Conjuge conjuge = conjugeRepository.buscarConjuge( usuario );

						// atribui idCasamento na sessao ...
						sessao.setAttribute( "idCasamento", conjuge.getCasamento().getIdCasamento() );						
			
					}
					// se for convidado
					else if (usuario.getDiscUsuario().equals("CONV")) { 

						// atribui idUsuario na sessao
						sessao.setAttribute("idUsuario", usuario.getIdUsuario());

						// tipo usuario = convidado
						sessao.setAttribute("tipoUsuario", "convidado");
						tipoUsuario = "convidado";
						
						// atribui id do casamento ao qual o convidado está vinculado ...

					}
					// se for profissional 
					else if (usuario.getDiscUsuario().equals("PROF")) {  

						
						// atribui idUsuario na sessao
						sessao.setAttribute("idUsuario", usuario.getIdUsuario());

						// tipo usuario = profissional
						sessao.setAttribute("tipoUsuario", "profissional");
						tipoUsuario = "profissional";
						
						
						// Atribui o conjuge na sessão
						// sessao.setAttribute("conjuge", conjuge);
						//
						// sessao.setAttribute("conjugeNome", conjuge.getNome());
						//
						// sessao.setAttribute("idCasamento", conjuge.getCasamento().getIdCasamento());

					} else {

						// Retorna a mensagem de "validação"
						resultado = "Login ou senha inválidos";
						request.setAttribute("resultado", resultado);
					}
				} else {

					// Retorna a mensagem de "validação"
					resultado = "Os campos de login e senha não podem estar em branco";
					request.setAttribute("resultado", resultado);
				}
			} else {

				// Retorna a mensagem de "validação"
				resultado = "Digite o login/senha";
				request.setAttribute("resultado", resultado);
			}
					
			System.out.println(resultado);

			// Por padrão..enquanto não vai para outra página conforme o tipo de usuário
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");

			if (resultado.equals("sucesso")) {

				sessao.setAttribute("isActive", "verdadeiro");
				
				
				/* Se for conjuge ou convidado */
				if( tipoUsuario.equals("conjuge") || tipoUsuario.equals("convidado") ) {
					
					view = request.getRequestDispatcher("listarTarefas.jsp");
				}
				/* Se for profissional */ 
				else if ( tipoUsuario.equals("profissional") ) {
					
					view = request.getRequestDispatcher("listarServicos.jsp");
				}

			} else {
				sessao.setAttribute("isActive", "falso");

				view = request.getRequestDispatcher("login.jsp");
			}

			view.forward(request, response);

		}

	}
}
