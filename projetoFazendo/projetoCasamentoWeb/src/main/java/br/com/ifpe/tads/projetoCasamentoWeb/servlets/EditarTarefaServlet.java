package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class EditarTarefaServlet
 */
public class EditarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditarTarefaServlet() {
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
		// Pega a sessão
		HttpSession sessao = request.getSession();

		// Cria os repositórios
		TarefaRepository tarefaRepository = new TarefaRepository();
		CasamentoRepository casamentoRepository = new CasamentoRepository();

		// Pega o id do casamento da sessão
		// Long idCasamento = Long.parseLong( (String)
		// sessao.getAttribute("idCasamento"));
		Long idCasamento = (Long) sessao.getAttribute("idCasamento");

		// Pega os valores do formulário
		String descricao = request.getParameter("descricao");
		String status = request.getParameter("statusSelectionado");

		String titulo = request.getParameter("titulo");

		String dataString = request.getParameter("data");

		// Busca o casamento a partir de seu id
		Casamento casamento = casamentoRepository.buscar(idCasamento);

		// Pega o serviço antes de alteá-lo
		Long idTarefa = (Long) sessao.getAttribute("idTarefa");

		// Pega a tarefa pelo id recebido pelo att da sessão
		Tarefa tarefa = tarefaRepository.buscar(idTarefa);

		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas.add(tarefa);

		// Verifica qual o status escolhido pelo usuário

		for (StatusTarefa statusTarefa : StatusTarefa.values()) {

			// Apenas para testes
			System.out.println(statusTarefa.name());

			// Atribui o valor do status ao status da nova tarefa
			if ((statusTarefa.name()).equals(status)) {
				tarefa.setStatus(statusTarefa);
			}
		}

		// Atribuindo os valores da tarefa
		tarefa.setCasamento(casamento);
		tarefa.setData(Date.from(Instant.now()));
		tarefa.setDescricao(descricao);
		tarefa.setTitulo(titulo);

		// Salva a tarefa
		tarefaRepository.atualizar(tarefa);

		// Pega a sessão
		sessao.setAttribute("listaTarefas", tarefas);

		request.getRequestDispatcher("listarTarefas.jsp").forward(request, response);

	}

}
