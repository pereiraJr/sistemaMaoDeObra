<!DOCTYPE html >
<html>
<%@page import="br.ucsal.web.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>HOME</title>
<jsp:useBean id="user" class="br.ucsal.web.Usuario" scope="session" />
</head>
<body>
	Bem vindo,
	<c:out value="${user.login}" />
</body>
</html>