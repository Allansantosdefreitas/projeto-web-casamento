package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.TarefaRepository;

/**
 * Servlet implementation class ListarTarefas
 */
public class ListarTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTarefas() {
        super();
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

		//Pega a sess�o do usu�rio
        HttpSession sessao = request.getSession();
        
        //Cria uma lista de usu�rios
        List<Tarefa> listaTarefas;
        TarefaRepository tarefaRepository = new TarefaRepository();
        
        //Popula a lista utilizando como apoio o Dao de usu�rio
        listaTarefas = tarefaRepository.listar();
        
        //Passa a lista com um atributo de sesss�o e retorna para a p�gina de gerencia
        sessao.setAttribute("listaTarefas", listaTarefas);
        response.sendRedirect(request.getContextPath()+ "/gerenciaContasAdmv2.jsp");
	}

}
