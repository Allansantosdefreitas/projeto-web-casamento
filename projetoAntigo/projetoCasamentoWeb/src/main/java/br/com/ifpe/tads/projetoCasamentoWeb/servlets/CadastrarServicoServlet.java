package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Profissional;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Servico;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository;

/**
 * Servlet implementation class CadastrarServicoServlet
 */
public class CadastrarServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CadastrarServicoServlet() {
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
		
		ServicoRepository servicoRepository = new ServicoRepository();

		String descricao = request.getParameter("descricao");
		float preco = Float.parseFloat(request.getParameter("preco"));
		Boolean statusDisponibilizado = Boolean.parseBoolean(request.getParameter("status"));
		String titulo = request.getParameter("titulo");
		Profissional profissional = new Profissional();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		Servico servico = new Servico();
		servico.setDescricao(descricao);
		servico.setPreco(preco);
		servico.setProfissional(profissional);
		servico.setStatusDisponibilizado(statusDisponibilizado);
		servico.setTarefas(tarefas);
		servico.setTitulo(titulo);
		
		servicoRepository.inserir(servico);

	}

}
