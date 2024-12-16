<%-- 
    Document   : homebuena
    Created on : 18-ene-2024, 12:20:52
    Author     : diurno
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>ACB</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
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
            <div class="shadow bg-light">
                <div class="row justify-content-center pt-3 px-3">
                    <c:forEach items="${equipos}" var="equipo">
                        <div class="col-md-3 mb-3 position-relative">
                            <a href="Controller?op=equipo&idequipo=${equipo.id}" class="text-decoration-none">
                                <div class="card position-relative bg-dark" style="border-bottom-left-radius: 100px;">
                                    <img class="card-img-top" src="${equipo.imgestadio}" alt="Title" />
                                    <img src="${equipo.imgescudo}" alt="" width="90"
                                        class="bg-white p-3 rounded-circle position-absolute top-50 start-50 translate-middle">
                                    <div class="card-body py-5">
                                        <h4 class="card-title text-white text-center">${equipo.nombre}</h4>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>

        <footer>
            <!-- place footer here -->
        </footer>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>
