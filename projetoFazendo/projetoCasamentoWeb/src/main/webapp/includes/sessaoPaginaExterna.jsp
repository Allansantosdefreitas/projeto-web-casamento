
<%
	/* Verificando se a sess�o est� ativa (Manda pra dentro ou n�o?)--------------
	    Se estiver ativa joga pra a p�gina principal. Sen�o fica onde est�.
	Nota: O usu�rio logado n�o pode ficar na p�gina de cadastro, por exemplo. 
	Pra cadastrar um usu�rio � necess�rio estar deslogado, como ocorre com o Facebook, 
	por exemplo. */

	HttpSession sessao = request.getSession();
	String estaAtivo = (String) sessao.getAttribute("isActive");

	if (estaAtivo == "verdadeiro") { // Se o usuário estiver logado
		// Redireciona para a página principal interna 

		if (sessao.getAttribute("tipoUsuario").equals("conjuge")) {

			RequestDispatcher view = request.getRequestDispatcher("listarTarefas.jsp");

			view.forward(request, response);
		} else if (sessao.getAttribute("tipoUsuario").equals("profissional")) {
			
			RequestDispatcher view = request.getRequestDispatcher("listarServicos.jsp");

			view.forward(request, response);

		} else { // SE for convidado
			
			RequestDispatcher view = request.getRequestDispatcher("paginaConvidado.jsp");

			view.forward(request, response);

		}

	}
%>

