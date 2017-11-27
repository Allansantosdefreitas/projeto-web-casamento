package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Conjuge;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConjugeRepository;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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

		//Pega a sessão
		HttpSession sessao = request.getSession();
		String resultado = "sucesso";
		
		//Cria o repositorio do conjuge
		ConjugeRepository conjugeRepository = new ConjugeRepository();
		
		//Pega os parâmetros de login e senha
		String loginUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");
		
		//Verifica se foi digitado algo nos campos
		if(loginUsuario != null && senhaUsuario != null) {
			
			
			//Verifica se o que foi digitado não é "espaço em branco"
			if (!loginUsuario.equalsIgnoreCase("") || !senhaUsuario.equalsIgnoreCase("")) {

				//Procura o conjuge pelo login e senha (a senha é encriptada no método)
				Conjuge conjuge = conjugeRepository.autenticar2(loginUsuario, senhaUsuario);
				
				//Se o conjuge for encontrado...
				if(conjuge != null) {
					
					//Atribui o conjuge na sessão
					sessao.setAttribute("conjuge", conjuge);
					sessao.setAttribute("idCasamento", conjuge.getCasamento().getIdCasamento());
				} else {
					
					//Retorna a mensagem de "validação"
					resultado = "Login ou senha inválidos";
					request.setAttribute("resultado", resultado);
				}
			} else {
				
				//Retorna a mensagem de "validação"
				resultado = "Os campos de login e senha não podem estar em branco";
				request.setAttribute("resultado", resultado);
			}
		} else {

			//Retorna a mensagem de "validação"
			resultado = "Digite o login/senha";
			request.setAttribute("resultado", resultado);
		}
		System.out.println(resultado);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
