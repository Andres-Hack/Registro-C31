<%-- 
    Document   : programado
    Created on : 21-12-2017, 03:01:26 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>    
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
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
                                                                <option value="TODO">TODO</option>
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
                                       <div class="col-md-6">
                                          <div class="panel panel-primary">
                                              <div class="panel-heading">
                                                  <span class="glyphicon glyphicon-stats"></span>
                                                  GRAFICO ESTADISTICO DEL MUNICIPIO DE <c:out value="${datos[18]}"/>
                                              </div>
                                              <div class="panel-body">
                                                <script src="https://code.highcharts.com/highcharts.js"></script>
                                                <script src="https://code.highcharts.com/highcharts-3d.js"></script>
                                                <script src="https://code.highcharts.com/modules/exporting.js"></script>
                                                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                              </div>
                                          </div>
                                        </div>    
                                        <div class="col-md-6">
                                          <div class="panel panel-primary">
                                              <div class="panel-heading">
                                                  <span class="glyphicon glyphicon-stats"></span>
                                                  GRAFICO ESTADISTICO DEL MUNICIPIO DE <c:out value="${datos[18]}"/>
                                              </div>
                                              <div class="panel-body">
                                                <div id="container2"></div>
                                                <div id="sliders">
                                                    <table>
                                                        <tr>
                                                                <td>Alpha Angle</td>
                                                                <td><input id="alpha" type="range" min="0" max="45" value="15"/> <span id="alpha-value" class="value"></span></td>
                                                        </tr>
                                                        <tr>
                                                                <td>Beta Angle</td>
                                                                <td><input id="beta" type="range" min="-45" max="45" value="15"/> <span id="beta-value" class="value"></span></td>
                                                        </tr>
                                                        <tr>
                                                                <td>Depth</td>
                                                                <td><input id="depth" type="range" min="20" max="100" value="50"/> <span id="depth-value" class="value"></span></td>
                                                        </tr>
                                                    </table>
                                                </div>
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
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                viewDistance: 25,
                depth: 40
            }
        },

        title: {
            text: 'Montos divididos por dos columnas BID/CTR con sus respectivas subcomponentes.'
        },

        xAxis: {
            categories: ['Monto Programado', 'Monto Ejecutado', 'Monto por Ejecutar']
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
            data: [<c:out value="${datos[9]}"/>, <c:out value="${datos3[0]}"/>, <c:out value="${datos[9]}"/>-<c:out value="${datos3[0]}"/>],
            stack: 'male'
        }, {
            name: '2,2 : ADQUISICION DEL SISTEMA DE CATASTRO',
            data: [<c:out value="${datos[11]}"/>, <c:out value="${datos3[1]}"/>,<c:out value="${datos[11]}"/>-<c:out value="${datos3[1]}"/>],
            stack: 'male'
        }, {
            name: '2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA',
            data: [<c:out value="${datos[13]}"/>, <c:out value="${datos3[2]}"/>, <c:out value="${datos[13]}"/>-<c:out value="${datos3[2]}"/>],
            stack: 'male'
        }, {
            name: '2,4 : ADMINISTRACIÓN Y SUPERVISIÓN',
            data: [<c:out value="${datos[15]}"/>, <c:out value="${datos3[3]}"/>, <c:out value="${datos[15]}"/>-<c:out value="${datos3[3]}"/>],
            stack: 'male'
        }, {
            name: '2,1 : APOYO A LA GESTION CATASTRAL Y SU INTERCONEXION CON LA ADMINISTRACION TRIBUTARIA',
            data: [<c:out value="${datos[10]}"/>, <c:out value="${datos3[4]}"/>, <c:out value="${datos[10]}"/>-<c:out value="${datos3[4]}"/>],
            stack: 'female'
        }, {
            name: '2,2 : ADQUISICION DEL SISTEMA DE CATASTRO',
            data: [<c:out value="${datos[12]}"/>, <c:out value="${datos3[5]}"/>, <c:out value="${datos[12]}"/>-<c:out value="${datos3[5]}"/>],
            stack: 'female'
        }, {
            name: '2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA',
            data: [<c:out value="${datos[14]}"/>, <c:out value="${datos3[6]}"/>, <c:out value="${datos[14]}"/>-<c:out value="${datos3[6]}"/>],
            stack: 'female'
        }, {
            name: '2,4 : ADMINISTRACIÓN Y SUPERVISIÓN',
            data: [<c:out value="${datos[16]}"/>, <c:out value="${datos3[7]}"/>, <c:out value="${datos[16]}"/>-<c:out value="${datos3[7]}"/>],
            stack: 'female'
        }]
    });
// Set up the chart
var chart = new Highcharts.Chart({
    chart: {
        renderTo: 'container2',
        type: 'column',
        options3d: {
            enabled: true,
            alpha: 15,
            beta: 15,
            depth: 50,
            viewDistance: 25
        }
    },
    title: {
        text: 'Grafico Resumido'
    },
    xAxis: {
            categories: ['']
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
                    this.series.name + ': ' + this.y + ' <c:out value="${datos[17]}"/><br/>';
            }
        },
        plotOptions: {
            column: {
                depth: 3
            }
        },
    
    series: [{
            name: 'Monto Programado',
            data: [<c:out value="${datos[6]}"/>],
            depth: 'male'
        }, {
            name: 'Monto Ejecutado',
            data: [<c:out value="${datos3[8]}"/>],
            depth: 'male'
        }, {
            name: 'Monto por Ejecutar',
            data: [<c:out value="${datos[6]}"/>-<c:out value="${datos3[8]}"/>],
            depth: 'male'
        }]
});

function showValues() {
    $('#alpha-value').html(chart.options.chart.options3d.alpha);
    $('#beta-value').html(chart.options.chart.options3d.beta);
    $('#depth-value').html(chart.options.chart.options3d.depth);
}

// Activate the sliders
$('#sliders input').on('input change', function () {
    chart.options.chart.options3d[this.id] = parseFloat(this.value);
    showValues();
    chart.redraw(false);
});

showValues();

</script>

</body>
</html>
<%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>