<!--  <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>


<title>Login</title>


    <link rel="stylesheet" href="css/reset.css">

    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="css/style.css">
</head>
<body>

</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="form">
    <h2>Login to your account</h2>
    <form>
      <input type="text" placeholder="Username"/>
      <input type="password" placeholder="Password"/>
      <button>Login</button>
    </form>
  </div>
	<form method="post" action="LoginServlet">
		Login: <input name="userName" type="text"> <br> 
		Senha: <input name="password" type="password"><br>
		<a href="UsuarioController.do?action=inserir">Não possui Cadastro?</a> 
		<input type="submit" value="Enviar">
	</form>
	<c:out value="${erro}" />
</body>
</html> 

