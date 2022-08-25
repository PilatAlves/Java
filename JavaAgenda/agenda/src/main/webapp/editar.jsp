<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="pt-br">
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="testedois.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form action="update" name="frmContato">
		<table class="form">
			<tr>
				<td><input type="text" name="idcon" id="Caixa3"
					readonly
					value="<%out.println(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.println(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="telefone" class="Caixa2"
					value="<%out.println(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1"
					value="<%out.println(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" class="Botao1" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>