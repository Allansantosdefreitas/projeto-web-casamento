<%
    /* Verificando se a sess�o est� ativa (Manda pra dentro ou n�o?)--------------
        Se estiver ativa joga pra a p�gina principal. Sen�o fica onde est�.
    Nota: O usu�rio logado n�o pode ficar na p�gina de cadastro, por exemplo. 
    Pra cadastrar um usu�rio � necess�rio estar deslogado, como ocorre com o Facebook, 
    por exemplo. */
    
     
    HttpSession sessao = request.getSession();
    String estaAtivo = (String) session.getAttribute("isActive");

    if (estaAtivo == "verdadeiro"){ // Se o usuário estiver logado
        // Redireciona para a página principal interna 
        
        RequestDispatcher view = request.getRequestDispatcher("listarTarefas.jsp");
        
		view.forward(request, response);
        
     
    }
      
%>

