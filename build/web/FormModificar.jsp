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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<% HttpSession sesion = request.getSession(); %>
<% if(sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

    <head>
        <%@ include file="/AdminMaterial.jsp"  %> 
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">
        <%@ include file="/header.jsp"  %> 

        <div id="base">
            <div id="content">
                <section class="bg1">
                    <div class="section-body">
                        <div class="col-lg-offset-2 col-md-6 col-sm-6">
                            <form class="form" action="CTRLModificar" method="post">
                                <div class="card">
                                    <center><h1>Formulario para Modificar</h1></center>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="help1" name="txtID" value="<c:out value="${dato[0]}"/>" >
                                            <label for="help1">ID</label>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFechE" value="<c:out value="${dato[1]}"/>">
                                                    <label >Fecha de Emision</label>
                                                    <p class="help-block" style="color: #D83526">* respetar el formato de fecha</p>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFechP" value="<c:out value="${dato[2]}"/>">
                                                    <label for="help1">Fecha de Pago</label>
                                                    <p class="help-block" style="color: #D83526">* respetar el formato de fecha</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtMesC31" value="<c:out value="${dato[3]}"/>">
                                                    <label for="help1">Mes C31</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtMesPa" value="<c:out value="${dato[4]}"/>">
                                                    <label for="help1">Mes Pago</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtNroC31" value="<c:out value="${dato[5]}"/>">
                                                    <label for="help1">Numero C31</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtBidCtr" value="<c:out value="${dato[6]}"/>">
                                                    <label for="help1">BID / CTR</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtInst" value="<c:out value="${dato[7]}"/>">
                                                    <label for="help1">Inst</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtGam" value="<c:out value="${dato[8]}"/>">
                                                    <label for="help1">GAM</label>
                                                    <p class="help-block" style="color: #D83526">* en esta version solo podremos modificar GAM</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="tooltip1" name="txtBene" data-toggle="tooltip" data-placement="bottom" data-trigger="hover" data-original-title="Ingrese el beneficiario" value="<c:out value="${dato[9]}"/>">
                                            <label for="help1">Beneficiario</label>
                                        </div>                                        
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtImporte" value="<c:out value="${dato[10]}"/>">
                                                    <label for="help1">Importe Bs</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtHR" value="<c:out value="${dato[11]}"/>">
                                                    <label for="help1">Hoja de Ruta</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtNroFac" value="<c:out value="${dato[12]}"/>">
                                                    <label for="help1">Nro. Factura / Doc. Ref.</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!--end .card-body -->
                                    <div class="card-actionbar">
                                        <div class="card-actionbar-row">
                                            <button type="submit" class="btn btn-warning btn-block">Modificar</button>
                                        </div>
                                    </div><!--end .card-actionbar -->
                                </div><!--end .card -->
                            </form>
                        </div>
                </section>
            </div>
        </div>
        </div>
        </div>
        </div></section>
        </div>
        <%@ include file="/menu.jsp"  %> 
        </div>
        
        <%@ include file="/AdminMaterialJS.jsp"  %>    

    </body>
</html>
        <%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>