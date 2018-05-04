
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
  <style>
      .panel {
        display: inline-block;
        background: #ffffff;
        min-height: 45px;
        height: 45px;
        padding: 10px;
      }
      .panel2 {
        min-width: 245px;
        width: 80%;
      }
  </style>
</head>
<body>
  <div class="form">
      <center><img src="./img/logo.png" width="235" class="img-responsive"></center>
      <div class="tab-content">
        <div id="signup">
          <h1>Sistema Financiero</h1>
          <form action="CTRLUsuario">
          <div class="field-wrap">
            <label>
              Usuario&nbsp;<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" name="txtusuario"/>
          </div>
          <div class="field-wrap">
            <label>
              Password&nbsp;<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="txtcontra"/>
          </div>
          <button type="submit" class="button button-block"/>INGRESAR</button>
          </form>
          <br />
          <div class="panel panel2">
              <img src="./img/Chrome.png" width="5%" class="img-responsive" style="text-align: "></img>&nbsp;<i> Se lo recomienda ingresar con navegador Chrome.</i>
          </div>
        </div
        <div id="login">
          <form action="CTRLUsuario2">

          </form>
        </div> 
      </div><!-- tab-content -->
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script  src="js/index.js"></script>
</body>
</html>


