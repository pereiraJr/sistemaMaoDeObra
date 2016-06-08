<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos os Anuncios</title>
</head>
<body>

    <table border="1">
        <thead>
            <tr>
                <th>ID Anuncio</th>
                <th>Titulo</th>
                <th>Descricao</th>
                <th colspan="2">Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${anuncios}" var="anuncio">
                <tr>
                    <td><c:out value="${anuncio.anuncioId}" /></td>
                    <td><c:out value="${anuncio.titulo}" /></td>
                    <td><c:out value="${anuncio.descricao}" /></td>
                    <td><a
                        href="AnuncioController.do?action=editar&anuncioId=<c:out value="${anuncio.anuncioId }"/>">Alterar</a></td>
                    <td><a
                        href="AnuncioController.do?action=deletar&anuncioId=<c:out value="${anuncio.anuncioId }"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="AnuncioController.do?action=inserir">Adicionar Anuncio</a>
    </p>
</body>
</html>