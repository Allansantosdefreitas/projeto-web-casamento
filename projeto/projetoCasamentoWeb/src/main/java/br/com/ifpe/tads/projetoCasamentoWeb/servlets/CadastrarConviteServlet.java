package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convite;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConviteRepository;

/**
 * Servlet implementation class CadastrarConviteServlet
 */
public class CadastrarConviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CadastrarConviteServlet() {
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

		HttpSession sessao = request.getSession();
		
		CasamentoRepository casamentoRepository = new CasamentoRepository();
		ConviteRepository conviteRepository = new ConviteRepository();
		
		String destinatarios = request.getParameter("destinatario");
		String mensagem = request.getParameter("mensagem");
		
		Integer idCasamento = Integer.getInteger( (String) sessao.getAttribute("idCasamento"));
		Casamento casamento = casamentoRepository.buscar(idCasamento);
		
		Convite convite = new Convite();
		convite.setCasamento(casamento);
		convite.setDestinatarios(destinatarios);
		convite.setMensagem(mensagem);
		
		conviteRepository.inserir(convite);
	}

}
