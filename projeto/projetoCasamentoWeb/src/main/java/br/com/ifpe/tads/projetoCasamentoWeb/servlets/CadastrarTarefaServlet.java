package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

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

		//Pega a sessão
		HttpSession sessao = request.getSession();
		
		//Cria os repositórios
		TarefaRepository tarefaRepository = new TarefaRepository();
		CasamentoRepository casamentoRepository = new CasamentoRepository();
		
		//Pega o id do casamento da sessão
		Integer idCasamento = Integer.getInteger((String) sessao.getAttribute("idCasamento") );

		//Pega os valores do formulário
		String descricao = request.getParameter("descricao");
		String status = request.getParameter("status");
		//StatusTarefa status = StatusTarefa.PENDENTE;
		String titulo = request.getParameter("titulo");
		
		//Busca o casamento a partir de seu id
		Casamento casamento = casamentoRepository.buscar(idCasamento);
		Servico servico = new Servico();

		//Inicializando a tarefa
		Tarefa tarefa = new Tarefa();
		
		//Verifica qual o status escolhido pelo usuário
		for(StatusTarefa statusTarefa : StatusTarefa.values()){
			
			//Apenas para testes
			System.out.println(statusTarefa.name());
			
			//Atribui o valor do status ao status da nova tarefa
			if((statusTarefa.name()).equals(status)) {
				tarefa.setStatus(statusTarefa);
			}
		}
		
		//Atribuindo os valores da tarefa
		tarefa.setCasamento(casamento);
		tarefa.setData(Date.from(Instant.now()));
		tarefa.setDescricao(descricao);
		tarefa.setServico(servico);
		tarefa.setTitulo(titulo);
		
		//Salva a tarefa
		tarefaRepository.inserir(tarefa);
	}

}
