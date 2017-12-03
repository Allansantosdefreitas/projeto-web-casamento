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
			            	<a class="nav-link" href="cadastrarCasamento.jsp">Cadastro</a>
			            </li>
			            <li class="nav-item">
			            	<a class="nav-link" href="gerenciar.jsp">Casamento</a>
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

    	<main role="main">
			
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
		        <ol class="carousel-indicators">
		        	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		        	<li data-target="#myCarousel" data-slide-to="1"></li>
		       		<li data-target="#myCarousel" data-slide-to="2"></li>
		        </ol>
	        	
	        	<div class="carousel-inner">
	          		<div class="carousel-item active">
	            		<img class="first-slide" src=" <c:url value="/images/imagem.jpg"/> " alt="First slide">
			            <div class="container">
			            	<div class="carousel-caption text-left">
				                <h1>Uma cerim�nia sem igual.</h1>
				                <p>� isso que achamos de uma cerim�nia de casamento, um momento �nico e especial e que deve ser executado com maestria. Portanto deixe-nos cuidar de tudo pra voc�.</p>
				                <p><a class="btn btn-lg btn-primary" href="#" role="button">Fa�a seu cadastro!</a></p>
			            	</div>
			            </div>
	          		</div>
		          	<div class="carousel-item">
			          	<img class="second-slide" src=" <c:url value="/images/imagem2.jpg"/> " alt="Second slide">
			          	<div class="container">
				          	<div class="carousel-caption">
					          	<h1>Muitas tarefas?</h1>
					          	<p>O WeddingWeb gerencia suas tarefas para que voc� esteja focado no que realmente interessa, poupando-lhe o tempo.</p>
					          	<p><a class="btn btn-lg btn-primary" href="#" role="button">Fa�a seu cadastro!</a></p>
				          	</div>
			          	</div>
		          	</div>
			    	<div class="carousel-item">
				    	<img class="third-slide" src=" <c:url value="/images/imagem3.jpg"/> " alt="Third slide">
				    	<div class="container">
					    	<div class="carousel-caption text-right">
						    	<h1>E as despesas?</h1>
						    	<p>O WeddingWeb gerencia a contrata��o de profissionais e servi�os, possibilitanto ainda o acompanhamento de seus gastos com a cerim�nia.</p>
						    	<p><a class="btn btn-lg btn-primary" href="#" role="button">Fa�a seu cadastro!</a></p>
					    	</div>
				    	</div>
			    	</div>
	        	</div>
		        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
		        	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		        	<span class="sr-only">Previous</span>
		        </a>
		        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
		        	<span class="carousel-control-next-icon" aria-hidden="true"></span>
		        	<span class="sr-only">Next</span>
	        	</a>
			</div>
	
	
		    <!-- Marketing messaging and featurettes
		    ================================================== -->
		    <!-- Wrap the rest of the page in another container to center all the content. -->
	
	    	<div class="container marketing">
		        <!-- Three columns of text below the carousel -->
		        <div class="row">
	        		<div class="col-lg-4">
				        <img class="rounded-circle" src=" <c:url value="/images/servico.jpg"/> " alt="Generic placeholder image" width="140" height="140">
				        <h2>Buffet</h2>
				        <p>Crie tarefas, como o buffet, por exemplo, descreva-as, estabele�a prazos e, se necess�rio, relacione aos servi�os. Quanto ao mais, nem se preocupe: Tudo estar� bem organizado.</p>
				        <p><a class="btn btn-secondary" href="#" role="button">Ver mais &raquo;</a></p>
        		 	</div><!-- /.col-lg-4 -->
			        <div class="col-lg-4">
				        <img class="rounded-circle" src=" <c:url value="/images/servico2.jpg"/> " alt="Generic placeholder image" width="140" height="140">
				        <h2>Convites</h2>
				        <p>Gerencie sua lista de convidados, envie links para os mesmos se cadastrarem e confirmarem presen�a na sua cerim�nia.</p>
				        <p><a class="btn btn-secondary" href="#" role="button">Ver mais &raquo;</a></p>
			        </div><!-- /.col-lg-4 -->
		          	<div class="col-lg-4">
		            	<img class="rounded-circle" src=" <c:url value="/images/servico3.jpg"/> " alt="Generic placeholder image" width="140" height="140">
		            	<h2>Decora��o</h2>
		            	<p>Na hora de contratar servi�os de profissionais, como a decora��o, n�o se preocupe. O WeddingWeb permique que voc� vincule suas tarefas aos diversos servi�os disponibilizados por profissionais, contrate servi�os e fique por dentro do que est� acontecendo. Quanto ao or�amento, gerenciamos tudo pra voc�.</p>
		            	<p><a class="btn btn-secondary" href="#" role="button">Ver mais  &raquo;</a></p>
		        	</div><!-- /.col-lg-4 -->
	        	</div><!-- /.row -->
	
		        <!-- START THE FEATURETTES -->
		        <hr class="featurette-divider">
	
		        <div class="row featurette">
			        <div class="col-md-7">
				        <h2 class="featurette-heading">Gerencie todas as tarefas. <span class="text-muted">Tudo sob controle</span></h2>
				        <p class="lead">Crie tarefas, descreva-as, estabele�a prazos e, se necess�rio, relacione aos servi�os. Quanto ao mais, nem se preocupe: Tudo estar� bem organizado.</p>
			        </div>
			        <div class="col-md-5">
			        	<img class="featurette-image img-fluid mx-auto" src="images/servico3.jpg" alt="Generic placeholder image">
			        </div>
		        </div>
	
	        	<hr class="featurette-divider">
	
		        <div class="row featurette">
				    <div class="col-md-7 order-md-2">
				    	<h2 class="featurette-heading">Convites? <span class="text-muted">Convidados?</span></h2>
				    	<p class="lead">Gerencie sua lista de convidados, envie links para os mesmos se cadastrarem e confirmarem presen�a na sua cerim�nia de maneira bem simples, sem complica��o.</p>
				    </div>
				    <div class="col-md-5 order-md-1">
				    	<img class="featurette-image img-fluid mx-auto" src="images/servico2.jpg" alt="Generic placeholder image">
				    </div>
		        </div>
	
	        	<hr class="featurette-divider">
	
	        	<div class="row featurette">
	            	<div class="col-md-7">
	            		<h2 class="featurette-heading">E os servi�os?<span class="text-muted">e os profissionais?</span></h2>
	            		<p class="lead">Na hora de contratar servi�os para sua cerim�nia, o WeddingWeb permique que voc� vincule suas tarefas aos diversos servi�os disponibilizados por profissionais, contrate servi�os e fique por dentro do que est� acontecendo, incluindo o or�amento, gerenciamos tudo pra voc�.</p>
	          		</div>
	          		<div class="col-md-5">
	            		<img class="featurette-image img-fluid mx-auto" src="images/servico_buffet.jpg" alt="Generic placeholder image">
	          		</div>
	        	</div>
	
	        	<hr class="featurette-divider">
	
	        <!-- /END THE FEATURETTES -->
	        </div><!-- /.container -->
	
	
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