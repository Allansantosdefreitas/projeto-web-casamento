package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.TarefaRepository;

/**
 * Servlet implementation class DeletarTarefaServlet
 */
public class DeletarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeletarTarefaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TarefaRepository tarefaRepository = new TarefaRepository();
		
		Integer idTarefa = Integer.getInteger((String) request.getParameter("idTarefa") );;
		
		Tarefa tarefa = tarefaRepository.buscar(idTarefa);
		tarefaRepository.deletar(tarefa);
	}

}
