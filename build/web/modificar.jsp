
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
                                            <center>
                                                <p class="bg-danger">La Pagina esta en Mantenimiento ......</p>
                                                <img src="./img/pc.gif" height="400" width="500" >
                                                    <% 
                                                        /*
                                                        String consulta = null, consulta1 = null, consulta2 = null, porcentaje = "", gestion="", fuente="";
                                                        String municipios[] = {"COB","CBB","EAL","ORU","POT","SAC","SCZ","SER","TAR","TOR","TDD","VIA"};

                                                        Connection con = DBConexion.IniciarSesion();

                                                        ResultSet rs = null, rs1 = null;
                                                        PreparedStatement pst = null, pst1 = null, pst2 = null;
                                                        consulta1 = "select id, importe, importe_usd, subc, act, subact, fech_pago, gestion, bid_ctr from tabla_c31 where inst='UEP' and gam_uep='UEP'";
                                                        pst1 = con.prepareStatement(consulta1);
                                                        rs1 = pst1.executeQuery();
                                                        Integer conteo1 = 0, conteo2 =0;
                                                        while (rs1.next()) {
                                                            rs1.getString("id");
                                                            rs1.getString("importe");
                                                            rs1.getString("importe_usd");
                                                            rs1.getString("subc");
                                                            rs1.getString("act");
                                                            rs1.getString("subact");
                                                            rs1.getString("fech_pago");
                                                            gestion = rs1.getString("gestion");
                                                            fuente = rs1.getString("bid_ctr");
                                                            
                                                            conteo1=conteo1+1;
                                                            if (gestion.equals("2016")) {
                                                                String fecha = rs1.getString("fech_pago");
                                                                String[] parts = fecha.split("/");
                                                                String part1 = parts[0];
                                                                String part2 = parts[1];
                                                                String part3 = parts[2];
                                                                int numero = 0;
                                                                numero = Integer.parseInt(part1+part2+part3);
                                                                if (numero>=1012016 && numero<=29082016 ){
                                                                    gestion = "2016i";  
                                                                }else{
                                                                    gestion = "2016ii";
                                                                }    
                                                            }      
                                                            for (int j = 0; j <= 11; j++) {          
                                                                consulta = "select porcentaje from porcentaje_dist where gam='"+municipios[j]+"' and gestion='"+gestion+"' and subc='"+rs1.getString("subc")+"'";
                                                                pst = con.prepareStatement(consulta);
                                                                rs = pst.executeQuery();
                                                                while (rs.next()) { porcentaje = rs.getString("porcentaje"); }
                                                                Double porcentajeF = Double.parseDouble(porcentaje);
                                                                Double importeF = Double.parseDouble(rs1.getString("importe"));
                                                                Double importe_usdF = Double.parseDouble(rs1.getString("importe_usd"));
                                                                Double resultado1 = importeF*porcentajeF;
                                                                Double resultado2 = importe_usdF*porcentajeF;
                                                                conteo2=conteo2+1;
                                                                System.out.println("multiplica esto : "+importeF+" con esto : "+porcentajeF+" resulta esto : "+resultado1+" de la gestion : "+gestion+" con fuente : "+fuente);
                                                                if (fuente.equals("BID")) {
                                                                    consulta2="INSERT INTO detalle_c31 (id_c31, subc, act, subact, gestion, gam, porcentaje, monto_bs_bid, monto_usd_bid, monto_bs_ctr, monto_usd_ctr) VALUES (?,?,?,?,?,?,?,?,?,null,null)";
                                                                } else {
                                                                    consulta2="INSERT INTO detalle_c31 (id_c31, subc, act, subact, gestion, gam, porcentaje, monto_bs_bid, monto_usd_bid, monto_bs_ctr, monto_usd_ctr) VALUES (?,?,?,?,?,?,?,null,null,?,?)";
                                                                }
                                                                pst2 = con.prepareStatement(consulta2);
                                                                pst2.setString(1,rs1.getString("id"));
                                                                pst2.setString(2,rs1.getString("subc"));
                                                                pst2.setString(3,rs1.getString("act"));
                                                                pst2.setString(4,rs1.getString("subact"));
                                                                pst2.setString(5,rs1.getString("gestion"));
                                                                pst2.setString(6,municipios[j]);
                                                                pst2.setString(7,porcentaje);
                                                                pst2.setString(8,Double.toString(resultado1));
                                                                pst2.setString(9,Double.toString(resultado2));
                                                                pst2.executeUpdate();
                                                            }

                                                            //System.out.println("--------------------------"); 
                                                            //System.out.println("Esta es la consulta : "+consulta+" y porsentaje : "+porcentaje);
                                                        }

                                                        System.out.println("** conteo1 = "+conteo1+" , conteo2 = "+conteo2);
                                                        System.out.println("** FELICIDADES SE INGRESO LOS DATOS MUY BIEN :D ..!!! ");
                                                        //while (rs2.next()) { num1 = rs2.getString("total"); }
                                                       
                                                        */
                                                        
                                                            String Data = Consultas.MontoSubActividad("1", "2,1,1,1", "2");
                                                            System.out.println("DATO : "+Data);
                                                            

                                                    %>
                                            </center>
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
