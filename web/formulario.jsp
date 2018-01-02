<div class="col-md-10" style="height: 1120px;" ng-controller="myCtrl1" ng-init="cambio=6.86">
                                
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
                                                <input type="date" name="txtFechaP" value="" class="form-control" />
                                                <label for='cite_original'>Fecha pago</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtMesC31"  required >
                                                    <option value="1">Enero</option>
                                                    <option value="2">Febrero</option>
                                                    <option value="3">Marzo</option>
                                                    <option value="4">Abril</option>
                                                    <option value="5">Mayo</option>
                                                    <option value="6">Junio</option>
                                                    <option value="7">Julio</option>
                                                    <option value="8">Agosto</option>
                                                    <option value="9">Septiembre</option>
                                                    <option value="10">Octubre</option>
                                                    <option value="11">Noviembre</option>
                                                    <option value="12">Diciembre</option>
                                                  </select>
                                                <label for='cite_original'>Mes C31</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtPago">
                                                    <option value="1">Enero</option>
                                                    <option value="2">Febrero</option>
                                                    <option value="3">Marzo</option>
                                                    <option value="4">Abril</option>
                                                    <option value="5">Mayo</option>
                                                    <option value="6">Junio</option>
                                                    <option value="7">Julio</option>
                                                    <option value="8">Agosto</option>
                                                    <option value="9">Septiembre</option>
                                                    <option value="10">Octubre</option>
                                                    <option value="11">Noviembre</option>
                                                    <option value="12">Diciembre</option>
                                                </select>
                                                <label for='cite_original'>Mes pago</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="number" name="txtNroC31" value="" class="form-control" required />
                                                <label for='cite_original'>Nro. C31</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtBidctr">
                                                    <option value="BID">BID</option>
                                                    <option value="CTR">CTR</option>
                                                </select>
                                                <label for='cite_original'>Recursos</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtFf">
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
                                                <select class="form-control" name="txtOf">
                                                    <option value=""></option>
                                                    <option value="113">113 : Tesoro General de la Nación - Coparticipación Tributaria.</option>
                                                    <option value="210">210 : Rec.Especif. de Municipalidades e Indigena Originario Campes.</option>
                                                    <option value="411">411 : Banco Interamericano del Desarrollo.</option>
                                                </select>
                                                <label for='cite_original'>Organismo Financiador</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <textarea class="form-control" rows="2" name="txtDescripcion" style="text-transform:uppercase;" required></textarea>
                                                <label for='cite_original'>Descripcion</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtSubc" ng-model="subc">
                                                    <option value="2,1" >2,1 : APOYO A LA GESTION CATASTRAL Y SU INTERCONEXION CON LA ADMINISTRACION TRIBUTARIA</option>
                                                    <option value="2,2" >2,2 : ADQUISICION DEL SISTEMA DE CATASTRO</option>
                                                    <option value="2,3" >2,3 : CAPACITACIÓN Y DIFUSION y ASISTENCIA TECNICA</option>
                                                    <option value="2,4" >2,4 : ADMINISTRACIÓN Y SUPERVISIÓN</option>
                                                </select>
                                              <label for='cite_original'>SUBC</label>  
                                            </div>
                                        </div>  
                                        <div class="col-md-4">
                                            <div class="form-group">
                                               <select class="form-control" name="txtAct" ng-model="act">
                                                    <option value="{{x.a2}}" ng-repeat="x in actividad.integrantes" ng-bind="x.a" ng-if=" subc == '2,1'"></option>
                                                    <option value="{{x.b2}}" ng-repeat="x in actividad.integrantes" ng-bind="x.b" ng-if=" subc == '2,2'"></option>
                                                    <option value="{{x.c2}}" ng-repeat="x in actividad.integrantes" ng-bind="x.c" ng-if=" subc == '2,3'"></option>
                                                    <option value="{{x.d2}}" ng-repeat="x in actividad.integrantes" ng-bind="x.d" ng-if=" subc == '2,4'"></option>
                                                </select>
                                              <label for='cite_original'>Actividad</label>  
                                            </div>
                                        </div> 
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtSubAct" ng-model="subact">
                                                    <option value="" ></option>
                                                    <option value="{{y.aa2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.aa" ng-if=" act == '2,1,1'"></option>
                                                    <option value="{{y.bb2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.bb" ng-if=" act == '2,1,2'"></option>
                                                    <option value="{{y.cc2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.cc" ng-if=" act == '2,1,3'"></option>
                                                    <option value="{{y.dd2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.dd" ng-if=" act == '2,1,4'"></option>
                                                    <option value="{{y.ee2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ee" ng-if=" act == '2,1,6'"></option>
                                                    <option value="{{y.ff2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ff" ng-if=" act == '2,1,7'"></option>
                                                    <option value="{{y.gg2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.gg" ng-if=" act == '2,1,8'"></option>
                                                    <option value="{{y.hh2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.hh" ng-if=" act == '2,2,1'"></option>
                                                    <option value="{{y.ii2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ii" ng-if=" act == '2,3,1'"></option>
                                                    <option value="{{y.jj2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.jj" ng-if=" act == '2,4,1'"></option>
                                                    <option value="{{y.kk2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.kk" ng-if=" act == '2,4,2'"></option>
                                                    <option value="{{y.ll2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.ll" ng-if=" act == '2,4,3'"></option>
                                                    <option value="{{y.mm2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.mm" ng-if=" act == '2,4,4'"></option>
                                                    <option value="{{y.nn2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.nn" ng-if=" act == '2,4,5'"></option>
                                                    <option value="{{y.oo2}}" ng-repeat="y in actividad.integrantes2" ng-bind="y.oo" ng-if=" act == '2,4,6'"></option>
                                                </select>
                                              <label for='cite_original'>Sub actividad</label>  
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="number" name="txtGast" class="form-control">
                                                <label for='cite_original'>Cat. gasto</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtTipo" class="form-control">
                                                <label for='cite_original'>Tipo de gasto</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="number" name="txtPartida" class="form-control">
                                                <label for='cite_original'>Partida</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control" name="txtInst" ng-model="inS" ng-init="inS='GAM'">
                                                    <option value="GAM" >GAM</option>
                                                    <option value="UEP" >UEP</option>
                                                </select>
                                                <label for='cite_original'>Institucion</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                    <select class="form-control" name="txtGamuep"  ng-if="inS=='UEP'">
                                                        <option value="UEP">UEP</option>
                                                    </select>
                                                    <select class="form-control" name="txtGamuep"  ng-if="inS=='GAM'">
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
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtBeneficiario" class="form-control" style="text-transform:uppercase;" required >
                                                <label for='cite_original'>Beneficiario / Proveedor</label>
                                            </div>
                                        </div>
                                    </div>
                                     <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtProducto" class="form-control" style="text-transform:uppercase;" required >
                                                <label for='cite_original'>Producto</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtActividad2" class="form-control" style="text-transform:uppercase;" >
                                                <label for='cite_original'>Actividad 2</label>
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
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtImporte" class="form-control" ng-model="bolivianos" required >
                                                <label for='cite_original'>Inporte en  Bs</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <input type="text" name="txtTc" class="form-control" ng-bind="tc" ng-model="cambio">
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
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <textarea class="form-control" rows="2" name="txtObservaciones" style="text-transform:uppercase;" required></textarea>
                                                <label for='cite_original'>Observacion</label>
                                            </div>
                                        </div>
                                    </div>
                                      <div class="col-md-12 col-sm-12">
                                          <label style="color: white" value="0">Importe en :.</label>
                                      </div>
                                      <div class="col-md-9 col-sm-9">
                                          <label style="color: white" value="0">Importe en :.</label>
                                      </div>
                                      <div class="col-md-3 col-sm-3">
                                          <button type="submit" class="btn btn-primary">REGISTRAR</button>
                                      </div>

                                  </form>
                            </div>

