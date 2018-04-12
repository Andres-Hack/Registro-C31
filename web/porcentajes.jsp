
<%@page import="java.util.LinkedList"%>
<%@page import="pClases.Porcentaje"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pModelo.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<% HttpSession sesion = request.getSession(); %>
<% if (sesion.getAttribute("usuario") != null) {%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <%@ include file="/AdminMaterial.jsp"  %>
    </head>
    <body class="menubar-pin header-fixed " ng-app="myApp">

        <%@ include file="/header.jsp"  %> 

        <div id="base">
            <div id="content">
                <section class="bg1">
                    <div class="section-body">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="card card-outlined style-primary">
                                    <div class="card-head">
                                        <div class="tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle btn-close"><i class="glyphicon glyphicon-remove"></i></a>
                                            </div>
                                        </div>
                                        <header><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;Distribucion de porcentajes por :</header>
                                    </div>
                                    <hr/>
                                    <div class="card-body">
                                        <form class="form" action="CTRLPorcentajes" method="post">
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar fa-lg"></span></span>
                                                    <div class="input-group-content">
                                                        <select class="form-control" name="txtgestion" placeholder="Gestión" required>
                                                            <option value="" selected="selected"></option>
                                                            <option value="TODO" >TODO</option>
                                                            <option value="2013" >2013</option>
                                                            <option value="2014" >2014</option>
                                                            <option value="2015" >2015</option>
                                                            <option value="2016" >2016</option>
                                                            <option value="2017" >2017</option>
                                                            <option value="2018" >2018</option>
                                                        </select>
                                                        <label for="select2">Gestión</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-globe fa-lg"></span></span>
                                                    <div class="input-group-content">
                                                        <select name="Gamuep" class="form-control" required>
                                                            <option value="" selected="selected"></option>
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
                                                        <label for="select2">Municipio</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <div class="input-group-content">
                                                        <button type="submit" class="btn btn-success">Buscar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div> 
                            <div class="col-md-7">
                                <div class="card card-bordered style-primary">
                                    <div class="card-head">
                                        <div class="tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle btn-close"><i class="glyphicon glyphicon-remove"></i></a>
                                            </div>
                                        </div>
                                        <header><i class="glyphicon glyphicon-list-alt"></i>&nbsp;&nbsp;Lista de Porcentajes</header>
                                    </div><!--end .card-head -->
                                    <div class="card-body style-default-bright">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Nro</th>
                                                    <th scope="col">GESTION</th>
                                                    <th scope="col">GAM</th>
                                                    <th scope="col">SUB COMPONENTE</th>
                                                    <th scope="col">PORCENTAJE</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% int i=0; %>
                                                <c:forEach items="${porcentaje}" var="p">
                                                    <% i=i+1; %>
                                                    <tr>
                                                        <td><%= i %></td>
                                                        <td>${gestion}</td>
                                                        <td>${municipio}</td>
                                                        <td>${p.getSubComp()}</td>
                                                        <td>${p.getPorcentaje()}&nbsp;%</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div><!--end .card-body -->
                                </div><!--end .card -->
                            </div><!--end .col -->
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
        <%@ include file="/AdminMaterialJS.jsp"  %>
        <!-- BEGIN JIVOSITE CODE {literal} -->
<script type='text/javascript'>
(function(){ var widget_id = 'C1CPRwzVQk';var d=document;var w=window;function l(){
var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = '//code.jivosite.com/script/widget/'+widget_id; var ss = document.getElementsByTagName('script')[0]; ss.parentNode.insertBefore(s, ss);}if(d.readyState=='complete'){l();}else{if(w.attachEvent){w.attachEvent('onload',l);}else{w.addEventListener('load',l,false);}}})();</script>
<div id='jivo_copyright' style='display: none'>Live Chat desarrollado por <a href='https://www.jivochat.es' target='_blank'>www.jivochat.es</a></div>
<!-- {/literal} END JIVOSITE CODE -->
    </body>
</html>
<%} else {
        response.sendRedirect("http://pmgmc2.oopp.gob.bo");
    }%>
