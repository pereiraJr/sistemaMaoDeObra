<!DOCTYPE html >
<html>
<%@page import="sistema.model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>HOME</title>
<jsp:useBean id="user" class="sistema.model.Usuario" scope="session" />
</head>
<body>
	Bem vindo,
	<c:out value="${user.login}"  />
</body>
</html>