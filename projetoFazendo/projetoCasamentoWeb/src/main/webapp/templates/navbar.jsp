<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="index2.jsp">WeddingWeb</a>
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	    	<li class="nav-item active">
	        	<a class="nav-link" href="index2.jsp">Home <span class="sr-only">(current)</span></a>
	      	</li>
	      	<li class="nav-item">
	        	<a class="nav-link" href="cadastrarCasamento.jsp">Casamento</a>
	      	</li>
	      	<c:if test="not empty pageContext.request.userPrincipal">
		      	<li class="nav-item">
		        	<a class="nav-link" href="listarTarefas.jsp">Tarefas</a>
		      	</li>
	      	</c:if>
	    </ul>
	    
	    <form class="form-inline my-2 my-lg-0">
	    	
	    	<a class="btn btn-outline-success my-2 my-sm-0" href="login.jsp">Login</a>
	    </form>
	</div>
</nav>