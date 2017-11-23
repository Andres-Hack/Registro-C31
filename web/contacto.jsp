<%-- 
    Document   : buscar
    Created on : 18-01-2017, 10:50:25 AM
    Author     : andres
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://pmgmc2.oopp.gob.bo/pmgm/templates/four-html/images/escudo.png">

    <title>Inicio</title>
    

    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    
    <script src="./js/ie-emulation-modes-warning.js"></script>
    <link href="./css/carousel.css" rel="stylesheet">

  </head>
  <body>
    <% if(true){ %>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="http://10.0.6.183:8084/registroC31/caratula.jsp">PMGM - CII</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="http://10.0.6.183:8084/registroC31/caratula.jsp">Inicio</a></li>
                <li><a href="#">Preguntas</a></li>
                <li><a href="#">Contactos</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Registro<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="http://10.0.6.183:8084/registroC31/inicio.jsp">Registro</a></li>
                    <li><a href="http://10.0.6.183:8084/registroC31/buscar.jsp">Reportes</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="CTRLSalir">Salir</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="https://i.ytimg.com/vi/3WzRBS5Act0/maxresdefault.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Programa de Mejora de la Gestion Municipal</h1>
              <p>Ministerio de Obras Publicas Srvicios y Viviendas</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="https://i.ytimg.com/vi/ljnzSj6XqNU/maxresdefault.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Programa de Mejora de la Gestion Municipal</h1>
              <p>Ministerio de Obras Publicas Srvicios y Viviendas</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="https://platomundo.files.wordpress.com/2015/03/cav9uekwcaa6-hd-1.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Programa de Mejora de la Gestion Municipal</h1>
              <p>Ministerio de Obras Publicas Srvicios y Viviendas</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="http://getbootstrap.com/examples/carousel/#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Anterior</span>
      </a>
      <a class="right carousel-control" href="http://getbootstrap.com/examples/carousel/#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Siguiente</span>
      </a>
    </div>

    <div class="container marketing">
      <div class="row featurette">
          <div class="col-md-8">
              <iframe src="https://www.google.com/maps/embed?pb=!1m19!1m8!1m3!1d1912.7686915158288!2d-68.1356258!3d-16.4989463!3m2!1i1024!2i768!4f13.1!4m8!3e6!4m0!4m5!1s0x915f20711b41a413%3A0xc47739fba9ff4689!2sAvenida+Mariscal+Santa+Cruz%2C+La+Paz%2C+Bolivia!3m2!1d-16.499242499999998!2d-68.1349127!5e0!3m2!1ses-419!2sar!4v1505940695517" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
          </div>
        <div class="col-md-4">  
            
          <h2 class="featurette-heading">Contactenos. </h2>
          <p class="lead"><span class="glyphicon glyphicon-ok-circle" ></span> Telef: (591)-2 2121075 - 2124638.</p>
          <p class="lead"><span class="glyphicon glyphicon-globe" ></span> Dirección: Av. Mariscal Santa Cruz, Esq. Calle Oruro, Edif. Centro de Comunicaciones La Paz - 4to piso.</p>
        </div>
        
      </div>
        
      <hr class="featurette-divider">

      <footer>
          <p>© 2017 Programa de Mejora de la Gestion Municipal,  <a href="http://pmgmc2.oopp.gob.bo" target="_blank">PMGM-CII</a> · <a href="https://www.oopp.gob.bo" target="_blank">MOPSV</a></p>
      </footer>

    </div>

    <script src="./js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/holder.min.js"></script>
    <script src="./js/ie10-viewport-bug-workaround.js"></script>


    <svg xmlns="http://www.w3.org/2000/svg" width="500" height="500" viewBox="0 0 500 500" preserveAspectRatio="none" style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs><style type="text/css"></style></defs><text x="0" y="25" style="font-weight:bold;font-size:25pt;font-family:Arial, Helvetica, Open Sans, sans-serif">500x500</text></svg>
    <% } %>
</body>
</html>