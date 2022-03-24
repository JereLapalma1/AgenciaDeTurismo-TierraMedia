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

				<h2 class="fw-bolder display-4 mb-3 ">Atracciones</h2>
				<!-- CARRUSEL DE ATRACCIONES COMPRA -->

				<!-- ----------------------------------CRUD-------------------------------------------------- -->
				<!-----SECCION TABLA ATRACCIONES-->
				<div id="" class="row row-cols-12 row-cols-xl-12">






					<div class="col-lg-12">

						<c:if test="${flash != null}">
							<div class="alert alert-danger">
								<p>
									<c:out value="${flash}" />
									<c:if test="${errors != null}">
										<ul>
											<c:forEach items="${errors}" var="entry">
												<li><c:out value="${entry.getValue()}"></c:out></li>
											</c:forEach>
										</ul>
									</c:if>
								</p>
							</div>
						</c:if>
						<table class="table table-stripped table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nombre</th>
									<th>Costo</th>
									<th>Tiempo</th>
									<th>Cupo</th>
									<th>Tipo</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${atracciones}" var="atraccion">
									<tr>
										<td><c:out value="${atraccion.id}"></c:out></td>
										<td><a class=" fw-bolder text-dark"
											style="text-decoration: none; font-size: 18px;" href="#"
											data-toggle="modal" data-target="#ComprarModal"> <c:out
													value="${atraccion.nombre}"></c:out>
										</a></td>
										<td><c:out value="${atraccion.monto}"></c:out></td>
										<td><c:out value="${atraccion.tiempo}"></c:out></td>
										<td><c:out value="${atraccion.cupoDisponible}"></c:out></td>
										<td><c:out value="${atraccion.tipo}"></c:out></td>

									</tr>

								</c:forEach>
							</tbody>
						</table>


					</div>
				</div>

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
<div class="modal fade" id="ComprarModal" tabindex="-1" role="dialog"
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
			<div class="modal-body">
			
			
			
			
			</div>
			
		</div>
	</div>
</div>
<!-- FIN MODAL SALIDA -->

<!--SECCION TARJETAS DE COMPRA -->


<!-- SECCION FIN TARJETAS DE COMPRA- -->
</body>

</html>
