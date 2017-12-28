<%-- 
    Document   : buscar
    Created on : 18-01-2017, 10:50:25 AM
    Author     : andres
--%>

<%@page import="java.util.Random"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="http://pmgmc2.oopp.gob.bo/pmgm/templates/four-html/images/escudo.png">
        <title>Inicio</title>
    
    <%
        String consulta = null, consulta1 = null, consulta2 = null, consulta3 = null, consulta4 = null, consulta5 = null,
                consulta6 = null, consulta7 = null, consulta8 = null, consulta9 = null, consulta10 = null, consulta11 = null;
        boolean sw;
        
        String log = request.getParameter("log");
        String id2 = request.getParameter("id2");
        int y12 = Integer.parseInt(request.getParameter("id"));

        Connection con = DBConexion.IniciarSesion();
        
        Random rnd = new Random();
        String xxx = Integer.toString(rnd.nextInt());

        consulta ="SELECT * FROM personal WHERE log='"+log+"'";                            
        consulta1 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='TOR'";
        consulta2 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='POT'";
        consulta3 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='CBB'";
        consulta4 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='COB'";
        consulta5 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='EAL'";
        consulta6 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='ORU'";
        consulta7 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='TAR'";
        consulta8 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='SAC'";
        consulta9 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='SER'";
        consulta10 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='TDD'";
        consulta11 = "SELECT SUM(importe) FROM tabla_c31 where gam_uep='VIA'";

                                        
        ResultSet rs = null, rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null, rs7 = null, rs8 = null, 
                rs9 = null, rs10 = null, rs11 = null;
        PreparedStatement pst = null, pst1 = null, pst2 = null, pst3 = null, pst4 = null, pst5 = null, pst6 = null, pst7 = null,
                pst8 = null, pst9 = null, pst10 = null, pst11 = null;
        pst1 = con.prepareStatement(consulta1); pst5 = con.prepareStatement(consulta5); pst9 = con.prepareStatement(consulta9);
        pst2 = con.prepareStatement(consulta2); pst6 = con.prepareStatement(consulta6); pst10 = con.prepareStatement(consulta10);
        pst3 = con.prepareStatement(consulta3); pst7 = con.prepareStatement(consulta7); pst11 = con.prepareStatement(consulta11);
        pst4 = con.prepareStatement(consulta4); pst8 = con.prepareStatement(consulta8);
        pst  = con.prepareStatement(consulta);

        rs1 = pst1.executeQuery(); rs4 = pst4.executeQuery(); rs7 = pst7.executeQuery(); rs10 = pst10.executeQuery();
        rs2 = pst2.executeQuery(); rs5 = pst5.executeQuery(); rs8 = pst8.executeQuery(); rs11 = pst11.executeQuery();
        rs3 = pst3.executeQuery(); rs6 = pst6.executeQuery(); rs9 = pst9.executeQuery(); 
        rs = pst.executeQuery();
        
        float y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0, y6 = 0, y7 = 0, y8 = 0, y9 = 0, y10 = 0, y11 = 0;
        while (rs1.next() && rs2.next() && rs3.next() && rs4.next() && rs5.next() && rs6.next() && rs7.next() && rs8.next() && rs9.next() && rs10.next() && rs11.next()) { 
          y1 = Float.parseFloat(rs1.getString("SUM(importe)"));
          y2 = Float.parseFloat(rs2.getString("SUM(importe)"));
          y3 = Float.parseFloat(rs3.getString("SUM(importe)"));
          y4 = Float.parseFloat(rs4.getString("SUM(importe)"));
          y5 = Float.parseFloat(rs5.getString("SUM(importe)"));
          y6 = Float.parseFloat(rs6.getString("SUM(importe)"));
          y7 = Float.parseFloat(rs7.getString("SUM(importe)"));
          y8 = Float.parseFloat(rs8.getString("SUM(importe)"));
          y9 = Float.parseFloat(rs9.getString("SUM(importe)"));
          y10 = Float.parseFloat(rs10.getString("SUM(importe)"));
          y11 = Float.parseFloat(rs11.getString("SUM(importe)"));
        }
        
    %>

    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css">
    <link href="./css/style3.css" rel="stylesheet" type="text/css">
    
    <style type="text/css">
        #container {
            height: 400px; 
            min-width: 310px; 
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            Highcharts.chart('container', {
                chart: {
                    type: 'column',
                    options3d: {
                        enabled: true,
                        alpha: 10,
                        beta: 25,
                        depth: 70
                    }
                },
                title: {
                    text: 'Pograma de Mejora de la Gestion Municipal'
                },
                subtitle: {
                    text: 'Viceministerio de Vicienda y Urbanismo'
                },
                plotOptions: {
                    column: {
                        depth: 25
                    }
                },
                xAxis: {
                    categories: ['El Alto', 'Cochabamba', 'Cobija', 'El Torno', 'Sacaba', 'Oruro', 'Potosi', 'Sucre', 'Viacha', 'Tarija', 'Trinidad']
                },
                yAxis: {
                    title: {
                        text: null
                    }
                },
                series: [{
                    name: 'Municipios',
                    data: [<%= y5 %>, <%= y3 %>, <%= y4 %>, <%= y1 %>, <%= y8 %>, <%= y6 %>, <%= y2 %>, <%= y9 %>, <%= y11 %>, <%= y7 %>, <%= y10 %>]
                }]
            });
        });
    </script>
    
    <script src="./js/ie-emulation-modes-warning.js"></script>
    <link href="./css/carousel.css" rel="stylesheet">

  </head>
  <body >
    <% if (rs.next()){ sw=true;%>

    

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
              <a class="navbar-brand" href="#">PMGM - CII</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Registro<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                <%
                    if (y12 == 1) {
                %>
                    <li><a href="http://10.0.6.183:8084/registroC31/inicio.jsp">Registro</a></li>
                    <li><a href="http://10.0.6.183:8084/registroC31/buscar.jsp">Reportes</a></li>
                <%
                            
                    }
                    else if (y12 == 2) {
                %>
                    <li><a href="http://10.0.6.183:8084/registroC31/municipio.jsp?us=0&bfgdbfg6513fbfd">Información del Municipio</a></li>
                <%
                            
                    }
                    else if (y12 == 3) {
                %>
                    <li><a href="http://10.0.6.183:8084/registroC31/municipio.jsp?us=0&bfgdbfg6513fbfd">Información del Municipio</a></li>
                <%
                            
                    }
                %>
                    <li role="separator" class="divider"></li>
                    <li><a href="CTRLSalir?id2=<%= id2 %>">Salir</a></li>
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
        <div class="col-md-6">
            <h2 class="featurette-heading">Bienvenido</h2>
          <p class="lead">El Programa de Mejora de la Gestion Muncipal Componente II. Expansión de la base 
              tributaria del impuesto predial, que financiara la mejora de la gestión catastral en 10 
              municipios de Bolivia, que será ejecutado por el Ministerio de Obras Publicas, Servicios y 
              Vivienda (MOPSV).</p>
        </div>
        <div class="col-md-6">
            <script src="https://code.highcharts.com/highcharts.js"></script>
            <script src="https://code.highcharts.com/highcharts-3d.js"></script>
            <script src="https://code.highcharts.com/modules/exporting.js"></script>

            <div id="container" style="height: 400px"></div>
        </div>
      </div>
        <hr class="featurette-divider">
      <div class="row featurette">
        <div class="col-md-6">
            <h2 class="featurette-heading">Nuestras oficinas</h2>
          <p class="lead">Nuestras oficinas y contactos son las siguientes :</p>
          <ul>
              <li>Dirección: Av. Mariscal Santa Cruz, Esq. Calle Oruro, Edif. Centro de Comunicaciones La Paz - 4to piso.</li>
              <li>Telef: (591)-2 2121075 - 2124638.</li>
          </ul>
        </div>
        <div class="col-md-6">
            <iframe src="https://www.google.com/maps/embed?pb=!1m19!1m8!1m3!1d1912.7686915158288!2d-68.1356258!3d-16.4989463!3m2!1i1024!2i768!4f13.1!4m8!3e6!4m0!4m5!1s0x915f20711b41a413%3A0xc47739fba9ff4689!2sAvenida+Mariscal+Santa+Cruz%2C+La+Paz%2C+Bolivia!3m2!1d-16.499242499999998!2d-68.1349127!5e0!3m2!1ses-419!2sar!4v1505940695517" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
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
    <% }
        else{ 
        sw = false;
    }%>
</body>
</html>
<%}
else {
    response.sendRedirect("index.jsp");
}%>