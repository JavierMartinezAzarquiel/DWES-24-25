<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>Foster's</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link href="css/mycss.css" rel="stylesheet">
</head>

<body>
	<header style="background-color: rgb(23, 24, 71);" class="py-3">
		<img src="img/logo.svg" alt="">
	</header>
	<main>
		<div class="row justify-content-center mt-3">
			<c:forEach items="${categorias}" var="categoria">
				<div class="col-xl-2 col-lg-3 col-md-4 col-6 mb-3">
					<div class="card">
						<a	href="Controller?operacion=obtenerplatos&idcategoria=${categoria.id}&nombrecategoria=${categoria.nombre}" class="text-decoration-none text-black"> 
						    <img class="card-img-top" src="img/category/${categoria.nombre}.png" alt="Title" />
							<div class="card-body">
								<h5 class="card-title text-center">${categoria.nombre}</h5>
								<p class="card-text"></p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- A partir de aquí comienza el detalle-->
		<c:if test="${productos!=null}">
			<h1 class="text-center my-5">${nombrecategoria}</h1>
			<div class="row justify-content-center">
				<c:forEach items="${productos}" var="producto">
					<div class="col-xl-4 col-md-6 mb-3">
						<div class="card">
							<img class="card-img-top" src="${producto.imagen}" alt="Title" />
							<div class="card-body">
								<h4 class="card-title text-center">${producto.titulo}</h4>
								<p class="card-text">${producto.body}</p>
								<p class="text-center">
									<span class="rating">
										<a href="Controller?operacion=rating&idproducto=${producto.id}&puntos=1">&#9733</a>
										<a href="Controller?operacion=rating&idproducto=${producto.id}&puntos=2">&#9733</a>
										<a href="Controller?operacion=rating&idproducto=${producto.id}&puntos=3">&#9733</a>
										<a href="Controller?operacion=rating&idproducto=${producto.id}&puntos=4">&#9733</a>
										<a href="Controller?operacion=rating&idproducto=${producto.id}&puntos=5">&#9733</a>
									</span>
								</p>
							</div>
						</div>	
					</div>
				</c:forEach>
			</div>
		</c:if>
	</main>
	<footer style="background-color: rgb(23, 24, 71);"
		class="py-1 text-white position-fixed bottom-0 start-0 w-100">
		<h6 class="text-center">Foster's Hollywood</h6>
		<p class="position-absolute top-0 end-0">${msg}</p>
	</footer>
	<div class="position-fixed top-50 start-50 translate-middle">
	<div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
		<div class="toast-body bg-light text-danger text-center rounded-pill">
			<h4>${msg}</h4>
		</div>
	</div>
    </div>  
	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
		
	<c:if test="${msg!=null}">
		<script type="text/javascript">
    		const tostada = document.getElementById('tostada')
    		const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
    		toastBootstrap.show()
		</script>
    </c:if>    
</body>

</html>