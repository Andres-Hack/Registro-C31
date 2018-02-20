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
<!-- saved from url=(0026)https://sigec.oopp.gob.bo/ -->
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/EstilosJS.jsp"  %> 
       
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <style type="text/css">
        ${demo.css}
    </style>
    <script type="text/javascript">
    
                    <%

                                        String consulta = null, consulta1 = null, consulta2 = null, consulta3 = null, consulta4 = null, consulta5 = null, consulta6 = null
                                             , consulta7 = null, consulta8 = null, consulta9 = null, consulta10 = null, consulta11 = null, consulta12 = null,
                                               consulta13 = null, consulta14 = null;
                                        String gestion = request.getParameter("gestion");
                                        String gamuep = request.getParameter("Gamuep");
                                        String cambio = request.getParameter("cambio");
                                        String estado = null, valor1 = null;
                                        float dd = 0; float dd1 = 0; float dd2 = 0, dd3 = 0, dd4 = 0, dd5 = 0, dd6 = 0,
                                              dd7 = 0, dd8 = 0, dd9 = 0, dd10 = 0, dd11 = 0, dd12 = 0, dd13 = 0, dd14 = 0;

                                        Connection con = DBConexion.IniciarSesion();
                                        DecimalFormat formatea = new DecimalFormat("###,###.##");
                                        
                                        if (cambio != null) {
                                            estado = "importe_usd";
                                            valor1 = "$us";
                                        }
                                        else{
                                            estado = "importe";
                                            valor1 = "Bs";
                                        }
                                        String consulta01="select ROUND(sum(monto_bs_bid), 2) as total where id >= 1 ";
                                        String consulta02="select ROUND(sum(monto_bs_ctr), 2) as total where id >= 1 ";
                                        String consulta03="select ROUND(sum(monto_bs_bid)+sum(monto_bs_ctr), 2)  as total where id >= 1 ";
                                        consulta = "SELECT SUM("+estado+") as total FROM tabla_c31 where id >= 1 ";
                                        
                                        
                                        if (gestion != "") {                                                    
                                            consulta += " and gestion='"+gestion+"' ";   
                                            consulta01 += " and gestion='"+gestion+"' ";
                                            consulta02 += " and gestion='"+gestion+"' ";
                                            consulta03 += " and gestion='"+gestion+"' ";
                                        }
                                        if (gamuep != "") {
                                           consulta += " and gam_uep='"+gamuep+"' ";
                                           consulta01 += " and gam='"+gamuep+"' ";
                                           consulta02 += " and gam='"+gamuep+"' ";
                                           consulta03 += " and gam='"+gamuep+"' ";                                           
                                        }
                                        
                                        ResultSet rs = null, rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null,
                                                  rs7 = null, rs8 = null, rs9 = null, rs10 = null, rs11 = null, rs12 = null, rs13 = null, rs14 = null,
                                                    rs01=null,rs02=null,rs03=null;
                                        PreparedStatement pst = null, pst1 = null, pst2 = null, pst3 = null, pst4 = null, pst5 = null, pst6 = null,
                                                          pst7 = null, pst8 = null, pst9 = null, pst10 = null, pst11 = null, pst12 = null, pst13 = null,
                                                pst14 = null, pst01 = null, pst02 = null, pst03 = null;
                                        
                                        pst = con.prepareStatement(consulta);
                                        rs = pst.executeQuery();                                             
                                        
                                                                             
                                        while (rs.next()) {                                                
                                                dd = rs.getFloat("total");
                                        }
                                         
                                        String oop = formatea.format(dd); 
                                        System.out.println(oop);  
                                            
                                        ///////////////////////////////////
                                        // CONSULTA DIVIDIDAS POR SUB    //
                                        // COMPONENTE Y ACTIVIDADES      //
                                        ///////////////////////////////////
                                        consulta1 = consulta+" and subc='2,1' ";
                                        consulta2 = consulta+" and subc='2,2' ";
                                        consulta3 = consulta+" and subc='2,3' ";
                                        consulta4 = consulta+" and subc='2,4' ";
                                        consulta5 = consulta+" and bid_ctr = 'BID'";
                                        consulta6 = consulta+" and bid_ctr = 'CTR'";
                                        consulta7 = consulta+" and subc='2,1' and bid_ctr = 'BID'";
                                        consulta8 = consulta+" and subc='2,2' and bid_ctr = 'BID'";
                                        consulta9 = consulta+" and subc='2,3' and bid_ctr = 'BID'";
                                        consulta10 = consulta+" and subc='2,4' and bid_ctr = 'BID'";
                                        consulta11 = consulta+" and subc='2,1' and bid_ctr = 'CTR'";
                                        consulta12 = consulta+" and subc='2,2' and bid_ctr = 'CTR'";
                                        consulta13 = consulta+" and subc='2,3' and bid_ctr = 'CTR'";
                                        consulta14 = consulta+" and subc='2,4' and bid_ctr = 'CTR'";
                                        pst1 = con.prepareStatement(consulta1); pst2 = con.prepareStatement(consulta2);
                                        pst3 = con.prepareStatement(consulta3); pst4 = con.prepareStatement(consulta4); pst5 = con.prepareStatement(consulta5); pst6 = con.prepareStatement(consulta6);
                                        pst7 = con.prepareStatement(consulta7); pst9 = con.prepareStatement(consulta9);pst11 = con.prepareStatement(consulta11);pst13 = con.prepareStatement(consulta13);
                                        pst8 = con.prepareStatement(consulta8);pst10 = con.prepareStatement(consulta10);pst12 = con.prepareStatement(consulta12);pst14 = con.prepareStatement(consulta14);
                                        rs1 = pst1.executeQuery(); rs2 = pst2.executeQuery(); rs3 = pst3.executeQuery(); 
                                        rs4 = pst4.executeQuery(); rs5 = pst5.executeQuery(); rs6 = pst6.executeQuery(); rs7 = pst7.executeQuery();
                                        rs9 = pst9.executeQuery(); rs11 = pst11.executeQuery(); rs13 = pst13.executeQuery();
                                        rs8 = pst8.executeQuery(); rs10 = pst10.executeQuery(); rs12 = pst12.executeQuery(); rs14 = pst14.executeQuery();
                                        while (rs.next()) {                                                
                                                dd = rs.getFloat("total");
                                        }
                                        while (rs1.next()) {  dd1 = rs1.getFloat("total"); }
                                        while (rs2.next()) {  dd2 = rs2.getFloat("total"); }
                                        while (rs3.next()) {  dd3 = rs3.getFloat("total"); }
                                        while (rs4.next()) {  dd4 = rs4.getFloat("total"); }
                                        while (rs5.next()) {  dd5 = rs5.getFloat("total"); }
                                        while (rs6.next()) {  dd6 = rs6.getFloat("total"); }
                                        while (rs7.next()) {  dd7 = rs7.getFloat("total"); }
                                        while (rs8.next()) {  dd8 = rs8.getFloat("total"); }
                                        while (rs9.next()) {  dd9 = rs9.getFloat("total"); }
                                        while (rs10.next()) {  dd10 = rs10.getFloat("total"); }
                                        while (rs11.next()) {  dd11 = rs11.getFloat("total"); }
                                        while (rs12.next()) {  dd12 = rs12.getFloat("total"); }
                                        while (rs13.next()) {  dd13 = rs13.getFloat("total"); }
                                        while (rs14.next()) {  dd14 = rs14.getFloat("total"); }
                                        if (gamuep != null) {
                                            switch (gamuep){
                                                case "CBB" : gamuep = "Cochabamba"; break;
                                                case "COB" : gamuep = "Cobija"; break;
                                                case "EAL" : gamuep = "El Alto"; break;
                                                case "TOR" : gamuep = "El Torno"; break;
                                                case "ORU" : gamuep = "Oruro"; break;
                                                case "POT" : gamuep = "Potosi"; break;
                                                case "SAC" : gamuep = "Sacaba"; break;
                                                case "SER" : gamuep = "Sucre"; break;
                                                case "TAR" : gamuep = "Tarija"; break;
                                                case "TDD" : gamuep = "Trinidad"; break;
                                                case "VIA" : gamuep = "Viacha"; break;
                                                case "SCZ" : gamuep = "Santa Cruz"; break;
                                                default: gamuep = ""; break;
                                            }
                                        }
                                        
                                        float deuda = 5000;
                                        
                   %>
            $(function () {
    // Create the chart
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'PROGRAMA DE MEJORA DE LA GESTION MUNICIPAL - CII <br /> <%= oop %> <%= valor1 %> <br /> <%= gamuep %> - <%= gestion %>'
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
                y: <%= dd %>,
                drilldown: 'SUB-C - 2,1'
            }, {
                name: 'BID',
                y: <%= dd5 %>,
                drilldown: 'BID'
            }, {
                name: 'CTR',
                y: <%= dd6 %>,
                drilldown: 'CTR'
            }]
        }],
        drilldown: {
            series: [{
                name: 'COMPONENTES',
                id: 'SUB-C - 2,1',
                data: [
                    [
                        '2,1 : Apoyo a la gestion catastral y su interconexion con la administracion tributaria',
                        <%= dd1 %>
                    ],
                    [
                        '2,2 : Adquisicion del sistema de catastro',
                        <%= dd2 %>
                    ],
                    [
                        '2,3 : Capacitacion, difucion y asistencia tecnica',
                        <%= dd3 %>
                    ],
                    [
                        '2,4 : Administracion, suipervision y auditorias',
                        <%= dd4 %>
                    ]
                ]
            }, {
                name: 'COMPONENTES',
                id: 'BID',
                data: [
                    [
                        '2,1 : Apoyo a la gestion catastral y su interconexion con la administracion tributaria',
                        <%= dd7 %>
                    ],
                    [
                        '2,2 : Adquisicion del sistema de catastro',
                        <%= dd8 %>
                    ],
                    [
                        '2,3 : Capacitacion, difucion y asistencia tecnica',
                        <%= dd9 %>
                    ],
                    [
                        '2,4 : Administracion, suipervision y auditorias',
                        <%= dd10 %>
                    ]
                ]
            }, {
                name: 'COMPONENTES',
                id: 'CTR',
                data: [
                    [
                        '2,1 : Apoyo a la gestion catastral y su interconexion con la administracion tributaria',
                        <%= dd11 %>
                    ],
                    [
                        '2,2 : Adquisicion del sistema de catastro',
                        <%= dd12 %>
                    ],
                    [
                        '2,3 : Capacitacion, difucion y asistencia tecnica',
                        <%= dd13 %>
                    ],
                    [
                        '2,4 : Administracion, suipervision y auditorias',
                        <%= dd14 %>
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
            text: 'Ejecución Global Municipio "<%= gamuep %>" <br /> Total : <%= oop %> <%= valor1 %>'
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
                { name: 'Sub Conponente Total', y: <%= dd %> },
                { name: 'Deuda', y: <%= deuda %> }
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
                                                        <option value="" >Todo</option>
                                                        <option value="2013" >2013</option>
                                                        <option value="2014" >2014</option>
                                                        <option value="2015" >2015</option>
                                                        <option value="2016" >2016</option>
                                                    </select>
                                                    <label for='nur'>GESTION</label>
                                                </div>
                                            </div>
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
                        <!--
                        <div class="col-md-6">
                             <div class="card card-underline">
                                    <div class="card-head">
                                        <header><span class="glyphicon glyphicon-signal"></span> DATOS GLOBALES </header>
                                    </div>
                                    <div class="card-body" >
                                        <div id="container2" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                    </div>
                            </div> 
                        </div> 
                        -->
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
</body>
</html>
<%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>
