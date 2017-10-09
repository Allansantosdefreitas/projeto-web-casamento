package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convidado;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convite;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;

/**
 * Servlet implementation class CadastrarCasamentoServlet
 */
public class CadastrarCasamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CasamentoRepository casamentoRepository;
	
	/**
	 * Default constructor.
	 */
	public CadastrarCasamentoServlet() {
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

		double orcamentoTotal = Double.parseDouble(request.getParameter("orcamento"));
		List<Conjuge> conjuges = new ArrayList<Conjuge>();
		List<Convidado> convidados = new ArrayList<Convidado>();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Convite convite = new Convite();
		
		Casamento casamento = new Casamento();
		casamento.setConjuges(conjuges);
		casamento.setConvidados(convidados);
		casamento.setTarefas(tarefas);
		casamento.setConvite(convite);
		casamento.setOrcamentoTotal(orcamentoTotal);
		
		casamentoRepository.save(casamento);
	}

}
