package br.com.ifpe.tads.projetoCasamentoWeb.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convidado;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convite;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Despesa;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;

//import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
//import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
//import br.com.ifpe.tads.projetoCasamentoWeb.model.Convidado;
//import br.com.ifpe.tads.projetoCasamentoWeb.model.Convite;
//import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
//import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;

/**
 * Servlet implementation class CadastrarCasamentoServlet
 */
public class CadastrarCasamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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

		double orcamentoTotal = Double.valueOf(request.getParameter("orcamentoTotal"));
		
		//Instanciando o casamento
		Casamento casamento = new Casamento();
		casamento.setNome( request.getParameter("nomeCasamento"));
		
		Despesa despesa = new Despesa();
		despesa.setDespesaPrevista(orcamentoTotal);
		despesa.setDespesaAtual(0.0);
		//despesa.setCasamento(casamento);
		
		casamento.setDespesa(despesa);
		
		//Instantciando o noivo e a noiva
		Conjuge noivo = new Conjuge();
		noivo.setCasamento(casamento);
		noivo.setEmail( request.getParameter("emailNoivo") );
		noivo.setLogin( request.getParameter("loginNoivo") );
		noivo.setNome( request.getParameter("nomeNoivo") );
		noivo.setSenha( request.getParameter("senhaNoivo") );
		
		Conjuge noiva = new Conjuge();
		noiva.setCasamento(casamento);
		noiva.setEmail( request.getParameter("emailNoiva") );
		noiva.setLogin( request.getParameter("loginNoiva") );
		noiva.setNome( request.getParameter("nomeNoiva") );
		noiva.setSenha( request.getParameter("senhaNoiva") );
		
		//Adicionando o noivo e a noiva no casamento
		List<Conjuge> conjuges = new ArrayList<Conjuge>();
		conjuges.add(noivo);
		conjuges.add(noiva);
		
		//Outros atributos necess�rios para casamento
		List<Convidado> convidados = new ArrayList<Convidado>();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		Convite convite = new Convite();
		convite.setCasamento(casamento);
		
		//Atribuindo valores para o casamento
		casamento.setConjuges(conjuges);
		casamento.setConvidados(convidados);
		casamento.setTarefas(tarefas);
//		casamento.setConvite(convite);
//		casamento.setOrcamentoTotal(orcamentoTotal);
		
		CasamentoRepository casamentoRepository = new CasamentoRepository();
		casamentoRepository.inserir(casamento);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
