<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form method="post" action="Autenticador">
		Login: <input name="login" type="text"> <br> 
		Senha: <input name="senha" type="password"><br>
		<a href="UsuarioController.do?action=inserir">Não Tenho Conta! </a> 
		<input type="submit" value="Entrar">
	</form>
</body>
</html>