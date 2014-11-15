<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.nombre == null}">
	<jsp:forward page="index.jsp"/>
</c:if>
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
		<c:if test="${requestScope.repo != null }">
			<p>${requestScope.repo}</p>
			<hr/>
		</c:if>
		<!-- Respuesta -->
		<c:if test="${requestScope.error != null }">
			<p class="error">${requestScope.error}</p>
			<hr/>
		</c:if>
	</div>
</body>
</html>