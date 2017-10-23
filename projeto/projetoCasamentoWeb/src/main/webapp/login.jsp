<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Início</title>
		
		<!-- Bootstrap's styles -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	
		<!-- Login style -->
		<link href="css/login.css" rel="stylesheet">
	</head>
	
	<body>
	
		<!-- Navbar -->
		<header>
	    	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	        	<a class="navbar-brand" href="index2.jsp">WeddingWeb</a>
	        	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	        		<span class="navbar-toggler-icon"></span>
	        	</button>
		        <div class="collapse navbar-collapse" id="navbarCollapse">
		        	<ul class="navbar-nav mr-auto">
			            <li class="nav-item active">
			            	<a class="nav-link" href="index2.jsp">Home <span class="sr-only">(current)</span></a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="cadastrarCasamento.jsp">Casamento</a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="listarTarefas.jsp">Tarefas</a>
			            </li>
		          	</ul>
		          	<form class="form-inline mt-2 mt-md-0">
		            	<a class="btn btn-outline-success my-2 my-sm-0" href="login.jsp">Login</a>
		          	</form>
		        </div>
	    	</nav>
	    </header>
		
		<div class="container">

		    <form class="form-signin" method="post" action="LoginServlet">
		    
			    <h2 class="form-signin-heading">Realize o seu login</h2>
			    
			    <label for="inputEmail" class="sr-only">Login</label>
			    <input type="text" id="login" name="login" class="form-control" placeholder="Login" required autofocus>
			    
			    <label for="inputPassword" class="sr-only">Senha</label>
			    <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
			    
			    <div class="checkbox">
				    <label>
				    	<input type="checkbox" value="remember-me"> Lembrar-me
				    </label>
			    </div>
			    
			    <button class="btn btn-lg btn-success btn-block" type="submit">Entrar</button>
		    </form>
		    
		    <hr class="featurette-divider">
    	</div> <!-- /container -->
		
	    <!-- FOOTER -->
	    <footer class="container">
	    	<p>&copy; 2017 Jonathan Romualdo & Allan Santos &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
	    </footer>
	    
		<!-- Bootstrap's scripts -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>