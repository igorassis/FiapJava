<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
	<form action="/CalculadoraServlet" method="post">
		<fieldset>
			<legend>Digite os numeros e escolha a operação</legend>
			<label>Número 1:</label>
			<input type="text" name="valor1"></input>
			<label>Número 2:</label>
			<input type="text" name="valor2"></input>
			<select name="op">
				<option>Somar</option>
				<option>Subtrair</option>
				<option>Dividir</option>
				<option>Multiplicar</option>
			</select>
			<input type="submit" value="Calcular">
		</fieldset>
	</form>
</body>
</html>