<%-- 
    Document   : buscar
    Created on : 18-01-2017, 10:50:25 AM
    Author     : andres
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                                        <option value="SRE">SUCRE</option>
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
                                        <div class="col-md-3">
                                            <div class="form-group">
                                               <select class="form-control" name="txtAct" ng-model="act">
                                                    <option value="" ></option>
                                                    <option value="" >------</option>
                                                    <option value="{{x.a}}" ng-repeat="x in actividad.integrantes" ng-bind="x.a" ng-if=" subc == '2,1'"></option>
                                                    <option value="{{x.b}}" ng-repeat="x in actividad.integrantes" ng-bind="x.b" ng-if=" subc == '2,2'"></option>
                                                    <option value="{{x.c}}" ng-repeat="x in actividad.integrantes" ng-bind="x.c" ng-if=" subc == '2,3'"></option>
                                                    <option value="{{x.d}}" ng-repeat="x in actividad.integrantes" ng-bind="x.d" ng-if=" subc == '2,4'"></option>
                                                </select>
                                              <label for='cite_original'>ACTIVIDAD</label>  
                                            </div>
                                        </div> 
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <select class="form-control" name="suba" >
                                                    <option value="" ></option>
                                                    <option value="" >------</option>
                                                    <option value="{{y.aa}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.aa" ng-if=" act == '2,1,1 : CARTOGRAFIA BASE MUNICIPIOS'"></option>
                                                    <option value="{{y.bb}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.bb" ng-if=" act == '2,1,2 : LEVANTAMIENTO INFORMACIÓN CATASTRAL MUNICIPIOS'"></option>
                                                    <option value="{{y.cc}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.cc" ng-if=" act == '2,1,3 : VALORACIÓN CATASTRAL MUNICIPIOS'"></option>
                                                    <option value="{{y.dd}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.dd" ng-if=" act == '2,1,4 : SANEAMIENTO TECNICO DE LA PROPIEDAD URBANA'"></option>
                                                    <option value="{{y.ee}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ee" ng-if=" act == '2,1,6 : SISTEMA DE CATASTRO URBANO INTERCONECTADO CON LA ADMINISTRACIÓN TRIBUTARIA'"></option>
                                                    <option value="{{y.ff}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ff" ng-if=" act == '2,1,7 : NORMATIVA DE USO DE SUELO URBANO Y PARAMETRO DE EDIFICACIÓN'"></option>
                                                    <option value="{{y.gg}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.gg" ng-if=" act == '2,1,8 : NORMATIVA DE USO DE SUELO URBANO Y PARAMETRO DE EDIFICACIÓN'"></option>
                                                    <option value="{{y.hh}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.hh" ng-if=" act == '2,2,1 : ADQUISICION DEL SOFTWARE, MIGRACIÓN E IMPLEMENTACIÓN'"></option>
                                                    <option value="{{y.ii}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ii" ng-if=" act == '2,3,1 : CAPACITACIÓN MUNICIPIOS'"></option>
                                                    <option value="{{y.jj}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.jj" ng-if=" act == '2,4,1 : SERVICIOS PERSONALES'"></option>
                                                    <option value="{{y.kk}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.kk" ng-if=" act == '2,4,2 : SERVICIOS NO PERSONALES'"></option>
                                                    <option value="{{y.ll}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ll" ng-if=" act == '2,4,3 : MATERIALES Y SUMINISTROS'"></option>
                                                    <option value="{{y.mm}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.mm" ng-if=" act == '2,4,4 : ACTIVOS REALES'"></option>
                                                    <option value="{{y.nn}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.nn" ng-if=" act == '2,4,5 : EVALUACIÓN Y AUDITORIAS'"></option>
                                                    <option value="{{y.oo}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.oo" ng-if=" act == '2,4,6'"></option>
                                                </select>
                                              <label for='cite_original'>SUB-ACTIVIDAD</label>  
                                            </div>
                                        </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <input type="number" class="form-control" name="partida" />
                                                    <label for='nur'>PARTIDA</label>
                                                </div>
                                            </div>
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
                                        String gamuep = "", subc="", partida="", suba="", bid_ctr="", actividad="", v23="", v22="";
                                        String consulta = null, consulta2 = null, consulta3 = null;
                                        partida = request.getParameter("partida");
                                        subc = request.getParameter("subc");
                                        gamuep = request.getParameter("txtGamuep");
                                        suba = request.getParameter("suba");
                                        bid_ctr = request.getParameter("bid_ctr");
                                        actividad = request.getParameter("txtAct");

                                        Connection con = DBConexion.IniciarSesion();

                                        consulta = "select * from tabla_c31 where id >= '1'";
                                        consulta2 = "select ROUND(SUM(importe), 2) total from tabla_c31 where id >= '1'";
                                        consulta3 = "select ROUND(SUM(importe_usd), 2) total from tabla_c31 where id >= '1'";
                                        
                                        
                                        if (partida != "") {
                                           consulta += " and partida = '"+partida+"'";
                                           consulta2 += " and partida = '"+partida+"'";
                                           consulta3 += " and partida = '"+partida+"'";
                                        }
                                        if (subc != "") {
                                           consulta += " and subc = '"+subc+"'";
                                           consulta2 += " and subc = '"+subc+"'";
                                           consulta3 += " and subc = '"+subc+"'";
                                        }
                                        if (gamuep != "") {
                                           consulta += " and gam_uep = '"+gamuep+"'";
                                           consulta2 += " and gam_uep = '"+gamuep+"'";
                                           consulta3 += " and gam_uep = '"+gamuep+"'";
                                        }
                                        if (suba != "") {
                                           consulta += " and subact = '"+suba+"' ";
                                           consulta2 += " and subact = '"+suba+"' ";
                                           consulta3 += " and subact = '"+suba+"' ";
                                        }
                                        if (bid_ctr != "") {
                                           consulta += " and bid_ctr = '"+bid_ctr+"' ";
                                           consulta2 += " and bid_ctr = '"+bid_ctr+"' ";
                                           consulta3 += " and bid_ctr = '"+bid_ctr+"' ";
                                        }
                                        if (actividad != "") {
                                           consulta += " and act = '"+actividad+"' ";
                                           consulta2 += " and act = '"+actividad+"' ";
                                           consulta3 += " and act = '"+actividad+"' ";
                                        }


                                        ResultSet rs = null, rs2 = null, rs3 = null;
                                        PreparedStatement pst = null, pst2 = null, pst3 = null;
                                        pst = con.prepareStatement(consulta);
                                        pst2 = con.prepareStatement(consulta2);
                                        pst3 = con.prepareStatement(consulta3);
                                        rs = pst.executeQuery();             
                                        rs2 = pst2.executeQuery();             
                                        rs3 = pst3.executeQuery();
                                        
                                        
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
                                            <td>&nbsp;&nbsp;&nbsp;<%= gamuep %></td>
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
                                        <% while(rs.next()) { %>
                                            <tr>
                                                <td><%= rs.getString("gestion") %></td>
                                                <td><%= rs.getString("fech_emision") %></td>
                                                <td><%= rs.getString("fech_pago") %></td>
                                                <td><%= rs.getString("nro_c31") %></td>
                                                <td><%= rs.getString("concepto") %></td>
                                                <td><%= rs.getString("partida") %></td>
                                                <td><%= rs.getString("beneficiario") %></td>
                                                <td><%= rs.getString("producto") %></td>
                                                <td><%= rs.getString("descripcion") %></td>
                                                <td><%= rs.getString("importe") %></td>
                                                <td><%= rs.getString("importe_usd") %></td>
                                                <td><%= rs.getString("bid_ctr") %></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                        <h4><i>TOTAL : <%while (rs2.next()) {%><%= rs2.getString("total") %><%}%> Bs,&nbsp;&nbsp;&nbsp;<%while (rs3.next()) {%><%= rs3.getString("total") %><%}%> $us</i></h3><br />
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