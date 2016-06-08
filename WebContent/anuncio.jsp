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
    <form action="AnuncioController.do" method="post">
        <fieldset>
            <div>
                <label for="anuncioId">ID Anuncio </label> <input type="text"
                    name="anuncioId" value="<c:out value="${anuncio.anuncioId}" />"
                    readonly="readonly" placeholder="Anuncio ID" />
            </div>
            <div>
                <label for="titulo">Titulo </label> <input type="text"
                    name="titulo" value="<c:out value="${anuncio.titulo}" />"
                    placeholder="Titulo" />
            </div>
            <div>
                <label for="descricao">Descricao</label> 
                                    <textarea  id='descricao' name='descricao' id='descricao'><c:out value="${anuncio.descricao}" /> </textarea> 
            </div>
            <div>
                <input type="submit" value="Enviar" />
            </div>
        </fieldset>
    </form>
</body>
</html>