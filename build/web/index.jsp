
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" type="image/png" href="./img/logo.png" />
        <title>Login</title>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">

	<link rel="stylesheet" href="css/style2.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
         <div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">SISTEMA DE REGISTRO C31</span></h1>
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>PMGM - C2</h2>
			</div>
                        <form action="CTRLUsuario">
                            Usuario : <input type="text" name="txtusuario"/><br>
                            Contraseña : <input type="password" name="txtcontra"/><br>
                            <input type="submit" name="btningresar" value="Ingresar" class="btn btn-success"/>
                        </form>
                </div>
	</div>
        
    </body>
    <script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
    </script>
</html>

