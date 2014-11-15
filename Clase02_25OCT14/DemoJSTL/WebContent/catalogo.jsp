<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1>CATALOGO</h1>
		<hr/>
		<table border="1">
			<tr>
				<th>CODIGO</th>
				<th>NOMBRE</th>
				<th>PRECIO</th>
			</tr>
			<c:forEach items="${requestScope.lista}" var="r">
				<tr>
					<td>${r.id}</td>
					<td>${r.nombre}</td>
					<td>${r.precio}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>