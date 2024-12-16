<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />

    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="container">
        <header class="bg-dark">
            <div class="row justify-content-between p-4">
                <div class="col-2">
                    <img src="img/logoendesa.png" alt="" height="60">
                </div>
                <div class="col-2 text-end">
                    <img src="img/logoacb.png" alt="" height="60">
                </div>
            </div>
        </header>
        <main>
            <div class="shadow">
                <div class="bg-secondary text-center py-3">
                    <div><img src="${equipo.imgescudo}" alt="" width="150" class="bg-white p-3 rounded-circle"></div>
                    <h1 class="text-white">${equipo.nombre}</h1>
                </div>
                <div class="row justify-content-center pt-3 px-2">
                    <c:forEach items="${equipo.jugadors}" var="jugador">
                        <div class="col-6 col-md-4 mb-3">
                            <div class="card position-relative">
                                <div class="row">
                                    <div class="col-2 bg-dark"></div>
                                    <div class="col-5"><img src="${jugador.imagen}" alt="" class="img-fluid"></div>
                                    <div class="col-5">
                                        <h5 class="card-title mt-3">${jugador.nombre}</h5>
                                        <p class="card-text m-0">${jugador.estatura}</p>
                                        <p class="card-text m-0 fw-bold">${jugador.pais}</p>
                                        <p class="card-text m-0">${jugador.edad}</p>
                                    </div>
                                </div>
                                        <div class="position-absolute bottom-0 end-0">
                                            <span class="h2">${jugador.likes}</span>
                                            <a href="Controller?op=like&idjugador=${jugador.id}">
                                                <img src="img/thumbs.png" alt="" width="40" class="ms-2 mb-3">
                                            </a>
                                        </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
    </div>
    </div>
    </main>

    <footer>
        <!-- place footer here -->
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