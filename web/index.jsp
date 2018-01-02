
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <link rel="icon" type="image/png" href="./img/logo.png" />
  <title>Ingreso</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel="stylesheet" href="css/style4.css">
</head>
<body>
  <div class="form">
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Aréa Financiera</a></li>
        <li class="tab"><a href="#login">Aréa Técnica</a></li>
      </ul>
      <div class="tab-content">
        <div id="signup">
          <h1>Registro C-31</h1>
          <form action="CTRLUsuario">
          <div class="field-wrap">
            <label>
              Usuario<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" name="txtusuario"/>
          </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="txtcontra"/>
          </div>
          <button type="submit" class="button button-block"/>INGRESAR</button>
          </form>
        </div>
        <div id="login">
          <h1>Ficha de Control</h1>
          <form action="CTRLUsuario2">
            <div class="field-wrap">
            <label>
              Usuario<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" name="usuario"/>
          </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="password"/>
          </div>
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          <button class="button button-block" id="tecnica"/>Ingresar</button>
          </form>
        </div>
      </div><!-- tab-content -->
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>


