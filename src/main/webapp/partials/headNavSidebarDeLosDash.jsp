<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Turismo En Tierra Media || Dashboard</title>

<!---FONTS-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!---FIN FONTS-->


<!---DASHBOARD ESTILOS Y SCRRIPTS-->

<link href="estilos/dashboard-2.css" rel="stylesheet">


<link href="assets/bootstrap-5.0.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="assets/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js"
	defer></script>

<script defer src="scripts/validacion-contacto.js"></script>
<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>


<script defer
	src="assets/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js">
	
</script>


<script defer
	src="assets/cdnjs/jquery.easing.min.js"
></script>

<script defer src="scripts/dashboard-2-min.js"></script>



<script src="scripts/jQuery3.6.0.js" defer></script>
<!----FIN DASHBOARD ESTILOS Y SCRIPTS-->

<!---DATATABLES CDN-->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.css" />


<script defer src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script defer type="text/javascript"
	src="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.js"></script>
<script defer src="/scripts/tablas.js"></script>
<script defer
	src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
<script defer
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>


<!---FIN CDN DATATABLES-->



<style type="text/css">
.collapseprom {
	padding: 0.5rem 1rem !important;
	margin: 0 0.5rem;
	display: block !important;
	color: #3a3b45 !important;
	text-decoration: none;
	border-radius: 0.35rem;
	white-space: nowrap;
	width: 100% !important;
}

.collapseprom::after {
	font-size: .65rem !important;
	padding: 4.1%;
}

.colaitems {
	font-weight: 800 !important;
	font-size: smaller !important;
	padding: 0.2rem 1rem !important;
}
</style>
</head>
<body id="page-top">

	

		<!-- Sidebar -->
		<ul class="navbar-nav bg-white sidebar sidebar-light accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.jsp">
				<div class="sidebar-brand-icon ">
					<img src="assets/img/logo_small_icon_only.png" alt="" width="60px">

				</div>

			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!--ITEM Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Tablero de mando</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- SIDEBAR HEADING MENU ADMIN  -->
			<div class="sidebar-heading">
			<c:if test="${usuario.isAdmin()}">
			  <a href="#" style="text-decoration: none;">Gestión del admin</a> 
           

            <!-- ITEMS DEL MENU COLAPSE-->
           
                          <!---Insertar Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseInsertar"
                    aria-expanded="true" aria-controls="collapseTwo">Insertar</a>
                <div id="collapseInsertar" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded" style="margin: 0;">
                    <!-- EN CADA HREF IRIA CADA SERVLET EN DIRECCION A VISTA CORRESPONDIENTE -->
                    	<a class="collapse-item" href="insertar-usuario.do">Usuario</a>
                        <a class="collapse-item" href="insertar-atraccion.do">Atraccion</a>                       
                        <div class="nav-item" style="margin: 0;">
                        <a class="nav-link collapsed collapseprom" href="#" data-toggle="collapse" data-target="#collapsePromocion"
                    aria-expanded="true" aria-controls="collapseTwo">Promocion</a>
                <div id="collapsePromocion" class="collapse" aria-labelledby="headingTwo">
                    <div class="bg-white py-2 collapse-inner rounded" style="margin: 0;">
                        <a class="collapse-item colaitems" href="insertar-promo-porcentual.do">Porcentual</a>
                        <a class="collapse-item colaitems" href="insertar-promo-axb.do">A x B</a>
                        <a class="collapse-item colaitems" href="insertar-promo-absoluta.do">Absoluta</a>
                        </div></div>
                        </div>
                    </div>
                </div>
            </li>
            <!---Fin insertar Menu-->

            <!---Actualizar Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseActualizar"
                    aria-expanded="true" aria-controls="collapseTwo">Actualizar</a>
                <div id="collapseActualizar" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    	<a class="collapse-item" href="actualizar-usuario.do">Usuario</a>
                        <a class="collapse-item" href="actualizar-atraccion.do">Atraccion</a>
                        <a class="collapse-item" href="actualizar-promo.do">Promocion</a>                        
                    </div>
                </div>
            </li>
            <!---Fin Actualizar Menu-->

            <!---Listar  Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseListar"
                    aria-expanded="true" aria-controls="collapseTwo">Listar</a>
                <div id="collapseListar" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="listar-usuario.do">Usuarios</a>
                        <a class="collapse-item" href="listar-atraccion.do">Atracciones</a>
                        <a class="collapse-item" href="listar-promo.do">Promociones</a>
                        <a class="collapse-item" href="listar-itinerarios.do">Itinerarios</a>
                    </div>
                </div>
            </li>
            <!---Fin Listar Menu-->

             <!-- -BORRAR MENU -->
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBorrar"
                    aria-expanded="true" aria-controls="collapseTwo">Borrar</a>
                <div id="collapseBorrar" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    	<a class="collapse-item" href="borrar-usuario.do">Usuario</a>
                        <a class="collapse-item" href="borrar-atraccion.do">Atraccion</a>
                        <a class="collapse-item" href="borrar-promo.do">Promocion</a>                       
                    </div>
                </div>
            </li>
            </c:if>
            <!-- BORRAR MENU -->
            <!-- BORRAR MENU -->
</div>
			<!-- ITEM  Collapse Menu PERFILES -->

		  <div class="sidebar-heading">
             


              <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOpciones"
                    aria-expanded="true" aria-controls="collapseTwo">Gestión del usuario</a>
                <div id="collapseOpciones" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="listar-itinerario.do">Tu itinerario</a>
                        <a class="collapse-item" href="listar-ofertador.do">Ofertador</a>
                    </div>
                </div>
            </li>
            <!---Fin insertar Menu-->

         

          
         
            </div>


			<!-- Divider -->
			<hr class="sidebar-divider">







			<!-- SIDEBAR TOGGLE -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>
		<!-- FIN  Sidebar -->

	