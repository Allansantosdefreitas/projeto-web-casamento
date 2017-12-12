<%

/* Manda para a p�gina conforme o tipo de usu�rio */
	HttpSession sessao = request.getSession();
	String estaAtivo = (String) sessao.getAttribute("isActive");

	if (estaAtivo == "verdadeiro") { // Se o usu�rio estiver logado
		// Redireciona para a p�gina principal interna 

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

	}else{ /*Sess�o n�o est� ativa */
			RequestDispatcher view = request.getRequestDispatcher("index2.jsp");

			view.forward(request, response);
				
	}
%>