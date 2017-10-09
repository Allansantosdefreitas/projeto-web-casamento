package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository;

/**
 * Servlet implementation class DeletarServicoServlet
 */
public class DeletarServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicoRepository servicoRepository;

	/**
	 * Default constructor.
	 */
	public DeletarServicoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer idServico = Integer.getInteger((String) request.getParameter("idServico"));
		Servico servico = servicoRepository.getOne(idServico);

		servicoRepository.delete(servico);
	}

}
