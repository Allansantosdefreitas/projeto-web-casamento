<%@include file="includes/sessaoPaginaInterna.jsp" %> 
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.repository.ServicoRepository"%>
<%@page import="java.util.List"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String nome = "allan";

	Long idServico =  (Long) sessao.getAttribute("idServico");
	ServicoRepository servicoRepository = new ServicoRepository();
	
	// Pega o serviço pelo id recebido da outra página, pelo att da sessão
	Servico servico = servicoRepository.buscar(idServico);

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Editar Serviço</title>
		
		<!-- Bootstrap's styles -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	
	<body>
	
		<!-- Navbar -->
		<c:import url="/templates/navbar.jsp"/>
		
		<div class="container">
			<h2>Editar Serviço</h2>
			
			<form method="post" action="EditarServicoServlet">
			
				<div class="form-group">
					<label>Título do serviço: </label>
					<input class="form-control" type="text" name="titulo" value=" <%= servico.getTitulo() %>" />
				</div>
				
				<div class="form-group">
					<label>Descrição: </label>
					<input class="form-control" type="text" name="descricao" value="<%= servico.getDescricao() %>"/>
				</div>
				
				<div class="form-group">
					<label>Preço (R$): </label>
					<input class="form-control" type="number" name="preco" value="<%= servico.getPreco() %>"/>
				</div>
				
								
				<div class="form-group">
					<button class="btn btn-success" type="submit">Salvar</button>
					<button class="btn btn-default" type="reset">Limpar</button>
					<a href="listarServicos.jsp" class="btn btn-default" role="button">Voltar</a>
			
			</form>	
		</div>
		
		<!-- Bootstrap's scripts -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>