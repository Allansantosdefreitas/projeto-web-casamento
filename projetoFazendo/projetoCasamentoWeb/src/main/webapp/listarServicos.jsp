<%@include file="includes/sessaoPaginaInterna.jsp" %> 
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Servico"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

	ServicoRepository servicoRepository = new ServicoRepository();

	String tipoUsuario = (String) sessao.getAttribute("tipoUsuario");
	
	if (tipoUsuario.equals( "profissional") ){
		// pega o id do profissional
		Long idProfissional = (Long) sessao.getAttribute("idUsuario");
		// seta a lista com os serviços desse tal profissional
		List<Servico> listaServicos = servicoRepository.listarServicosPorProfissional(idProfissional);
		request.setAttribute("listaServicos", listaServicos);
	}
	/* Para conjuge e convidado */
	else{
		
		List<Servico> listaServicos = servicoRepository.listar();
		request.setAttribute("listaServicos", listaServicos);
	}
	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Serviços</title>
		
		<!-- Bootstrap's styles -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	
	<body>
	
		<!-- Navbar -->
		<c:import url="/templates/navbar.jsp"/>
		
		<div class="container">
			<h2>Serviços disponíveis </h2>
			
			<br/>
			<br/>
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
	        	<thead>
	        	<% 
	        		if (tipoUsuario.equals( "profissional") ){
	        		
	        	%>
	        	<button type="button"
					onclick="window.location.href = 'adicionarServico.jsp'"
					class="btn btn-success btn-sm">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					Cadastrar Servico
				</button>
				<br/>
				 <br/>
		        
				<% 
					}
				%>
				 
		            <tr>
		                <th>Título</th>
		                <th>Descrição</th>
		                <th>Preço</th>
		                <th>Opções</th>
		            </tr>
	            </thead>
		        <tbody>
		            <c:forEach items="${listaServicos}" var="servico">
		                <tr class="odd gradeX">
		                    <td> <c:out value="${servico.titulo}"/></td>
		                    <td> <c:out value="${servico.descricao}"/></td>
		                    <td> R$ <c:out value="${servico.preco}"/></td>
		                   
		                   <%
		                   	if (sessao.getAttribute("tipoUsuario").equals("conjuge")) {
		                   
		                    %>
		                    <td align="center"><font color="blue">
		                        <form action="ContratarServicoServlet" method="POST">
		                            <input type="hidden" value="${servico.idServico}" name="idServico">
		                            <button type="submit" class="btn btn-default btn-sm">
		                                <a href="#"><font color="blue">
		                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></font>Contratar 
		                                </a>
		                            </button>
		                        </form>
		                    </td>
		                    <%
		                    }else { /* Se for profissional */
		                    
		                    %>
		                     <td align="center"><font color="blue">
								<form action="BuscarServicoServlet" method="POST">
									<input type="hidden" value="${servico.idServico}"
										name="idServico">
									<button type="submit" class="btn btn-default btn-sm">
										<font color="black"> <span
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span></font>
											Editar </a>
									</button>
								</form>
								<form action="DeletarServicoServlet" method="POST">
									<input type="hidden" value="${servico.idServico}"
										name="idServico">
									<button type="submit" class="btn btn-danger btn-sm">
										<font color="white"> <span
												class="glyphicon glyphicon-trash" aria-hidden="true"></span></font>
											Excluir </a>
									</button>
								</form></td>
		                    
		                    <%
		                    }
		                    %>
		                </tr>
		            </c:forEach>
		        </tbody>
			</table>
		</div>
		
		<!-- Bootstrap's scripts -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>