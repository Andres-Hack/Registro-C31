<header id="header">
    <div class="headerbar">

        <div class="headerbar-left">
            <ul class="header-nav header-nav-options">
                <li class="header-nav-brand">
                    <div class="brand-holder">
                        <a target="_blank" href="http://pmgmc2.oopp.gob.bo/pmgm/index.php"  >
                            <span class="text-lg text-bold text-primary">REGISTRO C31 - PMGM</span>
                        </a>
                    </div>
                    <div class="caja-redes" style="position: fixed;">
                        <a href="#" target="_blank" class="icon-button pinterest"><i class="icon-pinterest"></i><span></span></a>
                        <a href="https://twitter.com/pmgmbol" target="_blank" class="icon-button twitter"><i class="icon-twitter"></i><span></span></a>
                        <a href="https://www.facebook.com/pmgmc2/?fref=ts" target="_blank" class="icon-button facebook"><i class="icon-facebook"></i><span></span></a>
                        <a href="#" target="_blank" class="icon-button google-plus"><i class="icon-google-plus"></i><span></span></a>
                      </div>
                </li>
            </ul>
        </div>
        <div class="headerbar-right">
            <ul class="header-nav header-nav-options">
                <li>
                    <form action="buscar.jsp">
                        <button type="submit" class="btn btn-icon-toggle ink-reaction"><span class="glyphicon glyphicon-search"></span></button>
                    </form>
                </li>
            </ul>
            <ul class="header-nav header-nav-profile">
                <li class="dropdown">
                    <a href="" class="" data-toggle="dropdown">
                        <img src="https://www.ocf.berkeley.edu/~dblab/blog/wp-content/uploads/2012/01/icon-profile.png" alt="">
                        <span class="profile-info">${sessionScope.usuario}<small>${sessionScope.usuario}@oopp.gob.bo</small></span>
                        <span class="glyphicon glyphicon-triangle-bottom"></span>
                    </a>
                    <ul class="dropdown-menu animation-dock">
                        <li class="dropdown-header">Opciones de usuario</li>
                        <li><a href=""><span class="glyphicon glyphicon-leaf"></span> Perfil</a></li>
                        <li><a href=""><span class="glyphicon glyphicon-pencil"></span> Cambiar Contraseña</a></li>
                        <li><a href="/registroC31/CTRLSalir"><span class="glyphicon glyphicon-log-out danger"></span> Salir</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>