<%-- 
    Document   : programado
    Created on : 21-12-2017, 03:01:26 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>    
<html lang="es" xml:lang="es">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/EstilosJS.jsp"  %> 
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">

    <%@ include file="/header.jsp"  %> 
        <%@ include file="/header.jsp"  %> 

                    <div id="base">
                        <div id="content">
                            <section class="bg1">
                                <div class="section-body">
                                    <div class="row">
                                       <div class="col-md-12">
                                          <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <span class="glyphicon glyphicon-leaf"></span>
                                                PANEL DE BUSQUEDA                    
                                                <br/>
                                            </div>
                                            <div class="panel-body">
                                              <form class="form " action="CTRLProgramado" id="form-search" method="post">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                            <samp style="color: rosybrown"> (*) campo obligatorio</samp>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <select name="Gamuep" class="form-control">
                                                                <option value="" selected="selected"></option>
                                                                <option value="UEP">UEP</option>
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
                                                            <label for='cite_original'>GAM / UEP</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                              <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox" name="cambio"> $us
                                                                </label>
                                                              </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <input type="submit" name="buscar" value="Buscar" class="btn btn-success" data-toggle="tooltip" data-placement="left" title="Calcular el monto ejecutado"  />
                                                            </br>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                            </div>
                                          </div>
                                       </div>                                            
                                    </div>
                                    <div class="row">
                                       <div class="col-md-12">
                                          <div class="panel panel-primary">
                                              <div class="panel-heading">
                                                  <span class="glyphicon glyphicon-stats"></span>
                                                  GRAFICO ESTADISTICO
                                              </div>
                                              <div class="panel-body">
                                                <script src="https://code.highcharts.com/highcharts.js"></script>
                                                <script src="https://code.highcharts.com/modules/exporting.js"></script>
                                                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                              </div>
                                          </div>
                                        </div>    
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

<script type="text/javascript">

    Highcharts.chart('container', {

        chart: {
            type: 'column'
        },

        title: {
            text: 'Montos Designados, gastados del GAM/UEP : <c:out value="${datos[18]}"/>'
        },

        xAxis: {
            categories: ['Monto Asignado', 'Monto Gastado', 'Monto Pendiente']
        },

        yAxis: {
            allowDecimals: false,
            min: 0,
            title: {
                text: 'Monto en <c:out value="${datos[17]}"/>'
            }
        },

        tooltip: {
            formatter: function () {
                return '<b>' + this.x + '</b><br/>' +
                    this.series.name + ': ' + this.y + ' <c:out value="${datos[17]}"/><br/>' +
                    'Total: ' + this.point.stackTotal+' <c:out value="${datos[17]}"/>';
            }
        },

        plotOptions: {
            column: {
                stacking: 'normal'
            }
        },

        series: [{
            name: '2,1 : APOYO A LA GESTION CATASTRAL Y SU INTERCONEXION CON LA ADMINISTRACION TRIBUTARIA',
            data: [<c:out value="${datos[9]}"/>, <c:out value="${datos3[0]}"/>, 7],
            stack: 'male'
        }, {
            name: '2,2 : ADQUISICION DEL SISTEMA DE CATASTRO',
            data: [<c:out value="${datos[11]}"/>, <c:out value="${datos3[1]}"/>, 2],
            stack: 'male'
        }, {
            name: '2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA',
            data: [<c:out value="${datos[13]}"/>, <c:out value="${datos3[2]}"/>, 2],
            stack: 'male'
        }, {
            name: '2,4 : ADMINISTRACIÓN Y SUPERVISIÓN',
            data: [<c:out value="${datos[15]}"/>, <c:out value="${datos3[3]}"/>, 4],
            stack: 'male'
        }, {
            name: '2,1 : APOYO A LA GESTION CATASTRAL Y SU INTERCONEXION CON LA ADMINISTRACION TRIBUTARIA',
            data: [<c:out value="${datos[10]}"/>, <c:out value="${datos4[0]}"/>, 7],
            stack: 'female'
        }, {
            name: '2,2 : ADQUISICION DEL SISTEMA DE CATASTRO',
            data: [<c:out value="${datos[12]}"/>, 5, 2],
            stack: 'female'
        }, {
            name: '2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA',
            data: [<c:out value="${datos[14]}"/>, 1, 2],
            stack: 'female'
        }, {
            name: '2,4 : ADMINISTRACIÓN Y SUPERVISIÓN',
            data: [<c:out value="${datos[16]}"/>, 14, 4],
            stack: 'female'
        }]
    });
</script>

</body>
</html>