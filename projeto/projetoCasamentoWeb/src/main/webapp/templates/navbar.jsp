<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="index.jsp">WeddingWeb</a>
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	    	<li class="nav-item active">
	        	<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
	      	</li>
	      	<li class="nav-item">
	        	<a class="nav-link" href="cadastrarCasamento.jsp">Casamento</a>
	      	</li>
	      	<c:if test="not empty pageContext.request.userPrincipal">
		      	<li class="nav-item">
		        	<a class="nav-link" href="listarrTarefas.jsp">Tarefas</a>
		      	</li>
	      	</c:if>
	    </ul>
	    
	    <form class="form-inline my-2 my-lg-0">
	    	<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
	    	<a class="btn btn-outline-success my-2 my-sm-0" href="login.jsp">Login</a>
	    </form>
	</div>
</nav>