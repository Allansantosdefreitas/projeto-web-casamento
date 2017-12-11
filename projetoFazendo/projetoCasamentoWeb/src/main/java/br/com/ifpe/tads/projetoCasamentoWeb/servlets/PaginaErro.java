package br.com.ifpe.tads.projetoCasamentoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginaErro
 */
public class PaginaErro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaErro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 processError(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 processError(request, response);
	
	}
	 protected void processError(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
	        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
	        
	        if (servletName == null) {
	            servletName = "Unknown";
	        }
	        
	        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
	        if (requestUri == null) {
	            requestUri = "Unknown";
	        }
	        response.setContentType("text/html");
	        
	        if (statusCode != 500) {
	            response.sendRedirect(request.getContextPath() + "/paginaNaoEncontrada.jsp");
	        } else {
	            response.sendRedirect(request.getContextPath() + "/erroInterno.jsp");
	        }

	    }

}
