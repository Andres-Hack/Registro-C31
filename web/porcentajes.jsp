
<%@page import="java.util.LinkedList"%>
<%@page import="pClases.Porcentaje"%>
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
                                           <div class="card-head">
                                               <header><span class="glyphicon glyphicon-search"></span> Distribucion de porcentajes</header>
                                           </div>
                                           <div class="card-body" ng-controller="myCtrl1">
                                               
                                               <form >
                                                  <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                    <input id="email" type="text" class="form-control" name="email" placeholder="Email">
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
                                                               out.println("<th scope='row'>"+lista.get(i).getId()+"</th>");
                                                               out.println("<td>"+lista.get(i).getGestion()+"</td>");
                                                               out.println("<td>"+lista.get(i).getGam()+"</td>");
                                                               out.println("<td>"+lista.get(i).getSubc()+"</td>");
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
