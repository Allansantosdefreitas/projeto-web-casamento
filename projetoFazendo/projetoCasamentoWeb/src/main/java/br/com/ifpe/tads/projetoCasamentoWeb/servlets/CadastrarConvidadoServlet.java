package br.com.ifpe.tads.projetoCasamentoWeb.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Casamento;
import br.com.ifpe.tads.projetoCasamentoWeb.model.Convidado;
import br.com.ifpe.tads.projetoCasamentoWeb.model.StatusConvidado;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.CasamentoRepository;
import br.com.ifpe.tads.projetoCasamentoWeb.repository.ConvidadoRepository;

/**
 * Servlet implementation class CadastrarConvidadoServlet
 */
public class CadastrarConvidadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarConvidadoServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	
		CasamentoRepository casamentoRepository = new CasamentoRepository();
		/* Por enquanto..depois deve pegar o id do casamento que enviou o convite ou o c�digo associado ao casamento */
		Long idCasamento = 4L; 
		
		// provis�rio..deve pegar o casamento que enviou o convite
		Casamento casamento = casamentoRepository.buscar(idCasamento);
		
		List<Convidado> listaConvidados = new ArrayList<Convidado>();
		
		ConvidadoRepository convidadoRepository = new ConvidadoRepository();
		Convidado convidado = new Convidado();
	
		String nomeConvidado = request.getParameter("nomeConvidado");
		String emailConvidado = request.getParameter("emailConvidado");
		String loginConvidado = request.getParameter("loginConvidado");
		String senhaConvidado = request.getParameter("senhaConvidado");
		
		convidado.setNome(nomeConvidado);
		convidado.setEmail(emailConvidado);
		convidado.setLogin(loginConvidado);
		convidado.setSenha(senhaConvidado);
		convidado.setCasamento(casamento);
		// pendente por padr�o
		convidado.setStatusConvidado(StatusConvidado.PENDENTE);
		
		
		//coloca na lista
		listaConvidados.add(convidado);	
		casamento.setConvidados(listaConvidados);
		
		
		convidadoRepository.inserir(convidado);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	
	
	}
	
	

}
