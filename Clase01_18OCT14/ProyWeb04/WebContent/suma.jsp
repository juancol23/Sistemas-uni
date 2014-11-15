<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMAR</title>
<style type="text/css">
body{
	background-color: #A4A4A4;
}

#PAGE{
	color: #08298A;
	background-color: #E0F8F1;
	width: 300px;
	margin: 10px auto;
	padding: 10px;
}
</style>
</head>
<body>
	<div id="PAGE">
		<h1>SUMAR</h1>
		
		<!-- FORMULARIO -->
		<form action="Sumadora">
			<fieldset>
				<legend>Datos</legend>
				<label>Número 1:</label><br/>
				<input type="text" name="num1" /><br/>
				<label>Número 2:</label><br/>
				<input type="text" name="num2" /><br/><br/>
				<input type="submit" name="btnProcesar" 
								value="Procesar" />
			</fieldset>
		</form>
		
		<!-- REPORTE -->
		<% if( request.getAttribute("suma") != null ){ %>
			<br/>
			<fieldset>
				<legend>Reporte</legend>
				<p>Número 1: <%=request.getAttribute("n1")%></p>	
				<p>Número 2: <%=request.getAttribute("n2")%></p>	
				<p>Suma: <%=request.getAttribute("suma")%></p>	
			</fieldset>
		<% } %>
		
	</div>
</body>
</html>