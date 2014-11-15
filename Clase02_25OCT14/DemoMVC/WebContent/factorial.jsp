<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/estilos.css">
<title>Index</title>
</head>
<body>
	<div class="CABECERA">
		<jsp:include page="cabecera.jsp"/>
	</div>
	<div class="WORK">
		<h1>CALCULO DE FACTORIAL</h1>
		<hr/>
		<!-- Formulario -->
		<form action="FactorialControl">
			<label>Número:</label>
			<input type="text" name="num" 
					size="8" maxlength="8"/>
			<input type="submit" value="Procesar">
		</form>
		<hr/>
		<!-- Respuesta -->
		<% if(request.getAttribute("repo") != null) { %>
		<p><%= request.getAttribute("repo") %></p>
		<hr/>
		<% } %>
		<!-- Respuesta -->
		<% if(request.getAttribute("error") != null) { %>
		<p class="error"><%= request.getAttribute("error") %></p>
		<hr/>
		<% } %>
	</div>
</body>
</html>