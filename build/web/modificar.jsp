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
            <link type="text/css" href="./css/open-iconic/font/css/open-iconic-bootstrap.css" rel="stylesheet"/>
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