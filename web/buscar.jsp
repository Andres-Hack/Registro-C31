<%-- 
    Document   : buscar
    Created on : 18-01-2017, 10:50:25 AM
    Author     : andres
--%>

<%@page import="pReporte.Consultas"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="pControlador.ListaPorcentaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/jquery.bootgrid.min.css" rel="stylesheet" />
        <%@ include file="/EstilosJS.jsp"  %>
        <script src="./js/jquery.bootgrid.js"></script>
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
                                    <header><span class="glyphicon glyphicon-search"></span> Busqueda y Reportes</header>
                                </div>
                                <div class="card-body" ng-controller="myCtrl1">
                                    <form class="form " action="buscar.jsp" id="form-search" method="post">
                                        <div class="row">                                            
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <select name="txtGamuep" class="form-control">
                                                        <option value="" selected="selected"></option>
                                                        <option value="" >------</option>
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
                                            <div class="col-md-3">
                                            <div class="form-group">
                                                <select class="form-control" name="subc" ng-model="subc">
                                                    <option value="" >------</option>
                                                    <option value="2,1" >2,1 : APOYO A LA GESTION CATASTRAL Y SU INTERCONEXION CON LA ADMINISTRACION TRIBUTARIA</option>
                                                    <option value="2,2" >2,2 : ADQUISICION DEL SISTEMA DE CATASTRO</option>
                                                    <option value="2,3" >2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA</option>
                                                    <option value="2,4" >2,4 : ADMINISTRACIÓN Y SUPERVISIÓN</option>
                                                </select>
                                              <label for='cite_original'>SUB-COMPONENTE</label>  
                                            </div>
                                        </div>  
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <select class="form-control" name="bid_ctr">
                                                        <option value="" >------</option>
                                                        <option value="BID" >BID</option>
                                                        <option value="CTR" >CONTRAPARTE</option>
                                                    </select>
                                                    <label for='nur'>BID / CTR</label>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <input type="submit" name="buscar" value="Buscar" class="btn btn-success" />                                
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <%
                                        String gamuep = "", subc="", partida="", suba="", bid_ctr="", actividad="";
                                        String gam="";
                                        String consulta = null;
                                        partida = request.getParameter("partida");
                                        subc = request.getParameter("subc");
                                        gamuep = request.getParameter("txtGamuep");
                                                                                   
                                        suba = request.getParameter("suba");
                                        bid_ctr = request.getParameter("bid_ctr");
                                        actividad = request.getParameter("txtAct");

                                        Connection con = DBConexion.IniciarSesion();
                                        consulta = "select * from C31 where c_C31 >= 1 ";
                                        
                                        if (bid_ctr != "") {
                                            consulta += " and BID_CTR = '"+bid_ctr+"' ";
                                        }
                                        if (subc != "") {
                                           consulta += " and SubComp = '"+subc+"'";
                                        }
                                        if (gamuep != "") {
                                           consulta += " and GAM_UEP = '"+gamuep+"'";
                                        }
                                        if (gamuep == null) {
                                           gamuep="";
                                        }
                                        ListaPorcentaje dato1 = new ListaPorcentaje();
                                        gam=dato1.municipio(gamuep);

                                        ResultSet rs = null;
                                        PreparedStatement pst = null;
                                        pst = con.prepareStatement(consulta);
                                        rs = pst.executeQuery();                         
                                        
                                        DecimalFormat formateador = new DecimalFormat("#,###.##");     
                                    %>
                                </div>
                            </div>    
                        </div>    
                    </div>                  
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <table border="0">
                                        <tbody>
                                          <tr>
                                            <td>GAM / UEP :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= gam %></td>
                                            <td WIDTH="200"></td>
                                            <td>SUB-ACTIVIDAD :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= suba %></td>
                                            <td WIDTH="200"></td>
                                            <td>ACTIVIDAD :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= actividad %></td>
                                          </tr>
                                          <tr>
                                            <td>SUB-COMPONENTE :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= subc %></td>
                                            <td WIDTH="200"></td>
                                            <td>PARTIDA :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= partida %></td>
                                            <td WIDTH="200"></td>
                                            <td>FUENTE :</td>
                                            <td>&nbsp;&nbsp;&nbsp;<%= bid_ctr %></td>
                                          </tr>
                                        </tbody>
                                     </table>
                                </div>
                        </div>
                            <div class="card" id="dvData">
                                <table id="grid" class="table table-bordered no-padding table-striped text-sm table-hover" data-selection="true" data-multi-select="true" data-row-select="true" data-keep-selection="true">
                                    <thead>
                                        <tr>
                                            <th data-column-id="id" data-align="center" data-width="90">Gestion</th>
                                            <th data-column-id="sender" data-align="center" data-width="150">Fecha de emision</th>
                                            <th data-column-id="received" data-align="center" data-filterable="true" data-width="150">Fecha de pago</th>
                                            <th data-column-id="link" data-align="center" data-visible="true" data-width="100" >Nro C31</th>
                                            <th data-column-id="status" data-visible="true" >Concepto</th>
                                            <th data-column-id="partida" data-align="center" data-visible="true" >Partida</th>
                                            <th data-column-id="beneficiario" data-align="center" data-visible="false" >Beneficiario</th>
                                            <th data-column-id="producto" data-align="center" data-visible="false" >Producto</th>
                                            <th data-column-id="descripcion" data-align="center" data-visible="false" >Descripción</th>
                                            <th data-column-id="importe" data-align="center" data-visible="false" >Importe (Bs)</th>
                                            <th data-column-id="importe_sus" data-align="center" data-visible="false" >Importe ($us)</th>
                                            <th data-column-id="fuente" data-align="center" data-visible="false" >Fuente</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% while(rs.next()) { 
                                            String cadenaX = String.valueOf(formateador.format (rs.getDouble("Importe_Bs")));
                                            String cadenaX2 = String.valueOf(formateador.format (rs.getDouble("Importe_Bs")/6.86));
                                        %>
                                            <tr>
                                                <td><%= rs.getString("Anio_Pago") %></td>
                                                <td><%= rs.getString("Fecha_Emision") %></td>
                                                <td><%= rs.getString("Fecha_Pago") %></td>
                                                <td><%= rs.getString("Mes_Dev") %></td>
                                                <td><%= rs.getString("Concepto") %></td>
                                                <td><%= rs.getString("Partida") %></td>
                                                <td><%= rs.getString("Beneficiario") %></td>
                                                <td><%= rs.getString("Producto") %></td>
                                                <td><%= rs.getString("Descripcion") %></td>
                                                <td><%= cadenaX %></td>
                                                <td><%= cadenaX2 %></td>
                                                <td><%= rs.getString("BID_CTR") %></td>
                                            </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <a href="reporte?v1=<%= gamuep %>&v2=<%= subc %>&v3=<%= partida %>&v4=<%= suba %>&v5=<%= bid_ctr %>&v6=<%= actividad %>" target="_blank">
                        <button class="btn btn-danger"><spam class="glyphicon glyphicon-print"></spam>&nbsp;&nbsp;IMPRIMIR REPORTE</button>
                    </a>
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
<script src="./js/fcJS.js" type="text/javascript" charset="utf-8"></script>
<script>
            $("#btnExport").click(function(e) {
                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html()));
                e.preventDefault();
            });
</script>
<script>
    $(function()
    {
	function init()
	{
            $("#grid").bootgrid({
        	formatters: {
				"link": function(column, row)
			{
				return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
			}
		},
            rowCount: [-1, 10, 50, 75]
            });
        }
        init();
    });
</script>

</body>
</html>
</html>
<%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>