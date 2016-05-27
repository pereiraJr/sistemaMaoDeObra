<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Adicionar Novo estudante</title>
</head>
<body>
    <form action="UsuarioController.do" method="post">
        <fieldset>
            <div>
                <label for="studentId">ID Usuario </label> <input type="text"
                    name="usuarioId" value="<c:out value="${usuario.usuarioId}" />"
                    readonly="readonly" placeholder="Student ID" />
            </div>
            <div>
                <label for="firstName">Nome </label> <input type="text"
                    name="nome" value="<c:out value="${usuario.nome}" />"
                    placeholder="Primeiro Nome" />
            </div>
            <div>
                <label for="lastName">Telefone</label> <input type="text"
                    name="telefone" value="<c:out value="${usuario.telefone}" />"
                    placeholder="telefone" />
            </div>
            <div>
                <label for="course">Curso</label> <input type="text" name="endereco"
                    value="<c:out value="${usuario.endereco}" />" placeholder="Endereco" />
            </div>
            <div>
                <label for="year">Email</label> <input type="text" name="email"
                    value="<c:out value="${usuario.email}" />" placeholder="email" />
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </fieldset>
    </form>
</body>
</html>