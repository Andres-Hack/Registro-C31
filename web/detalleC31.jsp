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
                    <div class="col-md-6 ">
                        <div class="card card-underline">
                            <div class="card-head style-success">
                                <header><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;Detalle de Registro</header>
                            </div>
                            <div class="card-body no-padding"><br />
                                <center><img src="./img/fotoDJ.png" width="800" height="70"></center>
                                <br />
                                <table class="table table-hover">
                                    <c:forEach items="${registro}" var="r">
                                    <tbody>
                                        <tr>
                                            <td style="width: 200px; overflow: auto;">Nro. C31 :</td>
                                            <td><strong>${r.getC31()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Año de pago :</td>
                                            <td><strong>${r.getAnio_Pago()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de emision :</td>
                                            <td><strong>${r.getFecha_Emision()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de pago :</td>
                                            <td><strong>${r.getFecha_Pago()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Mes C31 :</td>
                                            <td><strong>${r.getC31()}</strong></td>
                                        </tr><tr>
                                            <td>Mes de pago :</td>
                                            <td><strong>${r.getMes_Pago()}</strong></td>
                                        </tr><tr>
                                            <td>BID/CTR :</td>
                                            <td><strong>${r.getBID_CTR()}</strong></td>
                                        </tr><tr>
                                            <td>F.F. :</td>
                                            <td><strong>${r.getF_F()}</strong></td>
                                        </tr><tr>
                                            <td>O.F. :</td>
                                            <td><strong>${r.getO_F()}</strong></td>
                                        </tr><tr>
                                            <td>Sub componente :</td>
                                            <td><strong>${r.getSubComp()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Actividad :</td>
                                            <td><strong>${r.getActividad()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Sub actividad :</td>
                                            <td><strong>${r.getSubactividad()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Cat. Gasto :</td>
                                            <td><strong>${r.getC_G()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Partida :</td>
                                            <td><strong>${r.getPartida()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Institucion :</td>
                                            <td><strong>${r.getInst()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>GAM/UEP :</td>
                                            <td><strong>${r.getGAM_UEP()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Beneficiario :</td>
                                            <td><strong>${r.getBeneficiario()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Tipo :</td>
                                            <td><strong>${r.getTipo()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Producto :</td>
                                            <td><strong>${r.getProducto()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Concepto :</td>
                                            <td><strong>${r.getConcepto()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Importe (Bs) :</td>
                                            <td><strong>${r.getImporte_Bs()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Importe ($us) :</td>
                                            <td><strong>${r.getImporte_Us()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Hoja Ruta :</td>
                                            <td><strong>${r.getHoja_Ruta()}</strong></td>
                                        </tr>
                                        <tr>
                                            <td>Nro. Factura :</td>
                                            <td><strong>${r.getNro_Factura()}</strong></td>
                                        </tr>
                                    </tbody>
                                    </c:forEach>
                                </table>
                            </div><!--end .card-body -->
                        </div>
                    </div>                    
                    <p><a href="CTRLRegistro"><button type="button" class="btn ink-reaction btn-floating-action btn-primary active"><i class="oi oi-chevron-left" style="font-size: 20px"></i></button></p></a>
                </div>
        </div></section>
    </div>
    <%@ include file="/menu.jsp"  %> 
</div>

</body>
</html>
<%}
else {
    response.sendRedirect("http://pmgmc2.oopp.gob.bo");
}%>
