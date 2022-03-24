<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<!----	<c:out value="${usuario.nombre}"></c:out>!-->
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="estilos/estilos-index.css">


	<!---ANIME JS HERO-->
	<script src="scripts/demo.js" defer></script>
	<script src="scripts/anime.min.js" defer></script>
	<script src="scripts/imagesloaded.pkgd.min.js" defer></script>
	<script src="scripts/demo1.js" defer></script>
	<!---FIN ANIME JS HERO-->




	<!---SWIPPER CDN-->



	<!------->
	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">
	<script defer src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script defer src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/js/bootstrap.bundle.min.js"
		integrity="sha512-mULnawDVcCnsk9a4aG1QLZZ6rcce/jSzEGqUkeOLy0b6q0+T6syHrxlsAGH7ZVoqC93Pd0lBqd6WguPWih7VHA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script defer src="scripts/owl.carousel.min.js"></script>
	<!---FIN CDNS-->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"
		defer></script>
	<script defer type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js" defer></script>
	<script defer src="scripts/validacion-contacto.js"></script>
	<script defer src="scripts/xhr.js"></script>

	<script defer src="scripts/jquery-1.10.2.min.js"></script>
	<script defer src="scripts/jquery.easing.1.3.js"></script>

	<script defer src="scripts/modernizr-2.6.2.min.js"></script>
	<script defer src="scripts/owl.carousel.min.js"></script>
	<script defer src="scripts/jquery.magnific-popup.min.js"></script>
	<script defer src="scripts/custom.js"></script>

	<title>Turismo En Tierra Media</title>
	<script defer>



	</script>
</head>

<body>

	<div class="PageWrapper ">
		<!---NAV BAR --->
		<nav class="navbar navbar-expand-lg d-flex justify-content-between navbar-light bg-white fixed-top ">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"><img src="assets/img/logo_small.png" alt="" width="200px"
						class="d-inline-block align-text-center pt-1 pb-2"></a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<ion-icon name="menu-outline"></ion-icon>
				</button>

				<div class="collapse bg-white  container-fluid  navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav m-sm-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active fw-bolder" aria-current="page" href="#"
								id="inicio">Inicio</a></li>

						<li class="nav-item dropdown"><a id="perfiles-creados" class="nav-link dropdown-toggle fw-bold"
								href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false">
								GestiÃ³n</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item fw-bold" href="dashboard.jsp" id="usuario">Ir al tablero de
										mando</a></li>



							</ul>
						</li>
						<li class="nav-item"><a class="nav-link fw-bold" href="#quienes-somos" tabindex="-1"
								aria-disabled="false">QuiÃ©nes Somos</a></li>
						<li class="nav-item"><a class="nav-link fw-bold" href="#contacto" tabindex="-1"
								aria-disabled="false">Contacto</a></li>
						<li class="nav-item"><a class="salir ms-2 nav-link fw-bolder text-dark"
								href="/turismoHDR/logout" data-toggle="modal" data-target="#logoutModal">Cerrar
								Sesion</a>
						</li>




					</ul>
					<h6 class="nav-link fw-bolder  mb-2 mb-lg-0 text-dark "> !Bienvenido <c:out value="${usuario.nombre}"></c:out>! </h6>

				</div>
			</div>
		</nav>

		<!---FIN NAVBAR-->
	
		


		<!---Sectccion Imagen y breve despcripcion-->
		<section class=" w-100">



			<main>
				<div class="content content--fixed">
					<header class="codrops-header">
						<div class="codrops-links">
							<a class="codrops-icon codrops-icon--prev"
								href="https://tympanus.net/Development/ExpandingGridItemAnimation/"
								title="Previous Demo"><svg class="icon icon--arrow">
									<use xlink:href="#icon-arrow"></use>
								</svg></a>
							<a class="codrops-icon codrops-icon--drop" href="https://tympanus.net/codrops/?p=33037"
								title="Back to the article"><svg class="icon icon--drop">
									<use xlink:href="#icon-drop"></use>
								</svg></a>
						</div>

					</header>


				</div>
				<div class="slideshow">
					<div class="slides">
						<div class="slide slide--current">
							<div class="slide__img" style="background-image: url(assets/img/m5.jpg);"></div>
							<h2 class="slide__title text-white ">Moria</h2>
							<p class="slide__desc text-white display-4 mt-2">Fue una gran mina que durante muchas
								edades produjo inmensas riquezas, sÃ­mbolo del poderÃ­o enano
								en la Tierra Media, pero tambiÃ©n causa de muchas desdichas y
								pesares. Durante mÃ¡s de un milenio fue un gran centro de
								comercio enano, hasta que los habitantes de la ciudad
								excavaron demasiado profundo, en busca de mithril.</p>
							<a class="slide__link " href="#"></a>
						</div>
						<div class="slide">
							<div class="slide__img" style="background-image: url(assets/img/m6.jpg)"></div>
							<h2 class="slide__title text-white">Minas Thirt</h2>
							<p class="slide__desc text-white mt-2">Minas Tirith (S. 'Torre de la
								Guardia') era una ciudad de Gondor , originalmente llamada
								Minas Anor. Desde TA 1640 en adelante fue la capital del
								reino del Sur y la sede de sus reyes y mayordomos
								gobernantes.</p>
							<a class="slide__link  " type="button" href="#"></a>
						</div>
						<div class="slide">
							<div class="slide__img" style="background-image: url(assets/img/m7.jpg)"></div>
							<h2 class="slide__title text-white ">Bosque Negro</h2>
							<p class="slide__desc text-white mt-2">La zona forestal mÃ¡s grande que aÃºn
								perdura en la Tierra Media. Se halla al este del tramo
								superior de Anduin y al sur de las MontaÃ±as Grises. Su
								nombre original era el Gran Bosque Verde o Bosque Verde el
								Grande (S. Eryn Galen) y formaba el hÃ¡bitat de los elfos
								silvanos.</p>
							<a class="slide__link " href="#"></a>
						</div>
						<div class="slide">
							<div class="slide__img" style="background-image: url(assets/img/m8.jpg)"></div>
							<h2 class="slide__title text-white">Abismo De Helm</h2>
							<p class="slide__desc text-white mt-2">El Abismo de Helm se trata de una profunda garganta
								que
								se abre al pie
								del pico Thrihyrne, en la vertiente norte de las MontaÃ±as
								Blancas.</p>
							<a class="slide__link" href="#"></a>
						</div>
						<div class="slide">
							<div class="slide__img" style="background-image: url(assets/img/m3.jpg)"></div>
							<h2 class="slide__title text-white">Mordor</h2>
							<p class="slide__desc text-white mt-2">Mordor era una llanura volcÃ¡nica
								negra ubicada en el sureste de la Tierra Media al este de
								Gondor, Ithilien y el gran rÃ­o Anduin. Mordor fue elegido por
								Sauron para ser su reino debido a las cadenas montaÃ±osas que
								lo rodean por tres lados, creando una fortaleza natural
								contra sus enemigos</p>
							<a class="slide__link " href="#"></a>
						</div>
					</div>
					<nav class="slidenav">
						<button class="slidenav__item slidenav__item--prev text-white">Anterior</button>
						<span> </span>
						<button class="slidenav__item slidenav__item--next text-white">Siguiente</button>
					</nav>
				</div>
			</main>

		</section>
		<!---FIN SECCION-->



		<!---CARRUSEL ATRACCIONES-->

		<div class="fh5co-projects-wrap  pt-2">
			<h1 class="display-3 fw-bolder ps-4 txt"> Atracciones </h1>
			<div class="effects">
				<div class="owl-carousel">
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2  shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-1.jpg" alt="Project Title here" class="">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center"><c:out value="${ofertables.nombre}"></c:out>Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-1.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
							
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-2.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-2.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>

					</div>
					<div class="item me-2 ms-2">

						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-3.png" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-3.png" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-4.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-4.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>

					</div>
					<div class="item ms-2 me-2">

						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-5.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-5.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-6.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-6.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-7.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-7.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-8.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-8.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Producto</h>
									</a>


								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-----FIN CARRUSELL ATRACCIONES-->



		<!---CARRUSELL PROMOCIONES-->
		<div class="fh5co-projects-wrap  pt-2">
			<h1 class="display-3 fw-bolder pe-4 text-end txt2"> Promociones </h1>
			<div class="effects">
				<div class="owl-carousel">

					<div class="item me-2 ms-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>


								</div>

							</div>
						</div>
					</div>

					<div class="item me-2 ms-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo2.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo2.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>

								</div>

							</div>
						</div>


					</div>

					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>

								</div>

							</div>
						</div>
					</div>
					<div class="item ms-2 me-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo2.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo2.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>



								</div>

							</div>
						</div>



					</div>

					<div class="item  ms-2 me-2">

						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo3.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo3.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>

								</div>

							</div>
						</div>
					</div>

					<div class="item me-2 ms-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo4.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo4.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>

								</div>

							</div>
						</div>
					</div>

					<div class="item me-2 ms-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>


								</div>

							</div>
						</div>
					</div>
					<div class="item me-2 ms-2">
						<div class="hover-img pt-2 pb-2 shadow p-3 mb-5 bg-body rounded">
							<figure>
								<img src="assets/img/card-promo2.jpg" alt="Project Title here">
							</figure>
							<div class="fh5co-projects-overlay">
								<h3 class="from-top text-center">Mordor <span class="category"></span></h3>
								<p>Mordor era una llanura volcÃ¡nica
									negra ubicada en el sureste de la Tierra Media al este de
									Gondor, Ithilien y el gran rÃ­o Anduin.</p>

								<div class="fh5co-projects-action from-bottom">

									<a href="assets/img/card-promo2.jpg" class="goto-preview image-popup"><i
											class="ti-zoom-in"></i></a>
									<a type="button" class="d-flex justify-content-around  pt-2  text-dark " href="#">
										<ion-icon name="cart-outline" class=" " style="color: black; font-size: 28px;">
										</ion-icon>
										<h6 class="text-dark fw-bolder  "> Ver Oferta</h>
									</a>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--FIN CARRUSELL PROMOCIONES-->


		<!----SECCION SOBRE LA EMPRESA--->
		<section id="quienes-somos">
			<div class="container  bg-light">
				<div class="contenido-empresa">
					<h2 class="display-5 text-center mt-5 pt-2 ">
						Turismo en Tierra Media <br>Fue desarrollado por el grupo <br>
						<b>Hijos Del Rigor</b>
					</h2>
					<p class="text-center">La Tierra Media (Middle Earth en inglÃ©s),
						tambiÃ©n conocida como Endor, es el continente ficticio donde tienen
						lugar la mayorÃ­a de los acontecimientos de las obras del escritor
						J. R. R. Tolkien. ... Es uno de los continentes de Arda, el mundo
						donde se sitÃºa la totalidad del legendarium de Tolkien.</p>
				</div>
				<div class=" pt-5 row row-cols-1 row-cols-md-3 g-4">
					<div class="col-lg-3 col-sm-4 justify-content-center d-flex">
						<div class="contenido-miembro">
							<div class="contenido-detalles">
								<h5 class="text-start ps-1 mt-2">Gandalf</h5>
								<span class="ps-1">La copia Barata de Albus Dumbledore</span>
								<ul class="list-inline pe-3">
									<li class=" list-inline-item"><a href="">
											<ion-icon name="logo-instagram"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-slack"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-twitter"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-linkedin"></ion-icon>
										</a></li>
								</ul>
							</div>
							<img src="assets/img/pf1.png" class="img-fluid" alt="perfil-1">
						</div>

					</div>
					<div class="col-lg-3 col-sm-4 justify-content-center d-flex">
						<div class="contenido-miembro">
							<div class="contenido-detalles">
								<h5 class="text-start ps-1 mt-2">Sam</h5>
								<span class="ps-1">Sherk Con la posima de felices por
									siempre </span>
								<ul class="list-inline pe-3">
									<li class=" list-inline-item"><a href="">
											<ion-icon name="logo-instagram"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-slack"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-twitter"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-linkedin"></ion-icon>
										</a></li>
								</ul>
							</div>
							<img src="assets/img/pf2.jpg" class="img-fluid" alt="perfil-2">
						</div>
					</div>
					<div class="col-lg-3 col-sm-4 justify-content-center d-flex">
						<div class="contenido-miembro">
							<div class="contenido-detalles">
								<h5 class="text-start ps-1 mt-2">Galadriel</h5>
								<span class="ps-1">Hada Madrina full-stack</span>
								<ul class="list-inline pe-3">
									<li class=" list-inline-item"><a href="">
											<ion-icon name="logo-instagram"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-slack"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-twitter"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-linkedin"></ion-icon>
										</a></li>
								</ul>
							</div>
							<img src="assets/img/pf3.jpg" class="img-fluid" alt="perfil-3">
						</div>
					</div>
					<div class="col-lg-3 col-sm-4 justify-content-center d-flex">
						<div class="contenido-miembro">
							<div class="contenido-detalles">
								<h5 class="text-start ps-1 mt-2">Eowyn</h5>
								<span class="ps-1">Reina de muy muy Lejano</span>
								<ul class="list-inline pe-3">
									<li class=" list-inline-item"><a href="">
											<ion-icon name="logo-instagram"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-slack"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-twitter"></ion-icon>
										</a></li>
									<li class="list-inline-item"><a href="">
											<ion-icon name="logo-linkedin"></ion-icon>
										</a></li>
								</ul>
							</div>
							<img src="assets/img/pf4.jpg" class="img-fluid" alt="perfil-4">
						</div>
					</div>
				</div>

			</div>
		</section>
		<!---FIN SECCION SOBRE LA EMPRESA-->


		<!--CONTACTO-->
		<section id="contacto">
			<div class="container bg-light mt-2 mb-3">
				<div class="row">
					<div class="col-lg-6 col-sm-6 mt-5 pt-5 mb-2">
						<h2 class="fw-bolder ">Â¿EstÃ¡s listo para ser parte de esta
							aventura?</h2>
						<p class="pp">Por favor en este espacio nos gustarÃ­a que nos
							puedan dejar un comentario de como la pasaron , recomendaciones
							que nos quieran aportar , o cualquier consulta que quieran
							hacernos. Â¡Â¡Muchas gracias por ser parte de esta aventura!!</p>

					</div>
					<div class="col-lg-6 col-sm-6 mt-5 pt-5 pe-3 mb-2">
						<h2 class="fw-bolder display-5 ms-2 ps-3">Contacto</h2>

						<form id="form-contact" class="row g-3 needs-validation" novalidate>
							<div class="col-md-4">
								<label for="validationCustom01" class="form-label">Nombre</label>
								<input type="text" class="form-control" id="validationCustom01" required>
								<div class="valid-feedback">Â¡Se ve bien!</div>
							</div>
							<div class="col-md-4">
								<label for="validationCustom02" class="form-label">Apellido</label>
								<input type="text" class="form-control" id="validationCustom02" required>
								<div class="valid-feedback">Â¡Se ve bien!</div>
							</div>
							<div class="col-md-4">
								<label type="Email" for="validationCustomUsername" class="form-label">Email</label>
								<div class="input-group has-validation">
									<span class="input-group-text" id="inputGroupPrepend">@</span> <input type="text"
										class="form-control" id="validationCustomUsername"
										aria-describedby="inputGroupPrepend" required>
									<div class="invalid-feedback">Por favor, ingrese un nombre
										de usuario.</div>
								</div>
							</div>
							<div class="col-md-6">
								<label for="validationCustom03" class="form-label">Ciudad</label>
								<input type="text" class="form-control" id="validationCustom03" required>
								<div class="invalid-feedback">Proporcione una ciudad
									vÃ¡lida.</div>
							</div>

							<div class="col-md-3">
								<label for="validationCustom05" class="form-label">Comentario</label>
								<textarea type="text" class="form-control" id="validationCustom05"></textarea>
								<div class="invalid-feedback">por favor ingrese un
									comentario</div>
							</div>
							<div class="col-12">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
									<label class="form-check-label" for="invalidCheck"> Acepta
										tÃ©rminos y condiciones </label>
									<div class="invalid-feedback">Debes estar de acuerdo antes
										de enviar.</div>
								</div>
							</div>
							<div class="col-12">
								<button class="btn btn-primary" type="submit">Enviar
									Formulario</button>
							</div>
						</form>

					</div>
				</div>


			</div>


		</section>
		<!---FIN CONTACTO-->


		<!--FOOTER-->
		<footer class=" py-5 mt-5 bg-light shadow">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 mb-3 ">
						<a class="d-inline-flex align-items-center mb-2" href=""> <img src="assets/img/logo_small.png"
								alt="logo" width="200px"></a>
						<div>
							<ul class="list-unstyled  small  text-muted">
								<li class="mb-2"></li>
								<li class="mb-2">Gracias por visitar nuestra web</li>


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



		<!-- MODAL LOGOUT -->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Â¿Preparado para
							Salir?</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
					<div class="modal-body">Seleccione "Cerrar sesion" a
						continuaciÃ³n si estÃ¡ listo para finalizar su sesiÃ³n actual.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="login.jsp">Cerrar sesiÃ³n</a>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>

</html>