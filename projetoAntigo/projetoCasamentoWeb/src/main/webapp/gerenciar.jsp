<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bem-vindo ao WeddingWeb!</title>
		
		<!-- Bootstrap's styles -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
		
		<!-- CArousel stylesheet -->
		<link rel="stylesheet" href="css/carousel.css" />
	</head>
	
	<body>
		<header>
	    	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	        	<a class="navbar-brand" href="index.jsp">WeddingWeb</a>
	        	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	        		<span class="navbar-toggler-icon"></span>
	        	</button>
		        <div class="collapse navbar-collapse" id="navbarCollapse">
		        	<ul class="navbar-nav mr-auto">
			            <li class="nav-item active">
			            	<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="listarServicos.jsp">Serviços</a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="listarConvidados.jsp">Convites</a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="listarTarefas.jsp">Tarefas</a>
			            </li>
		          	</ul>
		          	<form class="form-inline mt-2 mt-md-0">
		            	<a class="btn btn-primary my-2 my-sm-0" href="login.jsp">Login</a>
		          	</form>
		        </div>
	    	</nav>
	    </header>
	
	    	<!-- FOOTER -->
		    <footer class="container">
		    	<p class="float-right"><a href="#">Ir para o topo</a></p>
		    	<p>&copy; 2017 Jonathan Romualdo & Allan Santos &middot; <!--<a href="#">Privacy</a> &middot; <a href="#">Terms</a>--></p>
		    </footer>
	    </main>
    
		<!-- Bootstrap's scripts -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>