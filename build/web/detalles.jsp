<%@page import="pReporte.Consultas"%>
<%@page import="java.text.DecimalFormat"%>
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
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/EstilosJS.jsp"  %> 
    <link type="text/css" href="./css/open-iconic/font/css/open-iconic-bootstrap.css" rel="stylesheet"/>
       
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <style type="text/css">
        ${demo.css}
    </style>
    <script type="text/javascript">
    
        <%
                DecimalFormat formatea = new DecimalFormat("###,###,###.###");

                String valor1 = "", montoBID = "0", montoCTR = "0", montoTotal="0", montoTotal21="0", montoTotal22="0", montoTotal23="0", montoTotal24="0"
                        , mostrar="0";
                String valor21BID = "", valor22BID = "", valor23BID = "", valor24BID = "";
                String valor21CTR = "", valor22CTR = "", valor23CTR = "", valor24CTR = "";
                
                String gestion = request.getParameter("gestion");
                String gamuep = request.getParameter("Gamuep");
                String cambio = request.getParameter("cambio");

                if (cambio != null) {
                    cambio = "1";
                    valor1 = "$us";
                } else {
                    cambio = "2";
                    valor1 = "Bs";
                }
                if (gamuep != null) {
                    montoBID = Consultas.MontoTotal(gestion, gamuep, "BID", cambio);
                    montoCTR = Consultas.MontoTotal(gestion, gamuep, "CTR", cambio);
                    montoTotal = String.valueOf(Double.parseDouble(montoBID)+Double.parseDouble(montoCTR));
                    
                    valor21BID = Consultas.MontoTotalSubc(gestion, gamuep, "BID", cambio, "1");
                    valor22BID = Consultas.MontoTotalSubc(gestion, gamuep, "BID", cambio, "2");
                    valor23BID = Consultas.MontoTotalSubc(gestion, gamuep, "BID", cambio, "3");
                    valor24BID = Consultas.MontoTotalSubc(gestion, gamuep, "BID", cambio, "4");
                    valor21CTR = Consultas.MontoTotalSubc(gestion, gamuep, "CTR", cambio, "1");
                    valor22CTR = Consultas.MontoTotalSubc(gestion, gamuep, "CTR", cambio, "2");
                    valor23CTR = Consultas.MontoTotalSubc(gestion, gamuep, "CTR", cambio, "3");
                    valor24CTR = Consultas.MontoTotalSubc(gestion, gamuep, "CTR", cambio, "4");
                    montoTotal21=String.valueOf(Double.parseDouble(valor21BID)+Double.parseDouble(valor21CTR));
                    montoTotal22=String.valueOf(Double.parseDouble(valor22BID)+Double.parseDouble(valor22CTR));
                    montoTotal23=String.valueOf(Double.parseDouble(valor23BID)+Double.parseDouble(valor23CTR));
                    montoTotal24=String.valueOf(Double.parseDouble(valor24BID)+Double.parseDouble(valor24CTR));
                    
                }
                mostrar = formatea.format(Double.parseDouble(montoTotal));
                         
        %>
    $(function () {
    // Create the chart
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'PROGRAMA DE MEJORA DE LA GESTION MUNICIPAL - CII <br /> <%= mostrar %>  <%= valor1 %> <br /> <%= gamuep %> - <%= gestion %>'
        },
        subtitle: {
            text: 'Hacer click en las columnas para entrar a detalles.'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Total del monto en <%= valor1 %>'
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
                    format: '{point.y:.1f} <%= valor1 %>'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f} <%= valor1 %></b> en total<br/>'
        },

        series: [{
            name: 'Importe',
            colorByPoint: true,
            data: [{
                name: 'TOTAL',
                y: <%= montoTotal %>,
                drilldown: 'TOTAL'
            }, {
                name: 'BID',
                y: <%= montoBID %>,
                drilldown: 'BID'
            }, {
                name: 'CTR',
                y: <%= montoCTR %>,
                drilldown: 'CTR'
            }]
        }],
        drilldown: {
            series: [{
                name: 'COMPONENTES',
                id: 'TOTAL',
                data: [
                    [
                        '2.1 ACTUALIZACION DE LOS REGISTROS DE CATASTRO',
                        <%= montoTotal21 %>
                    ],
                    [
                        '2.2 DESARROLLO DE LOS SISTEMAS DE GESTION CATASTRAL',
                        <%= montoTotal22 %>
                    ],
                    [
                        '2.3 CAPACITACION, ASISTENCIA TECNICA Y DIFUSIÓN',
                        <%= montoTotal23 %>
                    ],
                    [
                        '2.4 ADMINISTRACION, EVALUACION Y AUDITORIAS',
                        <%= montoTotal24 %>
                    ]
                ]
            }, {
                name: 'COMPONENTES',
                id: 'BID',
                data: [
                    [
                        '2.1 ACTUALIZACION DE LOS REGISTROS DE CATASTRO',
                        <%= valor21BID %>
                    ],
                    [
                        '2.2 DESARROLLO DE LOS SISTEMAS DE GESTION CATASTRAL',
                       <%= valor22BID %>
                    ],
                    [
                        '2.3 CAPACITACION, ASISTENCIA TECNICA Y DIFUSIÓN',
                        <%= valor23BID %>
                    ],
                    [
                        '2.4 ADMINISTRACION, EVALUACION Y AUDITORIAS',
                        <%= valor24BID %>
                    ]
                ]
            }, {
                name: 'COMPONENTES',
                id: 'CTR',
                data: [
                    [
                        '2.1 ACTUALIZACION DE LOS REGISTROS DE CATASTRO',
                        <%= valor21CTR %>
                    ],
                    [
                        '2.2 DESARROLLO DE LOS SISTEMAS DE GESTION CATASTRAL',
                        <%= valor22CTR %>
                    ],
                    [
                        '2.3 CAPACITACION, ASISTENCIA TECNICA Y DIFUSIÓN',
                        <%= valor23CTR %>
                    ],
                    [
                        '2.4 ADMINISTRACION, EVALUACION Y AUDITORIAS',
                        <%= valor24CTR %>
                    ]
                ]
            }]
        }
    });
});
</script>
                    		<style type="text/css">
${demo.css}
		</style>
		<script type="text/javascript">
$(function () {

    // Radialize the colors
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {
                cx: 0.5,
                cy: 0.3,
                r: 0.7
            },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.6).get('rgb')] // darken
            ]
        };
    });

    // Build the chart
    Highcharts.chart('container2', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Ejecución Global Municipio "<%= gamuep %>" <br /> Total xxxx :  <%= valor1 %>'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y:.2f} Bs</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.y:.2f} Bs',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    },
                    connectorColor: 'red'
                }
            }
        },
        series: [{
            name: 'Total',
            data: [
                { name: 'Sub Conponente Total', y: 41 },
                { name: 'Deuda', y: 741 }
            ]
        }]
    });
});
</script>

</head>

<body class="menubar-pin header-fixed " ng-app="myApp">

<%@ include file="/header.jsp"  %> 

<div id="base">
    <div id="content">
        <section class="bg1">
            <div class="section-body">

                <div class="row">
                    <div class="col-md-12">
                         <div class="card card-underline">
                                <div class="card-head">
                                    <header><span class="glyphicon glyphicon-leaf"></span> BUSQUEDA A DETALLES </header>
                                </div>
                                <div class="card-body" ng-controller="myCtrl1">
                                    <form class="form " action="detalles.jsp" id="form-search" method="post">
                                        <div class="row">
                                            <div class="col-md-4">
                                                    <samp style="color: rosybrown"> (*) campo obligatorio</samp>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <select class="form-control" name="gestion" >
                                                        <option value="" >-----------</option>
                                                        <option value="TODO" >TODO</option>
                                                        <option value="2013" >2013</option>
                                                        <option value="2014" >2014</option>
                                                        <option value="2015" >2015</option>
                                                        <option value="2016" >2016</option>
                                                        <option value="2017" >2017</option>
                                                        <option value="2018" >2018</option>
                                                    </select>
                                                    <label for='nur'>GESTION</label>
                                                </div>
                                            </div>
                                            <% if ("1".equals((String) session.getAttribute("nivel")) || "3".equals((String) session.getAttribute("nivel")) || "5".equals((String) session.getAttribute("nivel"))) {%>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <select name="Gamuep" class="form-control">
                                                        <option value="" selected="selected"></option>
                                                        <option value="" >-----------</option>
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
                                            <%} else {%>
                                            <input name="Gamuep" type="hidden" value="${sessionScope.abrev}">
                                            <%}%>
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
                    <div class="row">
                        <script src="https://code.highcharts.com/highcharts.js"></script>
                        <script src="https://code.highcharts.com/modules/data.js"></script>
                        <script src="https://code.highcharts.com/modules/drilldown.js"></script>
                        <script src="https://code.highcharts.com/modules/exporting.js"></script>
                        <div class="col-md-12" id="contenido">
                            <div class="card card-underline" id="dvData">
                                    <div class="card-head">
                                        <header><span class="glyphicon glyphicon-flash"></span> EJECUCIÓN FINANCIERO</header>
                                    </div>
                                    <div class="card-body">                                    
                                        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>                                   
                                    </div>
                                </div> 
                        </div>
                    </div>
                    
                </div>
                
            </div>
        </div></section>
    </div>
    <%@ include file="/menu.jsp"  %> 
    <% gamuep= null; %>
</div>
<script src="./js/fcJS.js" type="text/javascript" charset="utf-8"></script>
<script>
            $("#btnExport").click(function(e) {
                window.open('data:application/vnd.ms-pdf,' + encodeURIComponent($('#dvData').html()));
                e.preventDefault();
            });
</script>
<!--Start of Tawk.to Script-->
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/59a6b7087ab2de3aea9d75ac/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
<!--End of Tawk.to Script-->
</body>
</html>
<%}
else {
    response.sendRedirect("http://pmgmc2.oopp.gob.bo");
}%>
