package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Profissional;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ProfissionalRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository;

/**
 * Servlet implementation class EditarServicoServlet
 */
public class EditarServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditarServicoServlet() {
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

		HttpSession sessao = request.getSession();

		ServicoRepository servicoRepository = new ServicoRepository();
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();
		
		// Pega o serviço antes de alteá-lo
		Long idServico =  (Long) sessao.getAttribute("idServico");
		
		// Pega o serviço pelo id recebido pelo att da sessão
		Servico servico = servicoRepository.buscar(idServico);

		// pegar o profissional da sessao
		Long idProfissional = (Long) sessao.getAttribute("idUsuario");

		// pega o profissional
		Profissional profissional = profissionalRepository.buscar(idProfissional);

		String descricao = request.getParameter("descricao");
		float preco = Float.parseFloat(request.getParameter("preco"));
		// Boolean statusDisponibilizado =
		// Boolean.parseBoolean(request.getParameter("status"));
		Boolean statusDisponibilizado = true;

		String titulo = request.getParameter("titulo");

		/* Modifica os valores do serviço */
		servico.setDescricao(descricao);
		servico.setPreco(preco);
		servico.setProfissional(profissional);
		servico.setStatusDisponibilizado(statusDisponibilizado);
		servico.setTitulo(titulo);

		servicoRepository.atualizar(servico);

		request.getRequestDispatcher("listarServicos.jsp").forward(request, response);

	}

}
