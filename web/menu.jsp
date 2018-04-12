<div id="menubar" class="menubar-inverse animate">

    <div class="nano has-scrollbar" style="height: 877px;"><div class="nano-content" tabindex="0" style="right: -15px;"><div class="menubar-scroll-panel" style="padding-bottom: 55px;">
                <img src="./img/logo.png" width="235" class="img-responsive">
                <hr>
                <!-- BEGIN MAIN MENU -->
                <ul id="main-menu" class="gui-controls">
                    <% if ("1".equals((String)session.getAttribute("nivel")) || "4".equals((String)session.getAttribute("nivel")) || "5".equals((String)session.getAttribute("nivel"))) {%>
                    <li class="active expanded" s>
                        <a href="CTRLRegistro" >
                            <div class="gui-icon"><span class="glyphicon glyphicon-home"></span></div>
                            <span class="title">Registro</span>
                        </a>
                    </li>
                    <%}%>
                    <% if ("1".equals((String)session.getAttribute("nivel")) || "2".equals((String)session.getAttribute("nivel")) || "3".equals((String)session.getAttribute("nivel")) || "5".equals((String)session.getAttribute("nivel"))) {%>
                    <li>
                        <a href="buscar.jsp" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-search"></span></div>
                            <span class="title">Busqueda y Reporte</span>
                        </a>
                    </li>
                    <li>
                        <a href="reportePdf.jsp" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-send"></span></div>
                            <span class="title">Reporte Rápido</span>
                        </a>
                    </li>
                    <li>
                        <a href="detalles.jsp" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-signal"></span></div>
                            <span class="title">Estadisticas a Detalle</span>
                        </a>
                    </li>
                    <li>
                        <a href="programado.jsp" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-stats"></span></div>
                            <span class="title">Programado</span>
                        </a>
                    </li>
                    <%}%>
                    <% if ("1".equals((String)session.getAttribute("nivel"))) {%>
                    <li>
                        <a href="CTRLPorcentajes" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-edit"></span></div>
                            <span class="title">Distribución Porcentajes</span>
                        </a>
                    </li>
                    <li>
                        <a href="modificar.jsp" class="">
                            <div class="gui-icon"><span class="glyphicon glyphicon-refresh"></span></div>
                            <span class="title">Modificar</span>
                        </a>
                    </li>
                    <%}%>
                    <li>
                        <a href="CTRLSalir" class="">
                            <div class="gui-icon"><span style="color: red" class="glyphicon glyphicon-log-out danger"></span></div>
                            <span class="title">Salir</span>
                        </a>
                    </li>
                </ul>

                <div class="menubar-foot-panel">
                    <small class="no-linebreak hidden-folded">
                        <span class="opacity-75">VMVU - PMGM © 2017</span> <strong>SISTEMAS</strong>
                    </small>
                </div>
            </div></div><div class="nano-pane" style="display: none;"><div class="nano-slider" style="height: 862px; transform: translate(0px, 0px);"></div></div></div><!--end .menubar-scroll-panel-->
</div>