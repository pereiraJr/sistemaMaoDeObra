<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form method="post" action="LoginServlet">
		Login: <input name="userName" type="text"> <br> 
		Senha: <input name="password" type="password"><br> 
		<input type="submit">
	</form>
	<c:out value="${erro}" />
</body>
</html>