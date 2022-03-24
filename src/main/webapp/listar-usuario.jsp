<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- ENVOLTURA -->
<div id="wrapper">



	<!-- --SIDEBAR -->
	<jsp:include page="partials/headNavSidebarDeLosDash.jsp"></jsp:include>
	<!-- FIN SIDEBAR -->


	<!-- CONTENIDO ENVUELTO-->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- CONTENIDO DEL MENU-->
		<div id="content">

			<!-- BARRA DE ARRIBA  -->
			<nav
				class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">


				<button id="sidebarToggleTop"
					class="btn btn-link d-md-none rounded-circle mr-3">
					<i class="fa fa-bars"></i>
				</button>


				<div
					class="d-none d-sm-inline-block form-inline text-black-50      ">
					<div>
						<h2 class="me-2">Turismo en Tierra Media</h2>
					</div>
				</div>


				<!-- Topbar Navbar -->
				<ul class="navbar-nav ml-auto">
					<div class="topbar-divider d-none d-sm-block"></div>
					<li class="nav-item dropdown no-arrow"><a
						class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <span
							class="mr-2 d-none d-lg-inline text-gray-600 small"><c:out
									value="${usuario.nombre}"></c:out></span> <img
							class="img-profile rounded-circle"
							src="assets/img/undraw_profile.svg">
					</a>

						<div
							class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
							aria-labelledby="userDropdown">
							<a class="dropdown-item disabled" style="color: black;"><i
								title="monedas" style="color: gold;" class="me-2 fas fa-coins"></i>Presupuesto:
								<c:out value="${usuario.presupuesto}"></c:out> </a> <a
								class="dropdown-item disabled" style="color: black;"> <i
								title="tiempo" style="color: blue;"
								class="me-2 fas fa-stopwatch"></i>Tiempo: <c:out
									value="${usuario.tiempoDisponible}h"></c:out>
							</a> <a class="dropdown-item disabled" style="color: black;"> <i
								title="preferencia" style="color: red;"
								class="me-2 fab fa-gratipay"></i>Preferencia: <c:out
									value="${usuario.tipoFavorito}"></c:out>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="/turismoHDR/logout"
								data-toggle="modal" data-target="#logoutModal"> <i
								class="fas fa-sign-out-alt fa-sm fa-fw mr-2 "
								style="color: black;"></i> Salir
							</a>
						</div></li>

				</ul>

			</nav>
			<!-- FIN BARRA DE ARRIBA -->

			<!-- INICIO DEL CONTENIDO ,LA COMIDA VA AQUI-->
			<div class="container-fluid">

				<!-- HEADER DE PAGINA-->
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Tablero de mando</h1>

				</div>
				<!-- HAEDER FIN  -->

				<!-- ----------------------------------CRUD-------------------------------------------------- -->
				<div id="" class="row row-cols-12 row-cols-xl-12">

					<div class="col-lg-12">
						<table id="example"
							class="table  table-bordered table-white  table-hover"
							style="width: 100%">
							<thead>
								<tr class="table-dark">
									<th>ID</th>
									<th>Nombre</th>
									<th>Presupuesto</th>
									<th>Tiempo Disponible</th>
									<th>Tipo Favorito</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${usuarios}" var="usuario">
									<tr>
										<td><c:out value="${usuario.id}"></c:out></td>
										<td><c:out value="${usuario.nombre}"></c:out></td>
										<td><c:out value="${usuario.presupuesto}"></c:out></td>
										<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
										<td><c:out value="${usuario.tipoFavorito}"></c:out></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>

					</div>

				</div>
				<!-- FIN SECCION BUSCAR LISTAR -->
				<!-- -------------------------------FIN CRUD----------------------------------------------------------- -->





			</div>
		</div>

	</div>
	<!-- FIN CONTEINER -->

</div>
<!-- FIN MENU CONTENIDO -->

<!-- FOOTER -->
<footer class="sticky-footer bg-white ">
	<div class="container mb-4">
		<div class="copyright text-center my-auto">
			<span>Copyright &copy;Turismo En Tierra Media 2021</span>
		</div>
	</div>
</footer>
<!-- FIN FOOTER -->

<!-- FIN CONTENIDO ENVUELTO-->

<!-- FIN ENVOLTURA-->

<!--SCROLL-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>
<!-- FIN SCROLL -->

<!-- MODAL SALIDA-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">ï¿½Preparado
					para Salir?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
			</div>
			<div class="modal-body">Seleccione "Cerrar sesion" a
				continuacion si esta listo para finalizar su sesion actual.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
				<a class="btn btn-primary" href="login.jsp">Cerrar sesion</a>
			</div>
		</div>
	</div>
</div>
<!-- FIN MODAL SALIDA -->



</body>

</html>
