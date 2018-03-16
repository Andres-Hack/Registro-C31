
<%@page import="java.util.LinkedList"%>
<%@page import="pClases.Porcentaje"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

    <head>
        <%@ include file="/AdminMaterial.jsp"  %> 
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">

        <%@ include file="/header.jsp"  %> 
        <div id="base">
            <div id="content">
                <section class="bg1">
                    <div class="section-body">
                        <!-- BEGIN SIZES -->
                        <div class="row">
                            <div class="col-md-12 col-sm-6">
                                <div class="card">
                                    <div class="card-head">
                                        <header><span class="glyphicon glyphicon-send"></span> Generador de reportes rapidos</header>
                                    </div>
                                    <div class="card-body" ng-controller="myCtrl1">
                                        <form class="form " action="CTRReportePDF" method="post" id="form-search">
                                            <div  ng-show="mirar">     
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <select name="txtGamuep" class="form-control">
                                                                <option value="" selected="selected"></option>
                                                                <option value="" >------</option>
                                                                <option value="CBB">COCHABAMBA</option>
                                                                <option value="COB">COBIJA</option>
                                                                <option value="EAL">EL ALTO</option>
                                                                <option value="TOR">EL TORNO</option>
                                                                <option value="ORU">ORURO</option>
                                                                <option value="POT">POTOSI</option>
                                                                <option value="SAC">SACABA</option>
                                                                <option value="SER">SUCRE</option>
                                                                <option value="TAR">TARIJA</option>
                                                                <option value="TDD">TRINIDAD</option>
                                                                <option value="VIA">VIACHA</option>
                                                                <option value="SCZ">SANTA CRUZ</option>
                                                            </select>
                                                            <label for='cite_original'>MUNICIPIO : </label>
                                                        </div>
                                                    </div>  
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <select name="txtTipoRepo"class="form-control">
                                                                <option value="" selected="selected"></option>
                                                                <option value="1">SUB COMPONENTE </option>
                                                                <option value="3">SUB COMPONENTE / ACTIVIDAD</option>
                                                                <option value="2">SUB COMPONENTE / ACTIVIDAD / PRODUCTO</option>
                                                            </select>
                                                            <label for='cite_original'>TIPO DE REPORTE POR : </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <button type="submit" class="btn btn-success btn-lg active" ng-click="mirar = false" ng-init="mirar = true">Generar Reporte</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row" ng-show="!mirar">
                                                <div class="col-md-12">
                                                    <center>
                                                        <img src="./img/cargando.gif" height="100" width="800" >
                                                    </center>
                                                </div>
                                            </div>
                                        </form>
                                    </div><!--end .card-body -->
                                </div><!--end .card -->
                            </div><!--end .col -->
                        </div><!--end .row -->
                        <!-- END SIZES -->



                    </div>
            </div>
        </div>
        </section>
        </div>



        </div>
        </div>
        </div></section>
        </div>
        <%@ include file="/menu.jsp"  %> 
        </div>
        <%@ include file="/AdminMaterialJS.jsp"  %>
    </body>
</html>
