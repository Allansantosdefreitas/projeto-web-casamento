package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 //Pega a sessão do usuário
        HttpSession session = request.getSession();

        //Remove o conjuge da sessão
        session.removeAttribute("conjuge");
        session.removeAttribute("idCasamento");
  
        session.setAttribute("isActive", "false");
        
        //Invalida a sessão
        //session.invalidate();
        
        //Redireciona para a página inicial
        
        RequestDispatcher view = request.getRequestDispatcher("index2.jsp");
        
  		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 //Pega a sessão do usuário
        HttpSession session = request.getSession();

        //Remove o conjuge da sessão
        session.removeAttribute("conjuge");
        session.removeAttribute("idCasamento");
  
        session.setAttribute("isActive", "false");
        
        //Invalida a sessão
        //session.invalidate();
        
        //Redireciona para a página inicial
        
        RequestDispatcher view = request.getRequestDispatcher("index2.jsp");
        
  		view.forward(request, response);
      
        
      //response.sendRedirect(request.getContextPath() + "/index2.jsp");
	}

}
