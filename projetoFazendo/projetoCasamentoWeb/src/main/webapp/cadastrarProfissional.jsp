<%@include file="includes/sessaoPaginaExterna.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Profissional</title>

<!-- Bootstrap's styles -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<body>
	<header> <nav
		class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="index2.jsp">WeddingWeb</a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item "><a class="nav-link"
				href="index2.jsp">Home <span class="sr-only">(current)</span></a></li>


			<li class="nav-item"><a class="nav-link"
				href="cadastrarCasamento.jsp">Casamento</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="cadastrarProfissional.jsp">Profissional</a></li>

			<li class="nav-item"><a class="nav-link"
				href="cadastrarConvidado.jsp">Convidado</a></li>


		</ul>

		<a class="btn btn-primary my-2 my-sm-0" href="login.jsp">Login</a>

	</div>
	</nav> 
	
	<br />
	<br />


	<div class="container">
		<h2 class="text-center">Cadastre-se como profissional!</h2>
		<h4 class="text-center">Seja bem-vindo e bom trabalho!</h4>
		
		<form action="CadastrarProfissionalServlet" method="post">
			
			<fieldset>
				<legend>Dados do profissional</legend>

				<div class="form-group col-sm-12">
					<label>Nome:</label> <input type="text" class="form-control"
						name="nomeProfissional" />
				</div>
				<div class="form-group col-sm-12">
					<label>Email:</label> <input type="email" class="form-control"
						name="emailProfissional" />
				</div>
				<div class="form-group col-sm-12">
					<label>Login:</label> <input type="text" class="form-control"
						name="loginProfissional" />
				</div>
				<div class="form-group col-sm-12">
					<label>Senha:</label> <input type="password" class="form-control"
						name="senhaProfissional" />
				</div>
			</fieldset>

			<div class="form-group col-sm-12">
				<button type="submit" class="btn btn-success">Cadastrar</button>
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