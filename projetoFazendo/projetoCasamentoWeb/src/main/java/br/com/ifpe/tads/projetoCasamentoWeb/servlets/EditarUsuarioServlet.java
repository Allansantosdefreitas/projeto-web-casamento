package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.UsuarioRepository;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuarioServlet() {
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
		// doGet(request, response);

		HttpSession sessao = request.getSession();

		UsuarioRepository usuarioRepository = new UsuarioRepository();

		// Pega o serviço antes de alteá-lo
		Long idUsuario = (Long) sessao.getAttribute("idUsuario");

		// Pega o serviço pelo id recebido pelo att da sessão
		Usuario usuario = usuarioRepository.buscar(idUsuario);

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");

		/* Modifica os valores do serviço */
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setLogin(login);

		usuarioRepository.atualizar(usuario);

		sessao.removeAttribute("usuario");
		sessao.setAttribute("usuario", usuario);
		
		
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

}
