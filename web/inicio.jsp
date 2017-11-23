<%-- 
    Document   : inicio
    Created on : 18-01-2017, 10:21:46 AM
    Author     : andres
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="pControlador.CTRLRegistro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pClases.Registro"%>
<%@page import="pModelo.DBConexion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/EstilosJS.jsp"  %> 
    <%@ include file="/estadisticas.jsp"  %> 


</head>

<body class="menubar-pin header-fixed " ng-app="myApp">

<%@ include file="/header.jsp"  %> 

<div id="base">
    <div id="content">
        <section class="bg1">
            <div class="section-body">
                <div class="row">
                <%@ include file="/baner.jsp"  %> 

                <div class="row">
                    <div class="col-md-6">
                         <div class="card card-underline">
                            <div class="card-head ">
                                <header class=" text-default-light"><span class="glyphicon glyphicon-save"></span> Registro C31</header>
                            </div>
                            <div class="col-md-1"><label style="color: white">.</label></div>
                            <%@ include file="/formulario.jsp"  %> 
                            <div class="col-md-1"><label style="color: white">.</label></div>
                        </div>
                    </div>

                    <div class="col-md-6 ">
                        <div class="card card-underline">
                            <div class="card-head ">
                                <header class=" text-default-light "><span class="glyphicon glyphicon-ok"></span> Estadisticas</header>
                            </div>
                            <div class="nano has-scrollbar" style="height: 440px;"><div class="nano-content" tabindex="0" style="right: -15px;"><div class="card-body no-padding height-11 scroll style-default-bright" style="height: auto;">
                                <div class="table-responsive no-margin">
                                    <table class="table table-striped no-margin ">
                                        <tbody>
                                          <script src="https://code.highcharts.com/highcharts.js"></script>
                                          <script src="https://code.highcharts.com/modules/exporting.js"></script>
                                          <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                        </tbody>
                                    </table>
                                </div>
                            </div></div><div class="nano-pane" style="display: none;"><div class"nano-slider" style="height: 425px; transform: translate(0px, 0px);"></div></div></div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div></section>
    </div>
    <%@ include file="/menu.jsp"  %> 
</div>

</body>
</html>


