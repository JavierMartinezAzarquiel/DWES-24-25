<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Clicars</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
                            <a class="nav-link" href="Controller?operacion=inicio">Todos</a>
                        </li>
                        <c:forEach items="${marcas}" var="marca">
                            <li class="nav-item">
                                <a class="nav-link" href="Controller?operacion=cambiomarca&idmarca=${marca.id}">${marca.nombre}</a>
                            </li>
                        </c:forEach>

                        <li class="nav-item dropdown ms-5">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Ordenado por</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=nombre">Nombre</a>
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=modelo">Modelo</a>
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=anio">Año</a>
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=km">Kilómetros</a>
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=cv">Caballos</a>
                                <a class="dropdown-item" href="Controller?operacion=cambioorden&orden=precio">Precio</a>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>

    </header>
    <main class="my-4">
        <div class="container">
            <div class="row">
                <c:forEach items="${coches}" var="coche">
                <div class="col-xl-4 col-md-6 my-2 d-flex">
                    <div class="card bg-dark text-white">
                        <img class="card-img-top" src="${coche.foto}" alt="Title" />
                        <div class="card-body">
                            <h4 class="card-text text-end">${coche.likes} 
                            	<a class="text-decoration-none text-white" href="Controller?operacion=like&idcoche=${coche.id}">
                            		<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                            	</a>
                            </h4>
                            <div class="row justify-content-between">
                                <div class="col">
                                    <p>${coche.nombre}</p>
                                </div>
                                <div class="col text-end">
                                    <p class="text-danger">${coche.precioantes} &euro;</p>
                                </div>
                            </div>
                            <div class="row justify-content-between">
                                <div class="col">
                                    <p>${coche.modelo}</p>
                                </div>
                                <div class="col text-end">
                                    <p class="text-success">${coche.precio} &euro;</p>
                                </div>
                            </div>
                            <p>${coche.anio} |  ${coche.km}km | ${coche.cv}CV</p>
                        </div>
                    </div>

                </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <div class="py-4"></div>
    <footer>
        <h6 class="bg-light text-dark text-center py-3 position-fixed bottom-0 w-100 m-0">
            Clicars
        </h6>
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>
