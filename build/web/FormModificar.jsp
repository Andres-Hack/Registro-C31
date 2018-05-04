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
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFechaE" value="<c:out value="${dato[1]}"/>">
                                                    <input type="hidden" class="form-control" id="help1" name="txtID" value="<c:out value="${dato[0]}"/>">
                                                    <input type="hidden" name="txtusuario" value="${sessionScope.usuario}" />
                                                    <label >Fecha de Emision</label>
                                                    <p class="help-block" style="color: #D83526">* respetar el formato de fecha</p>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFechaP" value="<c:out value="${dato[2]}"/>">
                                                    <label for="help1">Fecha de Pago</label>
                                                    <p class="help-block" style="color: #D83526">* respetar el formato de fecha</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtMesC31" value="<c:out value="${dato[3]}"/>">
                                                    <label for="help1">Mes C31</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtMesPa" value="<c:out value="${dato[4]}"/>">
                                                    <label for="help1">Mes Pago</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtNroC31" value="<c:out value="${dato[5]}"/>">
                                                    <label for="help1">Numero C31</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">                                            
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtBidCtr" value="<c:out value="${dato[6]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">BID / CTR</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFF" value="<c:out value="${dato[7]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Fuente Financiador</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtOF" value="<c:out value="${dato[8]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Organo Financiador</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtSubComp" class="form-control" id="project-name" value="<c:out value="${dato[9]}"/>">
                                                    <label for="help1">Sub componente</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtAct" class="form-control" id="actividad-name" value="<c:out value="${dato[10]}"/>">
                                                    <label for="help1">Actividad</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtSubAct" class="form-control" id="subactividad-name" value="<c:out value="${dato[11]}"/>">
                                                    <label for="help1">Sub actividad</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtDescSubc" class="form-control" id="project-name" value="<c:out value="${dato[24]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Descripcion Sub componente</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text"  name="txtDescAct" class="form-control" id="actividad-name" value="<c:out value="${dato[25]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Descripcion Actividad</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtDescSubAct" class="form-control" id="subactividad-name" value="<c:out value="${dato[26]}"/>" style="text-transform:uppercase;"
                                                    <label for="help1">Descripcion Sub actividad</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtCg" value="<c:out value="${dato[12]}"/>">
                                                    <label for="help1">Clase de Gasto</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtPartida" value="<c:out value="${dato[14]}"/>">
                                                    <label for="help1">Partida</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtInst" value="<c:out value="${dato[15]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Institución</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtGamuep" value="<c:out value="${dato[16]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">GAM</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtTipo" value="<c:out value="${dato[18]}"/>">
                                                    <label for="help1">Tipo</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtConcepto" value="<c:out value="${dato[20]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Concepto</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="tooltip1" name="txtBeneficiario" data-toggle="tooltip" data-placement="bottom" data-trigger="hover" data-original-title="Ingrese el beneficiario" value="<c:out value="${dato[17]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Beneficiario</label>
                                                </div>  
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtProducto" value="<c:out value="${dato[19]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Producto</label>
                                                </div>
                                            </div>
                                        </div>
                                                                              
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtImporte" value="<c:out value="${dato[21]}"/>">
                                                    <label for="help1">Importe Bs</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtHR" value="<c:out value="${dato[22]}"/>" style="text-transform:uppercase;">
                                                    <label for="help1">Hoja de Ruta</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="help1" name="txtFactura" value="<c:out value="${dato[23  ]}"/>" style="text-transform:uppercase;">
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
<script src="./js/auto-complete.js"></script>
    <script>
        var demo1 = new autoComplete({
            selector: '#hero-demo',
            minChars: 1,
            source: function(term, suggest){
                term = term.toLowerCase();
                var choices = [
                    'ACTIVOS - LICENCIAS',
                    'AIRES ACONDICIONADOS',
                    'AIRES ACONDICIONADOS UEP',
                    'AJUSTE NORMATIVA',
                    'AJUSTE PLANIFICACION Y PROGRAMACION DEL PMGM CII 2016',
                    'ALQUILER DE EQUIPOS SUPERVISIÓN EL TORNO',
                    'ALQUILER EQUIPOS',
                    'ANULADO',
                    'APOYO ADQUISICIONES I',
                    'APOYO AL MANTENIMIENTO DEL HARDWARE Y SOFWARE',
                    'APOYO TECNICO EN PLANIFICACION Y SEGUIMIENTO',
                    'ASESORIA LEGAL EN CONTRATOS ',
                    'AUDITORIA EXTERNA',
                    'CAMARAS DE VIGILANCIA',
                    'CAMARAS LATERALES  Imajbox Twin S',
                    'CAMARAS LATERALES Imajbox S',
                    'CAMPAÑAS DE DIFUSIÓN',
                    'CAPACITACION EN ARCGIS DESKTOP Y ARCGIS SERVER',
                    'CAPACITACIÓN EN GEODESIA Y FOTOGRAMETRICA',
                    'CAPACITACION MANEJO ESTACIONES TOTALES Y GPS',
                    'CAPACITACION REVISION Y CONSENSO PARA LA ELABORACION TDRS LEVANTAMIENTO CATASTRAL',
                    'COMISIONES BANCARIAS',
                    'COMPRA DE STORAGE DELL EQUALLOGIC PS 6210E DE 48 TB ',
                    'COMPRA DE STORAGE DELL EQUALLOGIC PS 6210E DE 96 TB ',
                    'COMPRA MATERIAL ELECTRICO',
                    'COMUNICACIÓN',
                    'CONFERENCIA INTERNACIONAL DE CATASTRO',
                    'CONTROL CALIDAD FOTOS',
                    'CONTROL DE CALIDAD POSTPROCESO VUELO',
                    'CURSO DE CAPACITACION EN MANEJO Y ADMINISTRACION SEICU',
                    'CURSO DE CAPACITACION EN VMWARE',
                    'DETERMINACION PUNTOS DE CONTROL DE CALIDAD',
                    'DIFERENCIAS CAMBIARIAS',
                    'DIFUSION DE CUÑA RADIAL',
                    'DIFUSION DE SPOT TELEVISIVO ',
                    'DIFUSION SPOT PMGM JUNTOS TRABAJAMOS MEJOR',
                    'DIGITALIZACIÓN ',
                    'DIGITALIZACIÓN ARCHIVOS FINANCIEROS PMGM CII',
                    'DISEÑO GRAFICO PARA LA PMGM-CII',
                    'EJECUCION LEVANTAMIENTO CATASTRAL',
                    'EJECUCION NORMATIVA DE USO DE SUELO',
                    'EQUIPO DE COMPUTACIÓN ',
                    'EQUIPO DE COMUNICACIÓN',
                    'EQUIPO EDUCACIONAL Y RECREATIVO',
                    'EQUIPOS DE COMPUTACION ESCRITORIO',
                    'ESTACION TOTAL Y ACCESORIOS',
                    'ESTRATEGIA COMUNICACIONAL DEL PMGM ',
                    'EVENTO REVISION, VERIFICACION Y CAPACITACION EN ADMINISTRACION DE SERVIDORES',
                    'FACILITADOR SOCIAL Y DE PREVENCIÓN DE CONFLICTOS',
                    'FIREWALL',
                    'FOTOCOPIADORAS',
                    'FOTOCOPIAS',
                    'FOTOGRAFIAS RESTITUCIÓN - ORTOFOTO DEL GAM ',
                    'FOTOS LATERALES A NIVEL DE CALLE',
                    'GASTOS DE ALIMENTACION ',
                    'GENERACION DEL SISTEMA DE VALORACION CATASTRAL',
                    'GEODESIA Y CARTOGRAFICA PARA CATASTRO',
                    'GPS RTK Y ESTACION TOTAL',
                    'HONORARIOS PROFESIONALES UEP',
                    'HONORARIOS PROFESIONALES UEP',
                    'II CONFERENCIA Y REUNIÓN ANUAL DE LA RED INTERAMERICANA DE CATASTRO',
                    'INTERNET',
                    'LEVANTAMIENTO TOPOGRAFICO',
                    'LICENCIA RENOVACION GATEWAY SECURITY SUITE',
                    'LICENCIA VMWARE UEP',
                    'LICENCIA WINDOWS SERVER 2012',
                    'LICENCIAS ARGIS GAM',
                    'LICENCIAS SOFTWARE BENTLEY MAP POWER VIEW MICROSTATION Y TERRASOLID BUNDLE',
                    'LICENCIAS SOFTWARE IMAJVIEW PROCESS 3.7 GAM',
                    'LICENCIAS TERRASOLID',
                    'LICENCIAS VMWARE, BSF',
                    'MANTENIMIENTO Y REPARACION DE INMUEBLES ',
                    'MATERIAL DE LIMPIEZA',
                    'MIGRACION DE DATOS',
                    'MONITOREO DEL PMGM CII',
                    'MONITOREO PUBLICITARIO',
                    'MOTOCICLETAS',
                    'MUEBLES DE OFICINA',
                    'MUEBLES Y ENSERES',
                    'OTRA MAQUINARIA - BIOMETRICO',
                    'OTROS ALQUILERES',
                    'PAGINA WEB',
                    'PAPEL',
                    'PAPEL RECICLADO',
                    'PASAJES AEREOS',
                    'PASAJES AEREOS ',
                    'PASAJES AL EXTERIOR',
                    'PASAJES TERRESTRES',
                    'PLANIFICACION URBANA',
                    'PLOTTER CANON 44"',
                    'POSICIONAMIENTO  PMGM CII',
                    'PRODUCCION DE 3 CUÑAS RADIALES',
                    'PRODUCCION DE SPOT PUBLICITARIOS ',
                    'PRODUCCION MATERIAL AUDIVISUAL ',
                    'PUBLICACION CONVOCATORIA',
                    'PUBLICIDAD EN VALLAS',
                    'RED GEODESICA',
                    'RED GEODESICA Y LEVANTAMIENTO TOPOGRAFICO COBIJA',
                    'REDES SOCIALES Y PÁGINA WEB',
                    'REFRIGERIOS PERSONAL',
                    'RESTITUCIÓN FOTOGRAMETRICA',
                    'REUNION CON INCLAM',
                    'REVERTIDO',
                    'SEGURO DE ACTIVOS ',
                    'SEGUROS MOTOCICLETAS',
                    'SERVICIO DE LIMPIEZA ',
                    'SERVICIOS MANUALES ',
                    'SERVIDOR Y ACCESORIOS',
                    'SIMPOSION INTER.GEODESIA Y FOTOGRAMETRICA',
                    'SIST. GEST. CENTRALIZADA INFRAEST VIRTUAL',
                    'SISTEMA RESPALDO INFRAES. VIRTUAL',
                    'SISTEMATIZACION TALLER CAPACITACIÓN EN CATASTRO URBANO',
                    'SISTEMATIZACION TALLER GEODESIA Y FOTOGRAMETRICA',
                    'SOFTWARE DE DIGITALIZACIÓN',
                    'SOFTWARE SEICU',
                    'SPOTS DE LA CAMPAÑA ¨MI MUNICIPIO MEJORA¨',
                    'STORAGE Y SERVIDORES',
                    'SUPERVISIÓN LEVANTAMIENTO CATASTRAL',
                    'SUPERVISIÓN NORMA USO DE SUELO',
                    'SUPERVISIÓN RED GEODESICA',
                    'SUPERVISIÓN RED GEODESICA Y LEVANTAMIENTO TOPOGRAFICO  COBIJA',
                    'SUPERVISIÓN RESTITUCIÓN FOTOGRAMETRICA',
                    'SUPERVISIÓN SEICU',
                    'SUPERVISIÓN VUELO',
                    'TALLER CAPACITACION SEICU 3 MODULOS',
                    'TALLER CATASTRO URBANO',
                    'TALLER COORDINACION',
                    'TALLER CURSO CAPACITACION EN SITEMA IMAJING Y SOFTWARE IMAJVIEW',
                    'TALLER DE ANALISIS Y ESTADO DE SITUACIÓN DEL PMGM CII',
                    'TALLER DE CAPACITACION SOFTWARE TERRASOLID',
                    'TALLER DE INICIO CONSULTORIA DE USO DE SUELO ',
                    'TALLER DE PRUEBAS DE FUNCIONALIDAD, REVISION Y VALIDACION MODULOS DEL SEICU',
                    'TALLER DE RENDICION DE CUENTAS PMGM CII',
                    'TALLER DE RENDICION DE CUENTAS PMGM CII 2017',
                    'TALLER DE SOCIALIZACION DE DIAGNOSTICO URBANO',
                    'TALLER DE VALORACION CATASTRAL',
                    'TALLER GAMS COORDINACION',
                    'TALLER INTERCAMBIO CRITERIOS TECNICOS METODOLOGIA SUPERVISIÓN LEV. CATASTRAL',
                    '"TALLER INTERNO ELABORACION POA 2017 DEL',
                    'PMGM CII"',
                    'TALLER NORMA DE VALORACION',
                    'TALLER PLANIFICACION URBANA',
                    'TALLER SERVIDORES',
                    'TALLER TDRS SEICU',
                    'TALLER TEMATICA DEL DERECHO PROPIETARIO ',
                    'TÉCNICO EN ADQUISICIONES, ORGANIZACIÓN Y CLASIFICACIÓN DEL ARCHIVO DOCUMENTAL',
                    'TELEFONÍA',
                    'TELEVISOR',
                    'TRANSPORTE DE MATERIAL',
                    'TRANSPORTE PERSONAL ',
                    'UTILES DE ESCRITORIO Y OFICINA',
                    'VALIDACION DE LA PLANILLA DE REQUERIMIENTO DE EQUIPAMIENTO DE LOS GAM',
                    'VALIDACION SEICU',
                    'VEHICULOS PARA LOS GAM',
                    'VIAJE A COLOMBIA',
                    'VIAJE A COSTA RICA',
                    'VIATICOS AL EXTERIOR',
                    'VIATICOS VIAJES',
                    'VUELO FOTOGRAMETRICO'
                ];
                var suggestions = [];
                for (i=0;i<choices.length;i++)
                    if (~choices[i].toLowerCase().indexOf(term)) suggestions.push(choices[i]);
                suggest(suggestions);
            }
        });
        var demo2 = new autoComplete({
            selector: '#hero-demo2',
            minChars: 1,
            source: function(term, suggest){
                term = term.toLowerCase();
                var choices2 = [
                    '25820','26990','22210','25300','25500','22110','39500','43120','22220','31120',
                    '22120','25600','43110','23200','23400','32100','31110','43500','22600','21400',
                    '25900','39700','22300','25810','26950','39100','49100','25230','21100','21600',
                    '43600','25400','24110','43320','43700','22500'
                ];
                var suggestions = [];
                for (i=0;i<choices2.length;i++)
                    if (~choices2[i].toLowerCase().indexOf(term)) suggestions.push(choices2[i]);
                suggest(suggestions);
            }
        });
        
        $(function() {
            var availableTags = [
                {key:"2,1", value:"2.1 ACTUALIZACION DE LOS REGISTROS DE CATASTRO", desc:"ACTUALIZACION DE LOS REGISTROS DE CATASTRO"},
                {key:"2,2", value:"2.2 DESARROLLO DE LOS SISTEMAS DE GESTION CATASTRAL", desc:"DESARROLLO DE LOS SISTEMAS DE GESTION CATASTRAL"},
                {key:"2,3", value:"2.3 CAPACITACION, ASISTENCIA TECNICA Y DIFUSIÓN", desc:"CAPACITACION, ASISTENCIA TECNICA Y DIFUSIÓN"},
                {key:"2,4", value:"2.4 ADMINISTRACION, EVALUACION Y AUDITORIAS", desc:"ADMINISTRACION, EVALUACION Y AUDITORIAS"}
            ];
            var actividadTag = [
                {key:"2,1,1", value:"2.1.1 CARTOGRAFIA BASE DE LOS MUNICIPIOS", desc:"CARTOGRAFIA BASE DE LOS MUNICIPIOS"},
                {key:"2,1,2", value:"2.1.2 LEVANTAMIENTO INFORMACION CATASTRAL MUNICIPIOS", desc:"LEVANTAMIENTO INFORMACION CATASTRAL MUNICIPIOS"},
                {key:"2,1,3", value:"2.1.3 VALORACION CATASTRAL ", desc:"VALORACION CATASTRAL "},
                {key:"2,1,6", value:"2.1.6 SISTEMA DE CATASTRO INTERCONECTADO", desc:"SISTEMA DE CATASTRO INTERCONECTADO"},
                {key:"2,1,7", value:"2.1.7 NORMATIVA DE USO DE SUELO URBANO Y PARAMETROS DE EDIFICACION", desc:"NORMATIVA DE USO DE SUELO URBANO Y PARAMETROS DE EDIFICACION"},
                {key:"2,2,1", value:"2.2.1 ADQUISICION DEL SISTEMA DE CATASTRO", desc:"ADQUISICION DEL SISTEMA DE CATASTRO"},
                {key:"2,2,2", value:"2.2.2 ADQUISICION DEL SISTEMA DE CATASTRO", desc:"ADQUISICION DEL SISTEMA DE CATASTRO"},
                {key:"2,3,1", value:"2.3.1 CAPACITACIÓN", desc:"CAPACITACIÓN"},
                {key:"2,3,2", value:"2.3.2 DIFUSIÓN", desc:"DIFUSIÓN"},
                {key:"2,3,3", value:"2.3.3 ASISTENCIA TÉCNICA", desc:"ASISTENCIA TÉCNICA"},
                {key:"2,4,1", value:"2.4.1 SERVICIOS PERSONALES", desc:"SERVICIOS PERSONALES"},
                {key:"2,4,2", value:"2.4.2 SERVICIOS NO PERSONALES", desc:"SERVICIOS NO PERSONALES"},
                {key:"2,4,3", value:"2.4.3 MATERIALES Y SUMINISTROS", desc:"MATERIALES Y SUMINISTROS"},
                {key:"2,4,4", value:"2.4.4 ACTIVOS REALES", desc:"ACTIVOS REALES"},
                {key:"2,4,5", value:"2.4.5 OTROS SERVICIOS PERSONALES", desc:"OTROS SERVICIOS PERSONALES"}
            ];
            var subactividadTags = [
                {key:"2,1,1,1", value:"2.1.1.1 RED GEODESICA", desc:"RED GEODESICA"},
                {key:"2,1,1,2", value:"2.1.1.2 RED GEODESICA Y LEVANTAMIENTO TOPOGRAFICO", desc:"RED GEODESICA Y LEVANTAMIENTO TOPOGRAFICO"},
                {key:"2,1,1,4", value:"2.1.1.4 RESTITUCION FOTOGRAMETRICA", desc:"RESTITUCION FOTOGRAMETRICA"},
                {key:"2,1,2,1", value:"2.1.2.1 LEVANTAMIENTO CATASTRAL", desc:"LEVANTAMIENTO CATASTRAL"},
                {key:"2,1,2,2", value:"2.1.2.2 LEVANTAMIENTO CATASTRAL", desc:"LEVANTAMIENTO CATASTRAL"},
                {key:"2,1,3,1", value:"2.1.3.1 VALORACION CATASTRAL", desc:"VALORACION CATASTRAL"},
                {key:"2,1,6,1", value:"2.1.6.1 EQUIPOS DE OFICINA Y MUEBLES", desc:"EQUIPOS DE OFICINA Y MUEBLES"},
                {key:"2,1,6,2", value:"2.1.6.2 EQUIPOS DE COMPUTACIÓN", desc:"EQUIPOS DE COMPUTACIÓN"},
                {key:"2,1,6,3", value:"2.1.6.3 VEHICULOS Y MOTOCICLETAS", desc:"VEHICULOS Y MOTOCICLETAS"},
                {key:"2,1,6,4", value:"2.1.6.4 EQUIPOS DE COMUNICACIÓN", desc:"EQUIPOS DE COMUNICACIÓN"},
                {key:"2,1,6,5", value:"2.1.6.5 ACTIVOS INTANGIBLES", desc:"ACTIVOS INTANGIBLES"},
                {key:"2,1,7,1", value:"2.1.7.1 NORMA USO DE SUELO", desc:"NORMA USO DE SUELO"},
                {key:"2,1,7,2", value:"2.1.7.2 NORMA USO DE SUELO", desc:"NORMA USO DE SUELO"},
                {key:"2,2,1,1", value:"2.2.1.1 ADQUISICION DEL SOFTWARE, MIGRACIÓN E IMPLANTACIÓN", desc:"ADQUISICION DEL SOFTWARE, MIGRACIÓN E IMPLANTACIÓN"},
                {key:"2,2,2,1", value:"2.2.2.1 DIGITALIZACIÓN ARCHIVOS DE CATASTRO", desc:"DIGITALIZACIÓN ARCHIVOS DE CATASTRO"},
                {key:"2,3,1,1", value:"2.3.1.1 TALLERES, CURSOS, REUNIONES Y OTROS", desc:"TALLERES, CURSOS, REUNIONES Y OTROS"},
                {key:"2,3,2,1", value:"2.3.2.1 MATERIAL PROMOCIONAL", desc:"MATERIAL PROMOCIONAL"},
                {key:"2,3,2,2", value:"2.3.2.2 DIFUSIÓN MASIVA", desc:"DIFUSIÓN MASIVA"},
                {key:"2,3,2,3", value:"2.3.2.3 PUBLICACION DE CONVOCATORIAS", desc:"PUBLICACION DE CONVOCATORIAS"},
                {key:"2,3,2,4", value:"2.3.2.4 SOCIALIZACIÓN DEL PMGM", desc:"SOCIALIZACIÓN DEL PMGM"},
                {key:"2,3,3,1", value:"2.3.3.1 ASISTENCIA TECNICA COMUNICACIÓN", desc:"ASISTENCIA TECNICA COMUNICACIÓN"},
                {key:"2,3,3,2", value:"2.3.3.2 ASISTENCIA TECNICA SEICU", desc:"ASISTENCIA TECNICA SEICU"},
                {key:"2,3,3,3", value:"2.3.3.3 ASISTENCIA TECNICA COMUNICACIÓN", desc:"ASISTENCIA TECNICA COMUNICACIÓN"},
                {key:"2,3,3,3", value:"2.3.3.3 ASISTENCIA TECNICA UEP", desc:"ASISTENCIA TECNICA UEP"},
                {key:"2,3,3,3", value:"2.3.3.3 REVERTIDO", desc:"REVERTIDO"},
                {key:"2,3,3,X", value:"2.3.3.X ASISTENCIA TECNICA UEP", desc:"ASISTENCIA TECNICA UEP"},
                {key:"2,4,1,1", value:"2.4.1.1 HONORARIOS PROFESIONALES", desc:"HONORARIOS PROFESIONALES"},
                {key:"2,4,1,2", value:"2.4.1.2 HONORARIOS PROFESIONALES", desc:"HONORARIOS PROFESIONALES"},
                {key:"2,4,2,1", value:"2.4.2.1 SERVICIOS BASICOS", desc:"SERVICIOS BASICOS"},
                {key:"2,4,2,2", value:"2.4.2.2 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,2,3", value:"2.4.2.3 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,2,4", value:"2.4.2.4 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,2,5", value:"2.4.2.5 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,2,6", value:"2.4.2.6 ADQUISICION SOFTWARE DE CATASTRO", desc:"ADQUISICION SOFTWARE DE CATASTRO"},
                {key:"2,4,3,1", value:"2.4.3.1 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,3,2", value:"2.4.3.2 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,3,3", value:"2.4.3.3 BIENES Y SERVICIOS", desc:"BIENES Y SERVICIOS"},
                {key:"2,4,4,1", value:"2.4.4.1 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,2", value:"2.4.4.2 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,3", value:"2.4.4.3 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,4", value:"2.4.4.4 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,5", value:"2.4.4.5 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,6", value:"2.4.4.6 BIENES DE USO", desc:"BIENES DE USO"},
                {key:"2,4,4,x", value:"2.4.4.x ACTIVOS INTANGIBLES", desc:"ACTIVOS INTANGIBLES"},
                {key:"2,4,5,1", value:"2.4.5.1 AUDITORIA EXTERNA 2013-2014", desc:"AUDITORIA EXTERNA 2013-2014"},
                {key:"2,4,5,2", value:"2.4.5.2 AUDITORIA EXTERNA 2015", desc:"AUDITORIA EXTERNA 2015"},
                {key:"2,4,5,3", value:"2.4.5.3 AUDITORIA EXTERNA 2016", desc:"AUDITORIA EXTERNA 2016"}
            ];

            $("#project-name").autocomplete({
              minLength: 0,
              source: availableTags,
              focus: function(event, ui) {
                $("#project-name").val(ui.item.value);
                return false;
              },
              select: function(event, ui) {
                $("#project-name").val(ui.item.value);
                $("#project-id").val(ui.item.key);
                $("#project-desc").val(ui.item.desc);
                return false;
              }
            });
            $("#actividad-name").autocomplete({
              minLength: 0,
              source: actividadTag,
              focus: function(event, ui) {
                $("#actividad-name").val(ui.item.value);
                return false;
              },
              select: function(event, ui) {
                $("#actividad-name").val(ui.item.value);
                $("#actividad-id").val(ui.item.key);
                $("#actividad-desc").val(ui.item.desc);
                return false;
              }
            });
            $("#subactividad-name").autocomplete({
              minLength: 0,
              source: subactividadTags,
              focus: function(event, ui) {
                $("#subactividad-name").val(ui.item.value);
                return false;
              },
              select: function(event, ui) {
                $("#subactividad-name").val(ui.item.value);
                $("#subactividad-id").val(ui.item.key);
                $("#subactividad-desc").val(ui.item.desc);
                return false;
              }
            });

          });
    </script>
    </body>
</html>
        <%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>