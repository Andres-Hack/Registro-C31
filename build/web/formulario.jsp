<%@page import="pClases.Actividad"%>
<%@page import="java.util.LinkedList"%>
<div class="col-md-10" style="height: 1120px;" ng-controller="myCtrl1" ng-init="cambio=6.86">
                            
                            <script>
                                <% if((request.getAttribute("dato")=="4") || (request.getAttribute("dato")=="1")) {%>
                                window.onload=ok;
                                <% } %>
                                function ok(){
                                    alertify.success("<a href=\"#\"><b><span class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;EL REGISTRO FUE CORRECTO ...!!!</b></a>");
                                    return false;
                                }
                                function error() {
                                    alertify.error("<a href=\"#\"><b>ERROR AL REGISTRAR LOS DATOS ...!!!</b></a>");
                                    return false;
                                }
                            </script>
                             
    
    
                              <form class="form " action="CTRLRegistro" id="form-search" method="post">
                                    <input type="hidden" name="op" value="1" />
                                    <div class="col-md-12 col-sm-12">
                                          <label style="color: white" value="0">Importe en :.</label>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="text" name="txtHR" value="" class="form-control" required />
                                                    <label for='cite_original'>Hoja de Ruta</label>
                                                </div>
                                        </div>
                                        <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="text" name="txtFactura" value="" class="form-control" required />
                                                    <label for='cite_original'>Nro. Factura / Doc. Ref</label>
                                                </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="date" name="txtFechaE" value="" class="form-control" required />
                                                <label for='cite_original'>Fecha emisión</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="date" name="txtFechaP" value="" class="form-control" required/>
                                                <label for='cite_original'>Fecha pago</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="number" name="txtNroC31" value="" class="form-control" required />
                                                <label for='cite_original'>Nro. C31</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtBidctr" required>
                                                    <option value="BID">BID</option>
                                                    <option value="CTR">CTR</option>
                                                </select>
                                                <label for='cite_original'>Recursos</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtFf" ng-model="FF" ng-init="FF='41'" required>
                                                    <option value=""></option>
                                                    <option value="41">41 : Transferencia T.G.N.</option>
                                                    <option value="42">42 : Transferencia de Recursos Especificos.</option>
                                                    <option value="43">43 : Transferencia de Credito Externo.</option>
                                                </select>
                                                <label for='cite_original'>Fuente de Financiamiento</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtOf" required>
                                                    <option value="113" ng-if="FF==='41'">113 : Tesoro General de la Nación - Coparticipación Tributaria.</option>
                                                    <option value="210" ng-if="FF==='42'">210 : Rec.Especif. de Municipalidades e Indigena Originario Campes.</option>
                                                    <option value="411" ng-if="FF==='43'">411 : Banco Interamericano del Desarrollo.</option>
                                                </select>
                                                <label for='cite_original'>Organismo Financiador</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input class="form-control" id="project-name" id="searchbox" required/>
                                                <input type="hidden" name="txtSubc" id="project-id" />
                                                <input type="hidden" name="txtDescSubc" id="project-desc" />
                                                <label for='cite_original'>Subcomponente</label>  
                                            </div>
                                        </div>                                         
                                        <div class="col-md-4">
                                            <div class="form-group">
                                               <input class="form-control" id="actividad-name" required/>
                                               <input type="hidden" name="txtAct" id="actividad-id" />
                                               <input type="hidden" name="txtDescAct" id="actividad-desc" />
                                              <label for='cite_original'>Actividad</label> 
                                              
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input class="form-control" id="subactividad-name" required/>
                                                <input type="hidden" name="txtSubAct" id="subactividad-id" />
                                                <input type="hidden" name="txtDescSubAct" id="subactividad-desc" />
                                              <label for='cite_original'>Sub actividad</label>  
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtGast" required >
                                                    <option value=""></option>
                                                    <option value="2">2</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                </select>
                                                <label for='cite_original'>Clase de gasto</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                             <div class="form-group">
                                                 <select class="form-control" name="txtTipo" required >
                                                    <option value=""></option>
                                                    <option value="E">E</option>
                                                    <option value="S">S</option>
                                                </select>
                                                 <label for='cite_original'>Tipo</label>
                                             </div>
                                         </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input id="hero-demo2" autofocus type="text" name="txtPartida" class="form-control" style="text-transform:uppercase;" required >
                                                <label for='cite_original'>Partida</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtInst" ng-model="inS" ng-init="inS='GAM'" required>
                                                    <option value="GAM" >GAM</option>
                                                    <option value="UEP" >UEP</option>
                                                </select>
                                                <label for='cite_original'>Institucion</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                    <select class="form-control" name="txtGamuep"  ng-if="inS==='UEP'">
                                                        <option value="UEP">UEP</option>
                                                    </select>
                                                    <select class="form-control" name="txtGamuep"  ng-if="inS==='GAM'">
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
                                    </div>
                                     <div class="row">
                                         
                                         <div class="col-md-4">
                                             <div class="form-group">
                                                 <input type="text" name="txtBeneficiario" class="form-control" style="text-transform:uppercase;" required >
                                                 <label for='cite_original'>Beneficiario / Proveedor</label>
                                             </div>
                                         </div>                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtConcepto" class="form-control" style="text-transform:uppercase;" required >
                                                <label for='cite_original'>Concepto</label>
                                            </div>
                                        </div>
                                     </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input id="hero-demo" autofocus type="text" name="txtProducto" class="form-control" style="text-transform:uppercase;" required >
                                                <label for='cite_original'>Producto</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtImporte" class="form-control" ng-model="bolivianos" required >
                                                <label for='cite_original'>Inporte en  Bs <cite style="color: #D83526">* punto decimal.</cite></label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtTc" class="form-control" ng-bind="tc" ng-model="cambio" readonly>
                                                <label for='cite_original'>T/C</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtImporteUSD" class="form-control" placeholder="{{bolivianos/cambio}}" readonly>
                                                <label for='cite_original'>Inporte en  $us</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">                                    
                                      <div class="col-md-12 col-sm-12">
                                          <label style="color: white" value="0">Importe en :.</label>
                                      </div>
                                      <div class="col-md-9 col-sm-9">
                                          <label style="color: white" value="0">Importe en :.</label>
                                      </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">REGISTRAR</button>

                                  </form>
                            </div>
                             
                             
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

