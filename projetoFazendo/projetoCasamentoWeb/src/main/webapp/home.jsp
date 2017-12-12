<%

/* Manda para a página conforme o tipo de usuário */
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
			
			RequestDispatcher view = request.getRequestDispatcher("responderConvite.jsp");

			view.forward(request, response);

		}

	}else{ /*Sessão não está ativa */
			RequestDispatcher view = request.getRequestDispatcher("index2.jsp");

			view.forward(request, response);
				
	}
%>