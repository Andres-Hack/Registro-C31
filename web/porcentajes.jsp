
<%@page import="java.util.LinkedList"%>
<%@page import="pClases.Porcentaje"%>
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

    <%@ include file="/header.jsp"  %> 

                    <div id="base">
                        <div id="content">
                            <section class="bg1">
                                <div class="section-body">
                                    <div class="row">
                                       <div class="col-md-12">
                                           <div class="card-head">
                                               <header><span class="glyphicon glyphicon-search"></span> Distribucion de porcentajes por :</header>
                                           </div>
                                           <div class="card-body" ng-controller="myCtrl1">
                                               
                                               <form >
                                                  <div class="row">
                                                    <div class="input-group col-md-4">
                                                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                                        <select class="form-control" name="txtgestion" placeholder="Gestión">
                                                            <option value="" >-----------</option>
                                                            <option value="TODO" >TODO</option>
                                                            <option value="2013" >2013</option>
                                                            <option value="2014" >2014</option>
                                                            <option value="2015" >2015</option>
                                                            <option value="2016" >2016</option>
                                                            <option value="2017" >2017</option>
                                                        </select>
                                                    </div>
                                                      <div class="input-group col-md-4">
                                                              <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                                              <select name="Gamuep" class="form-control">
                                                                  <option value="" selected="selected"></option>
                                                                  <option value="" >-----------</option>
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
                                                      </div>
                                                      <br />
                                                      <button type="submit" class="btn btn-success">Buscar</button>
                                                  </div>
                                               </form>
                                               
                                               
                                               <br /><br />
                                               <div class="card card-underline">
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
                                                        <%
                                                            LinkedList<Porcentaje> lista = pControlador.ListaPorcentaje.getPorsentajes();
                                                            
                                                            for (int i=0;i<lista.size();i++)
                                                            {
                                                               out.println("<tr>");
                                                               out.println("<th scope='row'>"+lista.get(i).getC_Porcentaje()+"</th>");
                                                               out.println("<td>"+lista.get(i).getC_Periodo()+"</td>");
                                                               out.println("<td>"+lista.get(i).getC_Municipio()+"</td>");
                                                               out.println("<td>"+lista.get(i).getC_Municipio()+"</td>");
                                                               out.println("<td>"+lista.get(i).getPorcentaje()+" %</td>");
                                                               out.println("</tr>");
                                                            }
                                                        %>
                                                    </tbody>
                                                  </table>
                                               </div>
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

</body>
</html>
<%}
else {
    response.sendRedirect("http://10.0.6.183:8084/registroC31/");
}%>
