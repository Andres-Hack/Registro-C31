<%-- 
    Document   : Test
    Created on : 20-03-2018, 10:57:15 AM
    Author     : andres
--%>

<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="pEmail.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>       
    </head>
    <body>
        <h1>ENVIAR CORREO</h1>
        <%
            try {
                    String host = "mail.oopp.gob.bo";
                    System.out.println("ahora en el try");
                    Properties prop = System.getProperties();
                    prop.put("mail.smtp.starttls.enable", true);
                    prop.put("mail.smtp.host", host);
                    prop.put("mail.smtp.user", "andres.mamani@oopp.gob.bo");
                    prop.put("mail.smtp.password", "204364");
                    prop.put("mail.smtp.port", 587);
                    prop.put("mail.smtp.auth", "true");

                    Session sesion = Session.getDefaultInstance(prop, null);
                    MimeMessage message = new MimeMessage(sesion);

                    message.setFrom(new InternetAddress("andres.mamani@oopp.gob.bo"));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress("andres.mamani@oopp.gob.bo"));
                    message.setSubject("mensaje de prueba");
                    message.setText("titulo de prueba");

                    Transport transport = sesion.getTransport("smpt");
                    transport.connect(host, "andres.mamani@oopp.gob.bo", "204364");
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();

            } catch (Exception e) {
            }
        %>
        
    </body>
</html>
