<%@include file="includes/sessaoPaginaInterna.jsp" %> 
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.repository.UsuarioRepository"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%


	
	//request.setAttribute("listaServicos", listaServicos);

	UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	// Pegar o usu�rio da sessao (conjuge, profissional ou convidado)..mostar dados b�sicos..nada de mais
	//Usuario usuario = usuarioRepository.buscar(idUsuario);
	

	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Servi�os</title>
		
		<!-- Bootstrap's styles -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	
	<body>
	
		<!-- Navbar -->
		<c:import url="/templates/navbar.jsp"/>
		
		<div class="container">
			<h2>Servi�os dispon�veis </h2>
			
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
	        	<thead>
		            <br/>
		            <br/>
		            <tr>
		                <th>T�tulo</th>
		                <th>Descri��o</th>
		                <th>Pre�o</th>
		                <th>Op��es</th>
		            </tr>
	            </thead>
		        <tbody>
		            <c:forEach items="${listaServicos}" var="servico">
		                <tr class="odd gradeX">
		                    <td> <c:out value="${servico.titulo}"/></td>
		                    <td> <c:out value="${servico.descricao}"/></td>
		                    <td> <c:out value="${servico.preco}"/></td>
		                   
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