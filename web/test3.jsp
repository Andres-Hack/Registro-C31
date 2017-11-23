
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/EstilosJS.jsp"  %> 
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
                                    <% 
                                        String num = request.getParameter("id");
                                        String num2 = request.getParameter("id2");
                                    %>
                                    <header>Pagina de Municipio</header>
                                </div>
                                <div class="card-body" ng-controller="myCtrl1" ng-init="cambio=6.86; bolivianos=0">
                                    <form class="form " action="test.jsp" id="form-search" method="post">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <input type="text" name="txtNombre" value="" class="form-control" />
                                                    <label for='nur'>Nombre</label>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <input type="text" name="txtImporte" class="form-control" ng-model="bolivianos">
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
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <select name="txtSubc" class="form-control">
                                                        <option value="2,3">2,3</option>
                                                        <option value="2,4">2,4</option>
                                                        </select>
                                                    <label for='cite_original'>Sub-Componente</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <input type="submit" name="buscar" value="Guardar" class="btn btn-success" />                                
                                                </div>
                                                  
                                            </div>
                                        </div>
                                    </form>
                                    
                                </div>
                            </div>    
                        </div>    
                    </div>
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

</body>
</html>
