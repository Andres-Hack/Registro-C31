<%@page import="java.util.LinkedList"%>
<%@page import="pClases.Registro"%>
<%@page import="pReporte.Consultas"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="pControlador.ListaPorcentaje"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <%@ include file="/EstilosJS.jsp"  %> 
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">
        <link rel="stylesheet" type="text/css" href="./css/jquery.dataTables.css">
            <script type="text/javascript" charset="utf8" src="./js/jquery.dataTables.js"></script>
            <%@ include file="/header.jsp"  %> 

            <div id="base">
                <div id="content">
                    <section class="bg1">
                        <div class="section-body">
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <div class="card card-underline" ng-controller="myCtrl1">
                                        <center>
                                            <h1>Lista de Registros C31</h1>
                                            <table class="table table-hover" id="table_id" >
                                                <thead>
                                                    <td>ID</td>
                                                    <td>AÑO</td>
                                                    <td>BENEFICIARIO</td>
                                                    <td></td>
                                                </thead>
                                                <%
                                                    LinkedList<Registro> lista = Consultas.getListaC31();
                                                    for (int i = 0; i < lista.size(); i++) {
                                                        out.println("<tr>");
                                                        out.println("<td>" + lista.get(i).getC_C31() + "</td>");
                                                        out.println("<td>" + lista.get(i).getAnio() + "</td>");
                                                        out.println("<td>" + lista.get(i).getBeneficiario() + "</td>");
                                                        out.println("<td><a href=\"CTRLBuscar?id="+lista.get(i).getC_C31()+"\"><button type=\"button\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon-pencil \"></span></button></a>&nbsp;&nbsp;"
                                                                + "<a href=\"#\"><button type=\"button\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-trash \"></button></a></td>");
                                                        out.println("</tr>");
                                                    }
                                                %>
                                            </table>
                                            
                                        </center>
                                    </div>
                                </div>    
                                <div class="col-md-1"></div>
                            </div>
                        </div>
                </div>
                </section>
            </div>
            </div>
            </div>
            </div></section>
            </div>
            <script>
                $(document).ready( function () {
                    $('#table_id').DataTable();
                } );
            </script>
            <%@ include file="/menu.jsp"  %> 
            </div>
<!-- BEGIN JIVOSITE CODE {literal} -->
<script type='text/javascript'>
(function(){ var widget_id = 'C1CPRwzVQk';var d=document;var w=window;function l(){
var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = '//code.jivosite.com/script/widget/'+widget_id; var ss = document.getElementsByTagName('script')[0]; ss.parentNode.insertBefore(s, ss);}if(d.readyState=='complete'){l();}else{if(w.attachEvent){w.attachEvent('onload',l);}else{w.addEventListener('load',l,false);}}})();</script>
<div id='jivo_copyright' style='display: none'>Live Chat desarrollado por <a href='https://www.jivochat.es' target='_blank'>www.jivochat.es</a></div>
<!-- {/literal} END JIVOSITE CODE -->
    </body>
</html>
            <%}
else {
    response.sendRedirect("http://pmgmc2.oopp.gob.bo");
}%>