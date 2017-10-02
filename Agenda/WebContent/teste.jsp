<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Teste</title>
<style>
html{
background:  url(https://media3.giphy.com/media/3ov9k9vVSTn6DevZsY/giphy.gif) no-repeat center center fixed; 
  background-size: cover;
}

body{
	font-family: Helvetica;
 	color: #fff;
    text-shadow: 1px 1px 5px black;
}
h1{
	margin-top: 400px;
	text-align: center;
}

input{
	margin-top: 10px;
	box-shadow: 1px 1px 4px black;
}

.btnSalvar{
	margin-top: -10px;
	box-shadow: 1px 1px 1px black;
}

</style>
</head>
<body>
	<h1>
	<%
		String mensagem = "Testando"; 
		out.println(mensagem);
	%>
	</h1>
</body>
</html>