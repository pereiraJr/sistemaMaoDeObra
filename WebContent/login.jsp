<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/style.css">
  </head>
  <body>

    <div class="form">
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Cadastro	</a></li>
        <li class="tab"><a href="#login">Logar</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="cadastro">   
          <h1>Cadastre-se</h1>
          <form action="UsuarioController.do" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Nome<span class="req">*</span>
              </label>
              <input type="text"
                    name="nome" value="<c:out value="${usuario.nome}" />"
                     required autocomplete="off" /><br>
            </div>
        
          </div>

          <div class="field-wrap">
            <label>
              Telefone<span class="req">*</span>
            </label>
            <input type="text" name="telefone" value="<c:out value="${usuario.telefone}" />"
                     required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Endereco<span class="req">*</span>
            </label>
            <input type="text" name="endereco"
                    value="<c:out value="${usuario.endereco}" />" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email" name="email"
                    value="<c:out value="${usuario.email}" />"  required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Login<span class="req">*</span>
            </label>
            <input type="text" name="login"
                    value="<c:out value="${usuario.login}" />" required autocomplete="off" />
          </div>
          
           <div class="field-wrap">
            <label>
              Senha<span class="req">*</span>
            </label>
            <input type="password" name="senha"
                    value="<c:out value="${usuario.senha}" />" required autocomplete="off" />
          </div>
          
          <button type="submit" class="button button-block">Cadastrar</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Bem Vindo!</h1>
          
          <form action="LoginServlet" method="post">
          
            <div class="field-wrap">
            <label>
              Login	<span class="req">*</span>
            </label>
            <input name="userName" type="text"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Senha<span class="req">*</span>
            </label>
            <input name="password" type="password" required autocomplete="off"/>
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <button class="button button-block">Log In</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
