<%@include file="includes/sessaoPaginaExterna.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Convidado</title>

<!-- Bootstrap's styles -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<body>

	<!-- NavBar -->
	<c:import url="/templates/navbar.jsp" />

	<div class="container">
		<h2 class="text-center">Cadastre-se como convidado!</h2>
		<h4 class="text-center">Seja bem-vindo</h4>
		
		<form action="CadastrarConvidadoServlet" method="post">
			
			<fieldset>
				<legend>Dados do convidado</legend>

				<div class="form-group col-sm-12">
					<label>Nome:</label> <input type="text" class="form-control"
						name="nomeConvidado" />
				</div>
				<div class="form-group col-sm-12">
					<label>Email:</label> <input type="email" class="form-control"
						name="emailConvidado" />
				</div>
				<div class="form-group col-sm-12">
					<label>Login:</label> <input type="text" class="form-control"
						name="loginConvidado" />
				</div>
				<div class="form-group col-sm-12">
					<label>Senha:</label> <input type="password" class="form-control"
						name="senhaConvidado" />
				</div>
			</fieldset>

			<div class="form-group col-sm-12">
				<button type="submit" class="btn btn-success">Enviar</button>
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