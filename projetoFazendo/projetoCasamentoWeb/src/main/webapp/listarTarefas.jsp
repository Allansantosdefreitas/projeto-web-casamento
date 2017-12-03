<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.model.StatusTarefa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.ifpe.tads.projetoCasamentoWeb.repository.TarefaRepository"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
	

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	//HttpSession sessao = request.getSession();
	//List<Tarefa> listaTarefas = (List<Tarefa>) sessao.getAttribute("listaTarefas");

	//request.setAttribute("listaTarefas", listaTarefas);
	HttpSession sessao = request.getSession();

	List<Tarefa> listaTarefas;
	TarefaRepository tarefaRepository = new TarefaRepository();

	//Popula a lista utilizando como apoio o Dao de usuário
//	listaTarefas = tarefaRepository.listar();
	
	Long idCasamento = (Long) sessao.getAttribute("idCasamento");
	
	listaTarefas = tarefaRepository.listarTarefasPorCasamento(idCasamento);

	//Passa a lista com um atributo de sesssão e retorna para a página de gerencia
	sessao.setAttribute("listaTarefas", listaTarefas);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Tarefas</title>

<!-- Bootstrap's styles -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<body>

	<!-- Navbar -->
	<c:import url="/templates/navbar.jsp" />

	<div class="container">
		<h2>Listar Tarefas para o casamento</h2>

		<table width="100%"
			class="table table-striped table-bordered table-hover"
			id="dataTables-example">
			<thead>
				<button type="button"
					onclick="window.location.href = 'adicionarTarefas.jsp'"
					class="btn btn-outline-primary btn-sm">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					Cadastrar Tarefa
				</button>
				<br />
				<br />
				<tr>
					<th>Título</th>
					<th>Descrição</th>
					<th>Data</th>
					<th>Status</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaTarefas}" var="tarefa">
					<tr class="odd gradeX">
						<td><c:out value="${tarefa.titulo}" /></td>
						<td><c:out value="${tarefa.descricao}" /></td>
						<td><c:out value="${tarefa.data}" /></td>
						<td><c:out value="${tarefa.status}" /></td>
						<td align="center"><font color="blue">
								<form action="EditarTarefaServlet" method="POST">
									<input type="hidden" value="${tarefa.idTarefa}"
										name="idDespesa">
									<button type="submit" class="btn btn-default btn-sm">
										<a href="#"><font color="blue"> <span
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span></font>
											Editar </a>
									</button>
								</form>
								<form action="DeletarTarefaServlet" method="POST">
									<input type="hidden" value="${tarefa.idTarefa}"
										name="idDespesa">
									<button type="submit" class="btn btn-default btn-sm">
										<a href="#"><font color="blue"> <span
												class="glyphicon glyphicon-trash" aria-hidden="true"></span></font>
											Excluir </a>
									</button>
								</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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