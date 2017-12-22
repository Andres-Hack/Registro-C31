<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html lang="es" xml:lang="es">

    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/EstilosJS.jsp"  %> 
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">

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
                                                <script src="https://code.highcharts.com/modules/data.js"></script>
                                                <script src="https://code.highcharts.com/modules/drilldown.js"></script>
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

// Create the chart
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Montos Designados, gastados del GAM/UEP : <c:out value="${datos[11]}"/>'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: 'Monto en Bs/$us'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
                format: '{point.y:.1f} <c:out value="${datos[10]}"/>'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:,.2f} <c:out value="${datos[10]}"/></b> total<br/>'
    },

    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'Monto Asignado',
            y: <c:out value="${datos[6]}"/>,
            drilldown: 'Monto Asignado'
        }, {
            name: 'Monto Gastado',
            y: <c:out value="${datos2[0]}"/>,
            drilldown: 'Monto Gastado'
        }, {
            name: 'Monto Pendiente',
            y: <c:out value="${datos[6]}"/>-<c:out value="${datos2[0]}"/>,
            drilldown: 'Monto Pendiente'
        }]
    }],
    drilldown: {
        series: [{
            name: 'Monto Asignado',
            id: 'Monto Asignado',
            data: [
                [
                    'Sub componente 2,1',
                    <c:out value="${datos[2]}"/>
                ],
                [
                    'Sub componente 2,2',
                    <c:out value="${datos[3]}"/>
                ],
                [
                    'Sub componente 2,3',
                    <c:out value="${datos[4]}"/>
                ],
                [
                    'Sub componente 2,4',
                    <c:out value="${datos[5]}"/>
                ]
            ]
        }, {
            name: 'Monto Gastado',
            id: 'Monto Gastado',
            data: [
                [
                    'Sub componente 2,1',
                    <c:out value="${datos2[1]}"/>
                ],
                [
                    'Sub componente 2,2',
                    <c:out value="${datos2[2]}"/>
                ],
                [
                    'Sub componente 2,3',
                    <c:out value="${datos2[3]}"/>
                ],
                [
                    'Sub componente 2,4',
                    <c:out value="${datos2[4]}"/>
                ]
            ]
        }, {
            name: 'Monto Pendiente',
            id: 'Monto Pendiente',
            data: [
                [
                    'Sub componente 2,1',
                    <c:out value="${datos[2]}"/>-<c:out value="${datos2[1]}"/>
                ],
                [
                    'Sub componente 2,2',
                    <c:out value="${datos[3]}"/>-<c:out value="${datos2[2]}"/>
                ],
                [
                    'Sub componente 2,3',
                    <c:out value="${datos[4]}"/>-<c:out value="${datos2[3]}"/>
                ],
                [
                    'Sub componente 2,4',
                    <c:out value="${datos[5]}"/>-<c:out value="${datos2[4]}"/>
                ]
            ]
        }]
    }
});

</script>

</body>
</html>