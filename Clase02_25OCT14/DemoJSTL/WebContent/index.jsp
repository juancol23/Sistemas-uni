<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INICIO DE SESION</title>
</head>
<body>
	<form action="LogonIngresar">
		<h1>INICIO DE SESION</h1>
		<label>Nombre:</label><br/>
		<input type="text" name="nombre" /><br/><br/>
		<input type="submit" value="Ingresar" />
	</form>	
	<c:if test="${requestScope.error != null }">
		<p>${requestScope.error}</p>
	</c:if>
</body>
</html>