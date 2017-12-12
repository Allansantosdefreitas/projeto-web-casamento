<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario"%>
<%
	HttpSession sessao = request.getSession();
	//String nomeDoConjuge = (String) sessao.getAttribute("conjugeNome");
	int dilma = 13;
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="index2.jsp">WeddingWeb</a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link"
				href="index2.jsp">Home <span class="sr-only">(current)</span></a></li>
			
			<%
				if (sessao.getAttribute("isActive").equals("falso")) {
			%>
			
			<li class="nav-item"><a class="nav-link"
				href="cadastrarCasamento.jsp">Casamento</a></li>
			
			<ul>
			<li class="nav-item"><a class="nav-link"
				href="cadastrarProfissional.jsp">Profissionais</a>
				</li>
				
			<li class="nav-item"><a class="nav-link"
				href="cadastrarConvidado.jsp">Convidados</a></li>
			
			<%
			}
				if (sessao.getAttribute("isActive").equals("verdadeiro")) {
			
					
						if (sessao.getAttribute("tipoUsuario").equals("conjuge")) {
			
			
				
				
			%>

			<li class="nav-item"><a class="nav-link"
				href="listarTarefas.jsp">Tarefas</a></li>
			<li class="nav-item"><a class="nav-link"
				href="listarServicos.jsp">Serviços</a></li>
					<li class="nav-item"><a class="nav-link"
				href="listarConvidados.jsp">Convidados</a></li>

					<%
						}else if (sessao.getAttribute("tipoUsuario").equals("profissional")) {
					%>
						<li class="nav-item"><a class="nav-link"
									href="listarServicos.jsp">Serviços</a></li>

					<%}else { // SE for convidado...
					 
					 %>
					 <li class="nav-item"><a class="nav-link"
				href="responderConvite.jsp">Convite</a></li>
					<%
					} 
					%>
			<%
			} 
			%>
			
		
		</ul>
		<%
			if (sessao.getAttribute("isActive").equals("verdadeiro")) {
			
			
			String tipoUsuario = (String) sessao.getAttribute("tipoUsuario");
			String tipoUsuarioSessao;
			
			if(tipoUsuario.equals("conjuge")){
					
					tipoUsuarioSessao = "Cônjuge";
			
			}else if(tipoUsuario.equals("convidado")){
				tipoUsuarioSessao = "Convidado";
			
			}else if(tipoUsuario.equals("profissional")){
					tipoUsuarioSessao = "Profissional";
			
			}
			
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
					
		%>

<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				${usuario.getNome()} <span class="caret"></span>
			</button>
	
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="dadosUsuario.jsp">${tipoUsuario}</a> 
					 <div class="dropdown-divider"></div>
					<a class="dropdown-item" href="LogoutServlet">Sair</a> 
				</div>
				
			</div>


		<%
			} else {
		%>

		<a class="btn btn-primary my-2 my-sm-0" href="login.jsp">Login</a>

		<%
			}
		%>
	</div>
</nav>

<br />
<br />