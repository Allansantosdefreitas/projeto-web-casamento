package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.model.StatusTarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.TarefaRepository;

/**
 * Servlet implementation class CadastrarTarefaServlet
 */
public class CadastrarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	TarefaRepository tarefaRepository;
	
	@EJB
	CasamentoRepository casamentoRepository;

	/**
	 * Default constructor.
	 */
	public CadastrarTarefaServlet() {
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
		
		Integer idCasamento = Integer.getInteger((String) sessao.getAttribute("idCasamento") );

		String descricao = request.getParameter("descricao");
//		StatusTarefa status = (StatusTarefa) request.getParameter("status");
		StatusTarefa status = StatusTarefa.PENDENTE;
		String titulo = request.getParameter("titulo");
		Casamento casamento = casamentoRepository.getOne(idCasamento);;
		Servico servico = new Servico();
		
		Tarefa tarefa = new Tarefa();
		tarefa.setCasamento(casamento);
		tarefa.setData(Date.from(Instant.now()));
		tarefa.setDescricao(descricao);
		tarefa.setServico(servico);
		tarefa.setStatus(status);
		tarefa.setTitulo(titulo);
		
		tarefaRepository.save(tarefa);
	}

}
