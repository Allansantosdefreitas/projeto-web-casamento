package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Profissional;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ProfissionalRepository;

/**
 * Servlet implementation class CadastrarProfissionalServlet
 */
public class CadastrarProfissionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastrarProfissionalServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
		Profissional profissional = new Profissional();
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();
		
		profissional.setEmail( request.getParameter("emailProfissional") );
		profissional.setLogin( request.getParameter("loginProfissional") );
		profissional.setNome( request.getParameter("nomeProfissional") );
		profissional.setSenha( request.getParameter("senhaProfissional") );
		
		profissionalRepository.inserir(profissional);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
