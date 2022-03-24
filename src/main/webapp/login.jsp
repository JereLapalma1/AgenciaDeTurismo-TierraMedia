<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- Optional JavaScript; choose one of the two! -->

<link rel="stylesheet" href="estilos/login.css">


<!-- Option 1: Bootstrap Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous" defer></script>
<script defer type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js" defer></script>
<script defer src="scripts/validacion-login.js"></script>
<title>Turismo En Tierra Media || Login</title>
</head>

<body class="">

	<section
		style="background: url(assets/img/img5.jpg) no-repeat; background-size: cover;">
		<div class="login">
			<h2 class="">
				<img src="assets/img/logo_white_large.png" width="250px" alt="logo"
					class="">
			</h2>
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>


			<form class="row g-3 needs-validation mb-4 " novalidate
				action="login" method="post">
				<div class="mb-4">
					<label for="nombre" class="form-labe">Nombre</label> <input
						type="nombre" class="form-control text text-white" name="nombre" id="nombre"
						aria-describedby="nombrelhelp" required>
					<div id="nombrehelp" class="form-text text-white">ingrese su
						Nombre de Usuario</div>
				</div>

				<div class="mb-4">
					<label for="password" class="form-labe">ContraseÃ±a</label> <input
						type="password" class="form-control  text" id="password"
						aria-describedby="passwordhelp"  name="password" required>
					<div id="passwordhelp" class="form-text text-white">ingrese
						su ContraseÃ±a</div>
				</div>
				<div class="mb-4 form-check">
					<input type="checkbox" class="form-check-input me-2 pt-1 "
						id="recordar"> <label for=" recordar"
						class="form-check-label m-auto ">Recordar usuraio </label>
				</div>
				<button type="submit" class=" text-white  pt-2 mb-2">Ingresar</button>
			</form>

		</div>

	</section>
	<!--FOOTER-->

	<footer class="">
		<div class="container-fluid shadow p-3  bg-light rounded">
			<div class="row m-auto">
				<div class="col-lg-3 mb-3 ">
					<a class="d-inline-flex align-items-center mb-2 pt-2" href="">
						<img src="assets/img/logo_small.png" alt="logo" width="200px">
					</a>
					<div>
						<ul class="list-unstyled  small  text-muted">

							<li class="mb-2">Gracias por visitar nuestra web</li>
							<li class="mb-2">&copy; 2022 Hijos del Rigor</li>
						</ul>
					</div>
				</div>
				<div class="col-6 col-lg-2 mb-3">
					<div>
						<a href="" class="fw-bolder text-dark">Atracciones</a>
						<ul class="list-unstyled  small  text-muted">
							<li class="mb-2"><a href="" class="text-dark">Lista De
									Atracciones</a></li>
						</ul>
					</div>
					<div class="col-6 col-lg-2 mb-3">
						<div>
							<a href="" class="fw-bolder text-dark">Promociones</a>
							<ul class="list-unstyled  small  text-muted">
								<li class="mb-2"><a href="" class="text-dark">Promociones
										Disponibles</a></li>
							</ul>
						</div>
					</div>
					<div class="col-8 col-lg-2 mb-3">
						<div>
							<a href="" class="fw-bolder text-dark">Otros Servicios</a>
							<ul class="list-unstyled  small  text-muted">
								<li class="mb-2"><a href="" class="text-dark">Argentina
										Programa</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

	</footer>

</body>

</html>