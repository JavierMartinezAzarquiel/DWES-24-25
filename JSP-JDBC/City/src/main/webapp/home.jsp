<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!doctype html>
<html lang="en">

<head>
    <title>Ciudades Patrimonio de la Humanidad</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<link href="css/mycss.css" rel="stylesheet" >
</head>

<body>
    <div class="container p-0 shadow">
        <header class="bg-primary p-3">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                <a class="navbar-brand" href="#"><img src="img/logo.png" alt=""></a>
                <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mx-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="h5 text-white" href="Controller?operacion=ciudades">Ciudades</a>
                        </li>
                        <li class="nav-item dropdown ms-lg-5">
                            <a class="h5 dropdown-toggle text-white" href="#" id="dropdownId" data-bs-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Rutas</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                            	<c:forEach items="${ciudadesrutas}" var="ciudad" >
                            		<a class="dropdown-item" href="Controller?operacion=rutaelegida&idciudad=${ciudad.id}">${ciudad.nombre}</a>
                            	</c:forEach>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
            
        </header>
        
        <main class="mt-3"> 
        <c:if test="${ciudades!=null}">
            <div class="row justify-content-center mt-3">
            	<c:forEach items="${ciudades}" var="ciudad" >
	                <div class="col-lg-6 col-md-6 position-relative mb-3 d-flex">
	                    <div class="card pb-3 flex-fill">
	                    	<a href="${ciudad.link}">
	                        	<img class="card-img-top" src="${ciudad.imagen}" alt="Title">
	                        </a>
	                        <div class="card-body">
	                            <h4 class="card-title">${ciudad.nombre}</h4>
	                            <p class="card-text">${ciudad.descripcion}
	                            </p>
	                            <div align="right">
	                                <img class="img" src="${ciudad.mapa}" alt="Title">
                                </div>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>
            </c:if>
         	<c:if test="${listarutas!=null}">
	        <h1 class="text-center my-5 bg-primary text-white">${ciudad}</h1>
	        <div class="row justify-content-center">
	        	<c:forEach items="${listarutas}" var="ruta">
		            <div class="col-xl-4 col-md-6 mb-3 d-flex">
		                <div class="card flex-fill position-relative pb-5">
		                	<a href="${ruta.link}">
		                    	<img class="card-img-top" src="${ruta.imagen}" alt="Title">
		                    </a>
		                    <div class="card-body">
		                        <h4 class="card-title text-center">${ruta.nombre}</h4>
		                        <p>${ruta.descripcion}</p>
		                        <p>
		                        	<c:forEach begin="1" end="${ruta.media}" varStatus="loop">
		                        		&#9733;
									</c:forEach>
		                        </p>
		                        <p class="text-center position-absolute bottom-0 start-50 translate-middle-x">
                   				<span class="rating">
                                	<a href="Controller?operacion=rating&rating=1&idruta=${ruta.id}">&#9733;</a>
                                	<a href="Controller?operacion=rating&rating=2&idruta=${ruta.id}">&#9733;</a>
                                	<a href="Controller?operacion=rating&rating=3&idruta=${ruta.id}">&#9733;</a>
                                	<a href="Controller?operacion=rating&rating=4&idruta=${ruta.id}">&#9733;</a>
                                	<a href="Controller?operacion=rating&rating=5&idruta=${ruta.id}">&#9733;</a>
                            	</span>
		                        </p>
		                    </div>
		                </div>
		            </div> 
	            </c:forEach>           
	        </div>
        </c:if>
       
        </main>
        <footer class="bg-primary text-white p-3">
            <h5 class="text-center">&copy; Ciudades Patrimonio</h5>
        </footer>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
        </script>
</body>

</html>