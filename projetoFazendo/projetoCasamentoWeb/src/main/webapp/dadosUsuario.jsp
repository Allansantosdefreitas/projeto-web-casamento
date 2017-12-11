<%@page
	import="br.com.ifpe.tads.projetoCasamentoWeb.repository.UsuarioRepository"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario"%>
<%@include file="includes/sessaoPaginaInterna.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados do usuário</title>

<!-- Bootstrap's styles -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<%
	String tipoUsuarioSessao = (String) sessao.getAttribute("tipoUsuario");
	String tipoUsuario;

	if (tipoUsuarioSessao.equals("conjuge")) {

		tipoUsuario = "Cônjuge";

	} else if (tipoUsuarioSessao.equals("convidado")) {
		tipoUsuario = "Convidado";

	} else if (tipoUsuarioSessao.equals("profissional")) {
		tipoUsuario = "Profissional";

	}

	UsuarioRepository usuarioRepository = new UsuarioRepository();

	// Pega o id do usuário
	Long idUsuario = (Long) sessao.getAttribute("idUsuario");

	Usuario usuario = usuarioRepository.buscar(idUsuario);
%>
<body>

	<!-- NavBar -->
	<c:import url="/templates/navbar.jsp" />

	<div class="container">

		<form action="EditarUsuarioServlet" method="post">

			<fieldset>
				<legend>Dados do ${tipoUsuario}</legend>

				<div class="form-group col-sm-12">
					<label>Nome:</label> <input type="text" class="form-control"
						name="nome" value="<%=usuario.getNome()%>" />
				</div>
				<div class="form-group col-sm-12">
					<label>Email:</label> <input type="email" class="form-control"
						name="email" value="<%=usuario.getEmail()%>" />
				</div>
				<div class="form-group col-sm-12">
					<label>Login:</label> <input type="text" class="form-control"
						name="login" value="<%=usuario.getLogin()%>" />
				</div>
			</fieldset>

			<div class="form-group col-sm-12">
				<button class="btn btn-success" type="submit">Salvar</button>
				<button class="btn btn-default" type="reset">Limpar</button>
				<a href="home.jsp" class="btn btn-default" role="button">Voltar</a>
			</div>


		</form>
	</div>

	<!-- Bootstrap's scripts -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>