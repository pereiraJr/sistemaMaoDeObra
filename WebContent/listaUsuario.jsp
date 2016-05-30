<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos os Registros</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>ID Usuario</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Endereco</th>
                <th>Email</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.usuarioId}" /></td>
                    <td><c:out value="${usuario.nome}" /></td>
                    <td><c:out value="${usuario.telefone}" /></td>
                    <td><c:out value="${usuario.endereco}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><a
                        href="UsuarioController.do?action=editar&usuarioId=<c:out value="${usuario.usuarioId }"/>">Alterar</a></td>
                    <td><a
                        href="UsuarioController.do?action=deletar&usuarioId=<c:out value="${usuario.usuarioId }"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="UsuarioController.do?action=inserir">Adicionar Usuario</a>
    </p>
</body>
</html>