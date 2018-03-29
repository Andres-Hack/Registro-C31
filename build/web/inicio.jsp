<%-- 
    Document   : inicio
    Created on : 18-01-2017, 10:21:46 AM
    Author     : andres
--%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/AdminMaterial.jsp"  %>
    <%@ include file="/AdminMaterialJS.jsp"  %>
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300">
    <link rel="stylesheet" href="https://cdn.rawgit.com/yahoo/pure-release/v0.6.0/pure-min.css">
    <link rel="stylesheet" href="./css/auto-complete.css">
    
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    <script type="text/javascript" src="./js/alertify.js"></script>
    <link rel="stylesheet" href="./css/alertify.core.css" />
    <link rel="stylesheet" href="./css/alertify.default.css" />


</head>

<body class="menubar-pin header-fixed " ng-app="myApp">

<%@ include file="/header.jsp"  %> 

<div id="base">
    <div id="content">
        <section class="bg1">
            <div class="section-body">
                <div class="row">
                    <div class="col-md-6">
                         <div class="card card-underline">
                            <div class="card-head style-info">
                                <header><span class="glyphicon glyphicon-save"></span> Registro C31</header>
                            </div>
                            <div class="col-md-1"><label style="color: white">.</label></div>
                            <%@ include file="/formulario.jsp"  %> 
                            <div class="col-md-1"><label style="color: white">.</label></div>
                        </div>
                    </div>

                    <div class="col-md-6 ">
                        <div class="card card-underline">
                            <div class="card-head style-success">
                                <header><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;Lista de Ultimos Ingresos</header>
                            </div>
                            <div class="card-body no-padding">
                                <div class="table-responsive no-margin">
                                    <table class="table table-striped no-margin">
                                        <thead>
                                            <tr>
                                                <th>Nro.</th>
                                                <th>Nro C31</th>
                                                <th>Sub Componente</th>
                                                <th>Actividad</th>
                                                <th>Sub Actividad</th>
                                                <th>Beneficiario</th>
                                                <th>Monto (Bs.)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${registro}" var="r">
                                                <tr>
                                                    <td>${r.getC_C31()}</td>
                                                    <td>${r.getC31()}</td>
                                                    <td>${r.getSubComp()}</td>
                                                    <td>${r.getActividad()}</td>
                                                    <td>${r.getSubactividad()}</td>
                                                    <td>${r.getBeneficiario()}</td>
                                                    <td>${r.getImporte_Bs()}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div><!--end .table-responsive -->
                            </div><!--end .card-body -->
                        </div>
                    </div>                    
                </div>
        </div></section>
    </div>
    <%@ include file="/menu.jsp"  %> 
</div>

</body>
</html>
<%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>
