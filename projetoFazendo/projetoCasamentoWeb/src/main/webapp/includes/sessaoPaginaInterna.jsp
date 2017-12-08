<% 
     /*Verificando se a sessão está ativa (Manda pra fora ou não?) ------------------------------------
        Se estiver ativa, permanece na página atual. Senão, redireciona para página principal */
    
    HttpSession sessao = request.getSession();
    String estaAtivo = (String) session.getAttribute("isActive");
  
    //String nomeCasamento = (String) session.getAttribute("nomeCasamento"); // Apenas para mostrar na página

    if (estaAtivo == "verdadeiro"){ // Se a sessão estiver ativa
     	// não faz nada :)
     	
    }else{ // Se estiver desativada
        // Manda para a página inicial
        
        RequestDispatcher view = request.getRequestDispatcher("index2.jsp");
        
		view.forward(request, response);
         
       
    } 

%>
